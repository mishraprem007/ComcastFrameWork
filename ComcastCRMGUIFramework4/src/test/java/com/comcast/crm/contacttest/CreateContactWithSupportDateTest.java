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

public class CreateContactWithSupportDateTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// read common data from Property file
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		String browser = fLib.DataFromPropertiesFile("browser");
		String url = fLib.DataFromPropertiesFile("url");
		String username = fLib.DataFromPropertiesFile("username");
		String password = fLib.DataFromPropertiesFile("password");

		// read the test data from excel
		String lastName = eLib.getDataFromExcel("Contact", 4, 2) + jLib.getRandomNumber();

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

		// TC 2. Navigate to Organizations module
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// TC 3. create new contact
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();

		String startDate = jLib.getSystemDateYYYYMMDD();
		String endDate = jLib.getRequiredDateYYYYMMDD(30);

		// TC 4. Enter all the details and create new organization
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.creatingNewContact(lastName, startDate, endDate);

		// verify the support start date and end date on contacts page
		ContactInformationPage cip = new ContactInformationPage(driver);

		String actStartDate = cip.getStartDateText().getText();
		System.out.println(actStartDate);
		if (actStartDate.contains(startDate)) {
			System.out.println(startDate + " information is verified ==>Pass");
		} else {
			System.out.println(startDate + " information is not verified ==>Fail");
		}

		String actEndDate = cip.getEndDateText().getText();
		System.out.println(actEndDate);
		if (actEndDate.contains(endDate)) {
			System.out.println(endDate + " information is verified ==>Pass");
		} else {
			System.out.println(endDate + " information is not verified ==>Fail");
		}

		// TC. 5 Logout
		hp.logOut();
		driver.quit();

	}

}