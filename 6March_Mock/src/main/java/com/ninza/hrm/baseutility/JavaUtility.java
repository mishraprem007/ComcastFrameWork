package com.ninza.hrm.baseutility;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

import org.testng.annotations.Test;

public class JavaUtility {

	
	public int getRandomNumber() {
		Random random = new Random();
			
		int randomNumber =random.nextInt(1000);
		
		return randomNumber;
	}

	
	  public static String getPresentDate() {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        return LocalDate.now().format(formatter);
	    }

	    public static String getFutureDateAfterDays(int days) {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        return LocalDate.now().plusDays(days).format(formatter);
	    }
	
}
