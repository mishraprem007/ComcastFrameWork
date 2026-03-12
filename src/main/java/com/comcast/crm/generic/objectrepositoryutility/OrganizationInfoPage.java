package com.comcast.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	WebDriver driver;		
	public OrganizationInfoPage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerMsg;
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement headerOrgName;
	
	@FindBy(id="dtlview_Industry")
	private WebElement industryDropdown;
	
	@FindBy(id="dtlview_Type")
	private WebElement typeDropdown;
	
	@FindBy(id="dtlview_Phone")
	private WebElement phoneTextfileld;
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	public WebElement getHeaderOrgName() {
		return headerOrgName;
	}
	public WebElement getindustryDropdown() {
		return industryDropdown;
	}
	public WebElement gettypeDropdown() {
		return typeDropdown;
	}
	public WebElement getphoneTextfileld() {
		return phoneTextfileld;
	}
	
	}


