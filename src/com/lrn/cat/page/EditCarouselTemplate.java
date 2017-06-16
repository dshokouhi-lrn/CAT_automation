package com.lrn.cat.page;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class EditCarouselTemplate extends CATAppCommon{
	
	static public void editCarouselTemplate(String screenTitle, String screenText1, String screenText2, String screenText3, String screenText4, String screenAudio, String screenAutoPlay, String screenDesktop, String screenMobile, String screenImageDesc, String screenAltText, String carouselAutoPlay, String pageAudio) throws Exception
	{
		try
		{
			Date d = new Date();
			
			Log.startTestCase("Start edit carousel template");
			
			if (screenTitle != "")
				typeTextByXpath(".//*[@id='carouselScreens']/div[2]/div[1]/div[2]/fieldset/div[1]/div/div/div", screenTitle + " " + d.toString());
			
			if (screenText1 != "")
				typeTextByXpath(".//*[@id='carouselScreens']/div[2]/div[1]/div[2]/fieldset/div[3]/div/div", screenText1 + " " + d.toString());
			
			if (screenText2 != "")
				typeTextByXpath(".//*[@id='carouselScreens']/div[2]/div[1]/div[2]/fieldset/div[4]/div/div", screenText2 + " " + d.toString());
			
			if (screenText3 != "")
				typeTextByXpath(".//*[@id='carouselScreens']/div[2]/div[1]/div[2]/fieldset/div[5]/div/div", screenText3 + " " + d.toString());
			
			if (screenText4 != "")
				typeTextByXpath(".//*[@id='carouselScreens']/div[2]/div[1]/div[2]/fieldset/div[6]/div/div", screenText4 + " " + d.toString());
			
			/*if (screenAudio != "")
			{
				clickIdentifierXpath(".//*[@id='carouselScreens']/div[2]/div[1]/div[2]/fieldset/div[7]/ul/div/div/div[1]/div[1]/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\audio\\Ambianica.mp3");
				Thread.sleep(3000);
				Log.info("uploaded carousel screen 1 audio");	
			}*/
			
			if (screenAutoPlay != "")
				typeTextByXpath(".//*[@id='carouselScreens']/div[2]/div[1]/div[2]/fieldset/div[7]/div[1]/p/span/input", screenAutoPlay);
			
			if (screenDesktop != "")
			{
				clickIdentifierXpath(".//*[@id='carouselScreens']/div[2]/div[1]/div[2]/fieldset/div[7]/div[2]/ul/div[2]/div[2]/div[1]/div[1]/div[1]/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Hydrangeas.jpg");
				Thread.sleep(5000);
				Log.info("uploaded screen 1 desktop image");
			}
			
			if (screenMobile != "")
			{
				clickIdentifierXpath(".//*[@id='carouselScreens']/div[2]/div[1]/div[2]/fieldset/div[7]/div[2]/ul/div[2]/div[2]/div[1]/div[1]/div[2]/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Hydrangeas.jpg");
				Thread.sleep(5000);
				Log.info("uploaded screen 1 mobile image");
			}
			
			if (screenImageDesc != "")
				typeTextByXpath(".//*[@id='carouselScreens']/div[2]/div[1]/div[2]/fieldset/div[7]/div[2]/ul/div[2]/div[2]/div[2]/div[1]/input", screenImageDesc + " " + d.toString());
			
			if (screenAltText != "")
				typeTextByXpath(".//*[@id='carouselScreens']/div[2]/div[1]/div[2]/fieldset/div[7]/div[2]/ul/div[2]/div[2]/div[2]/div[2]/input", screenAltText + " " + d.toString());
			
			if (carouselAutoPlay != "")
			{
				WebElement check1 = driver.findElement(By.id("carouselAutoplayFlag"));
				Boolean value = check1.isSelected();
				Log.info("carousel autoplay is " + value);
				
				if (value && carouselAutoPlay =="no")
				{
					clickIdentifierXpath(".//*[@class='ulClassCarouselAutoPlay']/div[2]/div[1]/div[2]/div[1]/div/label[1]");
					Log.info("turned off carousel autoplay");
				}
				
				if (!value && carouselAutoPlay =="yes")
				{
					clickIdentifierXpath(".//*[@class='ulClassCarouselAutoPlay']/div[2]/div[1]/div[2]/div[1]/div/label[1]");
					Log.info("turned on carousel autoplay");
				}
			}

			
			/*if (pageAudio.toLowerCase() == "yes")
			{
				checkCheckBox(".//*[@id='carouselPageAudioFlag']");
				clickIdentifierXpath(".//*[@id='page_uploadAudio']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\audio\\Ambianica.mp3");
				Thread.sleep(3000);
				Log.info("uploaded carousel audio");
			}
			
			if (pageAudio.toLowerCase() == "no")
			{
				uncheckCheckBox(".//*[@id='carouselPageAudioFlag']");
				Log.info("turned off audio for carousel template");
			}*/
			
			Thread.sleep(1000);
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			clickIdentifierByID("saveIconId");
			
			//Thread.sleep(1000);
			
			String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (pageSaved.contains("Page saved"))
				Log.pass("page saved");
			else
				Log.fail("page failed to save for reason: " + pageSaved);
			
			if (screenAudio != "")
			{
				clickIdentifierXpath(".//*[@id='carouselScreens']/div[2]/div[1]/div[2]/fieldset/div[7]/ul/div/div/div[1]/div[1]/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\audio\\Ambianica.mp3");
				Thread.sleep(3000);
				Log.info("uploaded carousel screen 1 audio");	
			}
			
			if (pageAudio != "")
			{
				WebElement check1 = driver.findElement(By.id("carouselPageAudioFlag"));
				Boolean value = check1.isSelected();
				Log.info("page audio is " + value);
				
				if (value && pageAudio =="no")
				{
					clickIdentifierXpath(".//*[@class='ulClassCarouselAutoPlay']/div[2]/div[1]/div[2]/div[1]/div/label[1]");
					Log.info("turned off page audio");
				}
				
				if (!value && pageAudio =="yes")
				{
					clickIdentifierXpath(".//*[@class='ulClassCarouselAutoPlay']/div[2]/div[1]/div[2]/div[1]/div/label[1]");
					Log.info("turned on page audio");
					
					clickIdentifierXpath(".//*[@id='page_uploadAudio']/img");
					uploadFile("C:\\github\\CAT_automation\\resource\\audio\\Ambianica.mp3");
					Thread.sleep(3000);
					Log.info("uploaded carousel audio");
				}
			}
			
			JavascriptExecutor jse1 = (JavascriptExecutor)driver;
			jse1.executeScript("window.scrollTo(0,0)", "");
			
			clickIdentifierByID("saveIconId");
			
			//Thread.sleep(1000);
			
			String pageSaved1 = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (pageSaved1.contains("Page saved"))
				Log.pass("page saved");
			else
				Log.fail("page failed to save for reason: " + pageSaved1);
		}
		
		
		catch(Exception e){  
            Log.fail("Failed to edit carousel template");
            e.printStackTrace();
            throw e;                                        
     } catch(AssertionError e)
     {
            Log.fail("Failed to edit carousel template");
            e.printStackTrace();
            throw e;

     }
	}
	
	static public void addCarouselScreen(int screenNumber, String screenTitle, String screenText1, String screenText2, String screenText3, String screenText4, String screenAudio, String screenAutoPlay, String screenDesktop, String screenMobile, String screenImageDesc, String screenAltText) throws Exception
	{
		try
		{
			Date d = new Date();
			
			int screenCount = screenNumber + 1;
			
			Log.startTestCase("Start adding additional carousel screen number: " + screenNumber);
			
			clickIdentifierXpath(".//*[@id='carouselScreens']/div[2]/div[2]/p/img");
			
			if (screenTitle != "")
				typeTextByXpath(".//*[@id='carouselScreens']/div[2]/div[1]/div[" + screenCount + "]/fieldset/div[1]/div/div/div", screenTitle + " " + d.toString());
			
			if (screenText1 != "")
				typeTextByXpath(".//*[@id='carouselScreens']/div[2]/div[1]/div[" + screenCount + "]/fieldset/div[3]/div/div", screenText1 + " " + d.toString());
			
			if (screenText2 != "")
				typeTextByXpath(".//*[@id='carouselScreens']/div[2]/div[1]/div[" + screenCount + "]/fieldset/div[4]/div/div", screenText2 + " " + d.toString());
			
			if (screenText3 != "")
				typeTextByXpath(".//*[@id='carouselScreens']/div[2]/div[1]/div[" + screenCount + "]/fieldset/div[5]/div/div", screenText3 + " " + d.toString());
			
			if (screenText4 != "")
				typeTextByXpath(".//*[@id='carouselScreens']/div[2]/div[1]/div[" + screenCount + "]/fieldset/div[6]/div/div", screenText4 + " " + d.toString());
			
			
			if (screenAudio != "")
			{
				clickIdentifierXpath(".//*[@id='carouselScreens']/div[2]/div[1]/div[" + screenCount + "]/fieldset/div[7]/ul/div/div/div[1]/div[1]/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\audio\\Ambianica.mp3");
				Thread.sleep(3000);
				Log.info("uploaded carousel screen " + screenNumber + " audio");	
			}
			
			if (screenAutoPlay != "")
				typeTextByXpath(".//*[@id='carouselScreens']/div[2]/div[1]/div[" + screenCount + "]/fieldset/div[7]/div[1]/p/span/span/input", screenAutoPlay);
			
			if (screenDesktop != "")
			{
				clickIdentifierXpath(".//*[@id='carouselScreens']/div[2]/div[1]/div[" + screenCount + "]/fieldset/div[7]/div[2]/ul/div[2]/div[2]/div[1]/div[1]/div[1]/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Hydrangeas.jpg");
				Thread.sleep(5000);
				Log.info("uploaded screen " + screenNumber + " desktop image");
			}
			
			if (screenMobile != "")
			{
				clickIdentifierXpath(".//*[@id='carouselScreens']/div[2]/div[1]/div[" + screenCount + "]/fieldset/div[7]/div[2]/ul/div[2]/div[2]/div[1]/div[1]/div[2]/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Hydrangeas.jpg");
				Thread.sleep(5000);
				Log.info("uploaded screen " + screenNumber + " mobile image");
			}
			
			if (screenImageDesc != "")
				typeTextByXpath(".//*[@id='carouselScreens']/div[2]/div[1]/div[" + screenCount + "]/fieldset/div[7]/div[2]/ul/div[2]/div[2]/div[2]/div[1]/input", screenImageDesc + " " + d.toString());
			
			if (screenAltText != "")
				typeTextByXpath(".//*[@id='carouselScreens']/div[2]/div[1]/div[" + screenCount + "]/fieldset/div[7]/div[2]/ul/div[2]/div[2]/div[2]/div[2]/input", screenAltText + " " + d.toString());
			
			clickIdentifierByID("saveIconId");
			
			String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (pageSaved.contains("Page saved"))
				Log.pass("screen " + screenNumber + " saved");
			else
				Log.fail("screen " + screenNumber + " failed to save for reason: " + pageSaved);
		
			
		}
		
		catch(Exception e){  
            Log.fail("Failed to add additional carousel screen");
            e.printStackTrace();
            throw e;                                        
     } catch(AssertionError e)
     {
            Log.fail("Failed to add additional carousel screen");
            e.printStackTrace();
            throw e;

     }
	}

}
