package com.lrn.cat.page;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class EditVideoTemplate1 extends CATAppCommon{
	
	static public void editVideoTemplate(String pageTitle, String showTitle, String pageContent, String autoPlay, String fullScreen, String addVideo, String addSrt, String webLink, String panelContent, String panelAudio, String desktopImage, String mobileImage, String imageDesc, String altText) throws Exception
	{
		try
		{  
			Date d = new Date();
			 
			Log.startTestCase("start editing video template");
			 
			//Thread.sleep(5000);
			 
			 //need to make dynamic
			//typeTextById("pageTitle", "page title " + d.toString());
			//typeTextById("ckeditorContentvideoContent", "video content " + d.toString());
			//Thread.sleep(8000);
			
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
				typeTextById("ckeditorContentvideoContent", pageContent + " " + d.toString());
			
			if (autoPlay != "")
			{
				//checkCheckBox(".//*[@id='videoAutoPlay']/div[2]/div/div[2]/div/input");
				WebElement check1 = driver.findElement(By.id("videoAutoplayFlag"));
				Boolean value = check1.isSelected();
				Log.info("autoplay is " + value);
				
				if (value && autoPlay =="no")
				{
					clickIdentifierXpath(".//*[@id='videoAutoPlay']/div[2]/div/div[2]/div/div/label[2]");
					Log.info("turned off autoplay");
				}
				
				if (!value && autoPlay =="yes")
				{
					clickIdentifierXpath(".//*[@id='videoAutoPlay']/div[2]/div/div[2]/div/div/label[2]");
					Log.info("turned on autoplay");
				}
				
			}
			
			if (fullScreen != "")
			{
				//clickIdentifierXpath(".//*[@id='videoAutoPlay']/div[3]/div/div[2]/div/div/label[2]");
				WebElement check1 = driver.findElement(By.id("data-video-size"));
				Boolean value = check1.isSelected();
				Log.info("video fullscreen is " + value);
				
				if (value && fullScreen =="no")
				{
					clickIdentifierXpath(".//*[@id='videoAutoPlay']/div[3]/div/div[2]/div/div/label[2]");
					Log.info("turned off fullscreen");
				}
				
				if (!value && fullScreen =="yes")
				{
					clickIdentifierXpath(".//*[@id='videoAutoPlay']/div[3]/div/div[2]/div/div/label[2]");
					Log.info("turned on fullscreen");
				}
			}

			   
			//driver.findElement(By.xpath(".//*[@id='videoAutoPlay']/div[3]/div/div[2]/div/div/span")).click();
			//Log.info("Clicked on toggle button to YES");
			
			if (addVideo == "yes")
			{
				clickIdentifierXpath(".//*[@id='videoUpload']/div/div[2]/label[1]/div/label");
				
				Thread.sleep(3000);
				clickIdentifierXpath("//div[@id='jw-player-video1-div']");
				
				Thread.sleep(3000);
				
				Log.info("Clicked on Video field to open Image libary");
				   	   
				   
				clickIdentifierXpath(".//*[@id='uploadAMedia']/label");
				Thread.sleep(3000);
				clickIdentifierByID("fileToUpload");
				Thread.sleep(3000);
				uploadFile("C:\\github\\CAT_automation\\resource\\video\\clipcanvas_14348_H264_640x360.mp4");
				Thread.sleep(30000);
				clickIdentifierXpath(".//div[@aria-describedby='uploadDialogArea']/div/button");
				Thread.sleep(3000);
				clickIdentifierXpath(".//div[@id='fileList']/div[2]/div[1]");
				Log.info("selecting video");
				   
				clickIdentifierXpath("//div[@aria-describedby='dialogArea']/div[3]/div/button[1]");
				Log.info("clicked on Ok");
				

			}
			   
			if (webLink == "yes")
			{
				clickIdentifierByID(".//*[@id='videoUpload']/div/div[2]/label[2]/div/label");
				typeTextById("webUrl", webLink);
			}
			   //clickIdentifierXpath("//div[@id='srt-div']");
			   //Log.info("selecting SRT");
			
			if (panelContent != "")
				typeTextById("ckeditorContentTextViewText0", panelContent + " " + d.toString());
			   
			if (desktopImage != "")
			{
				clickIdentifierXpath(".//*[@id='desktop-image-main-div-0-videoUploadPanel']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Penguins.jpg");
				Thread.sleep(5000);
				Log.info("uploaded desktop image");
			}
			
			if (mobileImage != "")
			{
				clickIdentifierXpath(".//*[@id='mobile-image-main-div-0-videoUploadPanel']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Jellyfish.jpg");
				Thread.sleep(5000);
				Log.info("uploaded mobile image");
			}
			
			if (imageDesc != "")
				typeTextById("widgetImageDescription-0-videoUploadPanel", imageDesc + " " + d.toString());
			
			if (altText != "")
				typeTextById("widgetAltTextBackgroundImage-0-videoUploadPanel", altText + " " + d.toString());
			   
			Thread.sleep(5000);
			  
			clickIdentifierXpath(".//*[@id='ok-button']");
			   
			String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
				
			Thread.sleep(3000);
				
			if (pageSaved.contains("Page saved"))
				Log.pass("page saved");
			else
				Log.fail("page failed to save for reason: " + pageSaved);
			
			if (addSrt == "yes")
			{
				clickIdentifierByID("srt-div");
				uploadFile("C:\\github\\CAT_automation\\resource\\srt\\vsshort-en.srt");
				Log.info("uploaded SRT file");
			}
			
			if (panelAudio != "")
			{
				clickIdentifierXpath(".//*[@id='widget1_uploadAudio']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\audio\\TechJam.mp3");
				Log.info("uploaded audio");
				Thread.sleep(5000);
			}
			
			Thread.sleep(5000);
			  
			clickIdentifierXpath(".//*[@id='ok-button']");
			   
			String pageSaved1 = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
				
			Thread.sleep(3000);
				
			if (pageSaved1.contains("Page saved"))
				Log.pass("page saved");
			else
				Log.fail("page failed to save for reason: " + pageSaved1);
			
		}
		
		catch(Exception e){  
		       Log.fail("Failed to edit video template");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to edit video template");
		       e.printStackTrace();
		       throw e;

		}
	}
	
	static public void addVideoPanel(int panelNumber, String panelContent, String panelAudio, String desktopImage, String mobileImage, String imageDesc, String altText) throws Exception
	{
		try
		{
			Date d = new Date();
			
			//String panels = Integer.toString(panelNumber);
			
			int panelPosition = panelNumber - 1;
			
			clickIdentifierXpath(".//*[@id='videoUploadPanel']/div[3]/div[1]");
			
			if (panelContent != "")
				typeTextById("ckeditorContentTextViewText" + panelPosition, panelContent + " " + d.toString());
			   
			if (desktopImage != "")
			{
				clickIdentifierXpath(".//*[@id='desktop-image-main-div-" + panelPosition + "-videoUploadPanel']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Penguins.jpg");
				Thread.sleep(5000);
				Log.info("uploaded desktop image");
			}
			
			if (mobileImage != "")
			{
				clickIdentifierXpath(".//*[@id='mobile-image-main-div-" + panelPosition + "-videoUploadPanel']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Jellyfish.jpg");
				Thread.sleep(5000);
				Log.info("uploaded mobile image");
			}
			
			if (imageDesc != "")
				typeTextById("widgetImageDescription-" + panelPosition + "-videoUploadPanel", imageDesc + " " + d.toString());
			
			if (altText != "")
				typeTextById("widgetAltTextBackgroundImage-" + panelPosition + "-videoUploadPanel", altText + " " + d.toString());
			
			if (panelAudio != "")
			{
				clickIdentifierXpath(".//*[@id='widget" + panelNumber + "_uploadAudio']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\audio\\TechJam.mp3");
				Log.info("uploaded audio");
				Thread.sleep(5000);
			}
			
			clickIdentifierXpath(".//*[@id='ok-button']");
			   
			String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
				
			Thread.sleep(3000);
				
			if (pageSaved.contains("Page saved"))
				Log.pass("panel saved");
			else
				Log.fail("panel failed to save for reason: " + pageSaved);
		}
		
		catch(Exception e){  
		       Log.fail("Failed to add video panel");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to add video panel");
		       e.printStackTrace();
		       throw e;

		}
	}
	
	static public void editNewBulletin(String enableBulletin, String bulletinLarge, String bulletinMandatory, String bulletinType, String bulletinTitle, String bulletinText) throws Exception
	{
		try
		{
			Date d = new Date();
			
			Log.startTestCase("start adding new bulletin");
			
			if (enableBulletin != "")
			{
				//clickIdentifierXpath(".//*[@id='tab1']/div/div[1]/div[2]/div/div/span");
				//Log.info("bulletin enabled");
				
				WebElement check1 = driver.findElement(By.id("bulletinVisible"));
				Boolean value = check1.isSelected();
				Log.info("bulletin is " + value);
				
				if (value && enableBulletin =="no")
				{
					clickIdentifierXpath(".//*[@id='tab1']/div/div[1]/div[2]/div/div/span");
					Log.info("turned off bulletin");
				}
				
				if (!value && enableBulletin =="yes")
				{
					clickIdentifierXpath(".//*[@id='tab1']/div/div[1]/div[2]/div/div/span");
					Log.info("turned on bulletin");
				}
			}
			
			if (bulletinLarge != "")
			{
				//clickIdentifierXpath(".//*[@id='tab1']/div/div[2]/div/div[2]/div/div/span");
				WebElement check1 = driver.findElement(By.id("bulletinSize"));
				Boolean value = check1.isSelected();
				Log.info("bulletin large is " + value);
				
				if (value && bulletinLarge =="no")
				{
					clickIdentifierXpath(".//*[@id='tab1']/div/div[2]/div/div[2]/div/div/span");
					Log.info("turned off bulletin large");
				}
				
				if (!value && bulletinLarge =="yes")
				{
					clickIdentifierXpath(".//*[@id='tab1']/div/div[2]/div/div[2]/div/div/span");
					Log.info("turned on bulletin large");
				}
			}

			if (bulletinMandatory != "")
			{
				//clickIdentifierXpath(".//*[@id='tab1']/div/div[3]/div[1]/div[1]/div[2]/div/div/span");
				//Log.info("bulletin is now optional");
				
				WebElement check1 = driver.findElement(By.id("bulletinOption"));
				Boolean value = check1.isSelected();
				Log.info("bulletin mandatory is " + value);
				
				if (value && bulletinMandatory =="no")
				{
					clickIdentifierXpath(".//*[@id='tab1']/div/div[3]/div[1]/div[1]/div[2]/div/div/span");
					Log.info("turned off bulletin mandatory");
				}
				
				if (!value && bulletinMandatory =="yes")
				{
					clickIdentifierXpath(".//*[@id='tab1']/div/div[3]/div[1]/div[1]/div[2]/div/div/span");
					Log.info("turned on bulletin mandatory");
				}
			}
			
			//driver.findElement(By.xpath(".//*[@id='tab1']/div/div[1]/div[2]/div/div/span")).click();
			//Log.info("Clicked on toggle button Yes for bulletin");
			   
			//driver.findElement(By.xpath(".//*[@id='tab1']/div/div[2]/div/div[2]/div/div/span")).click();
			//Log.info("Clicked on toggle button Yes for Large bulletin");
			//Thread.sleep(5000);  
			  // typeTextByXpath(".//div[@id='ckeditorContentBulletin']","Bulletin Title");
			
			if (bulletinType != "")
				clickIdentifierByID(bulletinType);
			
			if (bulletinTitle != "")
				typeTextById("ckeditorContentBulletinTitle", bulletinTitle + " " + d.toString());
			//Log.info("Entered bulletin title");
			//Thread.sleep(500);
			
			if (bulletinText != "")
				typeTextById("ckeditorContentBulletin", bulletinText + " " + d.toString());
			//Log.info("Entered bulletin text");
			 
			//driver.findElement(By.xpath(".//*[@id='tab1']/div/div[3]/div[5]/div[2]/div/div/span")).click();
			
			clickIdentifierXpath(".//*[@id='ok-button']");
			   
			String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
				
			Thread.sleep(3000);
				
			if (pageSaved.contains("Page saved"))
				Log.pass("bulletin saved");
			else
				Log.fail("bulletin failed to save for reason: " + pageSaved);
		}
		
		catch(Exception e){  
		       Log.fail("Failed to edit bulletin");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to edit bulletin");
		       e.printStackTrace();
		       throw e;

		}
	}

}
