package com.lrn.cat.page;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class ManageCourse extends CATAppCommon{
	
	static public void searchManageCourse(String courseName, String searchType) throws Exception
	{
		try
		{
			Log.startTestCase("Verify Search course ");
			
			clickIdentifierXpath("//ul[@class='nav navbar-nav nav-pills pull-right']/li[2]/a");
            
            clickIdentifierXpath(".//*[@id='cloneCourseDropDown']/a/span");
            
            Log.info("navigated to manage course page");
            
            typeTextById("searchText", courseName);
            
            if (searchType != "")
          	  selectDropdownValueVisibleText("searchField", searchType);
            
            Thread.sleep(300);
            
            clickIdentifierXpath("//form/div/div/div/input");
            
            Log.pass("Searched for course successfully");
		}
		
		catch(Exception e){  
            Log.fail("Failed to search course");
            e.printStackTrace();
            throw e;                                        
     } catch(AssertionError e)
     {
            Log.fail("Failed to search course");
            e.printStackTrace();
            throw e;

     }
	}
	
	static public void cloneCourse(String coursePosition, String newCatalogID) throws Exception
	{
		try
		{
			Log.startTestCase("start cloning course");
			
			if (coursePosition == "")
				coursePosition = "1";
			
			clickIdentifierXpath(".//*[@id='courseResultsTable']/tbody/tr[" + coursePosition + "]/td[10]/a[@id='cloneDialog']/span/i");
			
			Thread.sleep(1000);
			
			clickIdentifierXpath(".//div[@aria-describedby='dialogArea']/div[3]/div/button[1]");
			
			String checkedOut = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			if (checkedOut.contains("Click on create to clone"))
			{
				Log.pass("successfully started cloning course");
			}
			
			else
				Log.fail("course did not start cloning for reason: " + checkedOut);
		}
		
		catch(Exception e){  
            Log.fail("Failed to clone course");
            e.printStackTrace();
            throw e;                                        
     } catch(AssertionError e)
     {
            Log.fail("Failed to clone course");
            e.printStackTrace();
            throw e;

     }
	}

}
