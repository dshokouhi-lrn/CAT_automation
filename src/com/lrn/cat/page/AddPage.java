package com.lrn.cat.page;


import org.openqa.selenium.JavascriptExecutor;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class AddPage extends CATAppCommon {

	static public void addPage(String template) throws Exception
	{
		try {
		
			Log.startTestCase("adding a " + template + " page");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			String template1 = "";
			
			if (template == "consult")
				template1 = "0-0";
			
			if (template == "text")
				template1 = "0-1";
			
			if (template == "consent")
				template1 = "0-2";
			
			if (template == "hotspot")
				template1 = "0-3";
			
			if (template == "binary")
				template1 = "0-4";
			
			if (template == "selectable")
				template1 = "1-0";
			
			if (template == "sidebar")
				template1 = "1-1";
			
			if (template == "dnd")
				template1 = "1-2";
			
			if (template == "saq")
				template1 = "1-3";
			
			if (template == "carousel")
				template1 = "1-4";
			
			if (template == "video")
				template1 = "2-0";
			
			if (template == "snr")
				template1 = "2-1";
			
			if (template == "concern")
				template1 = "2-2";
			
			if (template == "multiple")
				template1 = "2-3";
			
			Thread.sleep(1000);
			
			clickIdentifierXpath("//*[@id='courseTreeOperationIcons']/li[3]");
			
			Thread.sleep(300);
			
			clickIdentifierXpath("//*[@id='template-row-column-image-" + template1 + "']/img");
			
			Log.info("selected the " + template + " template");
			
			//clickIdentifierXpath(".//div[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']/div/button[1]");
			
			clickIdentifierXpath(".//div[@aria-describedby='dialogArea']/div[3]/div/button[1]");
			
			Log.pass(template + " page added");
			
			Thread.sleep(10000);

		}
		
		catch(Exception e){  
		       Log.fail("Failed to add page");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to add page");
		       e.printStackTrace();
		       throw e;

		}
		
	}
}
