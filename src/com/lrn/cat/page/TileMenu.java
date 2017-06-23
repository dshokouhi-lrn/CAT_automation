package com.lrn.cat.page;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;


public class TileMenu extends CATAppCommon{
	
	static public void configureTileMenu(String enableTileMenu, int tilesPerRow1, String welcomeText, String enableActive, String activeText, String enableKC, String kcText, String enableCert, String certText, String completeText, String lessonNavigation, String jumpToLesson) throws Exception
	{
		try
		{
			Date d = new Date();
			
			Log.startTestCase("start configuring tile menu");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			clickIdentifierXpath(".//div[@id='menuTabs']/ul/li[2]/p");
			
			Thread.sleep(3000);
			
			clickIdentifierXpath("//*[@id='courseTree']/ul/li/a");
			
			Thread.sleep(3000);
			
			if (enableTileMenu != "")
			{
				//checkCheckBox(".//*[@id='videoAutoPlay']/div[2]/div/div[2]/div/input");
				WebElement check1 = driver.findElement(By.id("hasTileMenu"));
				Boolean value = check1.isSelected();
				Log.info("tile menu is " + value);
				
				if (value && enableTileMenu =="no")
				{
					clickIdentifierXpath(".//*[@id='tileMenuForm']/div[2]/div[2]/div[2]/div/div/span");
					Log.info("turned off tile menu");
				}
				
				if (!value && enableTileMenu =="yes")
				{
					clickIdentifierXpath(".//*[@id='tileMenuForm']/div[2]/div[2]/div[2]/div/div/span");
					Log.info("turned on tile menu");
				}
			}
			
			String tilesPerRow = Integer.toString(tilesPerRow1);
			
			if (tilesPerRow1 < 5)
				clickIdentifierXpath(".//*[@id='tileMenuForm']/div[2]/div[3]/div[2]/div[" + tilesPerRow + "]/img");
			
			if (welcomeText != "")
			{
				//checkCheckBox(".//*[@id='videoAutoPlay']/div[2]/div/div[2]/div/input");
				WebElement check1 = driver.findElement(By.xpath(".//*[@id='tileMenuForm']/div[2]/div[4]/fieldset[1]/div[1]/div/div/input"));
				Boolean value = check1.isSelected();
				Log.info("welcome message default is " + value);
				
				if (value && welcomeText !="")
				{
					clickIdentifierXpath(".//*[@id='tileMenuForm']/div[2]/div[4]/fieldset[1]/div[1]/div/div/label");
					Log.info("turned off welcome message default");
					typeTextById("welcomeMsg", welcomeText + " " + d.toString());
				}
				
				if (!value && welcomeText =="")
				{
					clickIdentifierXpath(".//*[@id='tileMenuForm']/div[2]/div[4]/fieldset[1]/div[1]/div/div/label");
					Log.info("turned on welcome message default");
				}
			}
			
			if (enableActive != "")
			{
				//checkCheckBox(".//*[@id='videoAutoPlay']/div[2]/div/div[2]/div/input");
				WebElement check1 = driver.findElement(By.xpath(".//*[@id='tileMenuForm']/div[2]/div[4]/fieldset[2]/legend/div/input"));
				Boolean value = check1.isSelected();
				Log.info("lessons in progress message is " + value);
				
				if (value && enableActive == "no")
				{
					clickIdentifierXpath(".//*[@id='tileMenuForm']/div[2]/div[4]/fieldset[2]/legend/div/div/span");
					Log.info("turned off lessons in progress message");
				}
				
				if (!value && enableActive == "yes")
				{
					clickIdentifierXpath(".//*[@id='tileMenuForm']/div[2]/div[4]/fieldset[2]/legend/div/div/span");
					Log.info("turned on lessons in progress message");

					
					if (activeText != "")
					{
						//checkCheckBox(".//*[@id='videoAutoPlay']/div[2]/div/div[2]/div/input");
						WebElement check11 = driver.findElement(By.xpath(".//*[@id='tileMenuForm']/div[2]/div[4]/fieldset[2]/div[1]/div/div/div/input"));
						Boolean value1 = check11.isSelected();
						Log.info("active message default is " + value1);
						
						if (value1 && activeText !="")
						{
							clickIdentifierXpath(".//*[@id='tileMenuForm']/div[2]/div[4]/fieldset[2]/div[1]/div/div/div/label");
							Log.info("turned off active message default");
							typeTextById("actvLsnMsg", activeText + " " + d.toString());
						}
						
						if (!value1 && activeText =="")
						{
							clickIdentifierXpath(".//*[@id='tileMenuForm']/div[2]/div[4]/fieldset[2]/div[1]/div/div/div/label");
							Log.info("turned on active message default");
						}
					}
				}
			}
			
			int count = driver.findElements(By.xpath(".//*[@id='tileMenuForm']/div[2]/div[4]/fieldset")).size();
			
			if (enableKC != "")
			{
				//checkCheckBox(".//*[@id='videoAutoPlay']/div[2]/div/div[2]/div/input");
				WebElement check1 = driver.findElement(By.xpath(".//*[@id='tileMenuForm']/div[2]/div[4]/fieldset[3]/legend/div/input"));
				Boolean value = check1.isSelected();
				Log.info("lessons in progress message is " + value);
				
				if (value && enableKC == "no")
				{
					clickIdentifierXpath(".//*[@id='tileMenuForm']/div[2]/div[4]/fieldset[3]/legend/div/div/span");
					Log.info("turned off kc message");
				}
				
				if (!value && enableKC == "yes")
				{
					clickIdentifierXpath(".//*[@id='tileMenuForm']/div[2]/div[4]/fieldset[3]/legend/div/div/span");
					Log.info("turned on kc message");

					
					if (kcText != "")
					{
						//checkCheckBox(".//*[@id='videoAutoPlay']/div[2]/div/div[2]/div/input");
						WebElement check11 = driver.findElement(By.xpath(".//*[@id='tileMenuForm']/div[2]/div[4]/fieldset[3]/div[1]/div/div/div/input"));
						Boolean value1 = check11.isSelected();
						Log.info("kc message default is " + value1);
						
						if (value1 && kcText !="")
						{
							clickIdentifierXpath(".//*[@id='tileMenuForm']/div[2]/div[4]/fieldset[3]/div[1]/div/div/div/label");
							Log.info("turned off kc message default");
							typeTextById("knldgChckMsg", kcText + " " + d.toString());
						}
						
						if (!value1 && kcText =="")
						{
							clickIdentifierXpath(".//*[@id='tileMenuForm']/div[2]/div[4]/fieldset[3]/div[1]/div/div/div/label");
							Log.info("turned on kc message default");
						}
					}
				}
			}
			
			int certCount = 4;
			
			if (count == 4)
				certCount = 3;

			if (enableCert != "")
			{
				//checkCheckBox(".//*[@id='videoAutoPlay']/div[2]/div/div[2]/div/input");
				WebElement check1 = driver.findElement(By.xpath(".//*[@id='tileMenuForm']/div[2]/div[4]/fieldset[" + certCount + "]/legend/div/input"));
				Boolean value = check1.isSelected();
				Log.info("cert message is " + value);
				
				if (value && enableCert == "no")
				{
					clickIdentifierXpath(".//*[@id='tileMenuForm']/div[2]/div[4]/fieldset[" + certCount + "]/legend/div/div/span");
					Log.info("turned off cert message");
				}
				
				if (!value && enableCert == "yes")
				{
					clickIdentifierXpath(".//*[@id='tileMenuForm']/div[2]/div[4]/fieldset[" + certCount + "]/legend/div/div/span");
					Log.info("turned on cert message");

					if (certText != "")
					{
						//checkCheckBox(".//*[@id='videoAutoPlay']/div[2]/div/div[2]/div/input");
						WebElement check11 = driver.findElement(By.xpath(".//*[@id='tileMenuForm']/div[2]/div[4]/fieldset[" + certCount + "]/div[1]/div/div/div/input"));
						Boolean value1 = check11.isSelected();
						Log.info("cert message default is " + certText);
						
						if (value1 && certText !="")
						{
							clickIdentifierXpath(".//*[@id='tileMenuForm']/div[2]/div[4]/fieldset[" + certCount + "]/div[1]/div/div/div/label");
							Log.info("turned off cert message default");
							typeTextById("crtMsg", certText + " " + d.toString());
						}
						
						if (!value1 && certText =="")
						{
							clickIdentifierXpath(".//*[@id='tileMenuForm']/div[2]/div[4]/fieldset[" + certCount + "]/div[1]/div/div/div/label");
							Log.info("turned on cert message default");
						}
					}
				}
			}
			
			if (completeText != "")
			{
				//checkCheckBox(".//*[@id='videoAutoPlay']/div[2]/div/div[2]/div/input");
				WebElement check11 = driver.findElement(By.xpath(".//*[@id='tileMenuForm']/div[2]/div[4]/fieldset[" + count + "]/div[1]/div/div/input"));
				Boolean value1 = check11.isSelected();
				Log.info("complete message default is " + value1);
				
				if (value1 && completeText !="")
				{
					clickIdentifierXpath(".//*[@id='tileMenuForm']/div[2]/div[4]/fieldset[" + count + "]/div[1]/div/div/label");
					Log.info("turned off complete message default");
					typeTextById("completionMsg", completeText + " " + d.toString());
				}
				
				if (!value1 && completeText =="")
				{
					clickIdentifierXpath(".//*[@id='tileMenuForm']/div[2]/div[4]/fieldset[" + count + "]/div[1]/div/div/label");
					Log.info("turned on complete message default");
				}
			}
			
			if (lessonNavigation == "linear")
				clickIdentifierXpath(".//*[@id='tileMenuForm']/div[2]/div[4]/div[2]/div[3]/label[2]/div/label");
			
			if (lessonNavigation == "exploratory")
				clickIdentifierXpath(".//*[@id='tileMenuForm']/div[2]/div[4]/div[2]/div[3]/label[1]/div/label");
			
			if (jumpToLesson != "")
			{
				//checkCheckBox(".//*[@id='videoAutoPlay']/div[2]/div/div[2]/div/input");
				WebElement check1 = driver.findElement(By.id("hasJumpLesson"));
				Boolean value = check1.isSelected();
				Log.info("jump to lesson is " + value);
				
				if (value && jumpToLesson == "no")
				{
					clickIdentifierXpath(".//*[@id='tileMenuForm']/div[2]/div[4]/div[3]/div[2]/div/div/span");
					Log.info("turned off jump to lesson");
				}
				
				if (!value && jumpToLesson == "yes")
				{
					clickIdentifierXpath(".//*[@id='tileMenuForm']/div[2]/div[4]/div[3]/div[2]/div/div/span");
					Log.info("turned on jump to lesson");
				}
			}
			
			Thread.sleep(1000);
			
			clickIdentifierByID("saveButtonImage");
			
			Log.info("clicked on save button");
			
			String lessonSaved1 = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (lessonSaved1.contains("Tile Menu Saved"))
				Log.pass("tile menu saved");
			else
				Log.fail("tile menu failed to save for reason: " + lessonSaved1);
			
		}
		
		catch(Exception e){  
            Log.fail("Failed to configure tile menu");
            e.printStackTrace();
            throw e;                                        
     } catch(AssertionError e)
     {
            Log.fail("Failed to configure tile menu");
            e.printStackTrace();
            throw e;
     }
}

	
	
