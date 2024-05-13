package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility {
	
	public String getDataFromExcel(String sheetName , int row ,int cell) throws Throwable {
		
		FileInputStream fis = new FileInputStream("D:\\SeleniumCRMGUIFramework\\TestData\\Book1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String DATA=wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		wb.close();

		return DATA;
		
		
	}
	
	public int getLastRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis1 =new FileInputStream("D:\\SeleniumCRMGUIFramework\\TestData\\Book1.xlsx");
		Workbook wb =WorkbookFactory.create(fis1);
		int rowCount =wb.getSheet(sheetName).getLastRowNum();
		wb.close();

		return rowCount; 
	}
	
	
	public void setDataIntoExcel(String sheetName , int row ,int cell, String data) throws Throwable {
		FileInputStream fis = new FileInputStream("D:\\SeleniumCRMGUIFramework\\TestData\\Book1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(row).createCell(cell);
		
		FileOutputStream fos=new FileOutputStream("D:\\SeleniumCRMGUIFramework\\TestData\\Book1.xlsx");
		wb.write(fos);
		wb.close();
		
	}
}
