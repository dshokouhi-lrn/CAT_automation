package com.lrn.webdrivercommon;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;



/*import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;*/




import org.testng.asserts.SoftAssert;

import com.lrn.pp.utility.Log;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class WebAppCommon {

	public static WebDriver driver = null;
	public static Properties configProperties = readPropertyFile("//resource//config//FrameworkConfig.properties");

	
//	public static ExtentReports report=new ExtentReports("C:\\Report\\PPTExecutionReport.html");
	public static ExtentReports report=new ExtentReports("C:\\Report\\CATExecutionReport.html", true);
	
	// Get the DB environment to be connected to
	String connectToDB = configProperties.getProperty("connectToDB");
	private Connection connection;
	private Statement stmt;
	public static  ExtentTest logger;	
	private static int timeoutSeconds = 10;
	public static String BROWSER_NAME = "";
	public static String BROWSER_VERSION = "";
	public static String PLATFORM = "";
	private static WebDriverWait wait = null;
	public static SoftAssert softA = new SoftAssert();
//	protected static Screen screen = new Screen();


//	protected String logs = appPath()+ "//src//log4j.xml";

	public static String backGroundImage = appPath()+ "\\resource\\SiteCustomizationImage\\Favicon.jpg";
	//C:/Users/ravi.jaiswar/Desktop/LocalDriver/CatalystAutomation/src/com/lrn/catalyst/logs/log4j.xml
	//String logs = "C:/Users/ravi.jaiswar/Desktop/LocalDriver/CatalystAutomation/src/com/lrn/catalyst/logs/log4j.xml";

	//private String URL = "http://www.xyz.com";
	//@Parameters("browser")C:\Users\ravi.jaiswar\Desktop\LRN_Automation\LCECAutomation\testdata\bulkload-file\qacustomize05\LRNADD112315.txt
	


	/*	public static WebDriver getDriver() throws Exception {
		if (driver == null) {
			String browser = FrameWorkConfig.getBrowser();
			timeoutSeconds = FrameWorkConfig.getBrowserTimeOut();

			if (browser.equals("FF")) {
				getFFDriver();
			} else if (browser.equals("IE")) {
				getIEDriver();
			} else if (browser.equals("GC")) {
				getChromeDriver();
			}

			// Get actualCapabilities
			Capabilities actualCapabilities = ((RemoteWebDriver) driver)
					.getCapabilities();
			BROWSER_NAME = actualCapabilities.getBrowserName().toUpperCase();
			BROWSER_VERSION = actualCapabilities.getVersion();
			PLATFORM = actualCapabilities.getPlatform().toString()
					.toUpperCase();
		}
		return driver;
	}*/
	
	
	public static void softAssertEquals(String xpath, String expectedValue)
	{
		try 
		{
			softA.assertEquals(getValueByXpath(xpath),expectedValue);
			
		} 
		catch (Exception e) 
		{
			throw e;
		}
	}

	
	public void connectToDB() 
	{
		try 
		{
			if (connectToDB.equals("QA")) 
			{
				Class driverClass = Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection("","","");
				stmt = connection.createStatement();

			}
			else if (connectToDB.equals("DEV")) 
			{
				Class driverClass = Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection("jdbc:oracle:thin:@10.103.30.30:1526/lcecbq5","lcec", "lcec");
				stmt = connection.createStatement();
				System.out.println("Connected to DB");
			}
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*Name - getStmt*/
	public Statement getStmt() throws  SQLException 
	{
			return connection.createStatement();
			
		
		
	}
	
	
	//select * from course_lookup where system_id='LRNL0384';
	
	
	
	public void keyDown() throws Exception {
		try 
		{
			Actions a = new Actions(driver);
			a.keyDown(Keys.DOWN).build().perform();

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			throw e;
		}
	}


	public void moveByOffset(int xOffset, int yOffset) throws Exception {
		try {
			Actions a = new Actions(driver);
			a.moveByOffset(xOffset, yOffset).build().perform();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw e;
		}
	}


	/*public static void sikuliExecute(String ImagePath ) throws Exception{
		try {
			ImagePath = appPath() + ImagePath; 

			Pattern image1 = new Pattern(ImagePath);

			if(screen.exists(image1) != null){
				//DO YOUR ACTIONS
				screen.wait(image1, 10);
				screen.click(image1);
				System.out.println("Sikuli operation successful");
			} else
				System.out.println("Outside sikuli loop, operation Un-successful");
		} catch (Exception e) {
			Log.info("Error: Failed in Sikuli, not able to perform action on Image");
			e.printStackTrace();
			throw e;
			// TODO: handle exception
		}
	}

	public static void sikuliVerifyImage(String ImagePath, String Comment ) throws Exception{
		try {
			ImagePath = appPath() + ImagePath; 
			Pattern image1 = new Pattern(ImagePath);
			if(screen.exists(image1) != null){
				screen.wait(image1, 10);
				screen.exists(image1);
				Log.info("Verification of "+ Comment +" Image is successfull");
			} else
				Log.info("Error: Verification of "+ Comment +" Image Failed");
		} catch (Exception e) {
			Log.info("Error: Verification of "+ Comment +" Image Failed");
			e.printStackTrace();
			throw e;
			// TODO: handle exception
		}
	}*/

	public boolean waitForWindow(String title){
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(70, TimeUnit.SECONDS) //How long should WebDriver wait for new window
				.pollingEvery(5, TimeUnit.SECONDS)  //How often should it check if a searched window is present
				.ignoring(NoSuchWindowException.class);

		wait.until(new Open_PopUp(title)); //Here 'title' is an actual title of the window, we are trying to find and switch to.
		return true;
	}

	private class Open_PopUp implements ExpectedCondition<String> {
		private String windowTitle;

		public Open_PopUp(String windowTitle){
			this.windowTitle = windowTitle;
		}
		public String apply(WebDriver driver) {

			for(String windowHandle: driver.getWindowHandles()){
				driver.switchTo().window(windowHandle);
				if (driver.getTitle().equalsIgnoreCase(windowTitle))
					return driver.getWindowHandle();
			}

			return null;
		}
	}

	public static WebDriver getIEDriver() {
		DesiredCapabilities capabilities = DesiredCapabilities
				.internetExplorer();
		capabilities
		.setCapability(
				InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
				true);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability("ignoreProtectedModeSettings", true);
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "/resource/drivers/IEDriverServer.exe");
		driver = new InternetExplorerDriver(capabilities);
		//driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeoutSeconds, TimeUnit.SECONDS);
		Capabilities actualCapabilities = ((RemoteWebDriver) driver)
				.getCapabilities();
		BROWSER_NAME = actualCapabilities.getBrowserName().toUpperCase();
		BROWSER_VERSION = actualCapabilities.getVersion();
		PLATFORM = actualCapabilities.getPlatform().toString()
				.toUpperCase();

		return driver;
	}

	//openURL
	public void openURL(String URL) throws Exception 
	{
		try {
			driver.get(URL);
		} catch (Exception e) {
			throw e;
		}
		
	}

	protected static WebDriver getFFDriver() {

		FirefoxProfile firefoxProfile = new FirefoxProfile();
		// Disable auto update
		firefoxProfile.setPreference("app.update.enabled", false); 
		// Disable the default browser check certificate
		firefoxProfile.setPreference("browser.shell.checkDefaultBrowser", false); 
		firefoxProfile.setAcceptUntrustedCertificates(true); // Accept certificates
		firefoxProfile.setPreference("browser.tabs.autoHide", true); // Hide tabs
		firefoxProfile.setPreference("browser.tabs.warnOnClose", false); // Disable warning on tab open
		firefoxProfile.setPreference("browser.tabs.warnOnOpen", false); // Disable warning on tab close

		firefoxProfile.setPreference("browser.rights.3.shown", true); // Disable know your right options

		driver = new FirefoxDriver(firefoxProfile);
		driver.manage().window().maximize();
		//	driver.get(URL);		
		driver.manage().timeouts()
		.implicitlyWait(timeoutSeconds, TimeUnit.SECONDS);

		return driver;
	}

	protected static WebDriver getChromeDriver() {
		System.setProperty("webdriver.chrome.driver",
		System.getProperty("user.dir")+ "/resource/drivers/chromedriver.exe");
		//System.getProperty("user.dir")+ "/resource/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(timeoutSeconds, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//driver.get(URL);		

		return driver;
	}

	public static WebDriverWait getWait() {
		if (wait == null) {
			wait = new WebDriverWait(driver, timeoutSeconds);
		}
		return wait;
	}

	public static void setWait(int timeoutSecs) {
		timeoutSeconds = timeoutSecs;
		wait = new WebDriverWait(driver, timeoutSeconds);
	}

	public static void setImplicitWait(int timeoutSeconds) {
		if (driver != null)
			driver.manage().timeouts()
			.implicitlyWait(timeoutSeconds, TimeUnit.SECONDS);
	}

	public static void closeDriver() throws Exception {
		try {
			if (driver != null)
				driver.quit();

			driver = null;
			wait = null;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}


	public void closeWindow() throws Exception{
		try {
			driver.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void launchBrowser(String browser) throws Exception
	{
	//	DOMConfigurator.configure(logs);
	
		try{
			if (browser.equalsIgnoreCase("firefox"))
			{
				getFFDriver();
			
				/*Log.info("Exceuting on FireFox");
				System.out.println(" Executing on FireFox");
				driver = new FirefoxDriver();
				driver.get(URL);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();*/
			}
			else if (browser.equalsIgnoreCase("chrome"))
			{
				getChromeDriver();
			
				/*Log.info("Executing on Chrome");
				System.out.println(" Executing on CHROME");
				System.out.println("Executing on IE");
				System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.get(URL);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();*/
			}
			else if (browser.equalsIgnoreCase("ie"))
			{
				getIEDriver();
		
				/*Log.info("Executing on Internet Explorer");
				System.out.println("Executing on IE");
				System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				driver.get(URL);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();*/
			}
			else
			{
				throw new IllegalArgumentException("The Browser Type is Undefined");
			} }
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
		//read table data
	public String[][] readExcelData(String xlFilePath, String sheetName,String tableName1, String tableend1) throws Exception {
		String[][] tabArray1 = null;
		try{

			Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
			Sheet sheet = workbook.getSheet(sheetName);
			int startRow, startCol, endRow, endCol, ci, cj;
			Cell tableStart1 = sheet.findCell(tableName1);
			startRow = tableStart1.getRow();
			startCol = tableStart1.getColumn();

			Cell tableEnd = sheet.findCell(tableend1);
			endRow = tableEnd.getRow();
			endCol = tableEnd.getColumn();
			System.out.println("startRow=" + startRow + ", endRow=" + endRow + ", "
					+ "startCol=" + startCol + ", endCol=" + endCol);
			tabArray1 = new String[endRow - startRow - 1][endCol - startCol - 1];
			ci = 0;


			for (int i = startRow + 1; i < endRow; i++, ci++) {
				cj = 0;
				for (int j = startCol + 1; j < endCol; j++, cj++) {
					tabArray1[ci][cj] = sheet.getCell(j, i).getContents();
				}
			}

		} catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return (tabArray1);
	}


	//read table data
	public String[][] readExcelData12(String xlFilePath, String sheetName) throws Exception {
		String[][] tabArray1 = null;

		Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
		Sheet sheet = workbook.getSheet(sheetName);
		int rows = sheet.getRows();
		System.out.println(rows);
		int cols =sheet.getColumns();
		int ci =0;
		for(int row=0; row<sheet.getRows(); row++)
		{
			System.out.println(row);
			int cj=0;
			for(int col=0;col<sheet.getColumns();col++){
				tabArray1[ci][cj] = sheet.getCell(col, row).getContents();	
			}
			System.out.print(sheet.getCell(0,0).getContents());
			System.out.print(":::");
			System.out.println(sheet.getCell(1,1).getContents());
		}
		return tabArray1;
	}

	public void verifyLableByXpath(String strXpathActualValue, String ExpectedValue) throws Exception
	{
		strXpathActualValue =strXpathActualValue.trim();
		ExpectedValue = ExpectedValue.trim();
		try 
		{
			if (waitForElementPresentByXpath(strXpathActualValue))
			{
				String actualLableValue= driver.findElement(By.xpath(strXpathActualValue)).getText();
				String expectedLableValue = ExpectedValue;
				if(actualLableValue.equalsIgnoreCase(expectedLableValue))
				{
					Log.info("Presence of Lable verified on the webpage : " +actualLableValue );
				}
				else
				{
					Log.fail("Error in verifying label : " +actualLableValue+ " is not present on Webpage"  );
				}
			}
		} 
		catch (Exception e) 
		{
			throw e;

		}
	}

	//clickIdentifierLinkText
	public void clickIdentifierLinkText(String strHTMLID) throws Exception
	{
		strHTMLID = strHTMLID.trim();
		try
		{
			if (waitForElementPresentByLinkText(strHTMLID))
			{
				WebElement e1 = driver.findElement(By.linkText(strHTMLID));
				Actions builder1 = new Actions(driver);
				builder1.moveToElement(e1).click(e1);
				builder1.perform();
				Thread.sleep(1000);
			}
			else
			{
				Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
				failTestcase("Could not click on " + strHTMLID + " because it was not found.");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw e;
		}
	}


	//clickIdentifierLinkText
	public static void clickIdentifierPartialLinkText(String strHTMLID) throws Exception
	{
		strHTMLID = strHTMLID.trim();
		try
		{
			if (waitForElementPresentByPartialLinkText(strHTMLID))
			{
				WebElement e1 = driver.findElement(By.partialLinkText(strHTMLID));
				Actions builder1 = new Actions(driver);
				builder1.moveToElement(e1).click(e1);
				builder1.perform();
				Thread.sleep(1000);
			}
			else
			{
				Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
				failTestcase("Could not click on " + strHTMLID + " because it was not found.");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw e;
		}
	}

	public void clickIdentifierCssSelector(String strHTMLID) throws Exception
	{
		strHTMLID = strHTMLID.trim();
		try
		{
			if (waitForElementPresentByCssSelector(strHTMLID))
			{
				WebElement e1 = driver.findElement(By.cssSelector(strHTMLID));
				Actions builder1 = new Actions(driver);
				builder1.moveToElement(e1).click(e1);
				builder1.perform();
				Thread.sleep(1000);
			}
			else
			{
				Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
				failTestcase("Could not click on " + strHTMLID + " because it was not found.");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw e;
		}
	}

	public static void uploadFile(String filePath) throws Exception 
	{
		try
		{
			//		filePath = appPath() + filePath; 
			System.out.println("--------------------------" +filePath);
			StringSelection stringSelection = new StringSelection(filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	//clickIdentifier xpath
	public static void clickIdentifierXpath(String strHTMLID) throws Exception
	{
		strHTMLID = strHTMLID.trim();
		try
		{
			if (waitForElementPresentByXpath(strHTMLID))
			{
				WebElement e1 = driver.findElement(By.xpath(strHTMLID));
				Actions builder1 = new Actions(driver);
				builder1.moveToElement(e1).click(e1);
				builder1.perform();
				Thread.sleep(1000);
			}
			else
			{
				Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
				failTestcase("Could not click on " + strHTMLID + " because it was not found.");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw e;
		}
	}

	

	
	/*public String getElementTextById(String strHTMLID) throws Exception
	{
		try 
		{
			if(waitForElementPresentByID(strHTMLID))
			{
				
				
			}
		
			
			
			
		} catch (Exception e) 
		
		{
		
		
		}
	}
*/

	//clickIdentifierLinkText
	public static void clickIdentifierByID(String strHTMLID) throws Exception
	{
		strHTMLID = strHTMLID.trim();
		try
		{
			if (waitForElementPresentByID(strHTMLID))
			{
				WebElement e1 = driver.findElement(By.id(strHTMLID));
				Actions builder1 = new Actions(driver);
				builder1.moveToElement(e1).click(e1);
				builder1.perform();
				Thread.sleep(1000);
			}
			else
			{
				Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
				failTestcase("Could not click on " + strHTMLID + " because it was not found.");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw e;
		}
	}

	//wait for element to visible
	public static boolean waitForElementPresentByID(String element) throws Exception
	{
		WebElement strElement = null;
		try
		{
			strElement= new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
			if(strElement.isDisplayed() == false)
			{
				failTestcase("Waited for the TIMEOUT period but element " + strElement + " not found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return strElement.isDisplayed();
	}
	
	public static boolean waitForElementPresentByName(String element) throws Exception
	{
		WebElement strElement = null;
		try
		{
			strElement= new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.name(element)));
			if(strElement.isDisplayed() == false)
			{
				failTestcase("Waited for the TIMEOUT period but element " + strElement + " not found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return strElement.isDisplayed();
	}

	//waitForElementPresentByxpath
	public static boolean waitForElementPresentByXpath(String element) throws Exception
	{
		WebElement strElement = null;
		try
		{
			strElement= new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
			if(strElement.isDisplayed() == false)
			{
				failTestcase("Waited for the TIMEOUT period but element " + strElement + " not found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return strElement.isDisplayed();
	}


	public boolean waitForElementPresentByCssSelector(String element) throws Exception
	{
		WebElement strElement = null;
		try
		{
			strElement= new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));
			if(strElement.isDisplayed() == false)
			{
				failTestcase("Waited for the TIMEOUT period but element " + strElement + " not found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return strElement.isDisplayed();
	}


	//waitForElementPresentByLinkText
	public static boolean waitForElementPresentByLinkText(String element) throws Exception
	{
		WebElement strElement = null;
		try
		{
			strElement= new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.linkText(element)));
			if(strElement.isDisplayed() == false)
			{
				failTestcase("Waited for the TIMEOUT period but element " + strElement + " not found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return strElement.isDisplayed();
	}


	//waitForElementPresentByPartialLinkText
	public static boolean waitForElementPresentByPartialLinkText(String element) throws Exception
	{
		WebElement strElement = null;
		try
		{
			strElement= new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(element)));
			if(strElement.isDisplayed() == false)
			{
				failTestcase("Waited for the TIMEOUT period but element " + strElement + " not found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return strElement.isDisplayed();
	}


	public static List<String> getAllDropDownOptions(By by) {
		List<String> options = new ArrayList<String>();
		for (WebElement option : new Select(driver.findElement(by)).getOptions()) {
			String txt = option.getText();
			Log.info("Languages available in dropDown : "  +txt);
			if (option.getAttribute("value") != "") options.add(option.getText());
		}
		return options;
	}




	/*	Name  - readPropertyFile*/
	public static Properties readPropertyFile(String pFileName) 
	{   
		FileInputStream fileSource = null;
		Properties propertyLoad = null;
		try 
		{
			pFileName = appPath() + pFileName; 
			//	System.out.println("Äbsolute path of WorkSpace---"+appPath());
			//	System.out.println("Absolute path of file---"+pFileName);
			propertyLoad = new Properties();
			propertyLoad.load(new FileInputStream(pFileName));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(fileSource!=null)
			{
				try 
				{
					fileSource.close();
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}	
		}
		return propertyLoad;	
	}

	//appPath
	public static String appPath() 
	{
		String strAppPath = null;
		try
		{
			java.io.File currentDir = new java.io.File("");
			strAppPath = currentDir.getAbsolutePath();
		}
		catch (Exception e)
		{
			strAppPath = "-1";
			e.printStackTrace();
		}
		return strAppPath;
	}

	public void mouseHoverAndClick(String mouseHover, String strElement) throws Exception
	{
		mouseHover = mouseHover.trim();
		strElement = strElement.trim();
		try
		{
			Actions builder = new Actions(driver);
			//	builder.moveToElement(driver.findElement(By.xpath(mouseHover))).moveToElement(driver.findElement(By.xpath(strElement))).click().perform();
			builder.moveToElement(driver.findElement(By.xpath(mouseHover))).perform();
			//		Thread.sleep(5000);
			builder.moveToElement(driver.findElement(By.xpath(strElement))).click().perform();
		}
		catch (Exception e) 
		{
			Reporter.log("Could not click on " + strElement + " because it was not found.");
			e.printStackTrace();
			throw e;
		}
	}



	public static void typeTextById(String strHTMLID, String strString) throws Exception
	{
		strHTMLID = strHTMLID.trim();
		strString = strString.trim();
		try 
		{
			if (waitForElementPresentByID(strHTMLID))
			{
				driver.findElement(By.id(strHTMLID)).clear();
				driver.findElement(By.id(strHTMLID)).sendKeys(strString);
			}
			else
			{
				Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
				failTestcase("Could not click on " + strHTMLID + " because it was not found.");
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	public static void typeTextByiframe(String strHTMLID, String strString) throws Exception
	{
		strHTMLID = strHTMLID.trim();
		strString = strString.trim();
		try 
		{
			
			if (waitForElementPresentByXpath("//iframe[@title='" + strHTMLID + "']"))
			{
				WebElement frame = driver.findElement(By.xpath("//iframe[@title='" + strHTMLID + "']"));
				driver.switchTo().frame(frame);
				WebElement body = driver.findElement(By.tagName("body"));
				body.clear();
				body.sendKeys(strString);
				
				driver.switchTo().defaultContent();
			}
			else
			{
				Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
				failTestcase("Could not click on " + strHTMLID + " because it was not found.");
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	
	public static void typeTextByName(String strHTMLID, String strString) throws Exception
	{
		strHTMLID = strHTMLID.trim();
		strString = strString.trim();
		try 
		{
			if (waitForElementPresentByName(strHTMLID))
			{
				driver.findElement(By.name(strHTMLID)).clear();
				driver.findElement(By.name(strHTMLID)).sendKeys(strString);
			}
			else
			{
				Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
				failTestcase("Could not click on " + strHTMLID + " because it was not found.");
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	public static void typeTextByXpath(String strHTMLID, String strString) throws Exception
	{
		strHTMLID = strHTMLID.trim();
		strString = strString.trim();
		try 
		{
			if (waitForElementPresentByXpath(strHTMLID))
			{
				driver.findElement(By.xpath(strHTMLID)).clear();
				driver.findElement(By.xpath(strHTMLID)).sendKeys(strString);
			}
			else
			{
				Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
				failTestcase("Could not click on " + strHTMLID + " because it was not found.");
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	
	public static void getWaitForElementPresent(String elementXpath,int time)
    {      
           WebDriverWait wt = new WebDriverWait(driver,time);
           wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
    }

/*************Module Manger**************/
public String getTextValueByXpath(String element,String strHTMLID)
    {
           String strValue = null;
           try
           {
                  if (waitForElementPresentByXpath(element,strHTMLID))
                  {
                        strValue = driver.findElement(By.xpath(strHTMLID)).getText();
                        strValue=strValue.trim();
                  }
                  else
                  {
                        Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
                        failTestcase("Could not click on " + strHTMLID + " because it was not found.");
                  }
           }
           catch(Exception e)
           {
                  e.printStackTrace();
           }
           return strValue;

    }

public static boolean waitForElementPresentByXpath(String element, String xpath1) throws Exception
{
       WebElement strElement = null;

       strElement= new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath1)));
       Log.info(strElement +  " is present");
       highLightElement(driver, strElement);
       Assert.assertTrue(strElement.isDisplayed(),element + "is not prsenet");
       return strElement.isDisplayed();
}


public  static void getDroupDown(WebElement element,String value)
    {
           Select select=new Select(element);
           //select.deselectAll();
           select.selectByVisibleText(value);
    }


	
	
	
	// Method created selectDropdownValue Index
		public static void selectDropdownValueByIndex(String strHTMLID, int strValue)
				throws Exception {
			strHTMLID = strHTMLID.trim();
			// strValue = strValue.trim();
			try {
				if (waitForElementPresentByID(strHTMLID)) {
					Select drpdown = new Select(
							driver.findElement(By.id(strHTMLID)));
					drpdown.selectByIndex(strValue);
				} else {
					Reporter.log("Could not click on " + strHTMLID
							+ " because it was not found.");
					failTestcase("Could not click on " + strHTMLID
							+ " because it was not found.");
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}

	//selectDropdownValue
	public static void selectDropdownValueVisibleText(String strHTMLID, String strValue) throws Exception
	{
		strHTMLID = strHTMLID.trim();
		strValue = strValue.trim();
		try
		{
			if (waitForElementPresentByID(strHTMLID))
			{
				Select drpdown = new Select(driver.findElement (By.id(strHTMLID)));
				drpdown.selectByVisibleText(strValue);
			}
			else
			{
				Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
				failTestcase("Could not click on " + strHTMLID + " because it was not found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	public static void selectDropdownValueNameVisibleText(String strHTMLID, String strValue) throws Exception
	{
		strHTMLID = strHTMLID.trim();
		strValue = strValue.trim();
		try
		{
			if (waitForElementPresentByName(strHTMLID))
			{
				Select drpdown = new Select(driver.findElement (By.name(strHTMLID)));
				drpdown.selectByVisibleText(strValue);
			}
			else
			{
				Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
				failTestcase("Could not click on " + strHTMLID + " because it was not found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	public static void selectDropdownValueXpathVisibleText(String strHTMLID, String strValue) throws Exception
	{
		strHTMLID = strHTMLID.trim();
		strValue = strValue.trim();
		try
		{
			if (waitForElementPresentByXpath(strHTMLID))
			{
				Select drpdown = new Select(driver.findElement (By.xpath(strHTMLID)));
				drpdown.selectByVisibleText(strValue);
			}
			else
			{
				Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
				failTestcase("Could not click on " + strHTMLID + " because it was not found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	//failTestcase
	public static void failTestcase(String e)
	{
		Reporter.log(" Failed because " + e);
		//	Assert.fail("--------- FAILED ----------");
	}


	//assert2Strings
	public void assert2Strings(String strString1, String strString2)
	{
		Assert.assertEquals(strString1,strString2);        	
	}

	//assert title bar
	public void assertTitleBar(String strString1, String strString2)
	{
		Assert.assertEquals(strString1,strString2);        	
	}


	//getValuebyid changed to static
	public static String getValueByID(String strHTMLID)
	{
		String strValue = null;
		try
		{
			if (waitForElementPresentByID(strHTMLID))
			{
				strValue = driver.findElement(By.id(strHTMLID)).getAttribute("value");
			}
			else
			{
				Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
				failTestcase("Could not click on " + strHTMLID + " because it was not found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return strValue;

	}
	//getValuebyid
	public static String getValueByXpath(String strHTMLID)
	{
		String strValue = null;
		try
		{
			if (waitForElementPresentByXpath(strHTMLID))
			{
				strValue = driver.findElement(By.xpath(strHTMLID)).getText();
				System.out.println(strValue);
			}
			else
			{
				Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
				failTestcase("Could not click on " + strHTMLID + " because it was not found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return strValue;

	}

	//getTitlebar
	public static String getTitleBar()
	{
		String strValue = null;
		try
		{
			strValue = driver.getTitle();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return strValue;

	}
	
	
	public static String getCurrentURL()
	{
		String strValue = null;
		try
		{
			strValue = driver.getCurrentUrl();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return strValue;

	}

	public void switchToFrame(String frameName)
	{
		try
		{
			driver.switchTo().frame(frameName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	public void switchToParentWindow(String frameName) throws Exception
	{
		try
		{
			driver.switchTo().window(frameName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}

	}

	public static boolean isElementPresent(By by, String elementName) {
		try {
			driver.findElement(by);
			System.out.println(elementName + ": Present");
			return true;

		} catch (NoSuchElementException e) {
			System.out.println(elementName + ": Not-Present");
			return false;
		}
	}

	static public boolean isElementPresent(By by) {
		try {
			WebElement	strElement= new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(by));
			//		driver.findElement(by);
			if(strElement.isDisplayed())	return true;
		} catch (NoSuchElementException e) {
			return false;
		}
		return false;
	}



	public void waitForModalBoxToDisappear() throws Exception
	{
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@id,'messageModal')]")));
			System.out.println("here-11111111111111111111111111111111");
		} 
		catch (Exception e) 
		{
			System.out.println("catch catch catch ------------------------------");
			// TODO: handle exception
		}
	}
	
	
	public static void checkCheckBox(String xpath) throws Exception{
		WebElement checkbox = driver.findElement(By.xpath(xpath));
		if(!checkbox.isSelected()){
			clickIdentifierXpath(xpath);
		}
	}

	public static void uncheckCheckBox(String xpath) throws Exception{
		WebElement checkbox = driver.findElement(By.xpath(xpath));
		if(checkbox.isSelected()){
			clickIdentifierXpath(xpath);
		}
	}

	//public static void typeTextTinyMceEditor()

	public void typeTextTinyMceEditor(String frameName, String strHTMLID, String strString) throws Exception
	{
		strHTMLID = strHTMLID.trim();
		strString = strString.trim();
		try 
		{
			driver.switchTo().defaultContent();
			WebElement frame = driver.findElement(By.xpath(frameName));
			driver.switchTo().frame(frame);
			driver.findElement(By.id(strHTMLID)).clear();
			driver.findElement(By.id(strHTMLID)).sendKeys(strString);
			driver.switchTo().defaultContent();
		} 
		catch (Exception e)
		{
			Reporter.log("Could not click on " + strHTMLID + " because it was not found.");
			failTestcase("Could not click on " + strHTMLID + " because it was not found.");
			e.printStackTrace();
			throw e;
		}
	}
	/*	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}*/

	public void refreshWebPage()
	{
		try
		{
			driver.navigate().refresh();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	//wait for element to visible
	public boolean waitForElementToVisible(String element) throws Exception
	{
		WebElement strElement = null;
		try
		{
			strElement= new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
			if(strElement.isDisplayed() == false)
			{
				failTestcase("Waited for the TIMEOUT period but element " + strElement + " not found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			strElement= new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.name(element)));
			if(strElement.isDisplayed() == false)
			{
				failTestcase("Waited for the TIMEOUT period but element " + strElement + " not found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			strElement= new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.linkText(element)));
			if(strElement.isDisplayed() == false)
			{
				failTestcase("Waited for the TIMEOUT period but element " + strElement + " not found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return strElement.isDisplayed();
	}
	
	//Call this method when you want to highlight Element
	public static void highLightElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver; 

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) {

			System.out.println(e.getMessage());
		} 

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white')", element); 

	}

	//capture screenshots
	public static void CaptureScreenshot(String fileNameStart) throws Exception{
		String path = null;
		try {
			System.out.println("Capturing Snapshot");
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Calendar currentDate = Calendar.getInstance();
			java.io.File currentDir = new java.io.File("");		        
			String workingDirectory = System.getProperty("user.dir");
			//get today's date without Time stamp
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date today = dateFormat.parse(dateFormat.format(new Date()));
			String todaysDate = dateFormat.format(today).replace("/", "_");

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
			//Get Full Class name 
			String fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
			//Get Method name 
			String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
			//Get Class short name 
			int firstChar = fullClassName.lastIndexOf('.') +1; 
			String className = fullClassName.substring(firstChar);
			String dateN = formatter.format(currentDate.getTime()).replace("/","_");
			String dateNow = dateN.replace(":","_");
			//			System.out.println("printing datenow---------"+dateNow);
			String strAppPath = currentDir.getAbsolutePath()+ "/testresult/screenshots"+"_"+methodName+"_"+todaysDate;
			//	String strAppPath = currentDir.getAbsolutePath();

			String fileName = fileNameStart+"."+className+"."+methodName+"."+dateNow+".jpeg"; 
			//			String fileName = dateNow+".png"; 
			String snapShotDirectory = strAppPath;
			//			System.out.println("Im here-------------"+snapShotDirectory);
			File f = new File(snapShotDirectory);
			//check for snapshot having folder with today date if not then create one
			if(f.exists()){
				System.out.println("SnapshotDirectory Already Exists");
			}
			else{
				f.mkdir();
			}		        
			path = f.getAbsolutePath() + "/" + fileName ;
			//			System.out.println("Path------------------"+path);
			FileUtils.copyFile(source, new File(path));
			//			Reporter.log("<img src=\"file:///" + path + "\" alt=\"testPic\" " + "height=\"600\" width=\"600\"" + " /><br />"); //working
			//		Reporter.log("<a href=" +path+ "/a>");
			//			Reporter.log("<img src=\"file:///" + path + "\" alt=\"\"/><br />"); // printing in report
			//		Reporter.log("<a href='" + path+ "'>heloo</a>");
			//	Reporter.log("<a href='" + f.getAbsolutePath() + "'>click to open screenshot</a>");  //Working
			//Reporter.log("<a href='" + path + "'><p align=\"left\">Error screenshot at " + new Date()+ "</p>"); //working
			//Reporter.log("<p><img width=\"1024\" src=\"" + path + "\" alt=\"screenshot at " + new Date()+ "\"/></p></a><br />"); //working

			//	Reporter.log("Path of the Snapshot : " + path);
			/*//		Reporter.log("<a href='" + screenshotFile.getAbsolutePath() + "'>screenshot</a>")
			Reporter.log("<a href='" + path + "' >  path  </a>");
			Reporter.log("<a href=" + path + "> </a>"); 
			Reporter.log("<a href='"+path+".png'> </a>");*/

		}
		catch(IOException e) {
			path = "Failed to capture screenshot: " + e.getMessage();
			throw e;
		}
	}

}
