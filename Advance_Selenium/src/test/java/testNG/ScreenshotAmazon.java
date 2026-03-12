package testNG;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class ScreenshotAmazon {

	@Test
	public void amazonTest() throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		Thread.sleep(2000);
		TakesScreenshot tks = (TakesScreenshot) driver;
		File fileSrc = tks.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(fileSrc, new File("./Screenshot/amazon.png"));
		driver.close();

	}
}
