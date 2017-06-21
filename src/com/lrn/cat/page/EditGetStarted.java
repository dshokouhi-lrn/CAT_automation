package com.lrn.cat.page;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class EditGetStarted extends CATAppCommon {
	
	static public void editGetStartedPage(String CourseTitle, String Description, String Mobile, String Video, String Audio, String CourseDuration) throws Exception {
		
		try{
			
			Date d = new Date();
			
			Log.startTestCase("Start edit get started page");

			clickIdentifierXpath(".//*[@id='courseResultsTable']/tbody/tr[2]/td[7]/a[1]/span/i");
			
			Log.info("edited first course that shows up in the list");
			
			Thread.sleep(3000);
			
			if (driver.findElement(By.id("courseCheckoutButton")).isDisplayed())
				clickIdentifierByID("courseCheckoutButton");
			
			if (CourseTitle != "")
			{
				typeTextById("title", CourseTitle + d.toString());
				Log.info("course title updated");
			}
			
			if (Description != "")
			{
				
				
				if (driver.findElement(By.id("ckeditorContentDescription")).isDisplayed())
				{
					typeTextById("ckeditorContentDescription", Description + " "  + d.toString());
				}
				
				if (driver.findElement(By.id("ckeditorContentCourseObjective")).isDisplayed())
				{
					typeTextById("ckeditorContentCourseObjective", Description + " "  + d.toString());
				}
				
				if (driver.findElement(By.id("ckeditorContentLong")).isDisplayed())
				{
					typeTextById("ckeditorContentLong", Description + " "  + d.toString());
				}
				
				if (driver.findElement(By.id("ckeditorContentShort")).isDisplayed())
				{
					typeTextById("ckeditorContentShort", Description + " "  + d.toString());
				}
				
				Log.pass("course descriptions updated");
			}
			
			if (Mobile != "")
				selectDropdownValueVisibleText("hasMobileReady", Mobile);
			
			if (Video != "")
				selectDropdownValueVisibleText("hasVideo", Video);
			
			if (Audio != "")
				selectDropdownValueVisibleText("hasAudio", Audio);
			
			if (CourseDuration != "")
				typeTextById("courseDuration", CourseDuration);
			
			Log.info("mobile, video, audio and duration edited");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			if (CourseTitle != "" || Description != "" || Mobile != "" || Video != "" || Audio != "" || CourseDuration != "")
			{
				clickIdentifierXpath("//*[@id='editedCourse']/div[1]/button");
			
				Thread.sleep(5000);
			
				String courseSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
				String passed = "Course saved";
			
				if (courseSaved.contains(passed))
				{
					Log.pass("get started tab edited successfully");

				}
				
				else {
					Log.fail("could not edit course due to following error: " + courseSaved);
				}
			}
			
			
			clickIdentifierXpath(".//div[@id='menuTabs']/ul/li[2]/p"); 
			Log.info("Navigate to Create course tab");
			
			Thread.sleep(3000);
		}
		
		catch(Exception e){  
		       Log.fail("Failed to edit course");
		       e.printStackTrace();
		       throw e;                                        
		} 
		
		catch(AssertionError e)
		{
		       Log.fail("Failed to edit course");
		       e.printStackTrace();
		       throw e;
		}
	}
		
}
