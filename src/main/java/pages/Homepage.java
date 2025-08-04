package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class Homepage extends Base {


    public Homepage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			
    }


    @FindBy(xpath = "//a[normalize-space()='Products']")
    public WebElement products;

	public Homepage clickProducts() {
		 products.click();
	        logger.debug("Products link clicked");
			return null;
	     
			
	}

	 @FindBy(xpath = "//select[@class='form-control']")
	    public WebElement searchByDropdown;
	 
	 
	 public void waitAndSelectSearchBy(String optionText) {
	        waitforElement(searchByDropdown);
	        SelectDropdown(searchByDropdown, optionText);
	    }
    
	 public void SelectDropdown(WebElement element, String visibleText) {
	        Select dropdown = new Select(element);
	        dropdown.selectByVisibleText(visibleText);
	    }

	 public List<String> getSearchByDropdownOptions() {
	        waitforElement(searchByDropdown);
	        Select dropdown = new Select(searchByDropdown);
	        List<WebElement> options = dropdown.getOptions();
	        List<String> optionTexts = new ArrayList<>();
	        for (WebElement option : options) {
	            optionTexts.add(option.getText().trim());
	        }
	        return optionTexts;
	    }
    }
