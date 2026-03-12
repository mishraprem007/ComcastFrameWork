package package_dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		// Step 1: get the excel path location & java object of the physical ExcelFile
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Premshankar Mishra\\OneDrive\\Desktop\\New folder\\testScriptdata.xlsx");

		// Step 2: open workbook in read mode
		Workbook wb = WorkbookFactory.create(fis);

		// Step 3: get the control of the desired sheet (By default 1st sheet will be
		// selected)
		Sheet sh = wb.getSheet("Sheet1");
		// Step 4: get the control of the first row
		Row row = sh.getRow(1);

		// Step 5: get the control of the 3nd cell & read the string data

		String data = row.getCell(3).toString();

		System.out.println(data);
		// Step 6: close the WorkBook
		wb.close();

	}

}
