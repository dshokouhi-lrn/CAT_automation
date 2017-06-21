package com.lrn.cat.page;

import org.openqa.selenium.JavascriptExecutor;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class ExportToWord extends CATAppCommon{
	
	static public void exportToWordCourse(String showHidden, String showKC, String showCert, String showBulletin, String showTop10, String showFAQ, String showPageID) throws Exception
	{
		try
		{
			Log.startTestCase("start exporting course to word");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			   
			Thread.sleep(1000);
			
			clickIdentifierByID("courseExportToWordBtn");
			
			Thread.sleep(3000);
			
			if (showHidden == "yes")
				clickIdentifierXpath(".//*[@id='exportToWord']/div/div[3]/div/div[1]/input");
			
			if (showHidden == "no")
				clickIdentifierXpath(".//*[@id='exportToWord']/div/div[3]/div/div[2]/input");
			
			if (showKC == "yes")
				clickIdentifierXpath(".//*[@id='exportToWord']/div/div[4]/div/div[1]/input");
			
			if (showKC == "no")
				clickIdentifierXpath(".//*[@id='exportToWord']/div/div[4]/div/div[2]/input");
			
			if (showCert == "yes")
				clickIdentifierXpath(".//*[@id='exportToWord']/div/div[5]/div/div[1]/input");
			
			if (showCert == "no")
				clickIdentifierXpath(".//*[@id='exportToWord']/div/div[5]/div/div[2]/input");
			
			if (showBulletin == "yes")
				clickIdentifierXpath(".//*[@id='exportToWord']/div/div[6]/div/div[1]/input");
			
			if (showBulletin == "no")
				clickIdentifierXpath(".//*[@id='exportToWord']/div/div[6]/div/div[2]/input");
			
			if (showTop10 == "yes")
				clickIdentifierXpath(".//*[@id='exportToWord']/div/div[7]/div/div[1]/input");
			
			if (showTop10 == "no")
				clickIdentifierXpath(".//*[@id='exportToWord']/div/div[7]/div/div[2]/input");
			
			if (showFAQ == "yes")
				clickIdentifierXpath(".//*[@id='exportToWord']/div/div[8]/div/div[1]/input");
			
			if (showFAQ == "no")
				clickIdentifierXpath(".//*[@id='exportToWord']/div/div[8]/div/div[2]/input");
			
			if (showPageID == "yes")
				clickIdentifierXpath(".//*[@id='exportToWord']/div/div[9]/div/div[1]/input");
			
			if (showPageID == "no")
				clickIdentifierXpath(".//*[@id='exportToWord']/div/div[9]/div/div[2]/input");
			
			Log.info("configured export to word options");
			
			//Thread.sleep(1000);
			
			clickIdentifierXpath(".//*[@id='exportToWord']/div[1]/div[10]/input");
			
			//Thread.sleep(10);
			
			String export = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			if (export.contains("Course Exported to Word"))
			{
				Log.pass("course successfully exported to word");
			}
			
			else
				Log.fail("course did not export for reason: " + export);
		}
		
		catch(Exception e){  
		       Log.fail("Failed to export to word course");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to export to word course");
		       e.printStackTrace();
		       throw e;

		}
	}

}
