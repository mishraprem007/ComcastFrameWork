package com.ninza.hrm.baseutility;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.ninza.hrm.allutilities.ExcelUtility;
import com.ninza.hrm.objectRepositoryutil.HomePage;
import com.ninza.hrm.objectRepositoryutil.LoginPage;


public class BaseClass {

	public ExcelUtility eLib=new ExcelUtility();
	public	JavaUtility jLib= new JavaUtility();
	public WebDriverUtility wLib= new WebDriverUtility();
	public FileUtility fLib= new FileUtility();
	public WebDriver driver = null;
	
	
	@BeforeSuite(groups = {"smoke", "regression"},alwaysRun = true)
	public void configBS() {		
		
				
	}
	
	
	@BeforeClass(groups = {"smoke", "regression"},alwaysRun = true)
	
	public void configBC() throws Throwable {
		System.out.println("launch the browser");
		
		String browser =fLib.getDataFromProprtiesFile("browser");
		
		if( browser.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
			}
		else if(browser.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}
		else {
			driver= new ChromeDriver();
		}
		
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	
	@BeforeMethod(groups = {"smoke", "regression"},alwaysRun = true)
	public void configBM() throws Throwable {
		System.out.println("Login");
		LoginPage lp= new LoginPage(driver);
		String url =fLib.getDataFromProprtiesFile("url");
		String username =fLib.getDataFromProprtiesFile("username");
		String password =fLib.getDataFromProprtiesFile("password");
		lp.loginToApp(url, username, password);
		
	}
	
	@AfterMethod(groups = {"smoke", "regression"},alwaysRun = true)
	public void configAM() throws InterruptedException {
		System.out.println("Logout");
		
		HomePage hp= new HomePage(driver);
	}
	
	@AfterClass(groups = {"smoke", "regression"},alwaysRun = true)
	public void configAC() {
		System.out.println("close the browser");
		driver.quit();
		
	}
	
	@AfterSuite(groups = {"smoke", "regression"},alwaysRun = true)
	public void configAS() {
		
	}


	@BeforeTest(groups = {"smoke", "regression"} ,alwaysRun = true)
	public void configBT() {
	}
	@AfterTest(groups = {"smoke", "regression"},alwaysRun = true)
	public void configAT() {

	}
}
