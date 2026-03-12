package package_dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnConditions {
	/*
	 * read all the data of TC_02 - don't read the data of all test cases
	 */
	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		String expectedTestID = "TC_2000";
		String data1 = "";
		String data2 = "";
		String data3 = "";
		boolean flag =false;

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Premshankar Mishra\\OneDrive\\Desktop\\New folder\\testScriptdata.xlsx");

		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");

		for (int i = 0; i <= sh.getLastRowNum(); i++) {
			String data = "";
			/*
			 * to handle spaces between the data in excel using try catch block
			 */
			try {
				data = sh.getRow(i).getCell(0).toString();
				if (data.equals(expectedTestID)) {
					flag=true;
					data1 = sh.getRow(i).getCell(1).toString();
					data2 = sh.getRow(i).getCell(2).toString();
					data3 = sh.getRow(i).getCell(3).toString();
				}

			} catch (Exception e) {

			}

			wb.close();
		}
		
		if(flag==true) {
			System.out.println(data1);
			System.out.println(data2);
			System.out.println(data3);	
		} else {
			System.out.println("data is not available");
		}
		
	}
}
