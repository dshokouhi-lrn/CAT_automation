package com.lrn.cat.page;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class EditCertification extends CATAppCommon {
	
	static public void editCertification(String enableCert, String certName, String certDesc, String certInstruct, String certHide, String certReviewTitle, String certReviewMessage, String certCompleteTitle, String certCompleteMessage) throws Exception
	{
		try
		{
			Date d = new Date();
			
			Log.startTestCase("start editing certification");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			   
			Thread.sleep(1000);
			
			clickIdentifierXpath(".//*[@id='menuTabs']/ul/li[4]/p");
			
			Thread.sleep(3000);
			
			clickIdentifierXpath(".//*[@id='menuTabs']/ul/li[4]/p");
			
			Thread.sleep(5000);
			
			if (enableCert == "Yes")
			{
				selectDropdownValueXpathVisibleText(".//*[@id='isCourseRequireCertification']", enableCert);
				Log.info("certification turned on");
				
				if (certName != "")
					typeTextById("certificationName", certName + " " + d.toString());
				
				if (certDesc != "")
					typeTextById("ckeditorCertificationContent", certDesc + " " + d.toString());
			
				if (certInstruct != "")
					typeTextById("certificationInstruction", certInstruct + " " + d.toString());
			
				if (certHide == "Yes")
				{
					selectDropdownValueXpathVisibleText(".//*[@id='isHidden']", certHide);
					Log.info("certification hidden");
				}
				
				if (certHide == "No")
				{
					selectDropdownValueXpathVisibleText(".//*[@id='isHidden']", certHide);
					Log.info("certification unhidden");
				}
				
				if (certReviewTitle != "" || certReviewMessage != "" || certCompleteTitle != "" || certCompleteMessage != "")
				{
					clickIdentifierXpath(".//*[@id='certificationAccordian']/h5[3]");
					
					Thread.sleep(1000);
					
					if (certReviewTitle != "")
						typeTextById("reviewTitle", certReviewTitle + " " + d.toString());
					
					if (certReviewMessage != "")
						typeTextById("ckeditorReviewMessage", certReviewMessage + " " + d.toString());
					
					if (certCompleteTitle != "")
						typeTextById("closingTitle", certCompleteTitle + " " + d.toString());
					
					if (certCompleteMessage != "")
						typeTextById("ckeditorClosingMessage", certCompleteMessage + " " + d.toString());
				}
			}
			
			if (enableCert == "No")
			{
				selectDropdownValueXpathVisibleText(".//*[@id='isCourseRequireCertification']", enableCert);
				Log.info("certification turned off");
				
				clickIdentifierByID("certificationSubmitButton");
				
				Thread.sleep(2000);
				
				clickIdentifierXpath("//*[@role='dialog']/div[3]/div/button[1]");
				
				String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
				
				Thread.sleep(3000);
				
				if (pageSaved.contains("Certification Saving: Successfull"))
					Log.pass("certification saved");
				else
					Log.fail("certification failed to save for reason: " + pageSaved);
			}
		}
		
		catch(Exception e){  
		       Log.fail("Failed to edit certification");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to edit certification");
		       e.printStackTrace();
		       throw e;
		}
	}
	
	static public void addCertificationQuestion(String hideQuestion, String questionText, String responseType, String learnersExplanation, String explainText, String showExplain, String answerText1, String answerVariant1, String answerText2, String answerVariant2) throws Exception
	{
		try
		{
			Date d = new Date();
			
			clickIdentifierXpath(".//*[@id='certificationAccordian']/h5[2]");
			
			Thread.sleep(1000);
			
			clickIdentifierXpath(".//*[@id='certQuestionTree']/ul/li/a");
			
			Thread.sleep(1000);
			
			clickIdentifierByID("certificationQuestionOpenDialog");
			
			Thread.sleep(3000);
			
			if (hideQuestion.toLowerCase() == "no")
			{
				uncheckCheckBox(".//*[@id='questionIsHidden']");
				Log.info("unchecked hide question");
			}
			
			if (hideQuestion.toLowerCase() == "yes")
			{
				checkCheckBox(".//*[@id='questionIsHidden']");
				Log.info("checked hide question");
			}
			
			if (questionText != "")
				typeTextByiframe("Rich Text Editor, ckeditorAddQuestion", questionText + " " + d.toString());
			
			if (responseType == "Learners can select only one answer" || responseType == "Learners can select one or more answers" || responseType == "Learners can select one answer from dropdown" || responseType == "Learners can enter a number" || responseType == "Learners can select a date" || responseType == "Learners can enter text")
			{
				selectDropdownValueXpathVisibleText(".//*[@id='responseType']", responseType);
				
				if (responseType == "Learners can select only one answer" || responseType == "Learners can select one or more answers" || responseType == "Learners can select one answer from dropdown")
				{
					if (answerText1 != "")
						typeTextByXpath(".//*[@id='addCertificationQuestionTextField']/div[1]/div[1]/input[3]", answerText1);
					
					if (answerVariant1.toLowerCase() == "no")
					{
						uncheckCheckBox(".//*[@id='addCertificationQuestionTextField']/div[1]/div[1]/input[2]");
						Log.info("unchecked answer 1 variant");
					}
					
					if (answerVariant1.toLowerCase() == "yes")
					{
						checkCheckBox(".//*[@id='addCertificationQuestionTextField']/div[1]/div[1]/input[2]");
						Log.info("checked answer 1 variant");
					}
					
					clickIdentifierXpath(".//*[@id='addCertificationQuestionTextField']/div[1]/div[1]/input[1]");
					
					Thread.sleep(1000);
					
					if (answerText2 != "")
						typeTextByXpath(".//*[@id='addCertificationQuestionTextField']/div[2]/div[1]/input[3]", answerText2);
					
					if (answerVariant2.toLowerCase() == "no")
					{
						uncheckCheckBox(".//*[@id='addCertificationQuestionTextField']/div[2]/div[1]/input[2]");
						Log.info("unchecked answer 2 variant");
					}
					
					if (answerVariant2.toLowerCase() == "yes")
					{
						checkCheckBox(".//*[@id='addCertificationQuestionTextField']/div[2]/div[1]/input[2]");
						Log.info("checked answer 2 variant");
					}
				}
				
				if (learnersExplanation.toLowerCase() == "no")
				{
					uncheckCheckBox(".//*[@id='certificationQuestionCheckbox']");
					Log.info("unchecked learners explanation");
				}
				
				if (learnersExplanation.toLowerCase() == "yes")
				{
					checkCheckBox(".//*[@id='certificationQuestionCheckbox']");
					Log.info("checked learners explanation");
					
					if (explainText != "")
						typeTextByiframe("Rich Text Editor, ckeditorAddQuestionResponderAnswer", explainText + " " + d.toString());
				
					if (showExplain.toLowerCase() == "no")
					{
						uncheckCheckBox(".//*[@id='explanation']");
						Log.info("unchecked explain text box");
					}
					
					if (showExplain.toLowerCase() == "yes")
					{
						checkCheckBox(".//*[@id='explanation']");
						Log.info("checked explain text");
					}
				}
			}
			
			clickIdentifierXpath("//*[@aria-describedby='questionDialog']/div[3]/div[1]/button");
			
			String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (pageSaved.contains("Your changes were saved."))
				Log.pass("certification question saved");
			else
				Log.fail("certification question failed to save for reason: " + pageSaved);
			
			Thread.sleep(2000);
			
			clickIdentifierByID("certificationSubmitButton");
			
			String pageSaved1 = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (pageSaved1.contains("Certification Saving: Successfull"))
				Log.pass("certification saved");
			else
				Log.fail("certification failed to save for reason: " + pageSaved1);
		}
		
		catch(Exception e){  
		       Log.fail("Failed to add certification question");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to add certification question");
		       e.printStackTrace();
		       throw e;
		}
	}
	
	static public void addFollowUp(String questionPosition, String followPosition, String answerPosition, String hideQuestion, String questionText, String responseType, String learnersExplanation, String explainText, String showExplain, String answerText1, String answerVariant1, String answerText2, String answerVariant2) throws Exception
	{
		try
		{
			Date d = new Date();
			
			clickIdentifierXpath(".//*[@id='certificationAccordian']/h5[2]");
			
			Thread.sleep(1000);
			
			if (followPosition == "")
			{
				clickIdentifierXpath(".//*[@id='certQuestionTree']/ul/li/ul/li[" + questionPosition + "]/ul/li[" + answerPosition + "]");
				WebElement productLink = driver.findElement(By.xpath(".//*[@id='certQuestionTree']/ul/li/ul/li[" + questionPosition + "]/ul/li[" + answerPosition + "]"));
				Actions action1= new Actions(driver);
				action1.contextClick(productLink).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
				clickIdentifierXpath("html/body/ul/li[1]/a");
				Log.pass("clicked on add-follow up");
			}
			
			if (followPosition != "")
			{
				clickIdentifierXpath(".//*[@id='certQuestionTree']/ul/li/ul/li[" + questionPosition + "]/ul/li[" + answerPosition + "]/ul/li/ul/li[" + followPosition + "]");
				WebElement productLink = driver.findElement(By.xpath(".//*[@id='certQuestionTree']/ul/li/ul/li[" + questionPosition + "]/ul/li[" + answerPosition + "]/ul/li/ul/li[" + followPosition + "]"));
			
				Actions action1= new Actions(driver);
				action1.contextClick(productLink).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
				clickIdentifierXpath("html/body/ul/li[1]/a");
				Log.pass("clicked on add-follow up");
			}
			
			if (hideQuestion.toLowerCase() == "no")
			{
				uncheckCheckBox(".//*[@id='questionIsHidden']");
				Log.info("unchecked hide question");
			}
			
			if (hideQuestion.toLowerCase() == "yes")
			{
				checkCheckBox(".//*[@id='questionIsHidden']");
				Log.info("checked hide question");
			}
			
			if (questionText != "")
				typeTextByiframe("Rich Text Editor, ckeditorAddQuestion", questionText + " " + d.toString());
			
			if (responseType == "Learners can select only one answer" || responseType == "Learners can select one or more answers" || responseType == "Learners can select one answer from dropdown" || responseType == "Learners can enter a number" || responseType == "Learners can select a date" || responseType == "Learners can enter text")
			{
				selectDropdownValueXpathVisibleText(".//*[@id='responseType']", responseType);
				
				if (responseType == "Learners can select only one answer" || responseType == "Learners can select one or more answers" || responseType == "Learners can select one answer from dropdown")
				{
					if (answerText1 != "")
						typeTextByXpath(".//*[@id='addCertificationQuestionTextField']/div[1]/div[1]/input[3]", answerText1);
					
					if (answerVariant1.toLowerCase() == "no")
					{
						uncheckCheckBox(".//*[@id='addCertificationQuestionTextField']/div[1]/div[1]/input[2]");
						Log.info("unchecked answer 1 variant");
					}
					
					if (answerVariant1.toLowerCase() == "yes")
					{
						checkCheckBox(".//*[@id='addCertificationQuestionTextField']/div[1]/div[1]/input[2]");
						Log.info("checked answer 1 variant");
					}
					
					clickIdentifierXpath(".//*[@id='addCertificationQuestionTextField']/div[1]/div[1]/input[1]");
					
					Thread.sleep(1000);
					
					if (answerText2 != "")
						typeTextByXpath(".//*[@id='addCertificationQuestionTextField']/div[2]/div[1]/input[3]", answerText2);
					
					if (answerVariant2.toLowerCase() == "no")
					{
						uncheckCheckBox(".//*[@id='addCertificationQuestionTextField']/div[2]/div[1]/input[2]");
						Log.info("unchecked answer 2 variant");
					}
					
					if (answerVariant2.toLowerCase() == "yes")
					{
						checkCheckBox(".//*[@id='addCertificationQuestionTextField']/div[2]/div[1]/input[2]");
						Log.info("checked answer 2 variant");
					}
				}
				
				if (learnersExplanation.toLowerCase() == "no")
				{
					uncheckCheckBox(".//*[@id='certificationQuestionCheckbox']");
					Log.info("unchecked learners explanation");
				}
				
				if (learnersExplanation.toLowerCase() == "yes")
				{
					checkCheckBox(".//*[@id='certificationQuestionCheckbox']");
					Log.info("checked learners explanation");
					
					if (explainText != "")
						typeTextByiframe("Rich Text Editor, ckeditorAddQuestionResponderAnswer", explainText + " " + d.toString());
				
					if (showExplain.toLowerCase() == "no")
					{
						uncheckCheckBox(".//*[@id='explanation']");
						Log.info("unchecked explain text box");
					}
					
					if (showExplain.toLowerCase() == "yes")
					{
						checkCheckBox(".//*[@id='explanation']");
						Log.info("checked explain text");
					}
				}
			}
			
			clickIdentifierXpath("//*[@aria-describedby='questionDialog']/div[3]/div[1]/button");
			
			String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (pageSaved.contains("Your changes were saved."))
				Log.pass("question saved");
			else
				Log.fail("questio failed to save for reason: " + pageSaved);
			
			Thread.sleep(2000);
			
			clickIdentifierByID("certificationSubmitButton");
			
			
			String pageSaved1 = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (pageSaved1.contains("Certification Saving: Successfull"))
				Log.pass("certification saved");
			else
				Log.fail("certification failed to save for reason: " + pageSaved1);
		}
		
		catch(Exception e){  
		       Log.fail("Failed to add follow up question");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to add follow up question");
		       e.printStackTrace();
		       throw e;
		}
		
	}

}
