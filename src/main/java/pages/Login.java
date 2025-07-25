package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import constants.FileConstants;
import utils.FileUtil;
import utils.UtilCommon;

public class Login extends Base{
	
//	locators
//	Reusable Function for Login
	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(id = "username")
	public WebElement username;
	
	@FindBy(id = "inputPassword" )
	public WebElement password;
	
	@FindBy(xpath = "//button[text()='Sign In']" )
	public WebElement signin;
	
	
	
	
	
	public void loginToApp(WebDriver driver) throws IOException {

		driver.get(FileUtil.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH, "url"));
		driver.manage().window().maximize();
		logger.info("LoginPage: loginToApp: application launched");
		if (UtilCommon.waitForElement(driver, username)) {
			username.sendKeys(FileUtil.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH, "username"));
			password.sendKeys(FileUtil.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH, "password"));
			signin.click();
		}
	}
	
	
	public boolean homepageisDisplayed(WebDriver driver) throws IOException {
		String expected =FileUtil.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH, "expected1");
		
		if(driver.getPageSource().contains(expected)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
}
