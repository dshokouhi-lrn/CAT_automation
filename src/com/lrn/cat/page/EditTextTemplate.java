package com.lrn.cat.page;

import java.util.Date;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;


public class EditTextTemplate extends CATAppCommon{
	
	static public void editTextTemplate(String layout, String pageTitle, String showTitle, String pageContent, String desktopImage, String mobileImage, String audioFile, String imageDesc, String altText) throws Exception
	{
		try
		{
			Date d = new Date();
			
			Log.startTestCase("editing text and graphic");
			
			Thread.sleep(1000);
			
			if (layout != "")
				clickIdentifierByID("layout-" + layout + "-main");
			
			if (pageTitle != "")
				typeTextById("pageTitle", pageTitle + " " + d.toString());
			
			if (showTitle == "no")
			{
				uncheckCheckBox("//*[@id='pageTitleId']/div/div/div/div/input");
				Log.info("unchecked show title");
			}
			
			if (showTitle == "yes")
			{
				checkCheckBox("//*[@id='pageTitleId']/div/div/div/div/input");
				Log.info("checked show title");
			}
			
			if (pageContent != "")
				typeTextById("ckeditorContenttextGraphic_content", pageContent + " " + d.toString());
			
			
			if (audioFile != "")
			{
				clickIdentifierXpath("//*[@id='page_uploadAudio']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\audio\\TechJam.mp3");
				Thread.sleep(3000);
				Log.info("uploaded audio");
			}
			
			if (desktopImage != "")
			{
				clickIdentifierXpath("//*[@id='desktop-image-main-div-textGraphic_image']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Penguins.jpg");
				Thread.sleep(5000);
				Log.info("uploaded desktop image");
			}
			
			if (mobileImage != "")
			{
				clickIdentifierXpath("//*[@id='mobile-image-main-div-textGraphic_image']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Jellyfish.jpg");
				Thread.sleep(5000);
				Log.info("uploaded mobile image");
			}
			
			if (imageDesc != "")
				typeTextById("widgetImageDescription-textGraphic_image", imageDesc + " " + d.toString());
			
			if (altText != "")
				typeTextById("widgetAltTextBackgroundImage-textGraphic_image", altText + " " + d.toString());
			
			clickIdentifierByID("saveIconId");
			
			String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (pageSaved.contains("Page saved"))
				Log.pass("page saved");
			else
				Log.fail("page failed to save for reason: " + pageSaved);
		}
		
		catch(Exception e){  
		       Log.fail("Failed to edit text template");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to edit text template");
		       e.printStackTrace();
		       throw e;

		}
	}

}
