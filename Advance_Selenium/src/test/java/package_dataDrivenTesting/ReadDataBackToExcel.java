package package_dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBackToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Premshankar Mishra\\OneDrive\\Desktop\\New folder\\testScriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		Row row = sh.getRow(1);

		/*
		 * Createcell() - will delete the data if already some data are present and then
		 * it will write the data
		 */

		Cell cell = row.createCell(4);
		cell.setCellType(CellType.STRING);
		cell.setCellValue("Fail");

		/*
		 * to save the created cell we need to create object of FileOutputStrem and
		 * enable the write mode because we just created the cell in read mode only.
		 * Note: To perform any action on excel read/write the excel file should not be
		 * already opened either through Automation/ Manual.
		 */
		FileOutputStream fos = new FileOutputStream(
				"C:\\Users\\Premshankar Mishra\\OneDrive\\Desktop\\New folder\\testScriptdata.xlsx");
		wb.write(fos);
		wb.close();
		System.out.println("Executed");
		
		

	}
}
