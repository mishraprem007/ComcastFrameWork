package com.ninza.hrm.objectRepositoryutil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ninza.hrm.baseutility.WebDriverUtility;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//a[text()='Projects']")
	private WebElement prjctlink;
	
	@FindBy(xpath ="//a[text()='Employees']")
	private WebElement emplink;
	
	@FindBy(xpath="//div[@title='Logout']")
	private WebElement logoutBtn;
	
	@FindBy(xpath="//select[@class='form-control']")
	private WebElement selprdd1;
	
	@FindBy(xpath="//div[@class='table-title']//select")
	private WebElement selprdd;
	
	@FindBy(xpath="//select[@class='form-control']/../following-sibling::div")
	private WebElement searchpr;
	
	@FindBy(xpath="//a[@class='nav-link' and contains(.,'Home')]")
	private WebElement homeBtn;
	
	
	
	public WebElement getHomeBtn() {
		return homeBtn;
	}



	public WebElement getPrjctlink() {
		return prjctlink;
	}



	public WebElement getEmplink() {
		return emplink;
	}



	public WebElement getLogoutBtn() {
		return logoutBtn;
	}



	public void logoutApp() {
		
		logoutBtn.click();
	}
	
	
	
}

