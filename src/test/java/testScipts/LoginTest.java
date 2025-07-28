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
	BaseTest.getTest().info("Login Successfull");
	logger.info("LoginTests: loginTest1: Home Page Displayed");
	Assert.assertEquals(lp.homepageisDisplayed(driver), true);
//	BaseTest.test.addScreenCaptureFromPath(UtilCommon.getScreenshots(driver));
	}
	

	
	
	

}
