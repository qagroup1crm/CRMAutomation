package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductPage extends Base{
	
	public AddProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//*[contains(@class,'nav-link') and contains(text(),'Products')]")
	public WebElement Products;		
			
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[1]/div/div[1]/div/div[2]/button/span")
	public WebElement AddProduct;
	//
	
}
