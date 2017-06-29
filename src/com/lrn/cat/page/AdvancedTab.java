package com.lrn.cat.page;

import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class AdvancedTab extends CATAppCommon{
	
	static public void setupAdvancedFeatures(String lrnLogo, String progressBar, String pageNumbers, String resourcesMenu, String pageLock, String hideFooter, String learnerRetry) throws Exception
	{
		try
		{
			Log.startTestCase("Start configuring advanced features");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			Thread.sleep(1000);
			
			clickIdentifierXpath(".//*[@id='menuTabs']/ul/li[8]/p");
			
			Thread.sleep(3000);
			
			if (lrnLogo == "yes")
				clickIdentifierXpath(".//*[@id='advanceToggleSection']/div[1]/div/div[2]/span/input");
			if (lrnLogo == "no")
				clickIdentifierXpath(".//*[@id='advanceToggleSection']/div[1]/div/div[3]/span/input");
			
			if (progressBar == "yes")
				clickIdentifierXpath(".//*[@id='advanceToggleSection']/div[2]/div/div[2]/span/input");
			if (progressBar == "no")
				clickIdentifierXpath(".//*[@id='advanceToggleSection']/div[2]/div/div[3]/span/input");
			
			if (pageNumbers == "yes")
				clickIdentifierXpath(".//*[@id='advanceToggleSection']/div[3]/div/div[2]/span/input");
			if (pageNumbers == "no")
				clickIdentifierXpath(".//*[@id='advanceToggleSection']/div[3]/div/div[3]/span/input");
			
			if (resourcesMenu == "yes")
				clickIdentifierXpath(".//*[@id='advanceToggleSection']/div[4]/div/div[2]/span/input");
			if (resourcesMenu == "no")
				clickIdentifierXpath(".//*[@id='advanceToggleSection']/div[4]/div/div[3]/span/input");
			
			if (pageLock == "yes")
				clickIdentifierXpath(".//*[@id='advanceToggleSection']/div[5]/div/div[2]/span/input");
			if (pageLock == "no")
				clickIdentifierXpath(".//*[@id='advanceToggleSection']/div[5]/div/div[3]/span/input");
			
			if (hideFooter == "yes")
				clickIdentifierXpath(".//*[@id='advanceToggleSection']/div[6]/div/div[2]/span/input");
			if (hideFooter == "no")
				clickIdentifierXpath(".//*[@id='advanceToggleSection']/div[6]/div/div[3]/span/input");
			
			if (learnerRetry != "")
				typeTextById("retakeAttempt", learnerRetry);
			
			jse.executeScript("window.scrollTo(0,0)", "");
			
			clickIdentifierXpath(".//*[@id='advanceFeatureForm']/div[1]/input");
			
			String checkedIn = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			if (checkedIn.contains("Data saved"))
			{
				Log.pass("advanced features configured and saved");
			}
			
			else
				Log.fail("advanced features did not save for reason: " + checkedIn);
			
		}
		
		catch(Exception e){  
            Log.fail("Failed to configure advanced features");
            e.printStackTrace();
            throw e;                                        
     } catch(AssertionError e)
     {
            Log.fail("Failed to configure advanced features");
            e.printStackTrace();
            throw e;

     }
	}
	
	static public void endOfCourseConfiguration(String printCert, String printCertLabel) throws Exception
	{
		try
		{
			Log.info("configuring eoc");
			
			Date d = new Date();
			
			clickIdentifierXpath(".//*[@id='pageAccordian']/h5[2]");
			
			Thread.sleep(2000);
			
			if (printCert == "yes")
				clickIdentifierXpath(".//*[@id='eocCourseMessageSection']/div[1]/div/div[2]/span/input");
			if (printCert == "no")
				clickIdentifierXpath(".//*[@id='eocCourseMessageSection']/div[1]/div/div[3]/span/input");
			
			if (printCertLabel != "")
				typeTextById("printCertButtonText", printCertLabel + " " + d.toString());
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			clickIdentifierXpath(".//*[@id='advanceFeatureForm']/div[1]/input");
			
			String checkedIn = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			if (checkedIn.contains("Data saved"))
			{
				Log.pass("advanced features configured and saved");
			}
			
			else
				Log.fail("advanced features did not save for reason: " + checkedIn);
			
		}
		
		catch(Exception e){  
            Log.fail("Failed end of course configuration");
            e.printStackTrace();
            throw e;                                        
     } catch(AssertionError e)
     {
            Log.fail("Failed end of course configuration");
            e.printStackTrace();
            throw e;

     }
	}
	
	static public void courseWindowSize(String windowSize, String fullorCustom, String courseWidth, String courseHeight) throws Exception
	{
		try
		{
			Log.info("configuring course window size");
			
			clickIdentifierXpath(".//*[@id='pageAccordian']/h5[3]");
			
			Thread.sleep(2000);
			
			if (windowSize == "yes")
			{
				clickIdentifierXpath(".//*[@class='customizeWindowSizeSelect']/div[2]/div[1]/span/input");
				
				if (fullorCustom == "full")
					clickIdentifierXpath(".//*[@class='customizeWindowSizeSelect']/div[3]/div[1]/span/input");
				
				if (fullorCustom == "custom")
				{
					clickIdentifierXpath(".//*[@class='customizeWindowSizeSelect']/div[3]/div[2]/span/input");
					
					typeTextByXpath(".//*[@class='customizeWindowSizeSelect']/div[4]/div[2]/span[1]/input", courseWidth);
					
					typeTextByXpath(".//*[@class='customizeWindowSizeSelect']/div[4]/div[2]/span[2]/input", courseHeight);
				}
			}
			if (windowSize == "no")
				clickIdentifierXpath(".//*[@class='customizeWindowSizeSelect']/div[2]/div[2]/span/input");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			clickIdentifierXpath(".//*[@id='advanceFeatureForm']/div[1]/input");
			
			String checkedIn = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			if (checkedIn.contains("Data saved"))
			{
				Log.pass("advanced features configured and saved");
			}
			
			else
				Log.fail("advanced features did not save for reason: " + checkedIn);
			
		}
		
		catch(Exception e){  
            Log.fail("Failed to customize course window size");
            e.printStackTrace();
            throw e;                                        
     } catch(AssertionError e)
     {
            Log.fail("Failed to customize course window size");
            e.printStackTrace();
            throw e;

     }
	}

}
