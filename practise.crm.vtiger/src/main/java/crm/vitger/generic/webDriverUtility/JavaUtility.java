package crm.vitger.generic.webDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber() {
		Random random = new Random();
		int randomNum = random.nextInt(99999);
		return randomNum;
	}

	public StringBuilder getRandomAlphaNumberic() {
		int n = 16;
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwsxyz";
		StringBuilder sb = new StringBuilder(n);
		int index = (int) (str.length() * (Math.random()));
		for (int i = 0; i < str.length(); i++) {
			sb.append(str.charAt(index));
		}
		return sb;
	}

	public String getCurrentDateYYMMDD() {
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		Date date = new Date();
		String data = sdf.format(date);
		return data;
	}

	public String getRequiredDateYYMMDD(int days) {
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(cal.DAY_OF_MONTH, days);
		String reqDate = sdf.format(cal.getTime());
		return reqDate;
	}
}
