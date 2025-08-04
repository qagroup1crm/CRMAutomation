package dataProviders;

import org.testng.annotations.DataProvider;

public class AddProductDP {
	@DataProvider(name = "productData")
	public Object[][] getData() {
		return new Object[][] { { "Chair", 4, "5", "67", "VID_009" }

		

		 };
			}
			

		}