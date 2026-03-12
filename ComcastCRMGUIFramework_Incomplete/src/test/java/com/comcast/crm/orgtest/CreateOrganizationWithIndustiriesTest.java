// Verify the drop down industry and type info
package com.comcast.crm.orgtest;

import java.io.IOException;

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
import com.comcast.crm.objectRepositoryUtility.OrganizationPage;

public class CreateOrganizationWithIndustiriesTest {

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
		String orgName = eLib.getDataFromExcel("Org", 4, 2) + jLib.getRandomNumber();
		String industries = eLib.getDataFromExcel("Org", 4, 3);
		String type = eLib.getDataFromExcel("Org", 4, 4);
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

		CreatingNewOrganizationPage cnp = new CreatingNewOrganizationPage(driver);
		cnp.createOrg(orgName, industries, address, type);

		wLib.WaitForElement(driver, cnp.getIndustryText());
		Thread.sleep(3000);
		// String actIndutries
		// driver.findElement(By.xpath("//span[@id='dtlview_Industry']")).getText();

		String actIndutries = cnp.getIndustryText().getText();
		if (actIndutries.equals(industries)) {
			System.out.println(industries + ": industry information is verfied-->Pass");
		} else {
			System.out.println(industries + ": industry information is not verfied-->Fail");
		}
		String actType = cnp.getTypeText().getText();
		if (actType.equals(type)) {
			System.out.println(actType + ": Type information is verifed-->Pass");
		} else {
			System.out.println(actType + ": Type information is not verifed-->Fail");
		}

		hp.logOut();

		driver.quit();

	}

}