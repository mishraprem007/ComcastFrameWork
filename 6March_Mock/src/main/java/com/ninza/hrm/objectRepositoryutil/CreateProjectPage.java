package com.ninza.hrm.objectRepositoryutil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ninza.hrm.baseutility.WebDriverUtility;

public class CreateProjectPage {

	WebDriver driver;
	public CreateProjectPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy (xpath ="//span[text()='Create Project']")
	private WebElement addprjctBtn;
	
	@FindBy (name="projectName")
	private WebElement nameTxt;
	
	@FindBy (name="createdBy")
	private WebElement managerTxt;
	
	@FindBy (xpath ="(//select[@name='status'])[2]")
	private WebElement dd;
	
	@FindBy (xpath ="//input[@value='Add Project']")
	private WebElement saveprjctBtn;
	
	public WebElement getAddprjctBtn() {
		return addprjctBtn;
	}

	public WebElement getNameTxt() {
		return nameTxt;
	}

	public WebElement getManagerTxt() {
		return managerTxt;
	}

	public WebElement getDd() {
		return dd;
	}
	
	
	public void createProject(String pname, String mname, int index) {
		
		addprjctBtn.click();
		nameTxt.sendKeys(pname);
		managerTxt.sendKeys(mname);
		WebDriverUtility wlib= new WebDriverUtility();
		wlib.selectByIndex(dd, index);
		saveprjctBtn.click();
		
		
	}
	

}
