package com.comcast.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.comcast.crm.generic.genericwebdriverutility.WebDriverUtility;

/**
 * @author Priyanka
 * Contains Login page elements & lib like loginToApp()
 */
public class LoginPage extends WebDriverUtility{	//Rule1- create a separate java class

	WebDriver driver;		// global variable
	public LoginPage(WebDriver driver) {//constructor //Rule3-object initialization(done in constructor)
		this.driver=driver;
	PageFactory.initElements(driver, this);// this current object ref
	}
	@FindBy(name="user_name")	//Rule2-Object Creation
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	// Rule4-object Encapsulation
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	/**
	 * login to application based on url, username, password arguments
	 * @param url
	 * @param username
	 * @param password
	 */
	//Rule5-Provide Action
	public void loginToapp(String url, String username , String password) {//business method
		waitForPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
}
