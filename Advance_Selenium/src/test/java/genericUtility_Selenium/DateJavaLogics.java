package genericUtility_Selenium;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateJavaLogics {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);

		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String actualDate = sim.format(date);
		System.out.println(actualDate);

		Calendar cal = Calendar.getInstance(); // get current date
		cal.setTime(date);                      // set today's date
		cal.add(Calendar.DAY_OF_MONTH, 30);

		String dateRequires = sim.format(cal.getTime());
		System.out.println(dateRequires);
	}
}
