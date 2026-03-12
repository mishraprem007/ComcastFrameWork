package com.comcast.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {

	WebDriver driver;		
	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name="ship_street")
	private WebElement orgShippingEdt;
	
	@FindBy(name="industry")
	private WebElement industryDB;
	
	@FindBy(name="accounttype")
	private WebElement typeDB;
	
	@FindBy(id="phone")
	private WebElement orgPhoneEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getOrgShippingEdt() {
		return orgShippingEdt;
	}

	public WebElement getIndustryDB() {
		return industryDB;
	}

	public WebElement getTypeDB() {
		return typeDB;
	}

	public WebElement getorgPhoneEdt() {
		return orgPhoneEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createOrg(String orgName , String shipping) {//business method
		orgNameEdt.sendKeys(orgName);
		orgShippingEdt.sendKeys(shipping);
		saveBtn.click();
 }
	public void createOrg(String orgName , String shipping, String industry, String type) {//business method
		orgNameEdt.sendKeys(orgName);
		orgShippingEdt.sendKeys(shipping);
		Select sel = new Select(industryDB);
		sel.selectByVisibleText(industry);
		Select sel1 = new Select(typeDB);
		sel1.selectByVisibleText(type);
		saveBtn.click();
}
	public void createOrg(String orgName , String shipping, String phoneNumber) {
		orgNameEdt.sendKeys(orgName);
		orgShippingEdt.sendKeys(shipping);
		orgPhoneEdt.sendKeys(phoneNumber);
		saveBtn.click();
	}
}
