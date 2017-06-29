package com.lrn.cat.page;

import org.openqa.selenium.JavascriptExecutor;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class RevertCourse extends CATAppCommon{
	
	static public void revertCourse() throws Exception
	{
		try
		{
			Log.startTestCase("start reverting course");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			clickIdentifierByID("courseRevertButton");
			
			Thread.sleep(2000);
			
			clickIdentifierXpath("//*[@role='dialog']/div[3]/div/button[1]");
			
			String checkedIn = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			if (checkedIn.contains("Course Revert Successful"))
			{
				Log.pass("course successfully reverted");
			}
			
			else
				Log.fail("course did not revert for reason: " + checkedIn);
		}
		
		catch(Exception e){  
		       Log.fail("Failed to revert course");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to revert course");
		       e.printStackTrace();
		       throw e;

		}
	}

}
