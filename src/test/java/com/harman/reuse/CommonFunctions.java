package com.harman.reuse;

import org.openqa.selenium.WebDriver;

import com.Harman.config.StartBrowser;
import com.Harman.wdcmts.ActionDriver;
import com.harman.objectRepository.HomePage;

public class CommonFunctions {
	
	public ActionDriver aDriver;
	public WebDriver driver;
	
	public CommonFunctions()
	{
		aDriver = new ActionDriver();
		driver = StartBrowser.driver;
	}

	public void login() throws Exception
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Login to Applciation");
		aDriver.navigateToApplication("https://www.smartshoppers.in/");
		aDriver.mousehover(HomePage.lnkMyAccount, "My Account Link");
		aDriver.click(HomePage.lnkLogin, "Login link");  
		//6thJan2021
		aDriver.type(HomePage.txtEmailadress, "sunil6204@gmail.com", "User Name");
		aDriver.type(HomePage.txtPassword, "Test@123", "Password");
		aDriver.click(HomePage.btnLogin, "Login Button");
		
	}
	public void logout() throws Exception 
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Logout of Applciation");
		aDriver.mousehover(HomePage.lnkMyAccount, "My Account Link");
		aDriver.click(HomePage.lnkLogout, "Logout link from My Account DD");
	}
	
	public void ViewCart() throws Exception
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("View selected cameras in Cart");
		aDriver.mousehover(HomePage.lnkCameras, "Cameras");
		aDriver.click(HomePage.lnkPoint, "Point");
	}
	
	public void SelectCamerasDSLR() throws Exception 
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Select Cameras from DSLR");
		aDriver.mousehover(HomePage.lnkCameras, "Cameras");
		aDriver.click(HomePage.lnkDSLR, "DSLR");
	}
}

