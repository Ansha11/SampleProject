package com.SampleProject.scrp;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Test;

import com.SampleProject.Base.TestBase;
import com.SampleProject.Constants.Messages;
import com.SampleProject.Pages.RegisterPage;
import com.SampleProject.Utilities.ExcelUtilities;

public class RegisterTest extends TestBase{
	RegisterPage objReg;
	  @Test
	  public void setFirstAndLastname() throws IOException {
		  objReg=new RegisterPage(driver);

		  objReg.clickRegister();
		 String fname=ExcelUtilities.getCellStringData(0, 0,Messages.Sheet2);
		 String lname=ExcelUtilities.getCellStringData(0, 1,Messages.Sheet2);
		 String address=ExcelUtilities.getCellStringData(1, 0, Messages.Sheet2);
		 objReg.setfirstname(fname);
		 objReg.setlastname(lname);
		 objReg.setAddress(address);
	  }
}
