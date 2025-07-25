package constants;


import utils.UtilCommon;

public class FileConstants {
	
	public static final String LOGIN_TESTDATA_FILE_PATH =  System.getProperty("user.dir") + "/src/test/java/data/loginTestData.properties";
	public static final String REPORT_PATH =  System.getProperty("user.dir") + "/src/main/resources/reports/"+UtilCommon.getDateAndTimeStamp()+"_CRM.html";
//	public static final String SCREENSHOT_PATH =  System.getProperty("user.dir") + "/src/main/resources/screenshots/"+UtilCommon.getDateAndTimeStamp()+"_CRM.PNG";
	
	public static final String SCREENSHOT_PATH =  System.getProperty("user.dir") + "/src/main/resources/reports/screen";
	
}
