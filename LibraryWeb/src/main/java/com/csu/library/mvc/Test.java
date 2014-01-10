package com.csu.library.mvc;

import java.util.Calendar;

public class Test {
	
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());
		cal.roll(Calendar.WEEK_OF_YEAR, true);
		
		System.out.println(cal.getTime());
	}

}
