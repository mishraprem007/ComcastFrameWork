// Verify the drop down industry and type info
package genericUtility_Selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationWithIndustiriesTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// read common data from Property file
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Premshankar Mishra\\OneDrive\\Desktop\\New folder\\commondata - Copy.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String browser = pObj.getProperty("browser");
		String url = pObj.getProperty("url");
		String username = pObj.getProperty("username");
		String password = pObj.getProperty("password");

		// Generate random number
		Random random = new Random();
		int randomInt = random.nextInt(10000);
		// read the test data from excel
		FileInputStream fis1 = new FileInputStream(
				"C:\\Users\\Premshankar Mishra\\OneDrive\\Desktop\\New folder\\testScriptdata - Copy - Copy - Copy.xlsx");
		Workbook wb1 = WorkbookFactory.create(fis1);
		Sheet sh = wb1.getSheet("Org");
		Row row = sh.getRow(4);

		// cancating random number with orgName value fetching from excel
		String orgName = row.getCell(2).toString() + randomInt;
		String industries = row.getCell(3).toString();
		String type = row.getCell(4).toString();
		String address = sh.getRow(1).getCell(5).toString();
		wb1.close();

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

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// TC 1. Login to app
		driver.get(url);

		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();

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