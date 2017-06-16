package com.lrn.cat.page;

import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class AddLesson extends CATAppCommon {

	static public void addLesson(String lessonName) throws Exception
	{
		try{
			Date d = new Date();
			
			
			Log.startTestCase("started adding lesson");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			clickIdentifierXpath("//*[@id='courseTree']/ul/li/a");
			
			Thread.sleep(3000);
			
			clickIdentifierXpath("//*[@id='courseTreeOperationIcons']/li[1]");
			
			Thread.sleep(3000);
			
			typeTextByXpath("//*[@id='note_pag']/ul/li/input", lessonName + " " + d.toString());
			
			Thread.sleep(3000);
			
			clickIdentifierXpath(".//div[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']/div/button[1]");
			
			Log.pass("lesson created");
		}
		
		catch(Exception e){  
		       Log.fail("Failed to add lesson");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to add lesson");
		       e.printStackTrace();
		       throw e;

		}
	}
}
