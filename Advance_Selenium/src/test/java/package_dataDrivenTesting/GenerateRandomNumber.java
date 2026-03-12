package package_dataDrivenTesting;

import java.util.Random;

public class GenerateRandomNumber {

	public static void main(String[] args) {

		/*
		 * create object of random class available in java.util package
		 */

		Random random = new Random();

		/*
		 * Set upper limit of random number
		 */

		int randomInt = random.nextInt(1000);

		System.out.println(randomInt); // every time it will get me the number between the range of 0 to 1000

	}

}
