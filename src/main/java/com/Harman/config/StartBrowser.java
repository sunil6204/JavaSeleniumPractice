package com.Harman.config;

import java.lang.reflect.Method;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.Harman.util.ConfiguratorSupport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StartBrowser {
  public static WebDriver driver;
  ConfiguratorSupport cs = new ConfiguratorSupport("config.properties");
  //these variables are related to extent report
  public static ExtentReports extent;
  public static ExtentTest parentTest;
  public static ExtentTest childTest;
  ExtentSparkReporter sparkReporter;

  @BeforeTest
  public void generateReport()
  {
	  LocalTime myObj = LocalTime.now(); // Create a date object
	    System.out.println(myObj);
 
	  sparkReporter = new ExtentSparkReporter("Reports/AutomationReport.html");
	  extent = new ExtentReports();
	  extent.attachReporter(sparkReporter);
  }
  @BeforeMethod
  public void methodName(Method method)
  {
	  parentTest = extent.createTest(method.getName()) ;
  }
  @BeforeClass
  public void beforeClass() {
	  if(cs.getProperty("browser").equalsIgnoreCase("chrome"))
	  {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  }
	  else if (cs.getProperty("browser").equalsIgnoreCase("firefox"))
	  {
		  WebDriverManager.firefoxdriver().setup();
		  driver = new FirefoxDriver();
	  }
	  else
	  {
		  System.out.println("Please provide a valid browser anem");
	  }
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
  }

  @AfterClass
  public void afterClass() {
	  //driver.quit();
	  extent.flush();
  }

}
