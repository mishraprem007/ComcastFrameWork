package com.comcast.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;		// global variable
	public HomePage(WebDriver driver) {//constructor //Rule3-object initialization(done in constructor)
		this.driver=driver;
	PageFactory.initElements(driver, this);// this current object ref
	}
	
	@FindBy(linkText="Organizations")
	private WebElement orgLink;

	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLnk;
	
	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}
	
	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(adminImg).perform();
		signoutLnk.click();
	}
}
