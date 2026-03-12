package com.comcast.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgImgPage {
	
	WebDriver driver;		
	public OrgImgPage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public void searchOrg(String orgName) {//business method
		searchEdt.sendKeys(orgName);
		searchBtn.click();
	}
	
}
