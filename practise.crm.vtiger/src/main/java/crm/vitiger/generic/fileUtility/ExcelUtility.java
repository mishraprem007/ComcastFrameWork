package crm.vitiger.generic.fileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcel(String sheet, int rowNum, int cellNum)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Premshankar Mishra\\OneDrive\\Desktop\\New folder\\testScriptdata - Copy - Copy - Copy.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheet).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return value;
	}

	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Premshankar Mishra\\OneDrive\\Desktop\\New folder\\testScriptdata - Copy - Copy - Copy.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheet).getLastRowNum();
		wb.close();
		return rowCount;
	}

	public void setDataIntoExcel(String sheet, int rowNum, int cellNum, String data)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Premshankar Mishra\\OneDrive\\Desktop\\New folder\\testScriptdata - Copy - Copy - Copy.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(rowNum).createCell(cellNum).setCellValue(data);

		FileOutputStream fos = new FileOutputStream(
				"C:\\Users\\Premshankar Mishra\\OneDrive\\Desktop\\New folder\\testScriptdata - Copy - Copy - Copy.xlsx");
		wb.write(fos);
		wb.close();
	}

}