	static public void tileConfiguration(String tilePosition, String tileDesc, String tileType, String tileImage, String tileImageDesc, String tileAltText, String tileColor) throws Exception
	{
		try
		{
			Date d = new Date();
			
			if (tileDesc != "")
				typeTextByXpath(".//*[@class='lesson-panels']/div[" + tilePosition + "]/div[2]/div/div", tileDesc + " " + d.toString());
			
			if (tileType == "solid")
				clickIdentifierXpath(".//*[@class='lesson-panels']/div[" + tilePosition + "]/div[3]/div[2]/img");
			
			if (tileType == "fifty")
			{
				clickIdentifierXpath(".//*[@class='lesson-panels']/div[" + tilePosition + "]/div[3]/div[3]/img");
			
				if (tileImage != "")
				{
					clickIdentifierXpath(".//*[@class='lesson-panels']/div[" + tilePosition + "]/div[4]/div/div[1]/div[1]/img[4]");
					uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
					Thread.sleep(6000);
					Log.info("uploaded tile image");
				}
				
				if (tileImageDesc != "")
					typeTextByXpath(".//*[@class='lesson-panels']/div[" + tilePosition + "]/div[4]/div/div[2]/textarea", tileImageDesc + " " + d.toString());
			
				if (tileAltText != "")
					typeTextByXpath(".//*[@class='lesson-panels']/div[" + tilePosition + "]/div[4]/div/div[2]/div/textarea", tileAltText + " " + d.toString());
			}
			
			if (tileType == "full")
			{
				clickIdentifierXpath(".//*[@class='lesson-panels']/div[" + tilePosition + "]/div[3]/div[4]/img");
			
				if (tileImage != "")
				{
					clickIdentifierXpath(".//*[@class='lesson-panels']/div[" + tilePosition + "]/div[4]/div/div[1]/div[1]/img[4]");
					uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
					Thread.sleep(6000);
					Log.info("uploaded tile image");
				}
				

				if (tileImageDesc != "")
					typeTextByXpath(".//*[@class='lesson-panels']/div[" + tilePosition + "]/div[4]/div/div[2]/textarea", tileImageDesc + " " + d.toString());
			
				if (tileAltText != "")
					typeTextByXpath(".//*[@class='lesson-panels']/div[" + tilePosition + "]/div[4]/div/div[2]/div/textarea", tileAltText + " " + d.toString());
			}
			
			if (tileColor == "light")
				clickIdentifierXpath(".//*[@class='lesson-panels']/div[" + tilePosition + "]/div[5]/div[2]/label[1]/div/label");
			
			if (tileColor == "dark")
				clickIdentifierXpath(".//*[@class='lesson-panels']/div[" + tilePosition + "]/div[5]/div[2]/label[2]/div/label");
			
			Thread.sleep(1000);
			
			clickIdentifierByID("saveButtonImage");
			
			Log.info("clicked on save button");
			
			String lessonSaved1 = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (lessonSaved1.contains("Tile Menu Saved"))
				Log.pass("tile menu saved");
			else
				Log.fail("tile menu failed to save for reason: " + lessonSaved1);
			
		}
		
		catch(Exception e){  
	            Log.fail("Failed to configure tile menu");
	            e.printStackTrace();
	            throw e;                                        
	     } catch(AssertionError e)
	     {
	            Log.fail("Failed to configure tile menu");
	            e.printStackTrace();
	            throw e;
	     }
		
		
		
	}

}
