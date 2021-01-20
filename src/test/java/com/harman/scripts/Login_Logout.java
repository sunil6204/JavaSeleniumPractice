package com.harman.scripts;

import org.testng.annotations.Test;

import com.Harman.config.StartBrowser;
import com.Harman.wdcmts.ActionDriver;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.harman.reuse.CommonFunctions;

public class Login_Logout extends StartBrowser{
  @Test
  public void Login_LogoutSmartShoppers() throws Exception {
	  CommonFunctions cfs = new CommonFunctions();
	  ActionDriver ad = new ActionDriver();
	  cfs.login();
	  if(ad.getUrl().equals("https://www.smartshoppers.in/index.php?route=account/account"))
	  {
		  StartBrowser.childTest.pass("Login successful",
				  MediaEntityBuilder.createScreenCaptureFromBase64String(ad.screenShot()).build());
	  }
	  else
	  {
		  StartBrowser.childTest.fail("Login unsuccessful", 
				  MediaEntityBuilder.createScreenCaptureFromBase64String(ad.screenShot()).build());
		  throw new Exception();
	  }
	cfs.logout();
  }
  
 }

