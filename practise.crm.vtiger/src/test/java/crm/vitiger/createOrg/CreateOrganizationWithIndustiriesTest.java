package crm.vitiger.createOrg;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import crm.vitger.generic.webDriverUtility.JavaUtility;
import crm.vitger.generic.webDriverUtility.WebDriverUtility;
import crm.vitiger.generic.fileUtility.ExcelUtility;
import crm.vitiger.generic.fileUtility.PropertyFileUtility;
import crm.vtiger.objectRepostoryUtility.LoginPage;

public class CreateOrganizationWithIndustiriesTest {
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
		String orgName =eul.getDataFromExcel("Org", 4, 2)+ randomInt;
		String industries = eul.getDataFromExcel("Org", 4, 3);
		String type = eul.getDataFromExcel("Org", 4, 4);
		String address =	eul.getDataFromExcel("Org", 1, 5);

		// cancating random number with orgName value fetching from excel
		
		WebDriverUtility wu = new WebDriverUtility();
		driver = wu.launchBrowser(browser);
		driver.get(url);
		wu.waitPageToLoad(driver);
		wu.maximizeScreen(driver);

		LoginPage lp = new LoginPage(driver);
		lp.login(username, password);
		
		// TC 2. Navigate to Organizations module
		driver.findElement(By.linkText("Organizations")).click();

		// TC 3. create new organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// TC 4. Enter all the details and create new organization

		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
		driver.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys(address);
		Select sel1 = new Select(driver.findElement(By.name("industry")));
		sel1.selectByVisibleText(industries);

		Select sel2 = new Select(driver.findElement(By.name("accounttype")));
		sel2.selectByVisibleText(type);

		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();

		// Verify the drop down industry and type info
		String actIndutries = driver.findElement(By.id("dtlview_Industry")).getText();
		if (actIndutries.equals(industries)) {
			System.out.println(industries + " information is verified ==>Pass");
		} else {
			System.out.println(industries + "information  is not verified ==>Fail");
		}

		String actType = driver.findElement(By.id("dtlview_Type")).getText();
		if (actType.equals(type)) {
			System.out.println(type + " information is verified ==>Pass");
		} else {
			System.out.println(type + " information is not verified ==>Fail");
		}

		// TC. 5 Logout
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		// actions.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();

	}

}
