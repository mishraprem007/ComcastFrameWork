package jdbcSelenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.mysql.cj.jdbc.Driver;

public class CreateProjectAndVerifyDataINDBWithGUI {

	public static void main(String[] args) throws SQLException {

		String expectedProjectName = "AAABTest!!!_007";

		// Create Project in GUI using Selenium
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

		driver.get("http://49.249.28.218:8091/");

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rmgyantra");
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();

		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(expectedProjectName);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("TestManager_007");

		Select sel = new Select(driver.findElement(By.xpath("(//select[@name='status'])[2]")));
		sel.selectByVisibleText("OnGoing");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		driver.close();

		// verify project in DB using JDBC

		boolean flag = false;

// Step 1- Register/laod the data base
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
// Step 2- Connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/ninza_hrm", "root@%", "root");
//Step-3- create sql statement
		Statement stat = conn.createStatement();
//Step-4- execute select query and get result
		ResultSet resultSet = stat.executeQuery("select * from project;");
		while (resultSet.next()) {
			String actProject = resultSet.getString(4);
			if (expectedProjectName.equals(actProject)) {
				flag = true;
				System.out.println(expectedProjectName + " is avialble ===Pass");
			}
		}
		if (flag == false) {
			System.out.println(expectedProjectName + " is not avialble ===Fail");
			Assert.fail();
		}
//Step-5-Close connection
		conn.close();

	}
}
