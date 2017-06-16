package com.lrn.cat.page;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class EditCourse extends CATAppCommon {
	
 static public void editcourse() throws Exception
 {
   try
   {
	   Date d = new Date();
	   
	   Log.startTestCase("Verify Edit course");
	   clickIdentifierXpath("//tr[9]/td[7]/a/span/i");
	   
	   Log.info("Clicked on Edit Button");
	   
	     //part of EditGetStarted
	   typeTextById("title", "Course title " + d.toString());
	   Log.info("Enter value");
	   clickIdentifierXpath(".//div[@id='menuTabs']/ul/li[2]/p"); 
	   Log.info("Navigate to Create course tab");
	   
	   
	   Thread.sleep(4000);
	   clickIdentifierXpath("//div[@class='ui-dialog-buttonset']/button[1]");
	   Log.info("Clicked on Yes on Save popup");
	   Thread.sleep(18000);
	   
	   
	   clickIdentifierXpath("//div[@id='menuTabs']/ul/li[2]/p");
	   clickIdentifierXpath("//li[2]/ul/li/ul/li[2]/a");
	   typeTextById("pageTitle", "video title " + d.toString());
	   Thread.sleep(5000);
	   
	   
	   clickIdentifierXpath("//div[4]/div/div[2]/div/div/div/img");
	   Thread.sleep(4000);
	   
	   clickIdentifierXpath(".//*[@id='courseTreeOperationIcons']/li[3]/p");
	   clickIdentifierXpath("//div[@id='template-row-column-image-1-4']/img");
	   clickIdentifierXpath("//div[@class='ui-dialog-buttonset']/button");
	   Thread.sleep(8000);
	   
	   
	   typeTextById("pageTitle", "page title " + d.toString());
	   typeTextById("ckeditorContentvideoContent", "video content " + d.toString());
	   Thread.sleep(8000);
	   
	   driver.findElement(By.xpath(".//*[@id='videoAutoPlay']/div[3]/div/div[2]/div/div/span")).click();
	   Log.info("Clicked on toggle button to YES");
	   
	   clickIdentifierXpath("//div[@id='jw-player-video1-div']");
	   Log.info("Clicked on Video field to open Image libary");
	   
	   clickIdentifierXpath(".//div[@id='fileList']/div[2]/div");
	   Log.info("selecting video");
	   
	   clickIdentifierXpath("html/body/div[19]/div[3]/div/button[1]");
	   Log.info("clicked on Ok");
	   
	   clickIdentifierXpath("//div[@id='srt-div']");
	   Log.info("selecting SRT");
	   
	   typeTextById("ckeditorContentTextViewText0", "content " + d.toString());
	   Log.info("Entered data for Panel text field");
	   Thread.sleep(5000);
	   
	   clickIdentifierByID("desktop-image-div-0-videoUploadPanel");
	   clickIdentifierXpath(".//div[@id='fileList']/div[2]/div[1]");
	   Log.info("Selecting Image");
	   
	   clickIdentifierXpath("html/body/div[19]/div[3]/div/button[1]");
	   Log.info("clicked on Ok");
	   
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
	   
	   //clickIdentifierXpath(".//div[@id='widget1_uploadAudio']/img");
	   //Log.info("Clicked on Upload audio icon");
	  // clickIdentifierXpath(".//*[@id='j1_12_anchor']");
	   driver.navigate().refresh();
	   Thread.sleep(10000);
	   clickIdentifierXpath(".//div[@id='menuTabs']/ul/li[2]/p"); 
	   Log.info("Navigate to Create course tab");
	   
	   
	   JavascriptExecutor jse = (JavascriptExecutor)driver;
	   jse.executeScript("window.scrollBy(0,-250)", "");
	   WebElement productLink = driver.findElement(By.xpath(".//*[@id='j1_7_anchor']"));
	   Actions action= new Actions(driver);
	  action.contextClick(productLink).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
	  Thread.sleep(10000);
	  clickIdentifierXpath("html/body/ul/li[3]/a");
	  Log.info("clicked on Lock");
	  Thread.sleep(20000);
	  
	  WebElement productLink1 = driver.findElement(By.xpath(".//*[@id='j1_7_anchor']"));
	   Actions action1= new Actions(driver);
	  action1.contextClick(productLink1).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
	  clickIdentifierXpath("html/body/ul/li[1]/a");
	  Log.info("clicked on UnLock");
	  
	  WebElement productLink11 = driver.findElement(By.xpath(".//*[@id='j1_7_anchor']"));
	   Actions action11= new Actions(driver);
	  action11.contextClick(productLink11).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
	  clickIdentifierXpath("html/body/ul/li[2]/a");
	  Log.info("clicked on Hide");
	  Thread.sleep(20000);
	  
	  WebElement productLink111 = driver.findElement(By.xpath(".//*[@id='j1_7_anchor']"));
	   Actions action111= new Actions(driver);
	  action111.contextClick(productLink111).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
	  clickIdentifierXpath("html/body/ul/li[1]/a");
	  Log.info("clicked on UnHide");
	  Thread.sleep(20000);
	  
	  WebElement productLink1111 = driver.findElement(By.xpath(".//*[@id='j1_7_anchor']"));
	   Actions action1111= new Actions(driver);
	  action1111.contextClick(productLink1111).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
	  clickIdentifierXpath("html/body/ul/li[4]/a");
	  Log.info("clicked on Delete");
	  clickIdentifierXpath("//div[@class='ui-dialog-buttonset']/button[1]");
	  Log.info("clicked on yes on Delete popup");
	   //uploadFile("C:\\Users\\megha.thombre\\Desktop\\l1p01_1.mp3");
	   
	   //clickIdentifierXpath("//div/button");
	  
	  //clickIdentifierPartialLinkText("Menu");
	  //Thread.sleep(5000);
	  //clickIdentifierByID("logout");
	  
	   Log.info("Clicked on LogOut button");
	   Thread.sleep(20000);
	   Log.pass("Edit course Successfully!!");
	   
   }
   catch(Exception e){  
       Log.fail("Failed to Edit course");
       e.printStackTrace();
       throw e;                                        
} catch(AssertionError e)
{
       Log.fail("Failed to Edit course");
       e.printStackTrace();
       throw e;

}
 
 }
 
}
