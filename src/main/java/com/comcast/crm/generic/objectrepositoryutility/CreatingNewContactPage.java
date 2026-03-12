package com.comcast.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {

	WebDriver driver;		
	public CreatingNewContactPage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(name="lastname")
	private WebElement lastNameEdt;

	@FindBy(name="support_start_date")
	private WebElement startDateEdt;
	
	@FindBy(name="support_end_date")
	private WebElement endDateEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement selectImg;
	
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}
	
	public WebElement getStartDateEdt() {
		return startDateEdt;
	}


	public WebElement getEndDateEdt() {
		return endDateEdt;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSelectImg() {
		return selectImg;
	}
	public void createContactpage(String lastName) {//business method
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	public void createContact() {//business method
		saveBtn.click();
	}
	public void createContact(String lastName) {//business method
		lastNameEdt.sendKeys(lastName);
		selectImg.click();
	}
	
	public void createContact(String lastName, String startDate, String endDate) {//business method
		lastNameEdt.sendKeys(lastName);
		startDateEdt.clear();
		startDateEdt.sendKeys(startDate);
		endDateEdt.clear();
		endDateEdt.sendKeys(endDate);
		saveBtn.click();
	}
	
}

