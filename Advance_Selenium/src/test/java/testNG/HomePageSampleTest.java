package testNG;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

class HomePageSampleTest {

	// Hard Assert

	@Test
	public void homePageTest(Method mtd) {
		System.out.println(mtd.getName() + " Test start");
		System.out.println("step-1");
		System.out.println("step-2");
		Assert.assertEquals("Home", "HomePage");
		System.out.println("step-3");
		System.out.println("step-4");
		System.out.println(mtd.getName() + " Test end");
	}

	@Test
	public void verifyHomePageTest(Method mtd) {
		System.out.println(mtd.getName() + " Test start");
		System.out.println("step-1");
		System.out.println("step-2");
		SoftAssert asertObj = new SoftAssert();
		asertObj.assertEquals("Home", "HomePage");;
		System.out.println("step-3");
		System.out.println("step-4");
		asertObj.assertAll();
		System.out.println(mtd.getName() + " Test end");
	}

}
