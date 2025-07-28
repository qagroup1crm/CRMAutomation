package testScipts;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import constants.FileConstants;


public class BaseTest {
	
    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    protected static ThreadLocal<ExtentTest> threadExtentTest = new ThreadLocal<>();

    public static ExtentReports extent;
    private static ExtentSparkReporter spark;
    protected static final Logger logger = LogManager.getLogger("BASETEST");
    

    public static ExtentTest getTest() {
        return threadExtentTest.get();
    }
    
    @Parameters({"browserName", "isHeadless"})
    @BeforeMethod
    public void setUpDriverAndTest(Method method, String browserName, boolean isHeadless) {
        

        WebDriver driver = getBrowserType(browserName, isHeadless);
        threadLocalDriver.set(driver);
        logger.info("Driver set for test: " + method.getName());

        ExtentTest test = extent.createTest(method.getName());
        extent.attachReporter();
        threadExtentTest.set(test);
        logger.info("ExtentTest created for: " + method.getName());
    }

    @AfterMethod
    public void tearDownDriver() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
            logger.info("Driver quit");
        }
        threadLocalDriver.remove();
        threadExtentTest.remove();
    }
    
    @BeforeSuite
    
    public static void setup() {
	
    	if (extent == null) {
            spark = new ExtentSparkReporter(new File(FileConstants.REPORT_PATH));
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
		logger.debug("BaseTest : setup : initializing report manager..");
    }

    @AfterSuite
    public void flushReport() {
        if (extent != null) {
            extent.flush();
            logger.info("Extent Report flushed.");
        }
    }

    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

   


	
public static WebDriver getBrowserType(String browserName, boolean headless) {
		
		WebDriver driver;
		String browserType = browserName.toLowerCase();
				
		switch (browserType) {
		case "chrome":
			if(headless) {
				
				Map<String, Object> prefs = new HashMap<>();
		        prefs.put("credentials_enable_service", false);
		        prefs.put("profile.password_manager_enabled", false);
		        prefs.put("profile.password_manager_leak_detection", false); 
		        
		        
				ChromeOptions co = new ChromeOptions();
				
				co.addArguments("--headless");
						
				co.setExperimentalOption("prefs", prefs);
		 	      
				driver = new ChromeDriver(co);	
				logger.info("BaseTest: getBrowserType: headless chrome is configured");
			}
			else {
				Map<String, Object> prefs = new HashMap<>();
		        prefs.put("credentials_enable_service", false);
		        prefs.put("profile.password_manager_enabled", false);
		        prefs.put("profile.password_manager_leak_detection", false); 
		        
		        ChromeOptions co = new ChromeOptions();
		        co.setExperimentalOption("prefs", prefs);
		        
				driver = new ChromeDriver(co);
				logger.info("BaseTest: getBrowserType: chrome configured");
			}
			
			break;
			
		case "firefox":
			
			if(headless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				driver = new FirefoxDriver(options);
				logger.info("BaseTest: getBrowserType: Firefox configured");
			}
			else {
			
			driver = new FirefoxDriver();
			logger.info("BaseTest: getBrowserType: Firefox configured");
			
			}
			break;
			
		case "safari":
			
			
			driver = new SafariDriver();
			logger.info("BaseTest: getBrowserType: Safari configured");
			
			
			break;	
			
		case "edge":
			
			if(headless) {
			EdgeOptions eo = new EdgeOptions();
			eo.addArguments("--headless");
			eo.addArguments("--disable-gpu");
			System.setProperty("webdriver.edge.driver", "C:\\Users\\gheva\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver(eo);
			logger.info("BaseTest: getBrowserType: Edge configured");
			}
			
			else {
				System.setProperty("webdriver.edge.driver", "C:\\Users\\gheva\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			
			driver = new EdgeDriver();
			logger.info("BaseTest: getBrowserType: Edge configured");
			}
			break;
					
		default:
			driver = null;
			logger.fatal("BaseTest: getBrowserType: incorrect browser name provided");
			break;
		}
		
		return driver;
		
	}

}
