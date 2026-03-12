package testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(dataProvider = "getData")
public class DataProviderTest1 {

	public void createContactTest(String firstName, String lastName, long phoneNumber) {
		System.out.println("FirstName: " + firstName + ", lastName: " + lastName + ", phoneNumber: " + phoneNumber);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] objectArr = new Object[3][3];
		objectArr[0][0] = "deppak";
		objectArr[0][1] = "hr";
		objectArr[0][2] = 9856149805L;

		objectArr[1][0] = "deepak_1";
		objectArr[1][1] = "hr_1";
		objectArr[1][2] = 9815637090L;

		objectArr[2][0] = "deepak_2";
		objectArr[2][1] = "hr_2";
		objectArr[2][2] = 950986843L;

		return objectArr;
	}
}
