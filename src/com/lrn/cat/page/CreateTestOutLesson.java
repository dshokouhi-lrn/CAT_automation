package com.lrn.cat.page;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class CreateTestOutLesson extends CATAppCommon{
	
	static public void createTestOutLesson(String lessonPosition, String welcomeLayout, String welcomeTitle, String welcomeContent, String welcomeAudio, String welcomeDesktop, String welcomeMobile, String welcomeImageDesc, String welcomeAltText, String assessmentLayout, String defaultPass, String passAudio, String passDesktop, String passMobile, String passImageDesc, String passAltText, String defaultFail, String failAudio, String failDesktop, String failMobile, String failImageDesc, String failAltText, String wrapUpLayout, String wrapUpTitle, String wrapUpContent, String wrapUpAudio, String wrapUpDesktop, String wrapUpMobile, String wrapUpImageDesc, String wrapUpAltText, String randomizeQuestions) throws Exception
	{
		try
		{
			Date d = new Date();
			
			Log.startTestCase("start creating test out lesson");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			clickIdentifierXpath("//*[@id='courseTree']/ul/li/ul/li["+ lessonPosition + "]/a");
			
			Thread.sleep(1000);
			
			clickIdentifierByID("layout-adp-lsn-typ-adaptive-main");
			
			Thread.sleep(1000);
			
			if (welcomeLayout != "")
				clickIdentifierByID("layout-landingPage-" + welcomeLayout + "-main");
			
			if (welcomeTitle != "")
				typeTextByName("adpLandingPageTitle", welcomeTitle + " " + d.toString());
			
			if (welcomeContent != "")
				typeTextById("adpLandingPageContentTxtArea", welcomeContent + " " + d.toString());
			
			if (welcomeAudio != "")
			{
				clickIdentifierXpath("//*[@id='adpLandingPage_uploadAudio']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\audio\\TechJam.mp3");
				Thread.sleep(3000);
				Log.info("uploaded welcome audio");
			}
			
			if (welcomeDesktop != "")
			{
				clickIdentifierXpath("//*[@id='desktop-image-main-div-adaptiveLandingPage_image']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Penguins.jpg");
				Thread.sleep(5000);
				Log.info("uploaded welcome desktop image");
			}
			
			if (welcomeMobile != "")
			{
				clickIdentifierXpath("//*[@id='mobile-image-main-div-adaptiveLandingPage_image']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Jellyfish.jpg");
				Thread.sleep(5000);
				Log.info("uploaded welcome mobile image");
			}
			
			if (welcomeImageDesc != "")
				typeTextById("widgetImageDescription-adaptiveLandingPage_image", welcomeImageDesc + " " + d.toString());
			
			if (welcomeAltText != "")
				typeTextById("widgetAltTextBackgroundImage-adaptiveLandingPage_image", welcomeAltText + " " + d.toString());
			
			if (assessmentLayout != "")
				clickIdentifierByID("layout-assess-" + assessmentLayout + "-main");
			
			if (randomizeQuestions != "")
			{
				WebElement check1 = driver.findElement(By.id("isTestOutQuestionRandomize"));
				Boolean value = check1.isSelected();
				Log.info("randomize questions is " + value);
				
				if (value && randomizeQuestions =="no")
				{
					clickIdentifierXpath("//*[@id='adaptiveInfo']/div[6]/div[2]/div/div/label[1]");
					Log.info("turned off randomize questions");
				}
				
				if (!value && randomizeQuestions =="yes")
				{
					clickIdentifierXpath("//*[@id='adaptiveInfo']/div[6]/div[2]/div/div/label[1]");
					Log.info("turned on randomize questions");
				}
			}
			
			if (defaultPass == "no")
			{
				uncheckCheckBox("//*[@id='adaptiveInfo']/fieldset[1]/div[1]/div/label/input");
				typeTextById("adpPassMessageTitle", "pass title " + d.toString());
			}
			
			typeTextById("adpPassMessageTxtArea", "pass message " + d.toString());
			
			if (passAudio != "")
			{
				clickIdentifierXpath("//*[@id='adpPassMessage_uploadAudio']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\audio\\FunkyDiva.mp3");
				Thread.sleep(3000);
				Log.info("uploaded pass audio");
			}
			
			if (passDesktop != "")
			{
				clickIdentifierXpath("//*[@id='desktop-image-main-div-adaptivePassMessage_image']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Desert.jpg");
				Thread.sleep(5000);
				Log.info("uploaded pass desktop image");
			}
			
			if (passMobile != "")
			{
				clickIdentifierXpath("//*[@id='mobile-image-main-div-adaptivePassMessage_image']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Koala.jpg");
				Thread.sleep(5000);
				Log.info("uploaded pass mobile image");
			}
			
			if (passImageDesc != "")
				typeTextById("widgetImageDescription-adaptivePassMessage_image", passImageDesc + " " + d.toString());
			
			if (passAltText != "")
				typeTextById("widgetAltTextBackgroundImage-adaptivePassMessage_image", passAltText + " " + d.toString());
			
			Thread.sleep(1000);
			
			if (defaultFail == "no")
			{
				uncheckCheckBox("//*[@id='adaptiveInfo']/fieldset[2]/div[1]/label/input");
				typeTextById("adpFailMessageTitle", "fail title " + d.toString());
			}
			
			typeTextById("adpFailMessageTxtArea", "fail message " + d.toString());
			
			if (failAudio != "")
			{
				clickIdentifierXpath("//*[@id='adpFailMessage_uploadAudio']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\audio\\NewAgeTechno.mp3");
				Thread.sleep(3000);
				Log.info("uploaded fail audio");
			}
			
			if (failDesktop != "")
			{
				clickIdentifierXpath("//*[@id='desktop-image-main-div-adaptiveFailMessage_image']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Tulips.jpg");
				Thread.sleep(5000);
				Log.info("uploaded fail desktop image");
			}
			
			if (failMobile != "")
			{
				clickIdentifierXpath("//*[@id='mobile-image-main-div-adaptiveFailMessage_image']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Lighthouse.jpg");
				Thread.sleep(5000);
				Log.info("uploaded fail mobile image");
			}
			
			if (failImageDesc != "")
				typeTextById("widgetImageDescription-adaptiveFailMessage_image", failImageDesc + " " + d.toString());
			
			if (failAltText != "")
				typeTextById("widgetAltTextBackgroundImage-adaptiveFailMessage_image", failAltText + " " + d.toString());
			
			if (wrapUpLayout != "")
				clickIdentifierByID("layout-wrapup-" + wrapUpLayout + "-main");
			
			if (wrapUpTitle != "")
				typeTextByName("adpWrapUpPageTitle", wrapUpTitle + " " + d.toString());
			
			if (wrapUpContent != "")
				typeTextById("adpWrapUpPageContentTxtArea", wrapUpContent + " " + d.toString());
			
			if (wrapUpAudio != "")
			{
				clickIdentifierXpath("//*[@id='adpWrapUp_uploadAudio']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\audio\\Ambianica.mp3");
				Thread.sleep(3000);
				Log.info("uploaded wrap up audio");
			}
			
			if (wrapUpDesktop != "")
			{
				clickIdentifierXpath("//*[@id='desktop-image-main-div-adaptiveWrapUp_image']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Hydrangeas.jpg");
				Thread.sleep(5000);
				Log.info("uploaded wrap up desktop image");
			}
			
			if (wrapUpMobile != "")
			{
				clickIdentifierXpath("//*[@id='mobile-image-main-div-adaptiveWrapUp_image']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Chrysanthemum.jpg");
				Thread.sleep(5000);
				Log.info("uploaded wrap up mobile image");
			}
			
			if (wrapUpImageDesc != "")
				typeTextById("widgetImageDescription-adaptiveWrapUp_image", wrapUpImageDesc + " " + d.toString());
			
			if (wrapUpAltText != "")
				typeTextById("widgetAltTextBackgroundImage-adaptiveWrapUp_image", wrapUpAltText + " " + d.toString());
			
			//clickIdentifierByID("saveIconId");
			
			Thread.sleep(3000);
			
			clickIdentifierByID("saveIconId");
			
			Log.info("clicked on save button");
			
			String lessonSaved = getValueByXpath("//div[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (lessonSaved.contains("Lesson saved"))
				Log.pass("test out lesson saved");
			else
				Log.fail("lesson failed to save for reason: " + lessonSaved);
			
			
		}
		
		catch(Exception e){  
		       Log.fail("Failed to create test out lesson");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to create test out lesson");
		       e.printStackTrace();
		       throw e;

		}
	}
	
	static public void addTestOutQuestion(String questionsToPass, String questionTitle, String questionText, String answerType, String answerOption1, String answerOption2, String image, String imageDesc, String altText) throws Exception
	{
		try{
			
			Date d = new Date();
				
			typeTextById("questionsToPass", "1");
			
			clickIdentifierXpath("//*[@id='adaptiveInfo']/div[8]/div/a");
			
			Thread.sleep(3000);
			
			typeTextById("adpAssessmentAddQuestionTitleText", questionTitle + " " + d.toString());
			
			typeTextByiframe("Rich Text Editor, adpAssessmentAddQuestionContentText", questionText + " " + d.toString());
			
			if (answerType == "single")
				clickIdentifierByID("adpQuestionTypeSingle");
			
			if (answerType == "multiple")
				clickIdentifierByID("adpQuestionTypeMultipleChoice");
			
			typeTextByiframe("Rich Text Editor, adpAssessmentanswerText_1", answerOption1 + " " + d.toString());
			
			
			checkCheckBox("//*[@id='adpAssessmentCorrectAnswer_1']");
			clickIdentifierXpath("//*[@id='adpAssessmentAddQuestionContainer']/div[6]/div/a");
			
			typeTextByiframe("Rich Text Editor, adpAssessmentanswerText_2", answerOption2 + " " + d.toString());
			
			//commented out as we need to save the question first before we can audio
			/*if (audio != "")
			{
				clickIdentifierXpath(".//*[@id='adpAssessmentAudio_uploadAudio']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\audio\\Ambianica.mp3");
				Thread.sleep(3000);
				Log.info("uploaded question audio");	
			}*/
			
			if (image != "")
			{
				clickIdentifierXpath(".//*[@id='desktop-image-main-div-questionDetails_image']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Hydrangeas.jpg");
				Thread.sleep(5000);
				Log.info("uploaded question image");
			}
			
			if (imageDesc != "")
				typeTextById("widgetImageDescription-questionDetails_image", imageDesc + " " + d.toString());
			
			if (altText != "")
				typeTextById("widgetAltTextBackgroundImage-questionDetails_image", altText + " " + d.toString());
			
			Thread.sleep(3000);
			
			clickIdentifierXpath("//div[@aria-describedby='adpAssessmentAddQuestionContainer']/div[3]/div/button");
			
			Log.info("created a test out question");
			
			Thread.sleep(5000);
			
			typeTextById("questionsToPass", questionsToPass);
			
			Thread.sleep(1000);
			
			clickIdentifierByID("saveIconId");
			
			Log.info("clicked on save button");
			
			String lessonSaved1 = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (lessonSaved1.contains("Lesson saved"))
				Log.pass("lesson saved");
			else
				Log.fail("lesson failed to save for reason: " + lessonSaved1);
			
			
		}
		
		catch(Exception e){  
		       Log.fail("Failed to add question to test out");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to add question to test out");
		       e.printStackTrace();
		       throw e;

		}
		
		
	}

}
