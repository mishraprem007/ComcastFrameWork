package com.ninjahrm.createemployee;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ninza.hrm.allutilities.ExcelUtility;
import com.ninza.hrm.allutilities.JavaUtility;
import com.ninza.hrm.baseutility.BaseClass;
import com.ninza.hrm.objectRepositoryutil.CreateEmployee;
import com.ninza.hrm.objectRepositoryutil.CreateProjectPage;
import com.ninza.hrm.objectRepositoryutil.HomePage;

public class CreateProjectTest extends BaseClass {

	@Test
	public void createProjectandEmployee() throws EncryptedDocumentException, IOException, InterruptedException {

		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();

		String projectname = elib.getDataFromExcel("org", 1, 1) + jlib.getRandomNumber();
		String manager = elib.getDataFromExcel("org", 1, 2);
		int valueIndex = elib.getintDataFromExcel("org", 1, 3);

		HomePage hp = new HomePage(driver);
		hp.getPrjctlink().click();

		CreateProjectPage cp = new CreateProjectPage(driver);
		cp.createProject(projectname, manager, valueIndex);

		String createdProject = driver.findElement(By.xpath("//tr/td[text()='" + projectname + "']")).getText();
		Assert.assertEquals(createdProject, projectname);
		System.out.println("createdProject:   " + createdProject);

		Thread.sleep(5000);
		hp.getHomeBtn().click();
		hp.getEmplink().click();

		String acteName = elib.getDataFromExcel("org", 3, 1) + jlib.getRandomNumber();
		String email = acteName + elib.getDataFromExcel("org", 3, 2);
		String phone = elib.getDataFromExcel("org", 3, 3);
		String userName = elib.getDataFromExcel("org", 3, 4) + jlib.getRandomNumber();
		String designa = elib.getDataFromExcel("org", 3, 5);
		String exp = elib.getDataFromExcel("org", 3, 6);

		CreateEmployee ce = new CreateEmployee(driver);

		ce.createEmp(acteName, email, phone, userName, designa, exp, projectname);

		String createdename = driver.findElement(By.xpath("//tr/td[text()='" + acteName + "']")).getText();
		System.out.println("createdename:   " + createdename);
		Assert.assertEquals(createdename, acteName);

		Thread.sleep(5000);

	}

}
