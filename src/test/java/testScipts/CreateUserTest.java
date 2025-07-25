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
		
	}
	
	
	@Test
	public void createuserTC1() throws InvalidFormatException, IOException {
		WebDriver driver = BaseTest.getDriver();
		CreateUserPage cu = new CreateUserPage(driver);
		Actions actions = new Actions(driver);
	        actions.moveToElement(cu.adminconsole).perform();
	        UtilCommon.waitForElementvisible(driver, cu.createuser);
	        cu.createuser.click();
	        BaseTest.test.info("Create User page displayed");
	       
	        cu.createuser("Joe Samantha","23456782","abc@xyz.com","joesaman","123456");
		
		}
	
	

}
