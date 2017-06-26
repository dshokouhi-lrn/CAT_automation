package com.lrn.cat.page;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class SearchCourse extends CATAppCommon{
	
	
	static public void searchcourse(String courseName, String courseContent, String courseType) throws Exception
    {
           try
           {
                  Log.startTestCase("Verify Search course ");
                  
                  clickIdentifierXpath("//ul[@class='nav navbar-nav nav-pills pull-right']/li[2]/a");
                  
                  clickIdentifierXpath(".//*[@id='homeDropDown']/a/span");
                  Log.info("navigated to home page");
                  
                  typeTextById("courseName", courseName);
                  
                  if (courseContent != "")
                	  selectDropdownValueVisibleText("courseContent", courseContent);
                  
                  if (courseType != "")
                  	selectDropdownValueVisibleText("courseType", courseType);
                  
                  Thread.sleep(300);
                  clickIdentifierXpath("//form/div/div/div/input");
                 
                  Thread.sleep(300);

                  Log.pass("Searched course successfully");

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