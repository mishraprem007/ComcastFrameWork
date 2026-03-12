package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.Baseclass;
import com.comcast.crm.generic.genericwebdriverutility.UtilityClassObject;
import com.comcast.crm.generic.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.generic.objectrepositoryutility.ContactsPage;
import com.comcast.crm.generic.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.generic.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.generic.objectrepositoryutility.HomePage;
import com.comcast.crm.generic.objectrepositoryutility.OrgImgPage;
import com.comcast.crm.generic.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.generic.objectrepositoryutility.OrganizationsPage;

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class CreateContactTest extends Baseclass {

	@Test(groups={"smokeTest","regressionTest"})
	public void createContactTest() throws Throwable {
		
		UtilityClassObject.gettest().log(Status.INFO, "read data from Excel");
		/* Read test script data from excel file*/
		String lastName = eLib.getDataFromexcel("contact", 1, 2) + jLib.getRandomNumber();

		/* step2: navigate to contact module*/
		UtilityClassObject.gettest().log(Status.INFO, "Navigate to contact page");
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		/* step3:click on "create contact" button*/
		UtilityClassObject.gettest().log(Status.INFO, "Navigate to create contact page");
		ContactsPage cp = new ContactsPage(driver);
		cp.getcreateNewcontactBtn().click();

		/* step4: enter all the details & create new contact*/
		UtilityClassObject.gettest().log(Status.INFO,  "Create contact page");
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createContactpage(lastName); 
		UtilityClassObject.gettest().log(Status.INFO,  "Contact page Created");
		
		/* verify Header LastName info Expected Result*/
		ContactInfoPage cip = new ContactInfoPage(driver);
		String actHeader=cip.getContactheaderMSG().getText();
		boolean status=actHeader.contains(lastName);
			Assert.assertEquals(status, true);
		
		/* verify Header LastName info Expected Result*/
		String actuaLastName = cip.getLastNameTF().getText();
		SoftAssert soft1 = new SoftAssert();
		soft1.assertEquals(actuaLastName, lastName);
		soft1.assertAll();
	}

	@Test(groups="regressionTest")
	public void createContactWithOrgTest() throws Throwable {

		UtilityClassObject.gettest().log(Status.INFO, "read data from Excel");
		/* Read test script data from excel file*/
		String orgName = eLib.getDataFromexcel("contact", 7, 2) + jLib.getRandomNumber();
		String shipping = eLib.getDataFromexcel("contact", 7, 3);
		String lastName = eLib.getDataFromexcel("contact", 7, 4) + jLib.getRandomNumber();

		/* step2: navigate to organization module*/
		UtilityClassObject.gettest().log(Status.INFO, "Navigate to org page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		/* step3:click on "create Organization" button*/
		UtilityClassObject.gettest().log(Status.INFO, "Navigate to create org page");
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		/* step4: enter all the details & create new Organization*/
		UtilityClassObject.gettest().log(Status.INFO,  "Create org page");
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName, shipping);
		UtilityClassObject.gettest().log(Status.INFO,  "Org page Created");

		/* verify Header msg Expected Result*/
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		boolean status=actOrgName.contains(orgName);
		Assert.assertEquals(status, true);

		/* step5: navigate to contact module*/
		UtilityClassObject.gettest().log(Status.INFO, "Navigate to contact page");
		hp.getContactLink().click();

		/* step 6:click on "create contact" button*/
		UtilityClassObject.gettest().log(Status.INFO, "Navigate to create contact page");
		ContactsPage ccp = new ContactsPage(driver);
		ccp.getcreateNewcontactBtn().click();

		/* step 7: enter all the details & create new contact*/
		UtilityClassObject.gettest().log(Status.INFO,  "Create contact pagewithOrg");
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.createContact(lastName);
		UtilityClassObject.gettest().log(Status.INFO,  "Contact page with Org created");

		/* switch to child window*/
		wLib.switchToTabOnURL(driver, "module=Accounts");

		OrgImgPage oIp = new OrgImgPage(driver);
		oIp.searchOrg(orgName);

		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		/* switch ton parent window*/
		wLib.switchToTabOnURL(driver, "module=Contacts&action");// url

		cncp.createContact(); // save

		/* verify Header msg Expected Result*/
		ContactInfoPage cip = new ContactInfoPage(driver);
		String headerInfo = cip.getHeaderMSG().getText();
		boolean status2=headerInfo.contains(lastName);
		Assert.assertEquals(status2, true);
				
		/* verify Header OrgName info Expected Result*/
		String actualOrgName = cip.getHeaderOrgName().getText();
		SoftAssert soft1 = new SoftAssert();
		soft1.assertEquals(actualOrgName, orgName);
		
		soft1.assertAll();
	}
	@Test(groups="regressionTest")
	public void createContactWithSupportDateTest() throws Throwable {

		UtilityClassObject.gettest().log(Status.INFO, "read data from Excel");
		/* Read test script data from excel file*/
		String lastName = eLib.getDataFromexcel("contact", 4, 2) + jLib.getRandomNumber();

		/* step2: navigate to contact module*/
		UtilityClassObject.gettest().log(Status.INFO, "Navigate to contact page");
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		/* step3:click on "create contact" button*/
		UtilityClassObject.gettest().log(Status.INFO, "Navigate to create contact page");
		ContactsPage cnp = new ContactsPage(driver);
		cnp.getcreateNewcontactBtn().click();

		String startDate = jLib.getSystemDateYYYYDDMM();
		String endDate = jLib.getRequiredDateYYYYDDMM(30);

		/* step4: enter all the details & create new contact*/
		UtilityClassObject.gettest().log(Status.INFO,  "Create contact page with supportdate");
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.createContact(lastName, startDate, endDate);
		UtilityClassObject.gettest().log(Status.INFO,  "Contact page with supportdate Created");

		/* verify Header start date info Expected Result*/
		ContactInfoPage cip = new ContactInfoPage(driver);
		String startDate1 = cip.getStartdateTF().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(startDate1, startDate);
		soft.assertAll();
		

		/* verify Header end date info Expected Result*/
		String endDate1 = cip.getEndDateTF().getText();
		SoftAssert soft1 = new SoftAssert();
		soft1.assertEquals(endDate1, endDate);
		soft1.assertAll();
		
	}
}
