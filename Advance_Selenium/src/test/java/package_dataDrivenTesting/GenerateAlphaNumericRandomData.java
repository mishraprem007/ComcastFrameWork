package package_dataDrivenTesting;

public class GenerateAlphaNumericRandomData {

	public static void main(String[] args) {
		/*
		 * Boundary to AlphaNumericRandomData char's max length
		 */
		int n = 20;
		// choose a character random from this String
		String alphaNumStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";

		// create StringBuffer size of AlphaNumberic
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			// generate a random number between 0 to AlphaNumberic variable
			int index = (int) (alphaNumStr.length() * Math.random());

			// add character one by one in end of sb
			sb.append(alphaNumStr.charAt(index));

		}
		System.out.println(sb);
	}

}
