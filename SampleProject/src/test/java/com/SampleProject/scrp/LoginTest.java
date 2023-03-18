package com.SampleProject.scrp;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SampleProject.Base.TestBase;
import com.SampleProject.Constants.ExtentLogMessage;
import com.SampleProject.Constants.Messages;
import com.SampleProject.Pages.LoginPage;
import com.SampleProject.Utilities.ExcelUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.SampleProject.Listeners.TestListener;

public class LoginTest extends TestBase {
	LoginPage objLogin;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	
  @Test(priority=1,retryAnalyzer=com.SampleProject.Listeners.RetryAnalyser.class)

  public void verifyLoginInvalidUserInvalidPassword() throws IOException {
	  objLogin=new LoginPage(driver);
	  String username=ExcelUtilities.getCellStringData(0, 0,Messages.Sheet1);
	  String password=ExcelUtilities.getCellStringData(0, 1,Messages.Sheet1);
	  objLogin.setUsername(username);
	  objLogin.setPassword(password);
	  objLogin.clickSubmit();
	  AssertJUnit.assertEquals(objLogin.getHomePageTitle(),Messages.HOMETITLE1);
	 extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_FAILED_MESSAGE);
  }
  
  @Test(priority=2)
  public void verifyLoginValidUserInvalidPassword() throws IOException {
	  objLogin=new LoginPage(driver);
	  String username=ExcelUtilities.getCellStringData(1, 0,Messages.Sheet1);
	  String password=ExcelUtilities.getCellStringData(1, 1,Messages.Sheet1);
	  objLogin.setUsername(username);
	  objLogin.setPassword(password);
	  objLogin.clickSubmit();
	  AssertJUnit.assertEquals(objLogin.getHomePageTitle(),Messages.HOMETITLE1);
  }
  
  @Test(priority=3)
  public void verifyLoginInvalidUserValidPassword() throws IOException {
	  objLogin=new LoginPage(driver);
	  String username=ExcelUtilities.getCellStringData(2, 0,Messages.Sheet1);
	  String password=ExcelUtilities.getCellStringData(2, 1,Messages.Sheet1);
	  objLogin.setUsername(username);
	  objLogin.setPassword(password);
	  objLogin.clickSubmit();
	  AssertJUnit.assertEquals(objLogin.getHomePageTitle(),Messages.HOMETITLE1);
  }
  @Test(priority=4,groups= {"smoke"})
  public void verifyLoginValidUserValidPassword() throws IOException {
	  objLogin=new LoginPage(driver);
	  String username=ExcelUtilities.getCellStringData(3, 0,Messages.Sheet1);
	  String password=ExcelUtilities.getCellStringData(3, 1,Messages.Sheet1);
	  objLogin.setUsername(username);
	  objLogin.setPassword(password);
	  objLogin.clickSubmit();
	  AssertJUnit.assertEquals(objLogin.getHomePageTitle(),Messages.HOMETITLE2);
  }
  
  
}
