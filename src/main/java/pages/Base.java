package pages;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	public static Logger logger =LogManager.getLogger("BASEPAGE");

	public void waitforElement(WebElement element) {
	    WebDriver driver = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void selectIndex(WebElement ele, int index) {
		Select select = new Select(ele);
		select.selectByIndex(index);
	}
	public static String getTextFromElement(WebElement ele) {
		String data = ele.getText();
		return data;
	}
	
}