package com.lrn.cat.page;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class ModuleManager extends CATAppCommon
{
	private List<WebElement> element = null;
	String SearchBox_Xpath="//input[@id='search']";
	String SearchButton_Xpath="//button[text()='Search']";
	String FilterValue_Xpath="//select[@id='filter_options']";
	String AdminTool_Xpath="//a[text()='Admin Tools']";
	String Module_Manager_Xpath="//div[contains(text(),'Module Manager')]";
	//this method use for search module
	
	public void getModuleManager() throws Exception
	{
		//click admin tool link
		clickIdentifierXpath(AdminTool_Xpath);
		//LogerData.info("Click Admin tool link.");
		//getScrrolToWebElement(Module_Manager_Xpath);
		clickIdentifierXpath(Module_Manager_Xpath);
		//LogerData.info("Click Module Manager link.");
	}
	public void getSearchModule(String SearchModule) throws Exception
	{
		Thread.sleep(5000);
		String NextButton="//a[contains(text(),'next')]";
		String PreviesButton="//span[contains(text(),'prev')]";
		getWaitForElementPresent(PreviesButton,1000);
		//getWaitForElementPresent(NextButton,10000);
		typeTextByXpath(SearchBox_Xpath,SearchModule);
		//LogerData.info("Send text to  Search Box");
		WebElement filterLocater=driver.findElement(By.xpath(FilterValue_Xpath));
		getDroupDown(filterLocater,"Search the entire LRN Library");
		clickIdentifierXpath(SearchButton_Xpath);
		//log.info("Click Search Button.");
		Thread.sleep(5000);
		getWaitForElementPresent("//div/div/div/div[@class='module_header']",600);
		element=driver.findElements(By.xpath("//div/div/div/div[@class='module_header']"));
		//Thread.sleep(2000);
		for(int k=1;k<=element.size();k++)
		{
			String exceptedResultXpath="//div["+k+"]/div/div/div[@class='module_header']";
			String exceptedSearchModule=driver.findElement(By.xpath(exceptedResultXpath)).getText();
			
			System.out.println("exceptedSearchModule:"+exceptedSearchModule);
			//String exceptedSearchModule=getTextValueByXpath(exceptedResultXpath,exceptedResultXpath);
			System.out.println("exceptedSearchModule:"+exceptedSearchModule);
			String exceptedModuleID = exceptedSearchModule.substring(exceptedSearchModule.indexOf("(")+1,exceptedSearchModule.indexOf(")"));
			System.out.println("exceptedModuleID:"+exceptedModuleID);

			if (exceptedModuleID.equalsIgnoreCase(SearchModule)) 
			{
				try
				{
					//assertEquals(SearchModule, exceptedModuleID);
					//Log.info("Searching module ::"+"excepted value "+exceptedModuleID+"and"+"  Actual value::"+SearchModule);
					clickIdentifierXpath("//*[@id='ADP028']/div[2]/div/div");
					//LogerData.info("Select Searching Module!");
					//break;
				}catch(AssertionError  e)
				{
					//LogerData.info("Searching Module are not same");
				}
			}
			
			
		}
	}
	/******************* Edit Course*************************/
	static public void editFluidxCourse() throws Exception
	{
		try{
			
			//Date d = new Date();
			
			Log.startTestCase("Start edit Fluidx Course in MM");
			
			String expecetedcourse = driver.findElement(By.xpath("//*[@id='yui-rec0']/td[3]/div/div")).getText();
			System.out.println("expecetedFluidxcourse:"+ expecetedcourse);
			
			
			if (expecetedcourse.equalsIgnoreCase("editionIcon FluidX")) 
			{
				try
				{
					//assertEquals(SearchModule, exceptedModuleID);
					//Log.info("Searching module ::"+"excepted value "+exceptedModuleID+"and"+"  Actual value::"+SearchModule);
					clickIdentifierXpath("//tr[@id='yui-rec0']/td[3]/div");
					//LogerData.info("Select Searching Module!");
					
				}catch(AssertionError  e)
				{
					//LogerData.info("Searching Module are not same");
				}
			}
	}
	
	catch(Exception e){  
        Log.fail("Failed to edit course in MM");
        e.printStackTrace();
        throw e;                                        
 } catch(AssertionError e)
 {
        Log.fail("Failed to edit course in MM");
        e.printStackTrace();
        throw e;

 }
	}
	
}
