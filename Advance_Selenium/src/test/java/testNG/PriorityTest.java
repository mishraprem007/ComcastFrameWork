package testNG;

import org.testng.annotations.Test;

public class PriorityTest {

	@Test(priority = 3)
	public void createContactTest() {
		System.out.println("3. execute create contact");
	}

	@Test(priority = 2)
	public void modifyContactTest() {
		System.out.println("2. execute modify contact");
	}

	@Test(priority = 1)
	public void deleteContactTest() {
		System.out.println("1. execute delete contact");
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
