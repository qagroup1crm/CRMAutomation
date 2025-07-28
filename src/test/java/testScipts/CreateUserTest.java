package testScipts;


import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;

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
	
	
	@Test(description = "Creating User using Valid mandatory field's values")
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
		
		}
	
	
//	@Test(description = "Invalid Password")
	public void createuserTC2() throws InvalidFormatException, IOException {
		WebDriver driver = BaseTest.getDriver();
		CreateUserPage cu = new CreateUserPage(driver);
		   UtilCommon.waitForElementvisible(driver, cu.adminconsole);
		Actions actions = new Actions(driver);
	        actions.moveToElement(cu.adminconsole).perform();
	        UtilCommon.waitForElementvisible(driver, cu.createuser);
	        cu.createuser.click();
	        BaseTest.getTest().info("Creat User for displayed");
	        cu.createuser();
	        
		
		}
	
	
	

}
