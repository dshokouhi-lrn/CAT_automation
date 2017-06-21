package com.lrn.cat.page;

import org.openqa.selenium.JavascriptExecutor;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class PushToCDVCourse extends CATAppCommon {
	
	static public void pushToCDVCourse() throws Exception
	{
		try
		{
			Log.startTestCase("start pushing to cdv course");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			   
			Thread.sleep(1000);
			
			clickIdentifierByID("pushToCdv");
			
			Thread.sleep(1000);
			
			clickIdentifierXpath(".//div[@aria-describedby='dialogArea']/div[3]/div/button[1]");

			String publish = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			if (publish.contains("Content is pushed to CDV"))
			{
				Log.pass("course successfully published");
			}
			
			else
				Log.fail("course did not push to cdv for reason: " + publish);
		}
		
		catch(Exception e){  
		       Log.fail("Failed to push to cdv");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to push to cdv");
		       e.printStackTrace();
		       throw e;

		}
	}

}
