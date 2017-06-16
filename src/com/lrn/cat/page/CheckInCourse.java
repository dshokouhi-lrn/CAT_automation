package com.lrn.cat.page;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class CheckInCourse extends CATAppCommon{
	
	static public void checkInCourse(String comments) throws Exception
	{
		
		try
		{
			Log.startTestCase("checking in course");
			
			Date d = new Date();
			
			//in order to click on the check in button we need to scroll to the top so the button is visible
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			   
			Thread.sleep(10000);
			
			clickIdentifierByID("courseCheckinButton");
			//clickIdentifierXpath("//*[@id='mainSection']/div[1]/div/ul/li[1]/button");
			
			//clickIdentifierXpath(".//div//*[@id='courseCheckinButton']");
			
			Thread.sleep(1000);
			
			if (isElementPresent(By.id("checkInComments"), "checkInComments"))
				typeTextById("checkInComments", comments + " " + d.toString());
			else
				Log.fail("comments section is not visible");
			
			//clickIdentifierXpath("//body/div[17]/div[3]/div/button[1]/span");
			
			clickIdentifierXpath(".//div[@aria-describedby='dialogArea']/div[3]/div/button[1]");
			
			String checkedIn = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			if (checkedIn.contains("Course Checked In Successful"))
			{
				Log.pass("course successfully checked in");
			}
			
			else
				Log.fail("course did not check in for reason: " + checkedIn);
		}
		
		catch(Exception e){  
		       Log.fail("Failed to check in course");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to check in course");
		       e.printStackTrace();
		       throw e;

		}
	}

}
