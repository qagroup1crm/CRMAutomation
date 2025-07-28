package listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import testScipts.BaseTest;
import utils.UtilCommon;

public class CRMListeners extends BaseTest implements ITestListener{
	
	
@Override

public void onTestStart(ITestResult result) {
//    ExtentTest test = BaseTest.extent.createTest(result.getMethod().getMethodName());
//    BaseTest.threadExtentTest.set(test);
}
	/*public void onTestSuccess(ITestResult result) {
		/*
		 * BaseTest.test.pass(result.getName()+" Test Passed");
		 
		try {
				
			BaseTest.test.addScreenCaptureFromPath(UtilCommon.getScreenshots(BaseTest.getDriver()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	
	 try {
	        String screenshotPath = UtilCommon.getScreenshots(BaseTest.getDriver());
//	        BaseTest.test.pass(result.getName() + " Test Passed",
//	            MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	        
	        BaseTest.threadExtentTest.get().pass(result.getName()+" Test Passed");
	        BaseTest.threadExtentTest.get().addScreenCaptureFromPath(screenshotPath);
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
    
    */
    
    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest test = BaseTest.getTest();
        test.pass("Test Passed");

        try {
            String path = UtilCommon.getScreenshots(BaseTest.getDriver());
            System.out.println("Screenshot path: " + path);
            test.addScreenCaptureFromPath(path);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = BaseTest.getTest();
        test.fail("Test Failed: " + result.getThrowable());

        try {
            String path = UtilCommon.getScreenshots(BaseTest.getDriver());
            test.addScreenCaptureFromPath(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        BaseTest.extent.flush();
    }

    
}

