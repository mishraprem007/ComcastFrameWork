package com.ninza.hrm.objectRepositoryutil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ninza.hrm.baseutility.WebDriverUtility;

public class CreateEmployee {
	
	WebDriver driver;
	public CreateEmployee(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (xpath ="//div[@class='table-title']//span")
	private WebElement addEmpBtn;

	@FindBy (xpath ="//label[text()='Email*']/following-sibling::input")
	private WebElement emailTxt;
	
	@FindBy (xpath="//label[text()='Name*']/following-sibling::input")
	private WebElement nameTxt;
	
	@FindBy (xpath="//label[text()='Username*']/following-sibling::input")
	private WebElement usernameTxt;
	
	@FindBy (xpath ="//label[text()='Experience*']/following-sibling::input")
	private WebElement experienceTxt;
	
	@FindBy (xpath ="//label[text()='Phone*']/following-sibling::input")
	private WebElement phoneTxt;
	
	@FindBy (xpath ="//label[text()='Designation*']/following-sibling::input")
	private WebElement designationTxt;
	
	@FindBy (xpath ="//select[@name='project']")
	private WebElement selprojectdd;
	
	@FindBy (xpath ="//div[@class='modal-footer']//input[@value='Add']")
	private WebElement saveEmpBtn;
	
	
	
	public WebElement getAddEmpBtn() {
		return addEmpBtn;
	}



	public WebElement getEmailTxt() {
		return emailTxt;
	}



	public WebElement getNameTxt() {
		return nameTxt;
	}



	public WebElement getUsernameTxt() {
		return usernameTxt;
	}



	public WebElement getExperienceTxt() {
		return experienceTxt;
	}



	public WebElement getPhoneTxt() {
		return phoneTxt;
	}



	public WebElement getDesignationTxt() {
		return designationTxt;
	}



	public WebElement getSelprojectdd() {
		return selprojectdd;
	}



	public WebElement getSaveEmpBtn() {
		return saveEmpBtn;
	}



	public void createEmp(String name, String email, String phone,String username, String desig , String exp , String actpname ) throws InterruptedException {
		
		
		addEmpBtn.click();
		nameTxt.sendKeys(name);
		emailTxt.sendKeys(email);
		phoneTxt.sendKeys(phone);
		usernameTxt.sendKeys(username);
		designationTxt.sendKeys(desig);
		experienceTxt.sendKeys(exp);
		WebDriverUtility wlib = new WebDriverUtility();
		wlib.actionClick(driver, selprojectdd);
		wlib.selectByContainsVisibleText(selprojectdd, actpname);
		Thread.sleep(5000);
		wlib.waitUntilElementToBeClickable(driver, saveEmpBtn);
		saveEmpBtn.submit();
		
		
		
	}
	

}
