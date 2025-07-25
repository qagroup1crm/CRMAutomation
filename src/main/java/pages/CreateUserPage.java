package pages;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.RandomDataGenerator;




public class CreateUserPage extends Base{
	
	
	
	public CreateUserPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath = "//li[contains(text(),'Admin Console')]")
	public WebElement adminconsole;
	
	@FindBy(xpath = "//div[@class='dropdown-item' and text()='Create User']")
	public WebElement createuser;
	
	@FindBy(name = "empId")
	public WebElement userid;
	
	@FindBy(name = "empName")
	public WebElement userfullname;
	
	
	@FindBy(name = "mobileNo")
	public WebElement mobile;
	
	@FindBy(name = "email")
	public WebElement email;
	
	@FindBy(name = "dob")
	public WebElement dob;
	
	@FindBy(name = "username")
	public WebElement username;
	
	@FindBy(name = "password")
	public WebElement password;
	
	@FindBy(xpath = "//button[text()='Create User']")
	public WebElement save;
	
	
	
	public void createuser(String fullname, String mobileno, String emailid,String usrname, String passwrd) throws IOException {
		
		 userfullname.click();
	       userfullname.sendKeys();
	       mobile.click();
	       mobile.sendKeys(mobileno);
	       email.click();
	       email.sendKeys(emailid);
	       username.click();
	       username.sendKeys(usrname);
	       password.click();
	       password.sendKeys(passwrd);
	       save.click();
		}
		    

}
