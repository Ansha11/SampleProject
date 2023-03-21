package com.SampleProject.DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SampleProject.Utilities.ExcelUtilities;

public class Data {
  @Test
  public void f() {
  }
  @DataProvider
  public Object[][] dp()  {
	  ExcelUtilities.getCellStringData(rowNum,colNum,Sheet);
}
}
