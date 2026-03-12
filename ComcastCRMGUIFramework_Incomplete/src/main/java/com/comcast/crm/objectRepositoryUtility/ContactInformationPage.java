package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	public WebElement getLastNameText() {
		return lastNameText;
	}

	WebDriver driver;

	public ContactInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@id='dtlview_Last Name']")
	WebElement lastNameText;

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	WebElement contactsHeaderText;

	public WebElement getContactsHeaderText() {
		return contactsHeaderText;
	}

	@FindBy(id = "mouseArea_Organization Name")
	WebElement orgNameText;

	public WebElement getOrgNameText() {
		return orgNameText;
	}

	public WebElement getStartDateText() {
		return startDateText;
	}

	public WebElement getEndDateText() {
		return endDateText;
	}

	@FindBy(id = "dtlview_Support Start Date")
	WebElement startDateText;

	@FindBy(id = "dtlview_Support End Date")
	WebElement endDateText;
}
