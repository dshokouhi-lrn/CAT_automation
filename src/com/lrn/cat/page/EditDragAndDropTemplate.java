package com.lrn.cat.page;

import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class EditDragAndDropTemplate extends CATAppCommon{
	
	static public void editDragAndDropTemplate(String pageTitle, String showTitle, String pageLayout, String pageContent, String categoryText, String categoryImage, String categoryImageDesc, String categoryAltText, String lineItemText, String lineItemCategory, String lineItemImage, String lineItemImageDesc, String lineItemAltText, String dndRetryNumber, String dndRetryTitle, String dndRetryMessage, String dndRetryButton, String feedbackOption, String singleFeedback, String singleImage, String singleImageDesc, String singleAltText, String correctTitle, String correctContent, String correctImage, String correctImageDesc, String correctAltText, String incorrectTitle, String incorrectContent, String incorrectImage, String incorrectImageDesc, String incorrectAltText, String pageAudio, String backgroundImage) throws Exception
	{
		try
		{
			Date d = new Date();
			
			Log.startTestCase("start editing drag and drop template");
			
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
			
			if (pageLayout == "Drag and Drop With Flags" || pageLayout == "Drag and Drop Without Flags")
				selectDropdownValueXpathVisibleText(".//*[@id='dragOptionslayout']/div[1]/div/select", pageLayout);
			
			if (pageContent != "")
				typeTextById("ckeditorContentdragOptionsContent", pageContent + " " + d.toString());
			
			if (categoryText != "")
				typeTextById("categoryTextdragOptionsMultiText1", categoryText + " " + d.toString());
			
			if (categoryImage != "")
			{
				clickIdentifierXpath(".//*[@id='categoryNameDivdragOptionsMultiText1']/div[5]/div[2]/img");
				uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
				Thread.sleep(5000);
				Log.info("uploaded category 1 image");
			}
			
			if (categoryImageDesc != "")
				typeTextByXpath(".//*[@id='categoryNameDivdragOptionsMultiText1']/div[6]/input", categoryImageDesc + " " + d.toString());
			
			if (categoryAltText != "")
				typeTextByXpath(".//*[@id='categoryNameDivdragOptionsMultiText1']/div[7]/input", categoryAltText + " " + d.toString());
			
			if (lineItemText != "")
				typeTextById("lineItemdragOptionsMultiText1", lineItemText + " " + d.toString());
			
			if (lineItemCategory != "")
				selectDropdownValueXpathVisibleText(".//*[@id='lineItemDivdragOptionsMultiText1']/div[5]/select", lineItemCategory);
			
			if (lineItemImage != "")
			{
				clickIdentifierXpath(".//*[@id='lineItemDivdragOptionsMultiText1']/div[7]/div[1]/img");
				uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
				Thread.sleep(5000);
				Log.info("uploaded line item 1 image");
			}
			
			if (lineItemImageDesc != "")
				typeTextByXpath(".//*[@id='lineItemDivdragOptionsMultiText1']/div[8]/input", lineItemImageDesc + " " + d.toString());
			
			if (lineItemAltText != "")
				typeTextByXpath(".//*[@id='lineItemDivdragOptionsMultiText1']/div[9]/input", lineItemAltText + " " + d.toString());
			
			
			//fix dnd issues
			if (dndRetryNumber != "")
				typeTextById("titleTextdragOptionsRetryAttempt", dndRetryNumber);
			
			if (dndRetryTitle != "")
				typeTextById("titleTextdragOptionsRetryAlertTitle", dndRetryTitle + " " + d.toString());
			
			if (dndRetryMessage != "")
				typeTextById("ckeditorContentdragOptionsRetryAlertText", dndRetryMessage + " " + d.toString());
			
			if (dndRetryButton != "")
				typeTextById("titleTextdragOptionsRetryAlertButtonTitle", dndRetryButton + " " + d.toString());
			
			if (feedbackOption.toLowerCase() == "single")
			{
				clickIdentifierXpath(".//*[@id='dragOptionsFeedback']/div/div/input[1]");
				
				if (singleFeedback != "")
					typeTextByXpath(".//*[@id='dragOptionsFeedback']/div[1]/div[2]/div[2]/div", singleFeedback + " " + d.toString());
				
				if (singleImage != "")
				{
					clickIdentifierXpath(".//*[@id='dragOptionsFeedback']/div[1]/div[2]/div[3]/div/div[2]/img");
					uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
					Thread.sleep(5000);
					Log.info("uploaded feedback image");
				}
				
				if (singleImageDesc != "")
					typeTextByXpath(".//*[@id='dragOptionsFeedback']/div[1]/div[2]/div[3]/div[2]/input", singleImageDesc + " " + d.toString());
				
				if (singleAltText != "")
					typeTextByXpath(".//*[@id='dragOptionsFeedback']/div[1]/div[2]/div[3]/div[3]/input", singleAltText + " " + d.toString());
			}
			
			if (feedbackOption.toLowerCase() == "multiple")
			{
				clickIdentifierXpath(".//*[@id='dragOptionsFeedback']/div/div/input[2]");
				
				if (correctTitle != "")
					typeTextByXpath(".//*[@id='dragOptionsFeedback']/div[1]/div[3]/div[1]/input", correctTitle + " " + d.toString());
				
				if (incorrectTitle != "")
					typeTextByXpath(".//*[@id='dragOptionsFeedback']/div[1]/div[3]/div[2]/input", incorrectTitle + " " + d.toString());
				
				if (correctContent != "")
					typeTextById("ckeditorContentCorrectdragOptionsFeedback", correctContent + " " + d.toString());
				
				if (incorrectContent != "")
					typeTextById("ckeditorContentIncorrectdragOptionsFeedback", incorrectContent + " " + d.toString());
				
				if (correctImage != "")
				{
					clickIdentifierXpath(".//*[@id='dragOptionsFeedback']/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/img");
					uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
					Thread.sleep(5000);
					Log.info("uploaded correct feedback image");
				}
				
				if (incorrectImage != "")
				{
					clickIdentifierXpath(".//*[@id='dragOptionsFeedback']/div[1]/div[3]/div[2]/div[3]/div[1]/div[2]/img");
					uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
					Thread.sleep(5000);
					Log.info("uploaded incorrect feedback image");
				}
				
				if (correctImageDesc != "")
					typeTextByXpath(".//*[@id='dragOptionsFeedback']/div/div[3]/div[1]/div[2]/div[2]/input", correctImageDesc + " " + d.toString());
				
				if (correctAltText != "")
					typeTextByXpath(".//*[@id='dragOptionsFeedback']/div/div[3]/div[1]/div[2]/div[3]/input", correctAltText + " " + d.toString());
				
				if (incorrectImageDesc != "")
					typeTextByXpath(".//*[@id='dragOptionsFeedback']/div/div[3]/div[2]/div[3]/div[2]/input", incorrectImageDesc + " " + d.toString());
				
				if (incorrectAltText != "")
					typeTextByXpath(".//*[@id='dragOptionsFeedback']/div/div[3]/div[2]/div[3]/div[3]/input", incorrectAltText + " " + d.toString());
				
			}
			
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
		       Log.fail("Failed to edit drag and drop template");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to edit drag and drop template");
		       e.printStackTrace();
		       throw e;

		}
	}
	
	static public void addCategory(String categoryPosition, String categoryText, String categoryImage, String categoryImageDesc, String categoryAltText) throws Exception
	{
		try
		{
			
			Date d = new Date();
			
			Log.info("adding category " + categoryPosition);
			
			clickIdentifierByID("multiTitle_adddragOptionsMultiText");
			
			if (categoryText != "")
				typeTextById("categoryTextdragOptionsMultiText" + categoryPosition, categoryText + " " + d.toString());
			
			if (categoryImage != "")
			{
				clickIdentifierXpath(".//*[@id='categoryNameDivdragOptionsMultiText" + categoryPosition + "']/div[6]/div[2]/img");
				uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
				Thread.sleep(5000);
				Log.info("uploaded category " + categoryPosition + " image");
			}
			
			if (categoryImageDesc != "")
				typeTextByXpath(".//*[@id='categoryNameDivdragOptionsMultiText" + categoryPosition + "']/div[7]/input", categoryImageDesc + " " + d.toString());
			
			if (categoryAltText != "")
				typeTextByXpath(".//*[@id='categoryNameDivdragOptionsMultiText" + categoryPosition + "']/div[8]/input", categoryAltText + " " + d.toString());
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			clickIdentifierByID("ok-button");
			
			String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (pageSaved.contains("Page saved"))
				Log.pass("category " + categoryPosition + " saved");
			else
				Log.fail("category " + categoryPosition + " failed to save for reason: " + pageSaved);
			
		}
		
		catch(Exception e){  
		       Log.fail("Failed to add drag and drop category " + categoryPosition);
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to add drag and drop category " + categoryPosition);
		       e.printStackTrace();
		       throw e;
		}
	}
	
	static public void addLineItem(String lineItemPosition, String lineItemText, String lineItemCategory, String lineItemImage, String lineItemImageDesc, String lineItemAltText) throws Exception
	{
		try
		{
			Date d = new Date();
			
			clickIdentifierByID("multiText_adddragOptionsMultiText");
			
			Log.info("adding line item " + lineItemPosition);
			
			if (lineItemText != "")
				typeTextById("lineItemdragOptionsMultiText" + lineItemPosition, lineItemText + " " + d.toString());
			
			if (lineItemCategory != "")
				selectDropdownValueXpathVisibleText(".//*[@id='lineItemDivdragOptionsMultiText" + lineItemPosition + "']/div[6]/select", lineItemCategory);
			
			if (lineItemImage != "")
			{
				clickIdentifierXpath(".//*[@id='lineItemDivdragOptionsMultiText" + lineItemPosition + "']/div[8]/div[1]/img");
				uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
				Thread.sleep(5000);
				Log.info("uploaded line item " + lineItemPosition + " image");
			}
			
			if (lineItemImageDesc != "")
				typeTextByXpath(".//*[@id='lineItemDivdragOptionsMultiText" + lineItemPosition + "']/div[9]/input", lineItemImageDesc + " " + d.toString());
			
			if (lineItemAltText != "")
				typeTextByXpath(".//*[@id='lineItemDivdragOptionsMultiText" + lineItemPosition + "']/div[10]/input", lineItemAltText + " " + d.toString());
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			clickIdentifierByID("ok-button");
			
			String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (pageSaved.contains("Page saved"))
				Log.pass("line item " + lineItemPosition + " saved");
			else
				Log.fail("line item " + lineItemPosition + " failed to save for reason: " + pageSaved);
			
		}
		
		catch(Exception e){  
		       Log.fail("Failed to add drag and drop line item " + lineItemPosition);
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to add drag and drop line item " + lineItemPosition);
		       e.printStackTrace();
		       throw e;
		}
	}
}
