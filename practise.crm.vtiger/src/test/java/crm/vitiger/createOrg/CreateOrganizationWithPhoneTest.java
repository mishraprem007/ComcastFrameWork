package crm.vitiger.createOrg;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import crm.vitger.generic.webDriverUtility.JavaUtility;
import crm.vitger.generic.webDriverUtility.WebDriverUtility;
import crm.vitiger.generic.fileUtility.ExcelUtility;
import crm.vitiger.generic.fileUtility.PropertyFileUtility;
import crm.vtiger.objectRepostoryUtility.CreatingNewOrganizationPage;
import crm.vtiger.objectRepostoryUtility.HomePage;
import crm.vtiger.objectRepostoryUtility.LoginPage;
import crm.vtiger.objectRepostoryUtility.OrganizationPage;

public class CreateOrganizationWithPhoneTest {
	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver = null;
		// read common data from Property file

		PropertyFileUtility pFU = new PropertyFileUtility();
		String browser = pFU.dataFromPropertyFile("browser");
		String url = pFU.dataFromPropertyFile("url");
		String username = pFU.dataFromPropertyFile("username");
		String password = pFU.dataFromPropertyFile("password");

		// Generate random number
		// Generate random number
		JavaUtility jU = new JavaUtility();
		int randomInt = jU.getRandomNumber();

		// read the test data from excel
		ExcelUtility eul = new ExcelUtility();
		String orgName = eul.getDataFromExcel("Org", 7, 2) + randomInt;
		String address = eul.getDataFromExcel("Org", 1, 5);
		String phone = eul.getDataFromExcel("Org", 7, 3);
		String industries = eul.getDataFromExcel("Org", 4, 3);
		String type = eul.getDataFromExcel("Org", 4, 4);

		WebDriverUtility wu = new WebDriverUtility();
		driver = wu.launchBrowser(browser);
		driver.get(url);
		wu.waitPageToLoad(driver);
		wu.maximizeScreen(driver);

		LoginPage lp = new LoginPage(driver);
		lp.login(username, password);

		// TC 2. Navigate to Organizations module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// TC 3. create new organization
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateNewOrgBtn().click();

		// TC 4. Enter all the details and create new organization
		CreatingNewOrganizationPage cnp = new CreatingNewOrganizationPage(driver);
		cnp.createOrg(orgName, phone, address, type, industries);

		// verify phone number entered information during Orgs creation
		String actPhone = cnp.getPhoneText().getText();

		if (actPhone.equals(phone)) {
			System.out.println(phone + " information is verified ==>Pass");
		} else {
			System.out.println(orgName + " information is not verified ==>Fail");
		}
		// TC. 5 Logout
		hp.logOut();
		driver.quit();
	}
}
