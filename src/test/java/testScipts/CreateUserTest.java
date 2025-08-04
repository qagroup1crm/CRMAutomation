package testScipts;


import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;

import dataProviders.CreateUserDP;
import listeners.CRMListeners;
import pages.CreateUserPage;
import pages.Login;
import utils.UtilCommon;

@Listeners(CRMListeners.class)
public class CreateUserTest extends BaseTest{
	
	
	@BeforeMethod
	public void navigateToHome() throws IOException {
		WebDriver driver = BaseTest.getDriver();
		Login lp = new Login(driver);
		lp.loginToApp(driver);
		
	}
	
	
//	@Test(description = "Creating User using Valid mandatory field's values")
	public void createuserTC1() throws InvalidFormatException, IOException {
		WebDriver driver = BaseTest.getDriver();
		CreateUserPage cu = new CreateUserPage(driver);
		   UtilCommon.waitForElementvisible(driver, cu.adminconsole);
		   	cu.createuserform(driver);
	        BaseTest.getTest().info("Create User form is displayed");
	        cu.createuser();
//	        UtilCommon.waitForElementvisible(driver, cu.assertUserName);
//	        Assert.assertTrue(cu.assertUserName.isDisplayed(), "Username not displayed in table: " + cu.assertUserName);
	       
		}
	
	
	@Test(description = "Invalid Password")
	public void createuserTC2() throws InvalidFormatException, IOException {
		WebDriver driver = BaseTest.getDriver();
		CreateUserPage cu = new CreateUserPage(driver);
		   UtilCommon.waitForElementvisible(driver, cu.adminconsole);
		   cu.createuserform(driver);
		   BaseTest.getTest().info("Create User form is displayed");
	        cu.invalidpassword(randomDataGenerator.CreateUser.getinvalidPassword());
	        BaseTest.getTest().info("Create User form is filled");
	        String valmessage = cu.validationmessage(driver, cu.password);
	        Assert.assertTrue(valmessage.contains("6 characters or more"));
	        BaseTest.getTest().info("Error/Validation message is displayed");
		}
	
	
	@Test(dataProvider = "invalidEmails", dataProviderClass = CreateUserDP.class, description ="TC 26- TC 37")
	public void testInvalidEmailValidation(String email) throws IOException {
	    WebDriver driver = BaseTest.getDriver();
	    CreateUserPage cu = new CreateUserPage(driver);

	    UtilCommon.waitForElementvisible(driver, cu.adminconsole);
	    cu.createuserform(driver);

	    BaseTest.getTest().info("Create User form is displayed");

	    cu.invalidemail(email);

	    UtilCommon.waitForElementvisible(driver, cu.emailerrormessage);
	    Assert.assertTrue(cu.emailerrormessage.isDisplayed(), "Please enter a valid email address");
	    
	}
	
	@Test(description = "Blank User Full name")
	public void createuserTC07() throws InvalidFormatException, IOException {
		WebDriver driver = BaseTest.getDriver();
		CreateUserPage cu = new CreateUserPage(driver);
		   UtilCommon.waitForElementvisible(driver, cu.adminconsole);
		   cu.createuserform(driver);
		   BaseTest.getTest().info("Create User form is displayed");
	        cu.blankfield();
	        cu.userfullname.clear();
	        cu.save.click();
	        String valmessage = cu.validationmessage(driver, cu.userfullname);
	        Assert.assertTrue(valmessage.contains("fill out this field"));
	        BaseTest.getTest().info("Error/Validation message is displayed");
	        
		}
	
	@Test(description = "Blank MobileNumber")
	public void createuserTCBMobile() throws InvalidFormatException, IOException {
		WebDriver driver = BaseTest.getDriver();
		CreateUserPage cu = new CreateUserPage(driver);
		   UtilCommon.waitForElementvisible(driver, cu.adminconsole);
		   cu.createuserform(driver);
		   BaseTest.getTest().info("Create User form is displayed");
	        cu.blankfield();
	        cu.mobile.clear();
	        cu.save.click();
	        String valmessage = cu.validationmessage(driver, cu.mobile);
	        Assert.assertTrue(valmessage.contains("fill out this field"));
	        BaseTest.getTest().info("Error/Validation message is displayed");
	        
		}
	
	
	@Test(description = "Blank email")
	public void createuserTCBEmail() throws InvalidFormatException, IOException {
		WebDriver driver = BaseTest.getDriver();
		CreateUserPage cu = new CreateUserPage(driver);
		   UtilCommon.waitForElementvisible(driver, cu.adminconsole);
		   cu.createuserform(driver);
		   BaseTest.getTest().info("Create User form is displayed");
	        cu.blankfield();
	        cu.email.clear();
	        cu.save.click();
	        String valmessage = cu.validationmessage(driver, cu.email);
	        Assert.assertTrue(valmessage.contains("fill out this field"));
	        BaseTest.getTest().info("Error/Validation message is displayed");
	        
		}
	
	@Test(description = "Blank username")
	public void createuserTCBUsername() throws InvalidFormatException, IOException {
		WebDriver driver = BaseTest.getDriver();
		CreateUserPage cu = new CreateUserPage(driver);
		   UtilCommon.waitForElementvisible(driver, cu.adminconsole);
		   cu.createuserform(driver);
		   BaseTest.getTest().info("Create User form is displayed");
	        cu.blankfield();
	        cu.username.clear();
	        cu.save.click();
	        String valmessage = cu.validationmessage(driver, cu.username);
	        Assert.assertTrue(valmessage.contains("fill out this field"));
	        BaseTest.getTest().info("Error/Validation message is displayed");
	        
		}
	
	
	@Test(description = "Blank Password")
	public void createuserTCBPassword() throws InvalidFormatException, IOException {
		WebDriver driver = BaseTest.getDriver();
		CreateUserPage cu = new CreateUserPage(driver);
		   UtilCommon.waitForElementvisible(driver, cu.adminconsole);
		   cu.createuserform(driver);
		   BaseTest.getTest().info("Create User form is displayed");
	        cu.blankfield();
	        cu.password.clear();
	        cu.save.click();
	        String valmessage = cu.validationmessage(driver, cu.password);
	        Assert.assertTrue(valmessage.contains("fill out this field"));
	        BaseTest.getTest().info("Error/Validation message is displayed");
	        
		}
	
	
	
	
}









