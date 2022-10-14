package com.grid.testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumStandaloneServerTest {	
	 @Test
	 private void Tests1() throws MalformedURLException, InterruptedException {
	 ChromeOptions chromeOptions = new ChromeOptions();
	 chromeOptions.addArguments("--start-maximized");
	 chromeOptions.addArguments("--ignore-certificate-errors");
	 chromeOptions.addArguments("--disable-popup-blocking");
	 //chromeOptions.setCapability("browserVersion", "100");
	 chromeOptions.setCapability("platformName", "Windows");
	 // Showing a test name instead of the session id in the Grid UI
	 chromeOptions.setCapability("se:name", "My simple test"); 
	 // Other type of metadata can be seen in the Grid UI by clicking on the 
	 // session info or via GraphQL
	 chromeOptions.setCapability("se:sampleMetadata", "Sample metadata value"); 
	 WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/"), chromeOptions);
	 driver.get("http://www.google.com");
	  // identify element
	      WebElement p=driver.findElement(By.name("q"));
	      //enter text with sendKeys() then apply submit()
	      p.sendKeys("Selenium Java");
	      // Explicit wait condition for search results
	      //WebDriverWait w = new WebDriverWait(driver, 5);
	      Thread.sleep(50000);
	      //w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
	      p.submit();

	 driver.quit();
	 }
}
