package com.ninza.hrm.objectRepositoryutil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy (id="username")
	private WebElement usnTxt;
	@FindBy (id="inputPassword")
	private WebElement pwdTxt;
	@FindBy (xpath="//button[text()='Sign in']")
	private WebElement lgnBtn;
	
	public WebElement getUsnTxt() {
		return usnTxt;
	}
	public WebElement getPwd() {
		return pwdTxt;
	}
	public WebElement getLgnBtn() {
		return lgnBtn;
	}
	
	public void loginToApp(String url, String usn, String pwd) {
		driver.get(url);
		usnTxt.sendKeys(usn);
		pwdTxt.sendKeys(pwd);
		lgnBtn.click();
		
		
		
	}
}
