package com.lrn.cat.page;

import java.util.Date;

import org.openqa.selenium.By;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class SidebarTemplate extends CATAppCommon {
	static public void sidebar(String layout, String pageTitle, String showTitle, String pageContent,String sidebarType ,String sbTitle,String sbText,String sbFaq,String sbTop10,String desktopImage, String mobileImage, String audioFile, String imageDesc, String altText,String selectbulletintype, String bulletinTitle,String bulletinText) throws Exception
	{
		try
		{
			Date d = new Date();
			
			Log.startTestCase("Adding Sidebar Template");
			
			Thread.sleep(1000);
			
			
			if (layout != "")
				clickIdentifierByID("layout-" + layout + "-main");
			
			if (pageTitle != "")
				typeTextById("pageTitle", pageTitle + " " + d.toString());
			
			if (showTitle == "no")
			{
				uncheckCheckBox("//*[@id='mz-showTitle-2']");
				Log.info("unchecked show title");
			}
			
			if (showTitle == "yes")
			{
				checkCheckBox("//*[@id='mz-showTitle-2']");
				Log.info("checked show title");
			}
			
			if (pageContent != "")
				typeTextById("ckeditorContentsidebar_content", pageContent + " " + d.toString());
			
			
			if (audioFile != "")
			{
				clickIdentifierXpath("//*[@id='page_uploadAudio']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\audio\\l1p01_1.mp3");
				Thread.sleep(3000);
				Log.info("uploaded audio");
			}
			
			String SBConfig =driver.findElement(By.xpath(".//*[@id='sidebar_type']/div[3]/div/div/label[1]")).getText();
			System.out.println("SB Config type default ="  + SBConfig); 
			String SBConfig1 =driver.findElement(By.xpath(".//*[@id='sidebar_type']/div[3]/div/div/label[2]")).getText();
			System.out.println("SB Config type1 ="  + SBConfig1);
			String SBConfig2 =driver.findElement(By.xpath(".//*[@id='sidebar_type']/div[3]/div/div/label[3]")).getText();
			System.out.println("SB Config type2 ="  + SBConfig2);
						
			if (SBConfig.equals(sidebarType))
			{
				Log.info("Custom config type is selected");
				
				//typeTextByXpath(".//*[@id='ckeditorContentSidebarTitle']",sbTitle + " " + d.toString());
				typeTextById("ckeditorContentSidebarTitle", sbTitle + " " + d.toString());
				//typeTextByXpath(".//*[@id='ckeditorContentSidebarText']",pageContent + " " + d.toString());
				typeTextById("ckeditorContentSidebarText", sbText + " " + d.toString());
				
				if (desktopImage != "")
				{
					clickIdentifierXpath(".//div[@id='desktop-image-main-div-sidebar_image']/img");
					uploadFile("C:\\github\\CAT_automation\\resource\\images\\bns999_p18.jpg");
					Thread.sleep(5000);
					Log.info("uploaded desktop image");
				}
				
				if (mobileImage != "")
				{
					clickIdentifierXpath(".//div[@id='mobile-image-main-div-sidebar_image']/img");
					uploadFile("C:\\github\\CAT_automation\\resource\\images\\bns999_p18.jpg");
					Thread.sleep(5000);
					Log.info("uploaded mobile image");
				}
				
				if (imageDesc != "")
					//typeTextByXpath(".//*[@id='widgetImageDescription-sidebar_image']",imageDesc + " " + d.toString());
					typeTextById("widgetImageDescription-sidebar_image", imageDesc + " " + d.toString());
				
				if (altText != "")
					
					//typeTextByXpath(".//*[@id='widgetAltTextBackgroundImage-sidebar_image']",altText + " " + d.toString());
					typeTextById("widgetAltTextBackgroundImage-sidebar_image", altText + " " + d.toString());
				
				}	
					
			else if(SBConfig1.equals(sidebarType)){
				
				clickIdentifierXpath(".//*[@id='sidebar_type']/div[3]/div/div/label[2]/div/label");
				selectDropdownValueXpathVisibleText(".//div[@id='sidebarDropdownDiv']/select",sbFaq);
				typeTextById("ckeditorContentSidebarText", sbText + " " + d.toString());
				Log.info("FAQ config type is selected");
						
			}
			else{
				
				clickIdentifierXpath(".//*[@id='sidebar_type']/div[3]/div/div/label[3]/div/label");
				Thread.sleep(3000);
				selectDropdownValueXpathVisibleText(".//div[@id='sidebarDropdownDiv']/select",sbTop10);
				typeTextById("ckeditorContentSidebarText", sbText + " " + d.toString());
				Log.info("TOP10 config type is selected");
				
			}
			
			//Bulletin 
			String bulletinstatus =driver.findElement(By.xpath(".//div[@id='tab1']/div/div[1]/div[2]/div/div/label[2]")).getText();
			System.out.println("Add Bulletin to pgae toggle Button Status="  + bulletinstatus); 
			
			String addBstatus = "NO";
			
			if (bulletinstatus.equals(addBstatus))
			{
				clickIdentifierXpath(".//*[@id='tab1']/div/div[1]/div[2]/div/div");
				System.out.println("Add Bulletin to pgae toggle Button Status to yes" ); 
				String largeBstatus =driver.findElement(By.xpath(".//*[@id='tab1']/div/div[2]/div/div[2]/div/div/label[2]")).getText();
				System.out.println("large Bulletin toggle Button Status="  + largeBstatus);
				String lbStatus = "NO";
				
				if(largeBstatus.equals(lbStatus)){
					clickIdentifierXpath(".//*[@id='tab1']/div/div[2]/div/div[2]/div/div");
					System.out.println("large Bulletin toggle Button Set to yes" ); 
					
				String mBstatus =driver.findElement(By.xpath(".//div[@id='tab1']/div/div[3]/div[1]/div[1]/div[2]/div/div/label[2]")).getText();
				System.out.println("large Bulletin toggle Button Status="  + mBstatus);
				String bmand = "NO";
				if(mBstatus.equals(bmand)){
					clickIdentifierXpath(".//*[@id='tab1']/div/div[3]/div[1]/div[1]/div[2]");
					System.out.println("Add Bulletin to pgae toggle Button Status to yes" ); 
					
					//clickIdentifierXpath(".//*[@id='tab1']/div/div[3]/div[1]/div[1]/div[2]");
					//if (selectbulletintype != "")
					
								clickIdentifierByID(selectbulletintype);
								
								typeTextById("ckeditorContentBulletinTitle", bulletinTitle + " " + d.toString());
								//typeTextByXpath(".//*[@id='ckeditorContentSidebarText']",pageContent + " " + d.toString());
								typeTextById("ckeditorContentBulletin", bulletinText + " " + d.toString());
				
			}
			else
			{
								
					
				}
				
				}
				else{
					
				}
				
			
			}
			else{
				
			}
					
			clickIdentifierByID("saveIconId");
			
			String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (pageSaved.contains("Page saved"))
				Log.info("page saved");
			else
				Log.fail("page failed to save for reason: " + pageSaved);
		}
		
		catch(Exception e){  
		       Log.fail("Failed to edit text template");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to edit text template");
		       e.printStackTrace();
		       throw e;

		}
	}
}

