package com.comcast.crm.basetest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.genericwebdriverutility.JavaUtility;
import com.comcast.crm.generic.genericwebdriverutility.UtilityClassObject;
import com.comcast.crm.generic.genericwebdriverutility.WebDriverUtility;
import com.comcast.crm.generic.objectrepositoryutility.HomePage;
import com.comcast.crm.generic.objectrepositoryutility.LoginPage;

public class Baseclass {
	// object creation//
	public DataBaseUtility dbLib=new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	
	@BeforeSuite(groups={"smokeTest","regressionTest"})
	public void configBS() {
		System.out.println("===Connect to DB, Report Config===");
		dbLib.getDbconnection();

	}
//	@Parameters("BROWSER")
	@BeforeClass(groups={"smokeTest","regressionTest"})
	public void configBC() throws Throwable {
		System.out.println("==Launch the BROWSER==");
		//String BROWSER =browser;
		String BROWSER = fLib.getDataFromPropertiesFile("browser");

		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}else {
			driver=new ChromeDriver();
		}
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
	}
	
	@BeforeMethod(groups={"smokeTest","regressionTest"})
	public void configBM() throws Throwable {
		System.out.println("=Login=");
		String URL =fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToapp(URL, USERNAME, PASSWORD);
	}
	
	@AfterMethod(groups={"smokeTest","regressionTest"})
	public void configAM() {
		System.out.println("=Logout=");
		HomePage hp=new HomePage(driver);
		hp.logout();
	}
	
	@AfterClass(groups={"smokeTest","regressionTest"})
	public void configAC() {
		System.out.println("==Close the BROWSER==");
		driver.quit();
		
	}
	
	@AfterSuite(groups={"smokeTest","regressionTest"})
	public void configAS() throws SQLException {
		System.out.println("===Close DB, Report backup===");
		dbLib.closeDbconnection();
	}

}
