package com.lrn.cat.page;

import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class EditConsentTemplate extends CATAppCommon{
	
	static public void editConsentTemplate(String pageTitle, String showTitle, String markComplete, String pageContent, String consentButton, String desktopImage, String mobileImage, String desktopImageDesc, String desktopAltText, String mobileImageDesc, String mobileAltText, String pageAudio, String backgroundImage) throws Exception
	{
		try
		{
			Date d = new Date();
			
			Log.startTestCase("start editing consent template");
			
			if (pageTitle != "")
				typeTextById("pageTitle", pageTitle + " " + d.toString());
			
			if (showTitle.toLowerCase() == "no")
			{
				uncheckCheckBox(".//input[@name='titleVisible']");
				Log.info("unchecked show title");
			}
			
			if (showTitle.toLowerCase() == "yes")
			{
				checkCheckBox(".//input[@name='titleVisible']");
				Log.info("checked show title");
			}
			
			if (markComplete.toLowerCase() == "no")
			{
				uncheckCheckBox(".//input[@name='markCouCmpl']");
				Log.info("unchecked show title");
			}
			
			if (markComplete.toLowerCase() == "yes")
			{
				checkCheckBox(".//input[@name='markCouCmpl']");
				Log.info("checked show title");
			}
			
			if (pageContent != "")
				typeTextById("ckeditorContentconscentContent1", pageContent + " " + d.toString());
			
			if (consentButton != "")
				typeTextById("ckeditorContentconscnetText1", consentButton + " " + d.toString());
			
			if (desktopImage != "")
			{
				clickIdentifierXpath("//*[@id='conscentImage']/div/div[1]/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Penguins.jpg");
				Thread.sleep(5000);
				Log.info("uploaded desktop image");
			}
			

			if (mobileImage != "")
			{
				clickIdentifierXpath("//*[@id='conscentImage_mobileReady']/div/div[1]/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Jellyfish.jpg");
				Thread.sleep(5000);
				Log.info("uploaded mobile image");
			}
			
			if (desktopImageDesc != "")
				typeTextById("graphicDescriptionconscentImage", desktopImageDesc + " " + d.toString());
			
			if (desktopAltText != "")
				typeTextById("altTextconscentImage", desktopAltText + " " + d.toString());
			
			if (mobileImageDesc != "")
				typeTextById("graphicDescriptionconscentImage_mobileReady", mobileImageDesc + " " + d.toString());
			
			if (mobileAltText != "")
				typeTextById("altTextconscentImage_mobileReady", mobileAltText + " " + d.toString());
			
			if (pageAudio.toLowerCase() == "yes")
			{
				
				uploadPageAudio();			
			}
			
			if (backgroundImage.toLowerCase() == "yes")
			{
				
				uploadBackgroundImage();
			}
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			clickIdentifierByID("ok-button");
			
			String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (pageSaved.contains("Page saved"))
				Log.pass("page saved");
			else
				Log.fail("page failed to save for reason: " + pageSaved);
		}
		
		catch(Exception e){  
		       Log.fail("Failed to edit consent template");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to edit consent template");
		       e.printStackTrace();
		       throw e;

		}
	}

}
