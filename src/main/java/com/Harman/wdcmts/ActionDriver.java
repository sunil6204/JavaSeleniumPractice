package com.Harman.wdcmts;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Harman.config.StartBrowser;
import com.aventstack.extentreports.MediaEntityBuilder;

public class ActionDriver {
public WebDriver driver;
	public ActionDriver() {
		driver = StartBrowser.driver;
		}
	/**
	 * validatation to navigate the URL whether successful or failure and 
	 * @param Url - pass the application url
	 */
	public void navigateToApplication(String Url) {
		try {
			driver.get(Url);
			StartBrowser.childTest.pass("successfully navigate to URL : "+Url);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to navigate to URL : "+Url);
		}
	}
	/**
	 * This is user for performing a Click action on the application
	 * @param locator -- Get it from Obj Repository
	 * @param eleName -- Name of the element 
	 * @throws Exception 
	 */
	public void click(By locator, String eleName) throws Exception {
		try {
			driver.findElement(locator).click();
			StartBrowser.childTest.pass("successfully clicked on: "+eleName);
			
		} catch (Exception e) {
			StartBrowser.childTest.fail("Failed to click on: "+eleName, 
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw new Exception();
		}
	}
	/**
	 * User has to enter the text inside the text box
	 * @param locator -- Get it from Obj Repository
	 * @param testdata -- Predefined data for the element
	 * @param eleName -- Name of the element
	 * @throws Exception
	 */
		public void type(By locator, String testdata, String eleName) throws Exception {
			try {
				driver.findElement(locator).sendKeys(testdata);
				StartBrowser.childTest.pass("Entered text successfully: "+eleName +" With the test data: "+testdata,
						MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			} catch (Exception e) {
				StartBrowser.childTest.fail("Failed to enter text: "+eleName +" With the test data: "+testdata,
						MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
				StartBrowser.childTest.info(e);
				throw new Exception();
			}
	}
		public String screenShot()
		{
			return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		}
		
		/**
		 * User mouseHover on the elements
		 * @param locator -- Get it from Obj Repository
		 * @param eleName -- Name of the element
		 * @throws Exception
		 */
		public void mousehover(By locator, String eleName) throws Exception {
			
			try {
				WebElement we=driver.findElement(locator);
				Actions a = new Actions(driver);
				a.moveToElement(we).perform();
				StartBrowser.childTest.pass("Successfully mouseHover: "+eleName,
						MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
				
			} catch (Exception e) {
				StartBrowser.childTest.fail("Failed to mouseHover: "+eleName,
						MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
				StartBrowser.childTest.info(e);
				throw new Exception();
			}
		}
		public String getUrl()
		{
			return driver.getCurrentUrl();
		}
			
		}

