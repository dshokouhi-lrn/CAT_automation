package com.lrn.cat.page;

import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class AddTopic extends CATAppCommon {
	
	static public void addTopic(String topicName) throws Exception
	{
		try {
			
		
			Date d = new Date();
			
			Log.startTestCase("start adding topic");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			clickIdentifierXpath("//*[@id='courseTreeOperationIcons']/li[2]");
			
			Thread.sleep(300);
			
			typeTextByXpath("//*[@id='note_pag']/ul/li/input", topicName + " " + d.toString());
			
			//clickIdentifierXpath(".//div[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']/div/button[1]");
			
			clickIdentifierXpath(".//div[@aria-describedby='dialogArea']/div[3]/div/button[1]");
			
			Log.pass("topic created");
		}
		
		catch(Exception e){  
		       Log.fail("Failed to add topic");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to add topic");
		       e.printStackTrace();
		       throw e;

		}
	}

}
