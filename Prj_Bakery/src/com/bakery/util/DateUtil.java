package com.bakery.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static final String DATE_PATTERN="dd-MM-yyyy";
	public static final SimpleDateFormat SDF=new SimpleDateFormat(DATE_PATTERN);
	public static String converD2S(Date d){
		return SDF.format(d);
	}
}
