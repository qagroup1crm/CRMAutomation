package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.FileConstants;
import constants.Wait;

public class UtilCommon {

	public static boolean waitForElement(WebDriver driver, WebElement element) {
		boolean isElementClickable = false;
		WebDriverWait wait = new WebDriverWait(driver, Wait.WAIT_FOR_ELEMENT);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			isElementClickable = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isElementClickable;
	}

		
	public static boolean waitForElementvisible(WebDriver driver, WebElement element) {
		boolean isElementvisible = false;
		WebDriverWait wait = new WebDriverWait(driver, Wait.WAIT_FOR_ELEMENT);
		try {
//			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			
			wait.until(ExpectedConditions.visibilityOfAllElements(element));
			isElementvisible = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isElementvisible;
	}
	
	public static boolean waitForElementToDisappear(WebDriver driver, WebElement element) {
		boolean isElementFound = false;
		WebDriverWait wait = new WebDriverWait(driver, Wait.WAIT_FOR_ELEMENT_TO_DISAPPEAR);
		try {
			wait.until(ExpectedConditions.invisibilityOf(element));
			isElementFound = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isElementFound;
	
		}
	public static void moveToElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public static String getDateAndTimeStamp() {
		String value = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
	     return value;
		}
	
	public static String getScreenshots(WebDriver driver) throws IOException {
		
		/*
		 TakesScreenshot screen = (TakesScreenshot) driver;
		String path = FileConstants.SCREENSHOT_PATH;
		File src = screen.getScreenshotAs(OutputType.FILE);
		File dst = new File(path);
		FileUtils.copyFile(src, dst);
		return path;
		
		*/
	
	
		
		TakesScreenshot screen = (TakesScreenshot) driver;
	    File src = screen.getScreenshotAs(OutputType.FILE);

	    String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	    String screenshotName = "CRM_" + timestamp + ".png";
	    String path = FileConstants.SCREENSHOT_PATH + File.separator+screenshotName;
	    
	    

	    File dst = new File(path);
	    FileUtils.copyFile(src, dst);

	    return path;
		
		
			
	}

}
