package com.comcast.crm.contacttest;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryUtility.ContactInformationPage;
import com.comcast.crm.objectRepositoryUtility.ContactsPage;
import com.comcast.crm.objectRepositoryUtility.CreatingNewContactPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.LoginPage;

public class CreateContactTest {

	public static void main(String[] args) throws IOException, InterruptedException {

		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		String browser = fLib.DataFromPropertiesFile("browser");

		String url = fLib.DataFromPropertiesFile("url");
		String username = fLib.DataFromPropertiesFile("username");
		String password = fLib.DataFromPropertiesFile("password");

		// read the test data from excel
		ExcelUtility excelObj = new ExcelUtility();
		String lastName = excelObj.getDataFromExcel("Contact", 1, 2) + jLib.getRandomNumber();

		WebDriver driver = null;

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		wLib.maximizeScerrn(driver);
		wLib.WaitForPageToLoad(driver);

		// TC 1. Login to app
		driver.get(url);
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(username, password);

		// TC 2. Navigate to Contacts module
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// TC 3. create new contact
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();

		// TC 4. Enter all the details and create new contact
		CreatingNewContactPage cnp = new CreatingNewContactPage(driver);
		cnp.creatingNewContact(lastName);

		// verify lastName entered during contact creation

		ContactInformationPage cip = new ContactInformationPage(driver);

		String actLastName = cip.getLastNameText().getText();
		if (actLastName.equals(lastName)) {
			System.out.println(lastName + " lastName information is verified ==>Pass");
		} else {
			System.out.println(lastName + " LastName information is not verified ==>Fail");
		}

		// TC. 5 Logout
		hp.logOut();

		driver.quit();

	}

}