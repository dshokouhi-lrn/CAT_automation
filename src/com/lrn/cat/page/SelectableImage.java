package com.lrn.cat.page;

import java.util.Date;

import org.openqa.selenium.By;


import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class SelectableImage extends CATAppCommon {
	
		static public void selectableimage(String layout, String pageTitle, String showTitle, String pageContent,String selectionOrder,String imagePlacement, String placementX, String placementY,String siTitle,String siText,String desktopImage, String mobileImage, String audioFile, String imageDesc, String altText,String selectbulletintype, String bulletinTitle,String bulletinText) throws Exception{
						
			
			try
			{
				Date d = new Date();
				
				Log.startTestCase("Adding Selectable Image Template");
				
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
					typeTextById("ckeditorContentrevealHotspot_content", pageContent + " " + d.toString());
				//*[@id='ckeditorContentrevealHotspot_content']
				
				/*if (audioFile != "")
				{
					
					clickIdentifierXpath("//*[@id='page_uploadAudio']/img");
					uploadFile("C:\\github\\CAT_automation\\resource\\audio\\l1p01_1.mp3");
					Thread.sleep(3000);
					Log.info("uploaded audio");
				}*/
				
				if (desktopImage != "")
				{
					clickIdentifierXpath(".//div[@id='desktop-image-main-div-hotspot_pageImage']/img");
					uploadFile("C:\\github\\CAT_automation\\resource\\images\\bns999_p18.jpg");
					Thread.sleep(5000);
					Log.info("uploaded desktop image");
				}
				
				if (mobileImage != "")
				{
					clickIdentifierXpath(".//div[@id='mobile-image-main-div-hotspot_pageImage']/img");
					uploadFile("C:\\github\\CAT_automation\\resource\\images\\bns999_p18.jpg");
					Thread.sleep(5000);
					Log.info("uploaded mobile image");
				}
				
				if (imageDesc != "")
					//typeTextByXpath(".//*[@id='widgetImageDescription-sidebar_image']",imageDesc + " " + d.toString());
					typeTextById("widgetImageDescription-hotspot_pageImage", imageDesc + " " + d.toString());
				
				if (altText != "")
					
					//typeTextByXpath(".//*[@id='widgetAltTextBackgroundImage-sidebar_image']",altText + " " + d.toString());
					typeTextById("widgetAltTextBackgroundImage-hotspot_pageImage", altText + " " + d.toString());
				
		
			String CISettings =driver.findElement(By.xpath(".//div[@id='selection-order-option-div']/div/div[2]")).getText();
			System.out.println("CISettings type default ="  + CISettings); 
			
						
			if (CISettings.equals(selectionOrder))
			{
				Log.info("selectionOrder is selected as Random");
				
				//typeTextByXpath(".//*[@id='ckeditorContentSidebarTitle']",sbTitle + " " + d.toString());
				typeTextById("ckeditorContentHotspotTitle0", siTitle + " " + d.toString());
				//typeTextByXpath(".//*[@id='ckeditorContentSidebarText']",pageContent + " " + d.toString());
				typeTextById("ckeditorContentHotspotText0", siText + " " + d.toString());
				/*if (audioFile != "")
				{
					
					clickIdentifierXpath(".//*[@id='widget1_uploadAudio']/img");
					uploadFile("C:\\github\\CAT_automation\\resource\\audio\\l1p01_1.mp3");
					Thread.sleep(3000);
					Log.info("uploaded Hotspot1 audio");
				}*/
				
				
				
				if(imagePlacement =="DesktopSamrtphones")
				{	
				/*desktop or tablets*/
				
				//typeTextByXpath(".//*[@id='hotSpotDesktopPositionX0']",placementX);
				typeTextById("hotSpotDesktopPositionX0", placementX);
				//typeTextByXpath(".//*[@id='hotSpotDesktopPositionY0']",placementY);
				typeTextById("hotSpotDesktopPositionY0", placementY);
				
				/*Smart phones*/
				
				//typeTextByXpath(".//*[@id='hotSpotSmartphonePositionX0']",placementX);
				typeTextById("hotSpotSmartphonePositionX0", placementX);
				//typeTextByXpath(".//*[@id='hotSpotSmartphonePositionY0']",placementY);
				typeTextById("hotSpotSmartphonePositionY0", placementY);
				
				/*driver.findElement(By.xpath(".//*[@id='hotSpotDesktopPositionX0']")).clear();
				driver.findElement(By.xpath(".//*[@id='hotSpotDesktopPositionX0']")).sendKeys("12");*/
				}
				else{
				/*--POPUP desktop or tablets Placement--*/
				
				clickIdentifierXpath(".//*[@id='placeDesktopHotSpot0']");

				typeTextById("popUpX", placementX);
				
				typeTextById("popUpY", placementY);
				
				//clickIdentifierXpath(".//*[@id='hotSpotPoint']"); Placement in popup image
				clickIdentifierXpath(".//*[@id='hotspotPopUpApplyButton']");
				//clickIdentifierXpath(".//*[@id='hotspotPopUpResetButton']"); //reset button in popup
				clickIdentifierXpath(".//*[@id='hotspotPopUpSaveButton']");
				
				//clickIdentifierXpath(".//*[@id='hotspotPopUpCancelButton']"); //Cancel popup 
				
				/*--POPUP SmartPhone Placement--*/
				
				clickIdentifierXpath(".//*[@id='placeSmartphoneHotSpot0']");

				typeTextById("popUpX", placementX);
				
				typeTextById("popUpY", placementY);
				
				clickIdentifierXpath(".//*[@id='hotspotPopUpApplyButton']");
				clickIdentifierXpath(".//*[@id='hotspotPopUpSaveButton']");
				
				}
				
				
				clickIdentifierXpath(".//*[@id='hotspot-normal-image-main-div-revealHotspot_hotspot0']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Desert.jpg");
				Thread.sleep(5000);
				Log.info("uploaded normal image");
				
				clickIdentifierXpath(".//div[@id='hotspot-hover-image-main-div-revealHotspot_hotspot0']/img");
			
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Jellyfish.jpg");
				Thread.sleep(5000);
				Log.info("uploaded hover image");
				
				
				clickIdentifierXpath(".//div[@id='hotspot-complete-image-main-div-revealHotspot_hotspot0']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Tulips.jpg");
				Thread.sleep(5000);
				Log.info("uploaded complete image");
				
				clickIdentifierXpath(".//*[@id='revealHotspot_hotspot']/div[2]/div[1]");
				String ImagePanel =driver.findElement(By.xpath(".//*[@id='fieldset-panel0']/legend/label")).getText();
				System.out.println("ImagePanel default Name ="  + ImagePanel); 
				
				/* Image panel2*/
				typeTextById("ckeditorContentHotspotTitle1", siTitle + " " + d.toString());
				//typeTextByXpath(".//*[@id='ckeditorContentSidebarText']",pageContent + " " + d.toString());
				typeTextById("ckeditorContentHotspotText1", siText + " " + d.toString());
				/*if (audioFile != "")
				{
					
					clickIdentifierXpath(".//*[@id='widget1_uploadAudio']/img");
					uploadFile("C:\\github\\CAT_automation\\resource\\audio\\l1p01_1.mp3");
					Thread.sleep(3000);
					Log.info("uploaded Hotspot1 audio");
				}*/
				
				
				
				if(imagePlacement =="DesktopSamrtphones")
				{	
				/*desktop or tablets*/
				
				//typeTextByXpath(".//*[@id='hotSpotDesktopPositionX0']",placementX);
				typeTextById("hotSpotDesktopPositionX1", placementX);
				//typeTextByXpath(".//*[@id='hotSpotDesktopPositionY0']",placementY);
				typeTextById("hotSpotDesktopPositionY1", placementY);
				
				/*Smart phones*/
				
				//typeTextByXpath(".//*[@id='hotSpotSmartphonePositionX0']",placementX);
				typeTextById("hotSpotSmartphonePositionX1", placementX);
				//typeTextByXpath(".//*[@id='hotSpotSmartphonePositionY0']",placementY);
				typeTextById("hotSpotSmartphonePositionY1", placementY);
				
				/*driver.findElement(By.xpath(".//*[@id='hotSpotDesktopPositionX0']")).clear();
				driver.findElement(By.xpath(".//*[@id='hotSpotDesktopPositionX0']")).sendKeys("12");*/
				}
				else{
				/*--POPUP desktop or tablets Placement--*/
				
				clickIdentifierXpath(".//*[@id='placeDesktopHotSpot1']");

				typeTextById("popUpX", placementX);
				
				typeTextById("popUpY", placementY);
				
				//clickIdentifierXpath(".//*[@id='hotSpotPoint']"); Placement in popup image
				clickIdentifierXpath(".//*[@id='hotspotPopUpApplyButton']");
				//clickIdentifierXpath(".//*[@id='hotspotPopUpResetButton']"); //reset button in popup
				clickIdentifierXpath(".//*[@id='hotspotPopUpSaveButton']");
				
				//clickIdentifierXpath(".//*[@id='hotspotPopUpCancelButton']"); //Cancel popup 
				
				/*--POPUP SmartPhone Placement--*/
				
				clickIdentifierXpath(".//*[@id='placeSmartphoneHotSpot1']");

				typeTextById("popUpX", placementX);
				
				typeTextById("popUpY", placementY);
				
				clickIdentifierXpath(".//*[@id='hotspotPopUpApplyButton']");
				clickIdentifierXpath(".//*[@id='hotspotPopUpSaveButton']");
				
				}
				
				
				clickIdentifierXpath(".//*[@id='hotspot-normal-image-main-div-revealHotspot_hotspot1']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Jellyfish.jpg");
				Thread.sleep(5000);
				Log.info("uploaded normal image");
				
				clickIdentifierXpath(".//div[@id='hotspot-hover-image-main-div-revealHotspot_hotspot1']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Tulips.jpg");
				Thread.sleep(5000);
				Log.info("uploaded hover image");
				
				clickIdentifierXpath(".//div[@id='hotspot-complete-image-main-div-revealHotspot_hotspot1']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\Penguins.jpg");
				Thread.sleep(5000);
				Log.info("uploaded complete image");

					
			}		
					
			else {
				//Sequential
				clickIdentifierXpath(".//*[@id='selection-order-option-div']/div/div[3]/input");
				
				Log.info("selectionOrder is selected as Sequential");
				
				//typeTextByXpath(".//*[@id='ckeditorContentSidebarTitle']",sbTitle + " " + d.toString());
				typeTextById("ckeditorContentHotspotTitle0", siTitle + " " + d.toString());
				//typeTextByXpath(".//*[@id='ckeditorContentSidebarText']",pageContent + " " + d.toString());
				typeTextById("ckeditorContentHotspotText0", siText + " " + d.toString());
				/*if (audioFile != "")
				{
					
					clickIdentifierXpath(".//*[@id='widget1_uploadAudio']/img");
					uploadFile("C:\\github\\CAT_automation\\resource\\audio\\l1p01_1.mp3");
					Thread.sleep(3000);
					Log.info("uploaded Hotspot1 audio");
				}*/
				
				
				
				/*desktop or tablets*/
				
				//typeTextByXpath(".//*[@id='hotSpotDesktopPositionX0']",placementX);
				typeTextById("hotSpotDesktopPositionX0", placementX);
				//typeTextByXpath(".//*[@id='hotSpotDesktopPositionY0']",placementY);
				typeTextById("hotSpotDesktopPositionY0", placementY);
				
				/*Smart phones*/
				
				//typeTextByXpath(".//*[@id='hotSpotSmartphonePositionX0']",placementX);
				typeTextById("hotSpotSmartphonePositionX0", placementX);
				//typeTextByXpath(".//*[@id='hotSpotSmartphonePositionY0']",placementY);
				typeTextById("hotSpotSmartphonePositionY0", placementY);
				
				clickIdentifierXpath(".//*[@id='hotspot-normal-image-main-div-revealHotspot_hotspot0']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\bns999_p18.jpg");
				Thread.sleep(5000);
				Log.info("uploaded normal image");
				
				clickIdentifierXpath(".//div[@id='hotspot-hover-image-main-div-revealHotspot_hotspot0']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\bns999_p18.jpg");
				Thread.sleep(5000);
				Log.info("uploaded hover image");
				
				clickIdentifierXpath(".//div[@id='hotspot-complete-image-main-div-revealHotspot_hotspot0']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\bns999_p18.jpg");
				Thread.sleep(5000);
				Log.info("uploaded complete image");
				
				
				
				
						//*[@id='messageDialog']/tr/td[2]
						
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
			if (audioFile != "")
			{
				
				clickIdentifierXpath("//div[@id='widget2_uploadAudio']/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\audio\\l1p01_1.mp3");
				Thread.sleep(3000);
				Log.info("uploaded audio");
			}
			clickIdentifierByID("saveIconId");
			
			String pageSaved1 = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (pageSaved1.contains("Page saved"))
				Log.info("page saved");
			else
				Log.fail("page failed to save for reason: " + pageSaved1);
		
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
