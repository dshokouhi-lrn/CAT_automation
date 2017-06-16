package com.lrn.cat.page;

import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class EditSAQ extends CATAppCommon{
	
	static public void editSAQ(String pageTitle, String showTitle, String typeSAQ, String layoutSAQ, String questionText, String questionType, String correctAnswer, String answerText, String answerImage, String answerDesktopImage, String answerImageDesc, String answerAltText, String retryNumber, String retryTitle, String retryMessage, String retryButton, String feedbackOption, String singleFeedback, String singleImage, String singleImageDesc, String singleAltText, String correctTitle, String correctContent, String correctImage, String correctImageDesc, String correctAltText, String incorrectTitle, String incorrectContent, String incorrectImage, String incorrectImageDesc, String incorrectAltText, String desktopImage, String desktopImageDesc, String desktopAltText, String mobileImage, String mobileImageDesc, String mobileAltText, String pageAudio, String backgroundImage) throws Exception
	{
		try
		{
			Date d = new Date();
			
			Log.startTestCase("start editing SAQ");
			
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
			
			if (typeSAQ == "Text SAQ" || typeSAQ == "Graphical SAQ")
				selectDropdownValueXpathVisibleText(".//*[@id='SAQLayout1']/div[1]/div/select", typeSAQ);
			
			if (layoutSAQ == "Left To Right" || layoutSAQ == "Right To Left")
				selectDropdownValueXpathVisibleText(".//*[@id='SAQLayoutForView']/div[1]/div/select", layoutSAQ);
			
			if (questionText != "")
				typeTextById("ckeditorContentSAQQuestion1", questionText + " " + d.toString());
			
			if (questionType == "Multiple Choice" || questionType == "Check All")
				selectDropdownValueXpathVisibleText(".//*[@id='SAQType']/div[1]/div/select", questionType);
			
			if (correctAnswer.toLowerCase() == "no")
			{
				uncheckCheckBox(".//*[@id='multiGraphicContentContainerSAQAns1']/div/div/label/input");
				Log.info("unchecked correct answer");
			}
			
			if (correctAnswer.toLowerCase() == "yes")
			{
				checkCheckBox(".//*[@id='multiGraphicContentContainerSAQAns1']/div/div/label/input");
				Log.info("checked correct answer");
			}
			
			if (answerText != "")
				typeTextById("ckeditorSAQAns1", answerText + " " + d.toString());
			
			if (answerImage.toLowerCase() == "yes")
			{
				checkCheckBox(".//*[@id='multiGraphicContentContainerSAQAns1']/div/div[4]/div/label/input");
				Log.info("checked answer image");
			}
			
			if (answerDesktopImage != "")
			{
				clickIdentifierXpath(".//*[@id='multiGraphicContentContainerSAQAns1']/div/div[4]/div[2]/div/div[1]/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Penguins.jpg");
				Thread.sleep(5000);
				Log.info("uploaded answer image");
			}
			
			if (answerImageDesc != "")
				typeTextByXpath(".//*[@id='multiGraphicContentContainerSAQAns1']/div/div[4]/div[3]/div/input", answerImageDesc + " " + d.toString());
			
			if (answerAltText != "")
				typeTextByXpath(".//*[@id='multiGraphicContentContainerSAQAns1']/div/div[4]/div[4]/div/input", answerAltText + " " + d.toString());
			
			if (retryNumber != "")
				typeTextById("titleTextSAQRetryAttempt", retryNumber);
			
			if (retryTitle != "")
				typeTextById("titleTextSAQRetryAlertTitle", retryTitle + " " + d.toString());
			
			if (retryMessage != "")
				typeTextById("ckeditorContentSAQRetryAlertText", retryMessage + " " + d.toString());
			
			if (retryButton != "")
				typeTextById("titleTextSAQRetryAlertButtonTitle", retryButton + " " + d.toString());
			
			if (feedbackOption.toLowerCase() == "single")
			{
				clickIdentifierXpath(".//*[@id='SAQFeedback1']/div/div/input[1]");
				
				if (singleFeedback != "")
					typeTextByXpath(".//*[@id='SAQFeedback1']/div[1]/div[2]/div[2]/div", singleFeedback + " " + d.toString());
				
				if (singleImage != "")
				{
					clickIdentifierXpath(".//*[@id='SAQFeedback1']/div[1]/div[2]/div[3]/div/div[2]/img");
					uploadFile("C:\\github\\CAT_automation\\resource\\images\\Penguins.jpg");
					Thread.sleep(5000);
					Log.info("uploaded feedback image");
				}
				
				if (singleImageDesc != "")
					typeTextByXpath(".//*[@id='SAQFeedback1']/div[1]/div[2]/div[3]/div[2]/input", singleImageDesc + " " + d.toString());
				
				if (singleAltText != "")
					typeTextByXpath(".//*[@id='SAQFeedback1']/div[1]/div[2]/div[3]/div[3]/input", singleAltText + " " + d.toString());
			}
			
			if (feedbackOption.toLowerCase() == "multiple")
			{
				clickIdentifierXpath(".//*[@id='SAQFeedback1']/div/div/input[2]");
				
				if (correctTitle != "")
					typeTextById("correctTitle", correctTitle + " " + d.toString());
				
				if (incorrectTitle != "")
					typeTextById("incorrectTitle", incorrectTitle + " " + d.toString());
				
				if (correctContent != "")
					typeTextById("ckeditorContentCorrectSAQFeedback1", correctContent + " " + d.toString());
				
				if (incorrectContent != "")
					typeTextById("ckeditorContentIncorrectSAQFeedback1", incorrectContent + " " + d.toString());
				
				if (correctImage != "")
				{
					clickIdentifierXpath(".//*[@id='feedbackCorrectImage']/div[1]/div[2]/img");
					uploadFile("C:\\github\\CAT_automation\\resource\\images\\Penguins.jpg");
					Thread.sleep(5000);
					Log.info("uploaded correct feedback image");
				}
				
				if (incorrectImage != "")
				{
					clickIdentifierXpath(".//*[@id='feedbackIncorrectImage']/div[1]/div[2]/img");
					uploadFile("C:\\github\\CAT_automation\\resource\\images\\Penguins.jpg");
					Thread.sleep(5000);
					Log.info("uploaded incorrect feedback image");
				}
				
				if (correctImageDesc != "")
					typeTextByXpath(".//*[@id='SAQFeedback1']/div/div[3]/div[1]/div[2]/div[2]/input", correctImageDesc + " " + d.toString());
				
				if (correctAltText != "")
					typeTextByXpath(".//*[@id='SAQFeedback1']/div/div[3]/div[1]/div[2]/div[3]/input", correctAltText + " " + d.toString());
				
				if (incorrectImageDesc != "")
					typeTextByXpath(".//*[@id='SAQFeedback1']/div/div[3]/div[2]/div[3]/div[2]/input", incorrectImageDesc + " " + d.toString());
				
				if (incorrectAltText != "")
					typeTextByXpath(".//*[@id='SAQFeedback1']/div/div[3]/div[2]/div[3]/div[3]/input", incorrectAltText + " " + d.toString());
			
			}
			
			if (desktopImage != "")
			{
				clickIdentifierXpath(".//*[@id='SAQImage']/div/div[1]/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Penguins.jpg");
				Thread.sleep(5000);
				Log.info("uploaded saq desktop image");
			}
			
			if (mobileImage != "")
			{
				clickIdentifierXpath(".//*[@id='SAQImage_mobileReady']/div/div[1]/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Penguins.jpg");
				Thread.sleep(5000);
				Log.info("uploaded saq mobile image");
			}
			
			if (desktopImageDesc != "")
				typeTextByXpath(".//*[@id='SAQImage']/div/div[2]/input", desktopImageDesc + " " + d.toString());
			
			if (desktopAltText != "")
				typeTextByXpath(".//*[@id='SAQImage']/div/div[3]/input", desktopAltText + " " + d.toString());
			
			if (mobileImageDesc != "")
				typeTextByXpath(".//*[@id='SAQImage_mobileReady']/div/div[2]/input", mobileImageDesc + " " + d.toString());
			
			if (mobileAltText != "")
				typeTextByXpath(".//*[@id='SAQImage_mobileReady']/div/div[3]/input", mobileAltText + " " + d.toString());
			
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
		       Log.fail("Failed to edit SAQ template");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to edit SAQ template");
		       e.printStackTrace();
		       throw e;

		}
		
	}
	
	static public void addAnswerOption(int answerCount, String correctAnswer, String answerText, String answerImage, String answerDesktopImage, String answerImageDesc, String answerAltText) throws Exception
	{
		try
		{
			Date d = new Date();
			
			Log.startTestCase("start adding additional answer option");
			
			clickIdentifierByID("multiGraphicContentContainer_addSAQAns1");
			
			int listCount =+ answerCount + 1;
			
			if (correctAnswer.toLowerCase() == "no")
			{
				uncheckCheckBox(".//*[@id='multiGraphicContent_add']/li[" + listCount + "]/div/div[2]/label[2]/input");
				Log.info("unchecked correct answer");
			}
			
			if (correctAnswer.toLowerCase() == "yes")
			{
				checkCheckBox(".//*[@id='multiGraphicContent_add']/li[" + listCount + "]/div/div[2]/label[2]/input");
				Log.info("checked correct answer");
			}
			
			if (answerText != "")
				typeTextById("ckeditorSAQAns1" + answerCount, answerText + " " + d.toString());
			
			if (answerImage.toLowerCase() == "yes")
			{
				checkCheckBox(".//*[@id='multiGraphicContent_add']/li[" + listCount + "]/div/div[5]/div/label/input");
				Log.info("checked answer image");
			}
			
			if (answerDesktopImage != "")
			{
				clickIdentifierXpath(".//*[@id='multiGraphicContent_add']/li[" + listCount + "]/div/div[5]/div[2]/div/div/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Penguins.jpg");
				Thread.sleep(5000);
				Log.info("uploaded answer image");
			}
			
			if (answerImageDesc != "")
				typeTextByXpath(".//*[@id='multiGraphicContent_add']/li[" + listCount + "]/div/div[5]/div[3]/div/input", answerImageDesc + " " + d.toString());
			
			if (answerAltText != "")
				typeTextByXpath(".//*[@id='multiGraphicContent_add']/li[" + listCount + "]/div/div[5]/div[4]/div/input", answerAltText + " " + d.toString());
		
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			clickIdentifierByID("ok-button");
			
			String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (pageSaved.contains("Page saved"))
				Log.pass("answer option saved");
			else
				Log.fail("answer option failed to save for reason: " + pageSaved);
		
		}
		
		catch(Exception e){  
		       Log.fail("Failed to add another answer option");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to add another answer option");
		       e.printStackTrace();
		       throw e;

		}
		
	}

}
