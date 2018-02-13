package com.berto.utilidades.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class DateFormatExample {
	public static void main(String[] args) throws ParseException {
		Date now = new Date();
		String dateString = now.toString();
		System.out.println(" 1. " + dateString);
		System.out.println(" 2. " + now);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		System.out.println(" 3. " + format.format(now));
		
	}
}
