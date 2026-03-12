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
import org.testng.Assert;

public class CreateContactTest3 {

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
		Sheet sh = wb1.getSheet("Contact");

		String lastName = sh.getRow(1).getCell(2).toString() + randomInt;
		;
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
		driver.findElement(By.linkText("Contacts")).click();

		// TC 3. create new contact
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// TC 4. Enter all the details and create new organization

		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();

		// verify lastName entered during contact creation

		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		
	
		
		
		if (actLastName.equals(lastName)) {
			System.out.println(lastName + " information is verified ==>Pass");
		} else {
			System.out.println(lastName + " information is not verified ==>Fail");
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