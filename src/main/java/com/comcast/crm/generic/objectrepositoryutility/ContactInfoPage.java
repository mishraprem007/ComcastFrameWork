package com.comcast.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	WebDriver driver;		
	public ContactInfoPage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(id="dtlview_Last Name")
	private WebElement lastNameTF;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerMSG;
	
	@FindBy(className="dvHeaderText")
	private WebElement contactheaderMSG;
	
	@FindBy(xpath="//td[@id='mouseArea_Organization Name']/a")
	private WebElement headerOrgName;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement startdateTF;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement endDateTF;
	
	public WebElement getLastNameTF() {
		return lastNameTF;
	}

	public WebElement getHeaderMSG() {
		return headerMSG;
	}
	
	public WebElement getContactheaderMSG() {
		return contactheaderMSG;
	}

	public WebElement getHeaderOrgName() {
		return headerOrgName;
	}

	public WebElement getStartdateTF() {
		return startdateTF;
	}

	public WebElement getEndDateTF() {
		return endDateTF;
	}
	
	
}
