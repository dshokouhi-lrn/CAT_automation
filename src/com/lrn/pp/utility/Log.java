package com.lrn.pp.utility;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.lrn.webdrivercommon.WebAppCommon;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class Log{
	
	static WebAppCommon common = new WebAppCommon();
	
	
	public static void startTestCase(String sTestCaseName)
	{
	
		common.logger=common.report.startTest(sTestCaseName);
	}
	
	// Need to create these methods, so that they can be called  
	public static void info(String message) 
	{ 
		common.logger.log(LogStatus.INFO,message);
	}
	
	public static void fail(String message) { 
		common.logger.log(LogStatus.FAIL,message);
	}
	
	public static void error(String message) { 
		common.logger.log(LogStatus.ERROR,message);
	}
	
	public static void pass(String message) { 
		common.logger.log(LogStatus.PASS,message);
	}
	


}
