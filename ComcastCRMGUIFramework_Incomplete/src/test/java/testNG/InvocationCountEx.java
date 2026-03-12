package testNG;

import org.testng.annotations.Test;

public class InvocationCountEx {

	@Test(invocationCount = 5)
	public void createOrderTest() {
		System.out.println("createOrderTest");
	}

	@Test(enabled = false)
	public void billingOrderTest() {
		System.out.println("billingOrderTest");
	}

}
