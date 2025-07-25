package listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import testScipts.BaseTest;
import utils.UtilCommon;

public class CRMListeners extends BaseTest implements ITestListener{
	
	
@Override

public void onTestStart(ITestResult result) {
	
//	BaseTest.test = extent.createTest(name.getName());
//   	logger.info("BaseTest: setup: "+name.getName()+" Object is created");

}
	public void onTestSuccess(ITestResult result) {
		/*
		 * BaseTest.test.pass(result.getName()+" Test Passed");
		 
		try {
				
			BaseTest.test.addScreenCaptureFromPath(UtilCommon.getScreenshots(BaseTest.getDriver()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
	
	
	 try {
	        String screenshotPath = UtilCommon.getScreenshots(BaseTest.getDriver());
	        BaseTest.test.pass(result.getName() + " Test Passed",
	            MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
		
	}
	
    public void onTestFailure(ITestResult result) {
    	BaseTest.test.fail(result.getName()+" Test Failed");
    	try {
			BaseTest.test.addScreenCaptureFromPath(UtilCommon.getScreenshots(BaseTest.getDriver()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
