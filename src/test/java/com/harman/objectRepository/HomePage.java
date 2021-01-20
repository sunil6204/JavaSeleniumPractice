package com.harman.objectRepository;

import org.openqa.selenium.By;

public class HomePage {
	
	public static By lnkMyAccount = By.xpath("//span[text()='My Account']");
	public static By lnkLogin = By.xpath("//a[@href='https://www.smartshoppers.in/index.php?route=account/login']");
	public static By txtEmailadress = By.xpath("//input[@id='input-email']");
	public static By txtPassword = By.xpath("//input[@id='input-password']");
	public static By btnLogin = By.xpath("//input[@value='Login']");
	public static By lnkLogout = By.xpath("//a[@href='https://www.smartshoppers.in/index.php?route=account/logout']");
	//13th Jan 2021
	public static By lnkCameras = By.xpath("//span[text()='CAMERAS']");
	public static By lnkPoint = By.xpath("//span [text()='POINT AND SHOOT']");
	public static By lnkDSLR =  By.xpath("//font[@face='Helvetica']");
}
