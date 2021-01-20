package com.harman.scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.Harman.config.StartBrowser;
import com.harman.reuse.CommonFunctions;

public class RemoveCamera_WishList extends StartBrowser{
	WebDriver driver;
	
	@Test
	 public void SelectCamerasFromDSLR_SmartShoppers() throws Exception{
		  CommonFunctions cfs = new CommonFunctions();
		  driver = StartBrowser.driver;
		  cfs.login();

}
}
