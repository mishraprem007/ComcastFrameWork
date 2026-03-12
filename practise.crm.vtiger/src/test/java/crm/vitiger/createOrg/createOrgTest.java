package crm.vitiger.createOrg;

import java.io.IOException;
import org.openqa.selenium.WebDriver;

import crm.vitger.generic.webDriverUtility.JavaUtility;
import crm.vitger.generic.webDriverUtility.WebDriverUtility;
import crm.vitiger.generic.fileUtility.ExcelUtility;
import crm.vitiger.generic.fileUtility.PropertyFileUtility;
import crm.vtiger.objectRepostoryUtility.CreatingNewOrganizationPage;
import crm.vtiger.objectRepostoryUtility.HomePage;
import crm.vtiger.objectRepostoryUtility.LoginPage;
import crm.vtiger.objectRepostoryUtility.OrganizationInfoPage;
import crm.vtiger.objectRepostoryUtility.OrganizationPage;

public class createOrgTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = null;
		// read common data from Property file
		PropertyFileUtility pFU = new PropertyFileUtility();
		String browser = pFU.dataFromPropertyFile("browser");
		String url = pFU.dataFromPropertyFile("url");
		String username = pFU.dataFromPropertyFile("username");
		String password = pFU.dataFromPropertyFile("password");

		// Generate random number
		JavaUtility jU = new JavaUtility();
		int randomInt = jU.getRandomNumber();

		// read the test data from excel
		ExcelUtility eul = new ExcelUtility();
		String orgName = eul.getDataFromExcel("Org", 1, 2) + randomInt;
		String address = eul.getDataFromExcel("Org", 1, 5);

		WebDriverUtility wu = new WebDriverUtility();
		driver = wu.launchBrowser(browser);
		driver.get(url);
		wu.waitPageToLoad(driver);
		wu.maximizeScreen(driver);

		LoginPage lp = new LoginPage(driver);
		lp.login(username, password);

		// TC 2. Navigate to Organizations module

		HomePage hp = new HomePage(driver);
		// HomePage hp=PageFactory.initElements(driver, HomePage.class);
		hp.getOrgLink().click();

		// TC 3. create new organization
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateNewOrgBtn().click();

		// TC 4. Enter all the details and create new organization
		CreatingNewOrganizationPage cnp = new CreatingNewOrganizationPage(driver);
		cnp.createOrg(orgName, address);

		// Verify Header msg Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);

		String headerMsg = oip.getHeaderMsg().getText();
		if (headerMsg.contains(orgName)) {
			System.out.println(headerMsg + " is verified ==Pass");
		} else {
			System.out.println(headerMsg + " is not verified ==Fail");
		}

		// Verify Header orgName info Expected Result
		String actOrgName = oip.getOrgNameText().getText();
		if (actOrgName.trim().equals(orgName)) {
			System.out.println(orgName + " is created ==>Pass");
		} else {
			System.out.println(orgName + " is not created ==>Fail");
		}
		// TC. 5 Logout
		hp.logOut();
		driver.quit();
	}
}
