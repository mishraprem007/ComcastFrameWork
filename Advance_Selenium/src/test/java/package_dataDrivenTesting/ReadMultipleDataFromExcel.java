package package_dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Premshankar Mishra\\OneDrive\\Desktop\\New folder\\testScript.xlsx");

		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");

		for (int i = 1; i <= sh.getLastRowNum(); i++) {
			Row row = sh.getRow(i);
			String column1data = row.getCell(0).toString();
			String column2data = row.getCell(1).toString();

			System.out.println(column1data + "\t" + column2data);
		}
		wb.close();
	}
}
