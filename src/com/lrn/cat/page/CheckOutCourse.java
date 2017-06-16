package com.lrn.cat.page;

import org.openqa.selenium.JavascriptExecutor;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class CheckOutCourse extends CATAppCommon{

	static public void checkOutCourse() throws Exception
	{
		try
		{
			Log.startTestCase("checking out course");
			
			//ensure page is scrolled to the top
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			Thread.sleep(10000);
			
			clickIdentifierByID("courseCheckoutButton");
			
			String checkedOut = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			if (checkedOut.contains("Course Checked Out Successful"))
			{
				Log.pass("course successfully checked out");
			}
			
			else
				Log.fail("course did not check out for reason: " + checkedOut);
		}
		
		catch(Exception e){  
		       Log.fail("Failed to check out course");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to check out course");
		       e.printStackTrace();
		       throw e;

		}
	}
}
