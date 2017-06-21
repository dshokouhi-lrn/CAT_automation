package com.lrn.cat.page;

import org.openqa.selenium.JavascriptExecutor;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class PublishCourse extends CATAppCommon {
	
	static public void publishCourse() throws Exception
	{
		try
		{
			Log.startTestCase("start publishing course");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			   
			Thread.sleep(1000);
			
			clickIdentifierByID("coursePublishButton");
			
			Thread.sleep(1000);
			
			clickIdentifierXpath(".//div[@aria-describedby='dialogArea']/div[3]/div/button[1]");

			String publish = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			if (publish.contains("Course publish status: Course published successfully"))
			{
				Log.pass("course successfully published");
			}
			
			else
				Log.fail("course did not publish for reason: " + publish);
		}
		
		catch(Exception e){  
		       Log.fail("Failed to publish course");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to publish course");
		       e.printStackTrace();
		       throw e;

		}
	}

}
