package com.lrn.cat.page;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class KCConifg extends CATAppCommon {
	//static public void KCConfiguration(String questionTitle,String questionText,String answerType,String answerOption1,String answerOption2,String CorrectAnswers,String feedback,String imgdes,String alttext,String learnertakesquestion,String dropval,String failedmsg) throws Exception
	static public void KCConfiguration(String learnertakesquestion,String dropval,String failedmsg) throws Exception
	{
	/****************************Knowledge check Configuration***************************************/
		try{
			
			Log.startTestCase("go to on Knowledge check Config");
			Thread.sleep(500);
			
			/***KC configuration ***/
			String customizeConfig =driver.findElement(By.xpath("//div[@id='isCustomizeKnowledgeCheckDiv']/div/div[3]/div/div")).getText();
			System.out.println("KC toggle Button Status="  + customizeConfig); 
			
			String cconfig = "NO";
			
			if (customizeConfig.equals(cconfig))
			{
				
				clickIdentifierXpath(".//*[@id='isCustomizeKnowledgeCheckDiv']/div/div[3]/div");
				System.out.println("customize  KC toggle Button is set to yes" ); 
				
				/***KC Random configuration ***/
				
				String randomQconfig =driver.findElement(By.xpath("//*[@id='isRandomQuizDiv']/div[2]/div/div")).getText();
				
				System.out.println("KC RandomQconfig toggle Button Status="  + randomQconfig); 
				
				String rQconfig = "NO";
				if (randomQconfig.equals(rQconfig))
				{
					clickIdentifierXpath(".//div[@id='isRandomQuizDiv']/div[2]/div/div");
					System.out.println("RandomQ  KC toggle Button is set to yes" ); 
					
					/***KC Random Question Poll configuration ***/
					String kcqpool =driver.findElement(By.xpath("//*[@id='isPooledQuizDiv']/div[2]/div/div")).getText();
					
					System.out.println("KC  Question poool toggle Button Status="  + kcqpool); 
					
					String qpool  = "NO";
					if (kcqpool.equals(qpool))
					{
						
						clickIdentifierXpath(".//div[@id='isPooledQuizDiv']/div[2]/div/div");
						//clickIdentifierByID("isPooledQuizDiv");
						System.out.println("Question poll  KC toggle Button is set to yes" );
						
						/***KC Total no of questions ***/
						
						String totalNQns =driver.findElement(By.xpath(".//*[@id='totalNoOfQuestions']")).getText();
						System.out.println("Total no of questions ="  + totalNQns);
						int kcTQ = Integer.parseInt(totalNQns);
						int kclTQ = Integer.parseInt(learnertakesquestion);
						if(kcTQ>kclTQ){
							
							typeTextById("knowledgeCheckPoolSize", learnertakesquestion);
							
							/***KC no of Attempts ***/
							String passkc =driver.findElement(By.xpath("//div[@id='isKnowledgeCheckRetryDiv']/div[2]/div/div/label[2]")).getText();
							System.out.println("pass KC  no.of retry toggle Button Status="  + passkc); 
							
							
							String attemptkc  = "NO";
							if (passkc.equals(attemptkc))
								
							{
								clickIdentifierXpath("//div[@id='isKnowledgeCheckRetryDiv']/div[2]/div/div");
								System.out.println("Retry question set to yes" ); 
								
								/*List<String> nofAttempts=getAllDropDownOptions("//*[@id='noOfRetryAttempts']");
								
								System.out.println("KC no of Attempts="  + nofAttempts);
								//int Nolessons = Integer.parseInt(lessonnos);
								
								for(int i=1;i<=nofAttempts.size();i++){}*/
								
								int i =3;
									selectDropdownValueByIndex("noOfRetryAttempts",i);
								//selectDropdownValueXpathVisibleText(".//*[@id='noOfRetryAttempts']",dropval);
									
									Thread.sleep(2500);
									clickIdentifierXpath("//div[@aria-describedby='noOfRetryDialogArea']/div[3]/div/button[1]");
									
								
								System.out.println(" number of attempts =" + i);
								
								typeTextByXpath(".//*[@id='attemptFailKC']",failedmsg);
								
								
								/***KC re take Learners ***/
								String retakekc =driver.findElement(By.xpath(".//div[@id='isRetryQuizRandomDiv']/div[2]/div/div/label[2]")).getText();
								
								System.out.println("retake KC  Question poool toggle Button Status="  + retakekc); 
								
								String retake  = "NO";
								if (retake.equals(retake))
								{
									Thread.sleep(1000);
									clickIdentifierXpath("//*[@id='isRetryQuizRandomDiv']/div[2]/div/div");
									System.out.println("retake question  KC toggle Button is set to yes" );
								}
								else{
									/***KC re take Learners ***/
									
								}
								
							}
							else{
								/***KC no of Attempts ***/
							}
						
						}
						
						else{
							/***KC Total no of questions ***/
						}
					}
					else{
						/***KC Random Question Poll configuration ***/
					}
			}
				else{
					/***KC Random configuration ***/
				}
			}
			else{
				/***KC configuration ***/
			}
			
			 
		}
		
		catch(Exception e){  
		       Log.fail("Failed to Add KC Congiguration");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to Add KC Congiguration");
		       e.printStackTrace();
		       throw e;

		}

	}
	static public void knowledgecheckTab(String desktopImage,String imageDesc,String altText,String SuccessMessage,String FailureMessage,String CertMessage,String QuestionTag,String pageComments) throws Exception
	{
		
	try{
		Date d = new Date();
		
		/******************************Question Image************************************/
		clickIdentifierXpath("//*//div[@id='pageAccordian']/h5[2]");//KC Question Image section
		
		if (desktopImage != "")
		{
			clickIdentifierXpath("//*[@id='imageToggleSection']/div[1]/div[1]/img");
			uploadFile("C:\\github\\CAT_automation\\resource\\images\\bns999_p18.jpg");
			Thread.sleep(5000);
			Log.info("uploaded desktop image");
		}
		
				if (imageDesc != "")
			//typeTextByXpath("//*[@id='graphicDescKC']",imageDesc + " " + d.toString());
			typeTextById("graphicDescKC", imageDesc + " " + d.toString());
		
		if (altText != "")
			
			//typeTextByXpath(".//*[@id='altTxtOnKC']",altText + " " + d.toString());
			typeTextById("altTxtOnKC", altText + " " + d.toString());
		
		
		/******************* End of course messages********************************/
		
		clickIdentifierXpath("//*//div[@id='pageAccordian']/h5[3]");
		//*[@id='ckeditorSuccessMessage']
		typeTextById("ckeditorSuccessMessage", SuccessMessage + " " + d.toString());
		//*[@id='ckeditorFailureMessage']
		typeTextById("ckseditorFailureMessage", FailureMessage + " " + d.toString());
		//*[@id='ckeditorCertMessage']
		typeTextById("ckeditorCertMessage", CertMessage + " " + d.toString());
		
		
		/*************************************Miscellaneous**************************/
		
		clickIdentifierXpath("//*//div[@id='pageAccordian']/h5[4]");
		
		
		/*************** No code added fro tag Info**************************/
		//*[@id='KCtags_tagsinput'],//*[@id='KCtags_tagsinput']/div
		//typeTextById("KCtags_tagsinput", QuestionTag + " " + d.toString());

		/*typeTextByXpath("//*[@id='KCtags_tagsinput']/div",QuestionTag + " " + d.toString());
		
		typeTextByXpath("//div[@id='KCtags_addTag']/input",QuestionTag + " " + d.toString());
		clickIdentifierXpath("//div[@id='KCtags_tagsinput']");
		typeTextById("KCtags_addTag", QuestionTag + " " + d.toString());
		typeTextByXpath("//*[@id='KCtags_tagsinput']/div[1]/input",QuestionTag + " " + d.toString());*/
		
		//*[@id='pageComments']
		//typeTextById("pageComments", pageComments + " " + d.toString());
		typeTextByName("DescriptionTxtArea", pageComments + " " + d.toString() );
		//typeTextById("//div[@id='miscToggleSection']/textarea", pageComments + " " + d.toString());
		
		//clickIdentifierXpath("//*//div[@id='pageAccordian']/h5[1]");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0,0)", "");
		
		clickIdentifierXpath("//*[@id='knowledgeCheckCertificationForm']/div/button");//KC Tab Save
		
		
		Thread.sleep(3000);
		String savemessage =driver.findElement(By.xpath("//*[@id='messageDialog']/tr/td[2]")).getText();
		System.out.println(" KC  Question tab="  + savemessage);
	}
	catch(Exception e){  
	       Log.fail("Failed to Add KC Congiguration");
	       e.printStackTrace();
	       throw e;                                        
	} catch(AssertionError e)
	{
	       Log.fail("Failed to Add KC Congiguration");
	       e.printStackTrace();
	       throw e;

	}
}	

}

