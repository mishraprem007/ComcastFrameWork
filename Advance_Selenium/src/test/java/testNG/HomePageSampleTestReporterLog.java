package testNG;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

class HomePageSampleTestReporterLog {

	// Hard Assert

	@Test
	public void homePageTest(Method mtd) {
		System.out.println(mtd.getName() + " Test start");
		Reporter.log("step-1", true);
		Reporter.log("step-2", true);
		Assert.assertEquals("Home", "HomePage");
		Reporter.log("step-3", true);
		Reporter.log("step-4", true);
		System.out.println(mtd.getName() + " Test end");
	}

	@Test
	public void verifyHomePageTest(Method mtd) {
		System.out.println(mtd.getName() + " Test start");
		Reporter.log("step-1", true);
		Reporter.log("step-2", true);
		SoftAssert asertObj = new SoftAssert();
		asertObj.assertEquals("Home", "HomePage");
		Reporter.log("step-3", true);
		Reporter.log("step-4", true);
		asertObj.assertAll();
		System.out.println(mtd.getName() + " Test end");
	}

}
