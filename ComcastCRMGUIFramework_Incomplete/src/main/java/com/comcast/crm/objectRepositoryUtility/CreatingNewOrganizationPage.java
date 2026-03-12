package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	WebDriver driver;

	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public WebElement getOrgNameEdit() {
		return orgNameEdit;
	}

	public WebElement getShippingAdd() {
		return shippingAdd;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	@FindBy(name = "accountname")
	private WebElement orgNameEdit;

	@FindBy(xpath = "//textarea[@name='ship_street']")
	private WebElement shippingAdd;

	@FindBy(xpath = "(//input[@class='crmbutton small save'])[1]")
	private WebElement saveBtn;

	@FindBy(name = "industry")
	private WebElement industryDD;

	@FindBy(xpath = "//select[@name='accounttype']")
	private WebElement accountTypeDD;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	@FindBy(xpath = "//span[@id='dtlview_Industry']")
	WebElement industryText;

	@FindBy(xpath = "//span[@id='dtlview_Type']")
	WebElement typeText;

	public WebElement getIndustryText() {
		return industryText;
	}

	public WebElement getTypeText() {
		return typeText;
	}

	public WebElement getPhone() {
		return phone;
	}

	@FindBy(xpath = "//input[@id='phone']")
	WebElement phone;

	@FindBy(xpath = "//span[@id='dtlview_Phone']")
	WebElement phoneText;

	public WebElement getPhoneText() {
		return phoneText;
	}

	public void createOrg(String orgName, String address) {
		orgNameEdit.sendKeys(orgName);
		shippingAdd.sendKeys(address);
		saveBtn.click();
	}

	public void createOrg(String orgName, String phone, String address, String accountType, String industries) {
		orgNameEdit.sendKeys(orgName);
		shippingAdd.sendKeys(address);
		this.phone.sendKeys(phone);
		Select sel = new Select(this.industryDD);
		sel.selectByVisibleText(industries);
		Select sel1 = new Select(this.accountTypeDD);
		sel1.selectByVisibleText(accountType);
		saveBtn.click();
	}

	public void createOrg(String orgName, String industries, String address) {
		orgNameEdit.sendKeys(orgName);
		Select sel = new Select(this.industryDD);
		sel.selectByVisibleText(industries);
		shippingAdd.sendKeys(address);
		saveBtn.click();
	}

	public void createOrg(String orgName, String industries, String address, String accountType) {
		orgNameEdit.sendKeys(orgName);
		Select sel = new Select(this.industryDD);
		sel.selectByVisibleText(industries);
		Select sel1 = new Select(this.accountTypeDD);
		sel1.selectByVisibleText(accountType);
		shippingAdd.sendKeys(address);
		saveBtn.click();
	}

}
