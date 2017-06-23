package com.lrn.cat.page;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class RenameNode extends CATAppCommon {

	static public void copyNode(String lesson, String topic, String nodeText) throws Exception
	{
		try
		{
			Log.startTestCase("starting rename node test case");  
			
			Date d = new Date();
			
			//WebElement productLink = driver.findElement(By.xpath(".//*[@id='j1_7_anchor']"));
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			WebElement productLink = null;
			
			
			if (lesson != "" && topic != "")
				productLink = driver.findElement(By.xpath(".//*[@id='courseTree']/ul/li/ul/li[" + lesson + "]/ul/li[" + topic + "]"));
			else if (lesson != "" && topic == "")
				productLink = driver.findElement(By.xpath(".//*[@id='courseTree']/ul/li/ul/li[" + lesson + "]"));

			  
			Log.info("found the page"); 
			  
			Actions action= new Actions(driver);
			action.contextClick(productLink).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
			
			Log.info("right clicked on the page");
			Thread.sleep(10000);
			
			if (lesson != "" && topic != "")
				clickIdentifierXpath("html/body/ul/li[2]/a");
			else if (lesson != "" && topic == "")
				clickIdentifierXpath("html/body/ul/li[2]/a");

			
			Log.pass("clicked on rename");
			
			Thread.sleep(3000);
			
			typeTextByXpath("//*[@id='note_pag']/ul/li/input", nodeText + " " + d.toString());
			
			Thread.sleep(3000);
			
			//clickIdentifierXpath(".//div[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']/div/button[1]");
			
			clickIdentifierXpath(".//div[@aria-describedby='dialogArea']/div[3]/div/button[1]");
			
			Log.pass("node renamed");
			
			Thread.sleep(5000);
			
		}
		
		   catch(Exception e){  
               Log.fail("Failed to rename node");
               e.printStackTrace();
               throw e;                                        
        } catch(AssertionError e)
        {
               Log.fail("Failed to rename node");
               e.printStackTrace();
               throw e;

        }
	}
}
