package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(5000);
		return randomNumber;
	}

	public String getSystemDateYYYYMMDD() {
		Date dateObj = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String data = sdf.format(dateObj);
		return data;
	}

	public String getRequiredDateYYYYMMDD(int days) {
		  SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");

		    Calendar cal = Calendar.getInstance(); // gets current date
		    cal.add(Calendar.DAY_OF_MONTH, days);

		    String reqDate = sim.format(cal.getTime());
		    return reqDate;
	}

}
