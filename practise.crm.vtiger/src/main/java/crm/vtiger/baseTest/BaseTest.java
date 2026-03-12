package crm.vtiger.baseTest;

import org.openqa.selenium.WebDriver;

import crm.vtiger.objectRepostoryUtility.LoginPage;

public class BaseTest {
	WebDriver driver;
LoginPage lp = new LoginPage(driver);
}
