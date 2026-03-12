package testNG;

import org.testng.annotations.Test;

public class dependsOnMethodsTest {

	@Test(dependsOnMethods = "deleteContactTest")
	public void createOrderTest() {
		System.out.println(" Execute create order Test");
	}

	@Test
	public void amodifyContactTest() {
		System.out.println(" modify create contact test ");
	}

	@Test
	public void deleteContactTest() {
		System.err.println(" delete contact test");
	}
}
