/**
 * 
 */
package com.berto.varios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author berto.gil 10/12/2014
 * 
 */
public class ExampleStringTime {
	public static void main(String[] args) {
		String myTime = "10:30:00";
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		Date date = null;

		try {
			date = sdf.parse(myTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String formattedTime = sdf.format(date);

		System.out.println(formattedTime);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hours = calendar.get(Calendar.HOUR_OF_DAY);
		int minutes = calendar.get(Calendar.MINUTE);
		int seconds = calendar.get(Calendar.SECOND);

		System.out.println(hours);

		System.out.println(minutes);

		System.out.println(seconds);

		System.out.println(calendar.get(Calendar.HOUR_OF_DAY)
				+ new Double(calendar.get(Calendar.MINUTE) / new Double(60)));

	}
}
