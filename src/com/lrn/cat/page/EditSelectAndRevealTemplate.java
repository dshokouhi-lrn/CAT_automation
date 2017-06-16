package com.lrn.cat.page;

import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class EditSelectAndRevealTemplate extends CATAppCommon{
	
	static public void editSelectAndRevealTemplate(String pageTitle, String showTitle, String layoutReveal, String snrText, String revealOrder, String revealText, String revealTitle, String revealImage, String revealImageDesc, String revealAltText, String revealAudio, String pageAudio, String backgroundImage) throws Exception
	{
		try
		{
			Date d = new Date();
			
			Log.startTestCase("start editing select and reveal");
			
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
			
			if (layoutReveal == "Left To Right" || layoutReveal == "Right To Left" || layoutReveal == "Bottom To Top" || layoutReveal == "Top To Bottom" || layoutReveal == "Full Screen Graphic")
				selectDropdownValueXpathVisibleText(".//*[@id='selectAndRevealLayout']/div[1]/div/select", layoutReveal);
			
			if (snrText != "")
				typeTextById("ckeditorContentselectAndRevealContent", snrText + " " + d.toString());
			
			if (revealOrder == "Random" || revealOrder == "Sequential")
				selectDropdownValueXpathVisibleText(".//*[@id='selectAndRevealTypeLayout']/div[1]/div/select", revealOrder);
			
			if  (revealText != "")
				typeTextById("ckeditorselectAndRevealText", revealText + " " + d.toString());
			
			if (revealTitle != "")
				typeTextById("desc_richTextselectAndRevealText", revealTitle + " " + d.toString());
			
			if (revealImage != "")
			{
				clickIdentifierXpath(".//*[@id='selectAndRevealText']/ul[1]/li[1]/div[1]/div[4]/div[2]/div[1]/div[1]/img");
				uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
				Thread.sleep(6000);
				Log.info("uploaded reveal 1 image");
			}
			
			if (revealImageDesc != "")
				typeTextByXpath(".//*[@id='selectAndRevealText']/ul[1]/li[1]/div[1]/div[4]/div[3]/div/input", revealImageDesc + " " + d.toString());
			
			if (revealAltText != "")
				typeTextByXpath(".//*[@id='selectAndRevealText']/ul[1]/li[1]/div[1]/div[4]/div[4]/div/input", revealAltText + " " + d.toString());
			
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
			
			Thread.sleep(1000);
			
			clickIdentifierByID("ok-button");
			
			String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (pageSaved.contains("Page saved"))
				Log.pass("page saved");
			else
				Log.fail("page failed to save for reason: " + pageSaved);
			
			if (revealAudio != "")
			{
				clickIdentifierXpath(".//*[@id='selectAndRevealText']/ul[1]/li[1]/div[1]/div[6]/div[2]/input");
				Thread.sleep(1000);
				clickIdentifierXpath(".//*[@id='audBtn_1']");
				Thread.sleep(1000);
				uploadFile("C:\\github\\CAT_automation\\resource\\audio\\Ambianica.mp3");
				Thread.sleep(3000);
				clickIdentifierXpath("//*[@aria-describedby='selectDialog']/div[3]/div[1]/button");
				Thread.sleep(2000);
				Log.info("uploaded reveal 1 audio");
			}
			
			JavascriptExecutor jse1 = (JavascriptExecutor)driver;
			jse1.executeScript("window.scrollTo(0,0)", "");
			
			Thread.sleep(1000);
			
			clickIdentifierByID("ok-button");
			
			String pageSaved1 = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (pageSaved1.contains("Page saved"))
				Log.pass("page saved");
			else
				Log.fail("page failed to save for reason: " + pageSaved1);
			
		}
		
		catch(Exception e){  
		       Log.fail("Failed to edit select and reveal page");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to edit select and reveal page");
		       e.printStackTrace();
		       throw e;

		}
	}
	
	static public void editRevealPanel(int revealPosition1, String revealText, String revealTitle, String revealImage, String revealImageDesc, String revealAltText, String revealAudio) throws Exception
	{
		try
		{
			Date d = new Date();
			
			String revealPosition = Integer.toString(revealPosition1);
			
			int revealPosition2 = revealPosition1 - 1;
			
			String revealPosition3 = Integer.toString(revealPosition2);
			
			if (revealText != "" || revealTitle != "" || revealImage != "" || revealImageDesc != "" || revealAltText != "" || revealAudio != "")
			{
				if (revealPosition1 >= 5)
					clickIdentifierByID("multiGraphicContentContainer_addselectAndRevealText");
				
				if  (revealText != "")
					typeTextById("ckeditorselectAndRevealText" + revealPosition3, revealText + " " + d.toString());
				
				if (revealTitle != "")
					typeTextById("desc_richTextselectAndRevealText" + revealPosition3, revealTitle + " " + d.toString());
				
				if (revealImage != "")
				{
					clickIdentifierXpath(".//*[@id='selectAndRevealText']/ul[1]/li[" + revealPosition + "]/div[1]/div[5]/div[2]/div[1]/div[1]/img");
					uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
					Thread.sleep(6000);
					Log.info("uploaded reveal " + revealPosition + " image");
				}
				
				if (revealImageDesc != "")
					typeTextByXpath(".//*[@id='selectAndRevealText']/ul[1]/li[" + revealPosition + "]/div[1]/div[5]/div[3]/div/input", revealImageDesc + " " + d.toString());
				
				if (revealAltText != "")
					typeTextByXpath(".//*[@id='selectAndRevealText']/ul[1]/li[" + revealPosition + "]/div[1]/div[5]/div[4]/div/input", revealAltText + " " + d.toString());
				
				if (revealAudio != "")
				{
					clickIdentifierXpath(".//*[@id='selectAndRevealText']/ul[1]/li[" + revealPosition + "]/div[1]/div[7]/div[2]/input");
					Thread.sleep(1000);
					clickIdentifierXpath(".//*[@id='audBtn_1']");
					Thread.sleep(1000);
					uploadFile("C:\\github\\CAT_automation\\resource\\audio\\Ambianica.mp3");
					Thread.sleep(3000);
					clickIdentifierXpath("//*[@aria-describedby='selectDialog']/div[3]/div[1]/button");
					Thread.sleep(2000);
					Log.info("uploaded reveal " + revealPosition + " audio");
				}
			}
			
			else
			{
				clickIdentifierXpath(".//*[@id='selectAndRevealText']/ul[1]/li[" + revealPosition + "]/div[1]/div[1]");
				
				Log.info("deleted reveal panel " + revealPosition);
			}
			
			JavascriptExecutor jse1 = (JavascriptExecutor)driver;
			jse1.executeScript("window.scrollTo(0,0)", "");
			
			Thread.sleep(1000);
			
			clickIdentifierByID("ok-button");
			
			String pageSaved1 = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (pageSaved1.contains("Page saved"))
				Log.pass("page saved");
			else
				Log.fail("page failed to save for reason: " + pageSaved1);
			
		}
		
		catch(Exception e){  
		       Log.fail("Failed to edit select and reveal page");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to edit select and reveal page");
		       e.printStackTrace();
		       throw e;

		}
	}

}
