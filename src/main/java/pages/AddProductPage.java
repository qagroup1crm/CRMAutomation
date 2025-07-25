package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddProductPage extends Base{
	
	public AddProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

}
