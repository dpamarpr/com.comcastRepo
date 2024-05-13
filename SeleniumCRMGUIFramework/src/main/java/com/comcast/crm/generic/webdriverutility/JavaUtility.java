package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class JavaUtility {
	
	public int getRandomNumber() {
		
		Random ranDom= new Random();
		int RandomNumber= ranDom.nextInt(5000);
		
		return  RandomNumber;	
	}

	
	public String getSystemDateYYYYDDMM() {
		Date date = new Date();
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		String data= sdf.format(date);
		
		return data;	
	}
	
	public String getRequiredDateYYYYDDMM(int days) {
				
		SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-DD");
		Calendar cal =sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String reqDate =sim.format(cal.getTime());
		
		return reqDate;
		
	}
}
