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
		Actions actions = new Actions(driver);
	        actions.moveToElement(cu.adminconsole).perform();
	        UtilCommon.waitForElementvisible(driver, cu.createuser);
	        cu.createuser.click();
	        BaseTest.getTest().info("Create User page displayed successfully");
	        cu.createuser();
//	        UtilCommon.waitForElementvisible(driver, cu.assertUserName);
//	        Assert.assertTrue(cu.assertUserName.isDisplayed(), "Username not displayed in table: " + cu.assertUserName);
	       
		}
	
	
//	@Test(description = "Invalid Password")
	public void createuserTC2() throws InvalidFormatException, IOException {
		WebDriver driver = BaseTest.getDriver();
		CreateUserPage cu = new CreateUserPage(driver);
		   UtilCommon.waitForElementvisible(driver, cu.adminconsole);
		   cu.createuserform(driver);
		    BaseTest.getTest().info("Creat User for displayed");
	        cu.createuser();
	        BaseTest.getTest().info("Create User form is displayed");
	        
		
		}
	
//	@Test(description = "email id without '@'")
	public void createuserTC26() throws InvalidFormatException, IOException {
		WebDriver driver = BaseTest.getDriver();
		CreateUserPage cu = new CreateUserPage(driver);
		   UtilCommon.waitForElementvisible(driver, cu.adminconsole);
		   cu.createuserform(driver);
		   BaseTest.getTest().info("Create User form is displayed");
	        cu.invalidemail("abc.com");
	        UtilCommon.waitForElementvisible(driver, cu.emailerrormessage);
	        Assert.assertTrue(cu.emailerrormessage.isDisplayed(), "Please enter a valid email address");
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
	
	
	
	
	
}









