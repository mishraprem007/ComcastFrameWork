package crm.vtiger.objectRepostoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
	WebDriver driver;

	public CreatingNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastName;

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[2]")
	private WebElement saveBtn;

	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement selectOrgIcon;

	public WebElement getSelectOrgIcon() {
		return selectOrgIcon;
	}

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}

	@FindBy(name = "support_start_date")
	private WebElement startDate;

	@FindBy(name = "support_end_date")
	private WebElement endDate;

	public void creatingNewContact(String lastName) {
		this.lastName.sendKeys(lastName);
		saveBtn.click();
	}

	public void creatingNewContact(String lastName, String startDate, String endDate) {
		this.lastName.sendKeys(lastName);
		this.startDate.clear();
		this.startDate.sendKeys(startDate);
		this.endDate.clear();
		this.endDate.sendKeys(endDate);
		saveBtn.click();

	}

}
