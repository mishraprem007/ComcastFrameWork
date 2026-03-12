package com.comcast.crm.orgtest;

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
import com.comcast.crm.objectRepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.LoginPage;
import com.comcast.crm.objectRepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.objectRepositoryUtility.OrganizationPage;

public class DeleteOrganizationTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		// read common data from Property file
		String browser = fLib.DataFromPropertiesFile("browser");
		String url = fLib.DataFromPropertiesFile("url");
		String username = fLib.DataFromPropertiesFile("username");
		String password = fLib.DataFromPropertiesFile("password");

		// read the test data from excel
		String orgName = eLib.getDataFromExcel("Org", 10, 2) + jLib.getRandomNumber();
		String address = eLib.getDataFromExcel("Org", 1, 5);

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

		CreatingNewOrganizationPage cnp = new CreatingNewOrganizationPage(driver);
		cnp.createOrg(orgName, address);

		// Verify Header msg Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		if (actOrgName.contains(orgName)) {
			System.out.println(orgName + ": name is verified==Pass");
		} else {
			System.out.println(orgName + "name is not verified==Fail");
		}

		// go back to Organization Page
		hp.getOrgLink().click();
		// search for Organization
		op.getSearchEdit().sendKeys(orgName);
		wLib.select(op.getSearchDD(), "Organization Name");
		op.getSearchBtn().click();

		// in dynamic webtable select and delete org
		driver.findElement(By.xpath("//a[text()='" + orgName + "']/../..//a[text()='del']")).click();

		wLib.switchToAlertAndAccept(driver);
		hp.logOut();
		driver.quit();
	}

}