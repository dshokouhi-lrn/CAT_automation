	package com.lrn.cat.page;

	import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;
import com.thoughtworks.selenium.webdriven.commands.GetValue;

public class KnowledgeCheck extends CATAppCommon {

	static public void knowledgecheck(String questionTitle,String questionText,String answerType,String answerOption1,String answerOption2,String CorrectAnswers,String feedback,String imgdes,String alttext,int i) throws Exception
	{
		   
	try{
		
				
				Date d = new Date();
				
				Log.startTestCase("Click on Knowledge check tab");
				
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollTo(0,0)", "");
				
				Thread.sleep(1000);
				
				clickIdentifierXpath(".//div[@id='menuTabs']/ul/li[3]/p"); //KC Tab element
				Log.info("clicked on Knowledge check tab");
				
				
				Thread.sleep(5000);
				String KCConfig =driver.findElement(By.xpath(".//div[@id='knowledgeCheckDiv']/div[2]/div/div/label[1]")).getText();
				System.out.println("KC toggle Button Status="  + KCConfig); 
				
				String config = "YES";
				
				if (KCConfig.equals(config))
				{
					Log.info("KC Config set to yes and clicked on add question");
					
					clickIdentifierXpath(".//*[@id='questionOpenDialog']"); //add question
					Log.info("add question clicked");
					String questionNo =getValueByID("questionNo");
					//String questionNo = getValueByXpath(".//*[@id='questionNo']");
					System.out.println("KC QuestionNo="  + questionNo); 
					int kcNo = Integer.parseInt(questionNo);
				
					if(kcNo >0){
						//typeTextByXpath(".//*[@id='questionTitle']", "Q1");
						typeTextById("questionTitle", questionTitle + " " + d.toString());
						//typeTextById("questionTitle","Q1");
						
						selectDropdownValueByIndex("lessonName",i);
							System.out.println("selected dropdown lesson="  + i);				
						//selectDropdownValueXpathVisibleText(".//*[@id='lessonName']","ADP Lesson A");
						//selectDropdownValueVisibleText("lessonName","Lesson A1");
						//selectDropdownValueVisibleText("questionType",CorrectAnswers);
							selectDropdownValueXpathVisibleText(".//*[@id='question_layout']/div[1]/div[4]/select", CorrectAnswers);

					}	
						Thread.sleep(5000);
			
					if (CorrectAnswers == "Learners can select only one answer")
					{
						typeTextByiframe("Rich Text Editor, question", questionText + " " + d.toString());
						typeTextById("question_2", answerOption1 + " "  + d.toString());
						clickIdentifierXpath(".//*[@id='knAdd']");
						typeTextById("question_3", answerOption1 + " "  + d.toString());
						checkCheckBox(".//*[@id='question_Answer_2']");
						typeTextByXpath(".//*[@id='feedback']",feedback + " " + d.toString());
						typeTextByXpath(".//*[@id='graphicDesc']",imgdes + " " + d.toString());
						typeTextByXpath(".//*[@id='altTxtOn']",alttext + " " + d.toString());
						clickIdentifierXpath("//*[@aria-describedby='question_layout']/div[3]/div/button");
						Log.info("single question type  selected and necessary details filled in");
					}
					
					if (CorrectAnswers == "Learners can select one or more answers")
					{
						typeTextByiframe("Rich Text Editor, question", questionText + " " + d.toString());
						typeTextById("question_2", answerOption1 + " "  + d.toString());
						clickIdentifierXpath(".//*[@id='knAdd']");
						typeTextById("question_3", answerOption1 + " "  + d.toString());
						checkCheckBox(".//*[@id='question_Answer_2']");
						typeTextByXpath(".//*[@id='feedback']",feedback + " " + d.toString());
						typeTextByXpath(".//*[@id='graphicDesc']",imgdes + " " + d.toString());
						typeTextByXpath(".//*[@id='altTxtOn']",alttext + " " + d.toString());
						clickIdentifierXpath("//*[@aria-describedby='question_layout']/div[3]/div/button");
						
						Log.info("Multiple questionType selected and necesary details filled in");
					}			
						
					Thread.sleep(3000);
					
					if (isElementPresent(By.xpath(".//*[@id='questionOpenBank_0']/div[2]/img[3]")))
						Log.pass("question added");
					
					}			
					
				else {
					Log.info("KC Config set to no and clicked on add question");
					Thread.sleep(1000);
					clickIdentifierXpath(".//div[@id='knowledgeCheckDiv']/div[2]/div/div");
					Thread.sleep(1000);
					clickIdentifierXpath(".//*[@id='questionOpenDialog']"); //add question
					Log.info("add question clicked");
					//String questionNo = getValueByXpath(".//*[@id='questionNo']");
					String questionNo = driver.findElement(By.id("questionNo")).getAttribute("value");
					int kcNo = Integer.parseInt(questionNo);
				
					if(kcNo >0){
						//typeTextByXpath(".//*[@id='questionTitle']", "Q1");
						typeTextById("questionTitle", questionTitle + " " + d.toString());
						selectDropdownValueByIndex("lessonName",i);
						//selectDropdownValueXpathVisibleText(".//*[@id='lessonName']","Lesson A");
						//selectDropdownValueVisibleText("lessonName","Lesson A");
						//selectDropdownValueVisibleText("questionType",CorrectAnswers);
						selectDropdownValueXpathVisibleText(".//*[@id='question_layout']/div[1]/div[4]/select", CorrectAnswers);
					}	
					
					Thread.sleep(5000);
					
					if (CorrectAnswers == "Learners can select only one answer")
					{
						typeTextByiframe("Rich Text Editor, question", questionText + " " + d.toString());
						typeTextById("question_2", answerOption1 + " "  + d.toString());
						clickIdentifierXpath(".//*[@id='knAdd']");
						typeTextById("question_3", answerOption1 + " "  + d.toString());
						checkCheckBox(".//*[@id='question_Answer_2']");
						typeTextByXpath(".//*[@id='feedback']",feedback + " " + d.toString());
						Thread.sleep(1000);
						clickIdentifierXpath("//div[@id='question_layout']/div/div/div/img");
						Thread.sleep(5000);
							
						uploadFile("C:\\github\\CAT_automation\\resource\\images\\bns999_p18.jpg");
						Thread.sleep(1000);
						typeTextByXpath(".//*[@id='graphicDesc']",imgdes + " " + d.toString());
						typeTextByXpath(".//*[@id='altTxtOn']",alttext + " " + d.toString());
						clickIdentifierXpath("//*[@aria-describedby='question_layout']/div[3]/div/button");
						Log.info("single question type  selected and necessary details filled in");
					}
					
					if (CorrectAnswers == "Learners can select one or more answers")
					{
						typeTextByiframe("Rich Text Editor, question", questionText + " " + d.toString());
						typeTextById("question_2", answerOption1 + " "  + d.toString());
						clickIdentifierXpath(".//*[@id='knAdd']");
						typeTextById("question_3", answerOption1 + " "  + d.toString());
						checkCheckBox(".//*[@id='question_Answer_2']");
						typeTextByXpath(".//*[@id='feedback']",feedback + " " + d.toString());
						
						clickIdentifierXpath(".//div[@id='question_layout']/div/div[10]/div[2]/img");
						Thread.sleep(1000);
						uploadFile("C:\\github\\CAT_automation\\resource\\images\\bns999_p18.jpg");
						
						typeTextByXpath(".//*[@id='graphicDesc']",imgdes + " " + d.toString());
						typeTextByXpath(".//*[@id='altTxtOn']",alttext + " " + d.toString());
						clickIdentifierXpath("//*[@aria-describedby='question_layout']/div[3]/div/button");
						
						Log.info("Multiple questionType selected used and necesary details filled in");
					}
					
					Thread.sleep(3000);
				
					if (isElementPresent(By.xpath(".//*[@id='questionOpenBank_0']/div[2]/img[3]")))
						Log.pass("question added");
				
				}
				
				Thread.sleep(3000);
				
				JavascriptExecutor jse1 = (JavascriptExecutor)driver;
				jse1.executeScript("window.scrollTo(0,0)", "");
				
				clickIdentifierXpath(".//*[@id='knowledgeCheckCertificationForm']/div[1]/button");
				
				String publish = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
				
				if (publish.contains("Data saved"))
				{
					Log.pass("knowledge check saved");
				}
				
				else
					Log.fail("Unable to save knowledge check for reason: " + publish);
				
	}
	catch(Exception e){  
	       Log.fail("Failed to add knowledge check");
	       e.printStackTrace();
	       throw e;                                        
	} catch(AssertionError e)
	{
	       Log.fail("Failed to add knowledge check");
	       e.printStackTrace();
	       throw e;
	       

	}
	}
	
	
	
		
}