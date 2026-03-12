package testNG;

import org.testng.annotations.Test;

public class PriorityTest2 {

	@Test(priority = 1)
	public void createContactTest() {
		int a = 10 / 0;
		System.out.println("1. execute create contact");
	}

	@Test(priority = 3)
	public void modifyContactTest() {
		System.out.println("3. execute modify contact");
	}

	@Test(priority = 2)
	public void deleteContactTest() {
		System.out.println("2. execute delete contact");
	}

	@Test
	public void zTest() {
		System.out.println("z test");
	}

	@Test
	public void aTest() {
		System.out.println("a test");
	}

}
