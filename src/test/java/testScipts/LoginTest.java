package testScipts;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import pages.Login;
import testScipts.BaseTest;

import utils.UtilCommon;

public class LoginTest extends BaseTest{
	
	@Test
	public void loginTest1() throws InvalidFormatException, IOException {
	WebDriver driver = BaseTest.getDriver();
	
	Login lp = new Login(driver);
	lp.loginToApp(driver);
	BaseTest.test.info("Login Successfull");
	logger.info("LoginTests: loginTest1: Home Page Displayed");
	Assert.assertEquals(lp.homepageisDisplayed(driver), true);
//	BaseTest.test.addScreenCaptureFromPath(UtilCommon.getScreenshots(driver));
	}
	
//	@Test
	public void loginTest2() throws InvalidFormatException, IOException {
		WebDriver driver = BaseTest.getDriver();
		driver.get("https://www.google.com/");
		logger.info("LoginTests: loginTest2: google Page Displayed");
		BaseTest.test.info("Google Page Opened");
		BaseTest.test.addScreenCaptureFromPath(UtilCommon.getScreenshots(driver));
		
	}
	
	
	

}
