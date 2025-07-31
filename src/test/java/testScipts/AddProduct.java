package testScipts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.CRMListeners;
import pages.AddProductPage;
import pages.Login;

@Listeners(CRMListeners.class)
public class AddProduct extends BaseTest{
	
	@BeforeMethod
	public void navigateToHome() throws IOException {
		WebDriver driver = BaseTest.getDriver();
		Login lp = new Login(driver);
		lp.loginToApp(driver);
		
	}
	
@Test
public void products()
{
	
	WebDriver driver = BaseTest.getDriver();	
	AddProductPage pr= new AddProductPage(driver);
	
utils.UtilCommon.waitForElementvisible(driver, pr.Products);
pr.Products.click();
BaseTest.getTest().info("Product Tab is opened");
}
}