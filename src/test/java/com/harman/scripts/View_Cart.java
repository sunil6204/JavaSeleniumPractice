package com.harman.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Harman.config.StartBrowser;
import com.harman.reuse.CommonFunctions;

public class View_Cart extends StartBrowser{
WebDriver driver;
	  @Test
	  public void View_CartSmartShoppers() throws Exception{
		  CommonFunctions cfs = new CommonFunctions();
		  driver = StartBrowser.driver;
		  cfs.login(); //Login to the "Smartshoppers.in" page
		  //driver.get("https://www.smartshoppers.in/");
		  cfs.ViewCart(); //Mousehover on Cameras & click on "Point AND Shoot"
	
	//Click on "Canon PowerShot G7 X Mark II" Camera from the result page	  
	driver.findElement(By.xpath("//img[@title='Canon PowerShot G7 X Mark II']")).click();
	//Get the text of the Product and store it in a variable
	String ProductName = driver.findElement(By.xpath("//h1[@class='title-product']")).getText();
	//Click on "Add to Cart" button --- Element is not interacting error
	driver.findElement(By.xpath("//button[@class='btn btn-sm btn-primary']")).click();
	//Click on CROSS icon from the confirmation pop-up
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='close']")).click();
	//Click on Cart icon from the top right corner of the page
	//driver.findElement(By.xpath("//i[@class='icon-cart pull-right radius-6x']")).click();
	Actions a = new Actions(driver);
	a.moveToElement(driver.findElement(By.xpath("//i[@class='icon-cart pull-right radius-6x']"))).perform();
	Thread.sleep(2000);
	//Click on "View Cart" button from the Pop-up
	WebElement we1=driver.findElement(By.xpath("//i[@class='icon-cart pull-right radius-6x']"));
	a.moveToElement(we1).perform();
	driver.findElement(By.xpath("//a[@class='btn btn-xs btn-primary btn-outline']")).click();
	//driver.findElement(By.linkText("View Cart")).click();
	//Verify the Product name is same as selected ---------------------------
	
	//Cancel the selected product from the Shopping cart list
	driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
	//Go back to the Previous page ------ This step is failing most of the time
	Thread.sleep(2000);
	driver.navigate().back();
	//Click on "Add to Wish list button" 
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()='Add to Wish List']")).click();	 
	//Click on "My Accounts" from the top of the page
	driver.findElement(By.xpath("//span[@class='icon-down']")).click();
	//Click on "Wish List" from the available list
	driver.findElement(By.xpath("//a[@id='wishlist-total']")).click();
	//Verify the selected product is available in the Wish list -------------------
	
	//Click on Continue button from the Wish list
	driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
	
	
	  }
}