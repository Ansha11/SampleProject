package com.SampleProject.Base;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.SampleProject.Constants.Messages;
import com.SampleProject.Utilities.WaitUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static Properties prop=null;
	public static WebDriver driver;

	
  @Test
public static void testBase() {
	  prop=new Properties();
		 try {
			 FileInputStream ip=new FileInputStream(Messages.CONFIGPATH);
		prop.load(ip);
		 } 
		 catch (Exception e) {
			e.printStackTrace();}
		 
		 
	 /* try
	  {
		prop=new Properties();
		FileInputStream ip=new FileInputStream(Messages.CONFIGPATH);
	

		prop.load(ip);
		
	  }
	  catch(FileNotFoundException e)
	  {
		  e.printStackTrace();
	  }
	  catch(IOException e)
	  {
		  e.printStackTrace();
	  }*/
	  
  }
 @AfterMethod
  public void afterMethod(ITestResult r) throws Exception {  //ITestResult use to pull-then get the details
	  if(ITestResult.SUCCESS==r.getStatus()) { 
		  //checking the status of the @Test is same as ITestResult.SUCCESS or not
		  File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(f, new File("/Users/Sanoob/Desktop/screenshot/"+r.getName()+".jpeg"));

	  }
 }

  @BeforeTest
  @Parameters({"browser"})

  public void beforeTest(String browser1 ) {
	  testBase();
	  if(browser1.equalsIgnoreCase("chrome")) {
	  WebDriverManager.chromedriver().setup();
	  ChromeOptions co=new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
	  driver=new ChromeDriver(co);
	  }
	  
	  else if(browser1.equalsIgnoreCase("edge")) {
		  WebDriverManager.edgedriver().setup();
		  driver=new EdgeDriver();
		
		  }
	  else if(browser1.equalsIgnoreCase("safari")) {
		  driver=new SafariDriver();
		
		  }
	  driver.manage().window().maximize();
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  WaitUtilities.implicitWait(driver);
	  String baseurl=prop.getProperty("url");
	  driver.get(baseurl);
  }
  
  
  
  ////without using crossbrowser testing 
//uses browser from confog.properties
  
  
	 /* public void beforeTest() {
		  testBase();
		  String mybrowser=prop.getProperty("browser");
		if(mybrowser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if (mybrowser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
		}
		String myurl=prop.getProperty("url");
		driver.get(myurl);
	  }
*/
	  
  

  
  @AfterTest
  public void afterTest() {
  }

}
