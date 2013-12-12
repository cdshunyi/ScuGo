package com.action.library;

import java.util.Date;

public class SystemUtils {
	
	static public Date timestampToDate(int time) {
		long timel =  (long)time * 1000;
		Date date = new Date(timel);
		return date;
	}
}
