package com.lrn.cat.page;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class LandingPage extends CATAppCommon{
	
	static public void addLandingPage(String enableLanding, String desktopImage1, String desktopImage2, String desktopImage3, String desktopImage4, String mobileImage1, String mobileImage2, String mobileImage3, String mobileImage4, String landingText, String courseDuration, String desktop, String tablet, String mobile, String desktopNormal, String desktopHover, String mobileNormal) throws Exception
	{
		try
		{
			Date d = new Date();
			
			Log.startTestCase("start adding landing page");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			Thread.sleep(1000);
			
			if (isElementPresent(By.xpath(".//*[@id='addLandingPageButton']/li/p")))
				clickIdentifierXpath(".//*[@id='addLandingPageButton']/li/p");
			else
				clickIdentifierXpath(".//*[@id='courseTree']/ul/li/ul/li[1]/a");
			
			if (enableLanding != "")
			{
				//checkCheckBox(".//*[@id='videoAutoPlay']/div[2]/div/div[2]/div/input");
				WebElement check1 = driver.findElement(By.id("hasLandingPage"));
				Boolean value = check1.isSelected();
				Log.info("landing page is " + value);
				
				if (value && enableLanding =="no")
				{
					clickIdentifierXpath(".//*[@id='landingPageForm']/div[2]/div[2]/div[2]/div/div/span");
					Log.info("turned off landing page");
				}
				
				if (!value && enableLanding =="yes")
				{
					clickIdentifierXpath(".//*[@id='landingPageForm']/div[2]/div[2]/div[2]/div/div/span");
					Log.info("turned on landing page");
				}
			}
			
			if (desktopImage1 != "")
			{
				clickIdentifierXpath(".//*[@id='dsktpImgSection']/div[1]/img[4]");
				uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
				Thread.sleep(6000);
				Log.info("uploaded desktop image 1");
			}
			
			if (desktopImage2 != "")
			{
				clickIdentifierXpath(".//*[@id='dsktpImgSection']/div[2]/img[4]");
				uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
				Thread.sleep(6000);
				Log.info("uploaded desktop image 2");
			}
			
			if (desktopImage3 != "")
			{
				clickIdentifierXpath(".//*[@id='dsktpImgSection']/div[3]/img[4]");
				uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
				Thread.sleep(6000);
				Log.info("uploaded desktop image 3");
			}
			
			if (desktopImage4 != "")
			{
				clickIdentifierXpath(".//*[@id='dsktpImgSection']/div[4]/img[4]");
				uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
				Thread.sleep(6000);
				Log.info("uploaded desktop image 4");
			}
			
			if (mobileImage1 != "")
			{
				clickIdentifierXpath(".//*[@id='mblImgSection']/div[1]/img[4]");
				uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
				Thread.sleep(6000);
				Log.info("uploaded mobile image 1");
			}
			
			if (mobileImage2 != "")
			{
				clickIdentifierXpath(".//*[@id='mblImgSection']/div[2]/img[4]");
				uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
				Thread.sleep(6000);
				Log.info("uploaded mobile image 2");
			}
			
			if (mobileImage3 != "")
			{
				clickIdentifierXpath(".//*[@id='mblImgSection']/div[3]/img[4]");
				uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
				Thread.sleep(6000);
				Log.info("uploaded mobile image 3");
			}
			
			if (mobileImage4 != "")
			{
				clickIdentifierXpath(".//*[@id='mblImgSection']/div[4]/img[4]");
				uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
				Thread.sleep(6000);
				Log.info("uploaded mobile image 4");
			}
			
			if (landingText != "")
				typeTextById("pgCaption", landingText + " " + d.toString());
			
			if (courseDuration != "")
			{
				//checkCheckBox(".//*[@id='videoAutoPlay']/div[2]/div/div[2]/div/input");
				WebElement check1 = driver.findElement(By.id("courseDurationCompatible"));
				Boolean value = check1.isSelected();
				Log.info("course duration is " + value);
				
				if (value && courseDuration =="no")
				{
					clickIdentifierXpath(".//*[@id='landingPageForm']/div[2]/fieldset/div[2]/div[2]/div/div/span");
					Log.info("turned off course duration");
				}
				
				if (!value && courseDuration =="yes")
				{
					clickIdentifierXpath(".//*[@id='landingPageForm']/div[2]/fieldset/div[2]/div[2]/div/div/span");
					Log.info("turned on course duration");
				}
			}
			
			if (desktop != "")
			{
				//checkCheckBox(".//*[@id='videoAutoPlay']/div[2]/div/div[2]/div/input");
				WebElement check1 = driver.findElement(By.id("dsktpCompatible"));
				Boolean value = check1.isSelected();
				Log.info("desktop is " + value);
				
				if (value && desktop =="no")
				{
					clickIdentifierXpath(".//*[@id='landingPageForm']/div[2]/fieldset/div[3]/div[2]/div/div/span");
					Log.info("turned off desktop");
				}
				
				if (!value && desktop =="yes")
				{
					clickIdentifierXpath(".//*[@id='landingPageForm']/div[2]/fieldset/div[3]/div[2]/div/div/span");
					Log.info("turned on desktop");
				}
			}
			
			if (tablet != "")
			{
				//checkCheckBox(".//*[@id='videoAutoPlay']/div[2]/div/div[2]/div/input");
				WebElement check1 = driver.findElement(By.id("tabCompatible"));
				Boolean value = check1.isSelected();
				Log.info("tablet is " + value);
				
				if (value && tablet =="no")
				{
					clickIdentifierXpath(".//*[@id='landingPageForm']/div[2]/fieldset/div[4]/div[2]/div/div/span");
					Log.info("turned off tablet");
				}
				
				if (!value && tablet =="yes")
				{
					clickIdentifierXpath(".//*[@id='landingPageForm']/div[2]/fieldset/div[4]/div[2]/div/div/span");
					Log.info("turned on tablet");
				}
			}
			
			if (mobile != "")
			{
				//checkCheckBox(".//*[@id='videoAutoPlay']/div[2]/div/div[2]/div/input");
				WebElement check1 = driver.findElement(By.id("mblCompatible"));
				Boolean value = check1.isSelected();
				Log.info("mobile is " + value);
				
				if (value && mobile =="no")
				{
					clickIdentifierXpath(".//*[@id='landingPageForm']/div[2]/fieldset/div[5]/div[2]/div/div/span");
					Log.info("turned off mobile");
				}
				
				if (!value && mobile =="yes")
				{
					clickIdentifierXpath(".//*[@id='landingPageForm']/div[2]/fieldset/div[5]/div[2]/div/div/span");
					Log.info("turned on mobile");
				}
			}
			
			if (desktopNormal != "")
			{
				clickIdentifierXpath(".//*[@id='divDsktpStartBtn']/img[4]");
				uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
				Thread.sleep(6000);
				Log.info("uploaded desktop normal start button");
			}
			
			if (desktopHover != "")
			{
				clickIdentifierXpath(".//*[@id='divDsktpStartBtnHover']/img[4]");
				uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
				Thread.sleep(6000);
				Log.info("uploaded desktop hover start button");
			}
			
			if (mobileNormal != "")
			{
				clickIdentifierXpath(".//*[@id='divMblStartBtn']/img[4]");
				uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
				Thread.sleep(6000);
				Log.info("uploaded mobile normal start button");
			}
			
			clickIdentifierByID("landingPageSave");
			
			String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (pageSaved.contains("Landing Page saved"))
				Log.pass("landing page saved");
			else
				Log.fail("landing page failed to save for reason: " + pageSaved);
			
			
		}
		
		catch(Exception e){  
		       Log.fail("Failed to add landing page");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to add landing page");
		       e.printStackTrace();
		       throw e;

		}
	}

}
