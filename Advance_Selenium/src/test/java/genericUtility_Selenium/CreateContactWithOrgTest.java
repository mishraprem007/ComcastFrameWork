package genericUtility_Selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWithOrgTest {
// If we have pre-conditon in test script, we should write the script for selenium or JDBC for them as well even though we have some data available currently
	public static void main(String[] args) throws InterruptedException, IOException {

//pre-condition (OrgName should be created)
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
		Sheet sh = wb1.getSheet("Contact");
		Row row = sh.getRow(7);
		// cancating random number with orgName value fetching from excel
		String orgName = row.getCell(2).toString() + randomInt;
		String address = row.getCell(5).toString();
		String lastName = row.getCell(3).toString();

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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

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
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();

		// Verify Header msg Expected Result
		String headerMsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerMsg.contains(orgName)) {
			System.out.println(orgName + " is created ==Pass");
		} else {
			System.out.println(orgName + " is not created ==Fail");
		}
		// Navigate to contact Module
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		// TC 3. create new contact
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// TC 4. Enter all the details and create new organization

		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();

		// Switch to child window
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String winddowID = it.next();
			driver.switchTo().window(winddowID);
			String actualURL = driver.getCurrentUrl();
			if (actualURL.contains("module=Accounts")) {
				break;
			}
		}

		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		// switch to parent window
		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> it1 = set.iterator();

		while (it1.hasNext()) {
			String winddowID = it1.next();
			driver.switchTo().window(winddowID);
			String actualURL = driver.getCurrentUrl();
			if (actualURL.contains("Contacts&action")) {
				break;
			}
		}

		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();

		// Verify Header msg Expected Result
		String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerinfo.contains(lastName)) {

			System.out.println(lastName + " header verifed ==Pass");
		} else {
			System.out.println(lastName + " header is not verifed ==Fail");
		}

		// Verify Header orgName info Expected Result
		Thread.sleep(2000);
		String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if (actOrgName.trim().equals(orgName)) {
			System.out.println(orgName + " information is created ==>Pass");
		} else {
			System.out.println(orgName + " information is not created ==>Fail");
		}

		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();

	}
}
