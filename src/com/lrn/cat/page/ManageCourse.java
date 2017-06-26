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

}
