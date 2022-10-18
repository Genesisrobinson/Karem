package com.grid.testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.*; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumStandaloneServerTest {	
	
	
	private WebDriver driver;
	LogManager lgmngr = LogManager.getLogManager(); 
	Logger log = lgmngr.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	
	
	@Test(priority=1)	
    public void applicationLaunch() throws MalformedURLException, InterruptedException { 		 
	
	     log.log(Level.INFO, "Test Has been started"); 
		 ChromeOptions chromeOptions = new ChromeOptions();
		 chromeOptions.addArguments("--start-maximized");
		 chromeOptions.addArguments("--ignore-certificate-errors");
		 chromeOptions.addArguments("--disable-popup-blocking");
		 chromeOptions.addArguments("--headless");
		 //chromeOptions.setCapability("browserVersion", "100");
		 chromeOptions.setCapability("platformName", "Windows");
		 // Showing a test name instead of the session id in the Grid UI
		 chromeOptions.setCapability("se:name", "My simple test"); 	 
		 chromeOptions.setCapability("se:sampleMetadata", "Sample metadata value");	 
		 driver = new RemoteWebDriver(new URL("http://localhos:4444/"), chromeOptions);
		 driver.get("https://demo.guru99.com/v4/index.php");  
		 log.log(Level.INFO, "Application is Launched");
		 Thread.sleep(3000);
	  
	 }
	
	 @Test (priority=2)	
	    public void depositAmount() throws InterruptedException
	    { 
	    	
	    	log.log(Level.INFO, "Navigated to Deposit Page");  	  
	  	   
	  	   // to enter valid username
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mngr446059");
	
			// to enter correct password
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("ajemeje");
	
			// to validate the login button
			driver.findElement(By.xpath("//input[@type='submit']")).click();
	
			// open new account tab
			driver.findElement(By.xpath("//a[@href='addAccount.php']")).click();
	
			// validate the customer id
			driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("38814");
			Thread.sleep(1000);
	
			// webelement of account type dropdown
			driver.findElement(By.name("selaccount")).click();
			Select selaccount =new Select( driver.findElement(By.xpath("//select[@name='selaccount']")));
			selaccount.selectByVisibleText("Current");
			Thread.sleep(1000);
	
			// validate the initial deposit tab
			driver.findElement(By.name("inideposit")).sendKeys("10000");
			Thread.sleep(1000);
	
			//validate submit button
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(1000);		
			
			log.log(Level.INFO, "Amount is deposited successfuly");			
		}

	    @Test (priority=3)	
		public void logout() {
	    	
			driver.quit();
			log.log(Level.INFO, "Test Executing Completed");
	
	}    
	 
	 
}
