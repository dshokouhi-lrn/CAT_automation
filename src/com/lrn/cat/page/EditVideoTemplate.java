package com.lrn.cat.page;

import java.util.Date;

import org.openqa.selenium.By;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class EditVideoTemplate extends CATAppCommon{
	
	static public void editVideoTemplate() throws Exception
	{
		   
		 Date d = new Date();
		 
		 Log.startTestCase("start editing video template");
		 
		 Thread.sleep(5000);
		 
		 //need to make dynamic
		   typeTextById("pageTitle", "page title " + d.toString());
		   typeTextById("ckeditorContentvideoContent", "video content " + d.toString());
		   Thread.sleep(8000);
		   
		   driver.findElement(By.xpath(".//*[@id='videoAutoPlay']/div[3]/div/div[2]/div/div/span")).click();
		   Log.info("Clicked on toggle button to YES");
		   
		   clickIdentifierXpath("//div[@id='jw-player-video1-div']");
		   Log.info("Clicked on Video field to open Image libary");
		   	   
		   
		   clickIdentifierXpath(".//*[@id='uploadAMedia']/label");
		   Thread.sleep(1000);
		   clickIdentifierByID("fileToUpload");
		   uploadFile("C:\\github\\CAT_automation\\resource\\video\\clipcanvas_14348_H264_640x360.mp4");
		   Thread.sleep(20000);
		   clickIdentifierXpath(".//div[@aria-describedby='uploadDialogArea']/div/button");
		   clickIdentifierXpath(".//div[@id='fileList']/div[2]/div[1]");
		   Log.info("selecting video");
		   
		   clickIdentifierXpath("//div[@aria-describedby='dialogArea']/div[3]/div/button[1]");
		   Log.info("clicked on Ok");
		   
		   
		   //clickIdentifierXpath("//div[@id='srt-div']");
		   //Log.info("selecting SRT");
		   
		   typeTextById("ckeditorContentTextViewText0", "content " + d.toString());
		   Log.info("Entered data for Panel text field");
		   Thread.sleep(5000);
		   
		   //clickIdentifierByID("desktop-image-div-0-videoUploadPanel");
		   //clickIdentifierXpath(".//div[@id='fileList']/div[2]/div[1]");
		   //Log.info("Selecting Image");
		   
		   //clickIdentifierXpath("html/body/div[19]/div[3]/div/button[1]");
		   //Log.info("clicked on Ok");
		   
		   clickIdentifierXpath(".//*[@id='saveIconId']");
		   Thread.sleep(5000);
		   
		   clickIdentifierXpath(".//*[@id='widget1_uploadAudio']/img");
		   Log.info("Clicked on Upload audio icon");
		   Thread.sleep(5000);
		   
		   uploadFile("C:\\github\\CAT_automation\\resource\\audio\\TechJam.mp3");
		   Thread.sleep(5000);
		   
		   driver.findElement(By.xpath(".//*[@id='tab1']/div/div[1]/div[2]/div/div/span")).click();
		   Log.info("Clicked on toggle button Yes for bulletin");
		   
		   driver.findElement(By.xpath(".//*[@id='tab1']/div/div[2]/div/div[2]/div/div/span")).click();
		   Log.info("Clicked on toggle button Yes for Large bulletin");
		   Thread.sleep(5000);  
		  // typeTextByXpath(".//div[@id='ckeditorContentBulletin']","Bulletin Title");
		   
		   typeTextById("ckeditorContentBulletinTitle","Bulletin Title " + d.toString());
		   Log.info("Entered bulletin title");
		   Thread.sleep(500);
		   
		   typeTextById("ckeditorContentBulletin","Bulletin content " + d.toString());
		   Log.info("Entered bulletin text");
		   
		   driver.findElement(By.xpath(".//*[@id='tab1']/div/div[3]/div[5]/div[2]/div/div/span")).click();
		   clickIdentifierXpath(".//*[@id='ok-button']");
		   Thread.sleep(500);
		   Log.info("Clicked on save button");
		   Thread.sleep(5000);
	}

}
