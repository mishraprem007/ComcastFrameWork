package com.ninza.hrm.allutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getDataFromExcel(String sheetname, int rowNum, int colNum) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./configAppData/TestScriptData1.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		String data=wb.getSheet(sheetname).getRow(rowNum).getCell(colNum).getStringCellValue();
		wb.close();
		return data;
	}
	
	public int getintDataFromExcel(String sheetname, int rowNum, int colNum) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./configAppData/TestScriptData1.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		int data=(int) wb.getSheet(sheetname).getRow(rowNum).getCell(colNum).getNumericCellValue();
		wb.close();
		return data;
	}
	
	
	public int getRowCount(String sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./configAppData/TestScriptData1.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		int rowCount =wb.getSheet(sheetname).getLastRowNum();
		wb.close();
		return rowCount;
		
	}
	
	
	public void setDataIntoExcel(String sheetname, int rowNum, int colNum, String data) throws Throwable {
		FileInputStream fis = new FileInputStream("./configAppData/TestScriptData1.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		
		wb.getSheet(sheetname).getRow(rowNum).createCell(colNum).setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream("./testdata/TestScriptData1.xlsx");
		
		wb.write(fos);
		wb.close();
	}

}
