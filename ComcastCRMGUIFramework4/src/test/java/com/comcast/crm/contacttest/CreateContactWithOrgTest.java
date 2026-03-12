package com.comcast.crm.contacttest;

import java.io.IOException;

import org.openqa.selenium.By;
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
import com.comcast.crm.objectRepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.LoginPage;
import com.comcast.crm.objectRepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.objectRepositoryUtility.OrganizationPage;
import com.comcast.crm.objectRepositoryUtility.OrganizationsChildPage;

public class CreateContactWithOrgTest {
// If we have pre-conditon in test script, we should write the script for selenium or JDBC for them as well even though we have some data available currently
	public static void main(String[] args) throws InterruptedException, IOException {
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();
//pre-condition (OrgName should be created)
		// read common data from Property file
		String browser = fLib.DataFromPropertiesFile("browser");
		String url = fLib.DataFromPropertiesFile("url");
		String username = fLib.DataFromPropertiesFile("username");
		String password = fLib.DataFromPropertiesFile("password");

		// read the test data from excel
		String orgName = eLib.getDataFromExcel("Contact", 7, 2) + jLib.getRandomNumber();
		String address = eLib.getDataFromExcel("Contact", 7, 5);
		String lastName = eLib.getDataFromExcel("Contact", 7, 3);

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
		hp.getOrgLink().click();

		// TC 3. create new organization
		OrganizationPage op = new OrganizationPage(driver);

		op.getCreateNewOrgBtn().click();

		// TC 4. Enter all the details and create new organization
		CreatingNewOrganizationPage cno = new CreatingNewOrganizationPage(driver);
		cno.createOrg(orgName, address);

		// Verify Header msg Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);

		String headerMsg = oip.getHeaderMsg().getText();
		if (headerMsg.contains(orgName)) {
			System.out.println(orgName + " is created ==Pass");
		} else {
			System.out.println(orgName + " is not created ==Fail");
		}
		// Navigate to contact Module
		hp.getContactLink().click();

		// TC 3. create new contact

		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();

		// TC 4. Enter all the details and create new organization
		CreatingNewContactPage cnp = new CreatingNewContactPage(driver);
		cnp.getLastName().sendKeys(lastName);
		cnp.getSelectOrgIcon().click();

		// Switch to child window

		wLib.switchToTheTabOnURL(driver, "module=Accounts");
		OrganizationsChildPage ocp = new OrganizationsChildPage(driver);
		ocp.getSearchText().sendKeys(orgName);
		ocp.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		// switch to parent window
		wLib.switchToTheTabOnURL(driver, "Contacts&action");

		cnp.getSaveBtn().click();

		// Verify Header msg Expected Result
		ContactInformationPage cip = new ContactInformationPage(driver);

		String headerinfo = cip.getContactsHeaderText().getText();
		if (headerinfo.contains(lastName)) {

			System.out.println(lastName + "  header verifed ==Pass");
		} else {
			System.out.println(lastName + "  header is not verifed ==Fail");
		}

		// Verify Header orgName info Expected Result

		Thread.sleep(2000);
		String actOrgName = cip.getOrgNameText().getText();
		if (actOrgName.trim().equals(orgName)) {
			System.out.println(orgName + " information is created ==>Pass");
		} else {
			System.out.println(orgName + " information is not created ==>Fail");
		}

		hp.logOut();
		driver.quit();

	}
}
