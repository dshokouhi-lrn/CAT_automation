package com.lrn.cat.page;

import java.util.Date;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class CreateCourse extends CATAppCommon {
	
	static public void createCourse(String CourseTitle, String Description, String BaseCat, String CourseType, String CourseFormat, String CourseProgression, String CourseTopic, String Site, String Partner, String Language, String Mobile, String Video, String Audio, String CourseDuration) throws Exception {
		
		try{
			
			Date d = new Date();
			
			Log.startTestCase("Start create a course");
			clickIdentifierXpath("//div[3]//a[1]");
			Log.info("clicked on create your course button");
			
			typeTextById("title", "Course title " + d.toString());
			Log.info("entered course title");
			
			selectDropdownValueVisibleText("courseTypeDropDown", CourseType);
			
			Thread.sleep(5000);
			
			if (CourseType == "Custom")
			{
				typeTextById("partnerName", Partner);
				selectDropdownValueVisibleText("siteId", Site);
				typeTextById("ckeditorContentDescription", Description + " "  + d.toString());
				typeTextById("ckeditorContentCourseObjective", Description + " "  + d.toString());
				
				Log.pass("course type custom selected and necessary details filled in");
			}
			
			if (CourseType == "Library")
			{
				selectDropdownValueVisibleText("topicArea", CourseTopic);
				typeTextById("ckeditorContentShort", Description + " "  + d.toString());
				typeTextById("ckeditorContentLong", Description + " "  + d.toString());
				typeTextById("ckeditorContentCourseObjective", Description + " "  + d.toString());
				
				Log.pass("course type library used and necesary details filled in");
			}
			
			selectDropdownValueVisibleText("courseFormatDropDown", CourseFormat);
			
			if (CourseProgression != "")
			{
				selectDropdownValueVisibleText("courseProgression", CourseProgression);
			}
			
			selectDropdownValueVisibleText("lang", Language);
			
			typeTextById("baseCatalogId", BaseCat);
			
			Log.info("base catalog id and course format selected");
			
			selectDropdownValueVisibleText("hasMobileReady", Mobile);
			
			selectDropdownValueVisibleText("hasVideo", Video);
			
			selectDropdownValueVisibleText("hasAudio", Audio);
			
			typeTextById("courseDuration", CourseDuration);
			
			Log.info("mobile, video, audio and duration configured");
			
			clickIdentifierXpath("//*[@id='editedCourse']/div[1]/button");
			
			Thread.sleep(5000);
			
			String courseSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			String passed = "Course saved";
			
			if (courseSaved.contains(passed))
			{
				String systemID = getValueByXpath(".//*[@id='systemId']");
				String catalogID = getValueByXpath(".//*[@id='catalogId']");
				
				Log.pass("course created successfully with system ID " + systemID + " and catalog ID " + catalogID);
				
				clickIdentifierXpath(".//div[@id='menuTabs']/ul/li[2]/p"); 
				Log.info("Navigate to Create course tab");
			}
			
			else {
				Log.fail("could not create course due to following error: " + courseSaved);
			}
		}
		
		catch(Exception e){  
		       Log.fail("Failed to Create course");
		       e.printStackTrace();
		       throw e;                                        
		} 
		
		catch(AssertionError e)
		{
		       Log.fail("Failed to Create course");
		       e.printStackTrace();
		       throw e;
		}
	}
		
}
