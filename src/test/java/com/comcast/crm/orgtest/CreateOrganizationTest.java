package com.comcast.crm.orgtest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.Baseclass;
import com.comcast.crm.generic.genericwebdriverutility.UtilityClassObject;
import com.comcast.crm.generic.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.generic.objectrepositoryutility.HomePage;
import com.comcast.crm.generic.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.generic.objectrepositoryutility.OrganizationsPage;

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class CreateOrganizationTest extends Baseclass {

	@Test(groups="smokeTest")
	public void createOrganizationTest() throws Throwable {

		UtilityClassObject.gettest().log(Status.INFO, "read data from Excel");
		/* Read test script data from excel file*/
		String orgName = eLib.getDataFromexcel("org", 1, 2) + jLib.getRandomNumber();
		String shipping = eLib.getDataFromexcel("org", 1, 4);

		/* step2: navigate to organization module*/
		UtilityClassObject.gettest().log(Status.INFO, "Navigate to org page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		/* step3:click on "create Organization" button */
		UtilityClassObject.gettest().log(Status.INFO, "Navigate to create org page");
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		/* step4: enter all the details & create new Organization*/
		UtilityClassObject.gettest().log(Status.INFO, "Create a new  org");
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName, shipping);
		UtilityClassObject.gettest().log(Status.INFO, orgName+"==>Org Created");

		/* verify Header msg Expected Result*/
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		boolean status=actOrgName.contains(orgName);
		Assert.assertEquals(status, true);

		/* verify Header OrgName info Expected Result*/
		String actualOrgName = oip.getHeaderOrgName().getText();
		SoftAssert soft1 = new SoftAssert();
		soft1.assertEquals(actualOrgName, orgName);
		soft1.assertAll();
	}

	@Test(groups="regressionTest")
	public void createOrganizationWithindustriesTest() throws Throwable {
		
		UtilityClassObject.gettest().log(Status.INFO, "read data from Excel");
		/* Read test script data from excel file*/
		String orgName = eLib.getDataFromexcel("org", 4, 2) + jLib.getRandomNumber();
		String industry = eLib.getDataFromexcel("org", 4, 3);
		String shipping = eLib.getDataFromexcel("org", 4, 4);
		String type = eLib.getDataFromexcel("org", 4, 5);

		UtilityClassObject.gettest().log(Status.INFO, "Navigate to org page");
		/* step2: navigate to organization module*/
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		UtilityClassObject.gettest().log(Status.INFO, "Navigate to create org page");
		/* step3:click on "create Organization" button*/
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		UtilityClassObject.gettest().log(Status.INFO, "Create a new  orgwithindustries");
		/* step4: enter all the details & create new Organization*/
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName, shipping, industry, type);
		UtilityClassObject.gettest().log(Status.INFO, orgName+"==>Org Created withindustries");

		/* verify drop down industries and type info Expected Result*/
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actualIndustries = oip.getindustryDropdown().getText();
		SoftAssert soft1 = new SoftAssert();
		soft1.assertEquals(actualIndustries, industry);
		soft1.assertAll();

		String actualType = oip.gettypeDropdown().getText();
		soft1.assertEquals(actualType, type);
		soft1.assertAll();
	}

	@Test(groups="regressionTest")
	public void createOrganizationWithPhoneNumberTest() throws Throwable {
		
		UtilityClassObject.gettest().log(Status.INFO, "read data from Excel");
		/* Read test script data from excel file*/
		String orgName = eLib.getDataFromexcel("org", 7, 2) + jLib.getRandomNumber();
		String phoneNumber = eLib.getDataFromexcel("org", 7, 3);
		String shipping = eLib.getDataFromexcel("org", 7, 4);

		UtilityClassObject.gettest().log(Status.INFO, "Navigate to org page");
		/* step2: navigate to organization module*/
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		UtilityClassObject.gettest().log(Status.INFO, "Navigate to create org page");
		/* step3:click on "create Organization" button*/
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		UtilityClassObject.gettest().log(Status.INFO, "Create a new  orgwithphonenumber");
		/* step4: enter all the details & create new Organization*/
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName, shipping, phoneNumber);
		UtilityClassObject.gettest().log(Status.INFO, orgName+"==>Org Created withphonenumber");

		/* verify phone number info Expected Result*/
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actualPhoneNumber = oip.getphoneTextfileld().getText();
		SoftAssert soft1 = new SoftAssert();
		soft1.assertEquals(actualPhoneNumber, phoneNumber);
		soft1.assertAll();
	}

	@Test(groups="regressionTest")
	public void DeleteOrgTest() throws Throwable {
		
		UtilityClassObject.gettest().log(Status.INFO, "read data from Excel");
		/* Read test script data from excel file*/
		String orgName = eLib.getDataFromexcel("org", 10, 2) + jLib.getRandomNumber();
		String shipping = eLib.getDataFromexcel("org", 10, 4);

		UtilityClassObject.gettest().log(Status.INFO, "Navigate to org page");
		/* step2: navigate to organization module*/
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		UtilityClassObject.gettest().log(Status.INFO, "Navigate to create org page");
		/* step3:click on "create Organization" button*/
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		UtilityClassObject.gettest().log(Status.INFO, "delete created org");
		/* step4: enter all the details & create new Organization*/
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName, shipping);
		UtilityClassObject.gettest().log(Status.INFO, orgName+"==>Org is Deleted:)");

		/* verify Header msg Expected Result*/
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		boolean status=actOrgName.contains(orgName);
		Assert.assertEquals(status, true);
		
		/* verify Header OrgName info Expected Result*/
		String actualOrgName = oip.getHeaderOrgName().getText();
		SoftAssert soft1 = new SoftAssert();
		soft1.assertEquals(actualOrgName, orgName);
		soft1.assertAll();
			
		/* go back to org page*/
		hp.getOrgLink().click();
		/* search for organization*/
		cnp.getSearchEdt().sendKeys(orgName);
		wLib.selectbyVisibleText(cnp.getSearchDD(), "Organization Name");
		cnp.getSearchBtn().click();
		/* In dynamic webtable select and delete org*/
		driver.findElement(By.xpath("//a[text()='" + orgName + "']/../../td[8]/a[text()='del']")).click();
        driver.switchTo().alert().accept();
	}
}
