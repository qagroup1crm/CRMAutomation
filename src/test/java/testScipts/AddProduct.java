package testScipts;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import org.testng.Assert;

import listeners.CRMListeners;
import pages.AddProductPage;
import pages.Homepage;
import pages.Login;
import utils.UtilCommon;

@Listeners(CRMListeners.class)
public class AddProduct extends BaseTest{
	
	@BeforeMethod
	public void navigateToHome() throws IOException {
		WebDriver driver = BaseTest.getDriver();
		Login lp = new Login(driver);
		lp.loginToApp(driver);
		
	}


	/*TC2: Verify dropdown shows options "Product Name" and "Product ID"
	 * 1. Login with valid credentials
	2. Click on "Products" tab from the top menu
	3.  Click on “Search By” dropdown*/

	@Test
		public void SearchBy() {
			WebDriver driver = BaseTest.getDriver();	
			Homepage hr= new Homepage(driver);

			
		utils.UtilCommon.waitForElementvisible(driver, hr.products);
		hr.products.click();
		BaseTest.getTest().info("Product Tab is opened");
		
		    // Step 2: Wait for Search By dropdown
		    UtilCommon.waitForElementvisible(driver, hr.searchByDropdown);

		    // Explicit click on dropdown (optional for visibility)
		    hr.searchByDropdown.click();
		    BaseTest.getTest().info("Clicked on Search By dropdown.");

		    // Step 3: Get dropdown options
		    List<String> dropdownOptions = hr.getSearchByDropdownOptions();
		    BaseTest.getTest().info("Dropdown options fetched: " + dropdownOptions);

		    // Step 4: Normalize options (lowercase trimmed)
		    List<String> normalizedOptions = new ArrayList<>();
		    for (String option : dropdownOptions) {
		        normalizedOptions.add(option.trim().toLowerCase());
		    }

		    // Step 5: Assert both expected values are present (case-insensitive)
		    assertTrue(
		        normalizedOptions.contains("search by product id".toLowerCase()),
		        "'Search by Product Id' is missing in dropdown."
		    );
		    assertTrue(
		        normalizedOptions.contains("search by product name".toLowerCase()),
		        "'Search by Product Name' is missing in dropdown."
		    );

		    BaseTest.getTest().pass("Search By dropdown contains both expected options.");
		}

}