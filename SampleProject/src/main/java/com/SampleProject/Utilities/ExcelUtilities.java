package com.SampleProject.Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.SampleProject.Constants.Messages;

public class ExcelUtilities {
	public static FileInputStream f;
	public static XSSFWorkbook w;
	public static XSSFSheet sh;
public static String getCellStringData(int RowNum, int ColNum,String Sheet) throws IOException
	{
	f=new FileInputStream(Messages.CONFIGPATH_EXCELREADER);
	//f=new FileInputStream("/Users/Sanoob/Documents/workspace1/SampleProject/src/main/resources/excelreader/Book1.xlsx");
		w= new XSSFWorkbook(f);
		sh=w.getSheet(Sheet);
		Row r=sh.getRow(RowNum);
		Cell c=r.getCell(ColNum);
		return c.getStringCellValue();
		
	}
public static int getCellNumericData(int RowNum, int ColNum) throws IOException
{
	f=new FileInputStream(Messages.CONFIGPATH_EXCELREADER);

	//f=new FileInputStream("/Users/Sanoob/Documents/workspace1/SampleProject/src/main/resources/excelreader/Book1.xlsx");
	w= new XSSFWorkbook(f);
	sh=w.getSheet("Sheet1");
	return (int) sh.getRow(RowNum).getCell(ColNum).getNumericCellValue();
	
}
}
