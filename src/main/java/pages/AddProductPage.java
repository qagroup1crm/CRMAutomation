package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;

	public class AddProductPage extends Base{
		
		public AddProductPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath ="//*[contains(@class,'nav-link') and contains(text(),'Products')]")
		public WebElement Products;	
		
				
		@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[1]/div/div[1]/div/div[2]/button/span")
		public WebElement AddProduct;
		//
   
    
    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[1]/div/div[1]/div/div[2]/button/span")
    public WebElement AddProductfield;
    
    @FindBy(xpath = "//input[@name='productId']")
	public WebElement ProductIDTextbox;
    
    @FindBy(xpath = "//input[@name='productName']")
    public WebElement productNameInput;
    
    @FindBy(xpath = "//button[@type='submit']")
	private WebElement AddButtonElement;
    
    @FindBy(xpath = "//select[@name='productCategory']")
	private WebElement CategoryDropdown;
    
    @FindBy(xpath = "//input[@name='quantity']")
    WebElement txtQuantity;
    
    public String getQuantityValue() {
        return txtQuantity.getAttribute("value");
    }
    
    public void enterQuantity(String qnty) {
    	txtQuantity.sendKeys(qnty);
    }
    
	@FindBy(xpath = "//input[@name='price']")
	public WebElement Unitprice;
    
	public String errorPriceValidationMsg() {
	    return Unitprice.getAttribute("validationMessage");
	}

	@FindBy(xpath = "//select[@name='vendorId']")
	public WebElement vendorDropdown;
	
	@FindBy(className = "Toastify__toast-container Toastify__toast-container--top-right")
	public WebElement successMsg;
	
	public String successMessage() {
	    WebDriver driver = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(successMsg));
	    return getTextFromElement(successMsg);
	}
	

	public void selectVendorByIndex(int data) {
		selectIndex(vendorDropdown, data);
	}
	
	public String errorVendorValidationMsg() {
	    return vendorDropdown.getAttribute("validationMessage");
	}
    public void AddProductDetails()
    {
    	AddButtonElement.click();
    	
    }
    
    
    public void enterProductName(String name) {
        productNameInput.clear();
        productNameInput.sendKeys(name);
    }

    public String errorProductNameValidationMsg() {
        return productNameInput.getAttribute("validationMessage");
    }
    
    public void AddProduct()
    {
    	AddProductfield.click();
    	
    }
    
    public boolean isProductIDReadOnly() {
        String readOnlyAttr = ProductIDTextbox.getAttribute("readonly");
        String disabledAttr = ProductIDTextbox.getAttribute("disabled");
        return (readOnlyAttr != null || disabledAttr != null);
    }

   

   

    public void selectCategoryByVisibleText(String categoryName) {
        Select select = new Select(CategoryDropdown);
        select.selectByVisibleText(categoryName);
    }
    
    


	public void enterPrice(String price ) {
		Unitprice.clear();
		Unitprice.sendKeys(price);
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public String successMsg() {
		  return successMsg.getText();
		
	}
}
