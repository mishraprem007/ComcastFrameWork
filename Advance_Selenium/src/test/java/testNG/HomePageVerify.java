package testNG;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

class HomePageVerify {

	// Hard Assert

	@Test
	public void homePageTest(Method mtd) {
		System.out.println(mtd.getName() + " Test start");
		String exmpectedPage = "Home----";

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");

		driver.findElement(By.id("submitButton")).click();

		String actTitle = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();

		Assert.assertEquals(exmpectedPage, actTitle);
		driver.close();
		System.out.println(mtd.getName() + " Test end");

	}

	@Test
	public void verifyHomePageTest(Method mtd) {
		System.out.println(mtd.getName() + " Test start");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		boolean status = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).isEnabled();
		Assert.assertTrue(status);

		driver.close();
		System.out.println(mtd.getName() + " Test end");
	}

}
