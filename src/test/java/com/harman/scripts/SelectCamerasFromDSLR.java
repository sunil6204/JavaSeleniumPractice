package com.harman.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.Harman.config.StartBrowser;
import com.harman.reuse.CommonFunctions;

public class SelectCamerasFromDSLR extends StartBrowser{
	WebDriver driver;
	
	@Test
	 public void SelectCamerasFromDSLR_SmartShoppers() throws Exception{
		  CommonFunctions cfs = new CommonFunctions();
		  driver = StartBrowser.driver;
		  cfs.login();
		  cfs.SelectCamerasDSLR();
		  
		  driver.findElement(By.xpath("//img[@title='Canon EOS 750D (Body)']")).click();
		  driver.findElement(By.xpath("//span[text()='Add to Wish List'] ")).click();
		  
}
}