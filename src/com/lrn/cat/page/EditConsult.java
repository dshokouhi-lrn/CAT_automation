package com.lrn.cat.page;

import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class EditConsult extends CATAppCommon{
	
	static public void editConsult(String showTitle, String pageTitle, String layoutConsult, String consultContent, String consultClickText, String consultClickTitle, String consultImage, String consultImageDesc, String consultAltText, String consultQuestion, String consultQuestionAudio, String consultQuestionType, String consultAnswerCorrect, String consultAnswer, String consultAnswerImage, String consultAnswerDesktopImage, String consultAnswerImageDesc, String consultAnswerAltText, String consultRetryNumber, String consultRetryTitle, String consultRetryMessage, String consultRetryButton, String feedbackOption, String singleFeedback, String singleImage, String singleImageDesc, String singleAltText, String correctTitle, String correctContent, String correctImage, String correctImageDesc, String correctAltText, String incorrectTitle, String incorrectContent, String incorrectImage, String incorrectImageDesc, String incorrectAltText, String pageAudio, String backgroundImage) throws Exception
	{
		try
		{
			Date d = new Date();
			
			Log.startTestCase("start editing consult");
			
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
			
			if (layoutConsult == "Left To Right" || layoutConsult == "Right To Left")
				selectDropdownValueXpathVisibleText(".//*[@id='consultLayout']/div[1]/div/select", layoutConsult);
			
			if (consultContent != "")
				typeTextById("ckeditorContentconsultContent", consultContent + " " + d.toString());
			
			if (consultClickText != "")
				typeTextById("ckeditorconsultClickReveal", consultClickText + " " + d.toString());
			
			if (consultClickTitle != "")
				typeTextById("desc_richTextconsultClickReveal", consultClickTitle + " " + d.toString());
			
			if (consultImage != "")
			{
				clickIdentifierXpath(".//*[@id='consultClickReveal']/ul/li/div/div[4]/div[2]/div/div/img");
				uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
				Thread.sleep(5000);
				Log.info("uploaded consult image");
			}
			
			if (consultImageDesc != "")
				typeTextByXpath(".//*[@id='consultClickReveal']/ul/li/div/div[4]/div[3]/div/input", consultImageDesc + " " + d.toString());
			
			if (consultAltText != "")
				typeTextByXpath(".//*[@id='consultClickReveal']/ul/li/div/div[4]/div[4]/div/input", consultAltText + " " + d.toString());
			
			if (consultQuestion != "")
				typeTextById("ckeditorContentconsultQuestion", consultQuestion + " " + d.toString());
			
			if (consultQuestionAudio != "")
			{
				/*clickIdentifierByID("sltAudio");
				uploadFile("C:\\Users\\dshokouhi\\Documents\\TechJam.mp3");
				Thread.sleep(3000);*/
				Log.info("uploaded audio");
			}
			
			if (consultQuestionType == "One Correct Answer" || consultQuestionType == "Two or More Correct Answers")
				selectDropdownValueXpathVisibleText(".//*[@id='consultQuestionType']/div[1]/div/select", consultQuestionType);
			
			if (consultAnswerCorrect.toLowerCase() == "no")
			{
				uncheckCheckBox(".//*[@id='consultAnswer']/ul/li[1]/div/div/label[2]/input");
				Log.info("unchecked correct answer");
			}
			
			if (consultAnswerCorrect.toLowerCase() == "yes")
			{
				checkCheckBox(".//*[@id='consultAnswer']/ul/li[1]/div/div/label[2]/input");
				Log.info("checked correct answer");
			}
			
			if (consultAnswer != "")
				typeTextById("ckeditorconsultAnswer", consultAnswer + " " + d.toString());
			
			if (consultAnswerImage.toLowerCase() == "yes")
			{
				checkCheckBox(".//*[@id='consultAnswer']/ul/li[1]/div/div[4]/div[1]/label/input");
				Log.info("checked answer image");
			}
			
			if (consultAnswerDesktopImage != "")
			{
				clickIdentifierXpath(".//*[@id='consultAnswer']/ul/li[1]/div/div[4]/div[2]/div/div[1]/img");
				uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
				Thread.sleep(5000);
				Log.info("uploaded consult image");
			}
			
			if (consultAnswerImageDesc != "")
				typeTextByXpath(".//*[@id='consultAnswer']/ul/li[1]/div/div[4]/div[3]/div/input", consultAnswerImageDesc + " " + d.toString());
			
			if (consultAnswerAltText != "")
				typeTextByXpath(".//*[@id='consultAnswer']/ul/li[1]/div/div[4]/div[4]/div/input", consultAnswerAltText + " " + d.toString());
			
			if (consultRetryNumber != "")
				typeTextById("titleTextconsultRetryAttempt", consultRetryNumber);
			
			if (consultRetryTitle != "")
				typeTextById("titleTextconsultRetryAlertTitle", consultRetryTitle + " " + d.toString());
			
			if (consultRetryMessage != "")
				typeTextById("ckeditorContentconsultRetryAlertText", consultRetryMessage + " " + d.toString());
			
			if (consultRetryButton != "")
				typeTextById("titleTextconsultRetryAlertButtonTitle", consultRetryButton + " " + d.toString());
			
			if (feedbackOption.toLowerCase() == "single")
			{
				clickIdentifierXpath(".//*[@id='consultFeedback']/div/div/input[1]");
				
				if (singleFeedback != "")
					typeTextByXpath(".//*[@id='consultFeedback']/div[1]/div[2]/div[2]/div", singleFeedback + " " + d.toString());
				
				if (singleImage != "")
				{
					clickIdentifierXpath(".//*[@id='consultFeedback']/div[1]/div[2]/div[3]/div/div[2]/img");
					uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
					Thread.sleep(5000);
					Log.info("uploaded feedback image");
				}
				
				if (singleImageDesc != "")
					typeTextByXpath(".//*[@id='consultFeedback']/div[1]/div[2]/div[3]/div[2]/input", singleImageDesc + " " + d.toString());
				
				if (singleAltText != "")
					typeTextByXpath(".//*[@id='consultFeedback']/div[1]/div[2]/div[3]/div[3]/input", singleAltText + " " + d.toString());
			}
			
			if (feedbackOption.toLowerCase() == "multiple")
			{
				clickIdentifierXpath(".//*[@id='consultFeedback']/div/div/input[2]");
				
				if (correctTitle != "")
					typeTextByXpath(".//*[@id='consultFeedback']/div[1]/div[3]/div[1]/input", correctTitle + " " + d.toString());
				
				if (incorrectTitle != "")
					typeTextByXpath(".//*[@id='consultFeedback']/div[1]/div[3]/div[2]/input", incorrectTitle + " " + d.toString());
				
				if (correctContent != "")
					typeTextById("ckeditorContentCorrectconsultFeedback1", correctContent + " " + d.toString());
				
				if (incorrectContent != "")
					typeTextById("ckeditorContentIncorrectconsultFeedback1", incorrectContent + " " + d.toString());
				
				if (correctImage != "")
				{
					clickIdentifierXpath(".//*[@id='consultFeedback']/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/img");
					uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
					Thread.sleep(5000);
					Log.info("uploaded correct feedback image");
				}
				
				if (incorrectImage != "")
				{
					clickIdentifierXpath(".//*[@id='consultFeedback']/div[1]/div[3]/div[2]/div[3]/div[1]/div[2]/img");
					uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
					Thread.sleep(5000);
					Log.info("uploaded incorrect feedback image");
				}
				
				if (correctImageDesc != "")
					typeTextByXpath(".//*[@id='consultFeedback']/div/div[3]/div[1]/div[2]/div[2]/input", correctImageDesc + " " + d.toString());
				
				if (correctAltText != "")
					typeTextByXpath(".//*[@id='consultFeedback']/div/div[3]/div[1]/div[2]/div[3]/input", correctAltText + " " + d.toString());
				
				if (incorrectImageDesc != "")
					typeTextByXpath(".//*[@id='consultFeedback']/div/div[3]/div[2]/div[3]/div[2]/input", incorrectImageDesc + " " + d.toString());
				
				if (incorrectAltText != "")
					typeTextByXpath(".//*[@id='consultFeedback']/div/div[3]/div[2]/div[3]/div[3]/input", incorrectAltText + " " + d.toString());
				
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
		       Log.fail("Failed to edit consult page");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to edit consult page");
		       e.printStackTrace();
		       throw e;

		}
	}
	
	static public void addConsult(int consultPosition, String consultClickText, String consultClickTitle, String consultImage, String consultImageDesc, String consultAltText) throws Exception
	{
		try
		{
			
			Date d = new Date();
			
			Log.startTestCase("start adding additional consult section");
			
			int consultCount = consultPosition + 1;
			
			clickIdentifierByID("multiGraphicContentContainer_addconsultClickReveal");
			
			if (consultClickText != "")
				typeTextById("ckeditorconsultClickReveal" + consultPosition, consultClickText + " " + d.toString());
			
			if (consultClickTitle != "")
				typeTextById("desc_richTextconsultClickReveal" + consultPosition, consultClickTitle + " " + d.toString());
			
			if (consultImage != "")
			{
				clickIdentifierXpath(".//*[@id='consultClickReveal']/ul/li[" + consultCount + "]/div/div[5]/div[2]/div/div/img");
				uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
				Thread.sleep(5000);
				Log.info("uploaded consult image");
			}
			
			if (consultImageDesc != "")
				typeTextByXpath(".//*[@id='consultClickReveal']/ul/li[" + consultCount + "]/div/div[5]/div[3]/div/input", consultImageDesc + " " + d.toString());
			
			if (consultAltText != "")
				typeTextByXpath(".//*[@id='consultClickReveal']/ul/li[" + consultCount + "]/div/div[5]/div[4]/div/input", consultAltText + " " + d.toString());
			
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
		       Log.fail("Failed to add consult section");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to add consult section");
		       e.printStackTrace();
		       throw e;

		}
	}
	
	static public void addAnswerOption(String answerPosition, String consultAnswerCorrect, String consultAnswer, String consultAnswerImage, String consultAnswerDesktopImage, String consultAnswerImageDesc, String consultAnswerAltText) throws Exception
	{
		try
		{
			Date d = new Date();
			
			Log.startTestCase("start adding additional consult answer option");
			
			clickIdentifierByID("multiGraphicContentContainer_addconsultAnswer");
			
			if (consultAnswerCorrect.toLowerCase() == "no")
			{
				uncheckCheckBox(".//*[@id='consultAnswer']/ul/li[" + answerPosition + "]/div/div[2]/label[2]/input");
				Log.info("unchecked correct answer");
			}
			
			if (consultAnswerCorrect.toLowerCase() == "yes")
			{
				checkCheckBox(".//*[@id='consultAnswer']/ul/li[" + answerPosition + "]/div/div[2]/label[2]/input");
				Log.info("checked correct answer");
			}
			
			if (consultAnswer != "")
				typeTextByXpath(".//*[@id='consultAnswer']/ul/li[" + answerPosition + "]/div/div[2]/div/div", consultAnswer + " " + d.toString());
			
			if (consultAnswerImage.toLowerCase() == "yes")
			{
				checkCheckBox(".//*[@id='consultAnswer']/ul/li[" + answerPosition + "]/div/div[5]/div[1]/label/input");
				Log.info("checked answer image");
			}
			
			if (consultAnswerDesktopImage != "")
			{
				clickIdentifierXpath(".//*[@id='consultAnswer']/ul/li[" + answerPosition + "]/div/div[5]/div[2]/div/div[1]/img");
				uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
				Thread.sleep(5000);
				Log.info("uploaded consult image");
			}
			
			if (consultAnswerImageDesc != "")
				typeTextByXpath(".//*[@id='consultAnswer']/ul/li[" + answerPosition + "]/div/div[5]/div[3]/div/input", consultAnswerImageDesc + " " + d.toString());
			
			if (consultAnswerAltText != "")
				typeTextByXpath(".//*[@id='consultAnswer']/ul/li[" + answerPosition + "]/div/div[5]/div[4]/div/input", consultAnswerAltText + " " + d.toString());
			
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
		       Log.fail("Failed to add answer option");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to add answer option");
		       e.printStackTrace();
		       throw e;

		}
	}

}
