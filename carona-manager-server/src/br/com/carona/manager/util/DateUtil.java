package br.com.carona.manager.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class for Date methods
 */
public class DateUtil {

	/**
	 * Format - dd/MM/yyyy - HH:mm:ss
	 */
	public static final String SIMPLE_DATE_FORMAT = "dd/MM/yyyy - HH:mm:ss";

	/**
	 * Format the date.
	 * 
	 * @param date - Date 
	 * @param format - Format
	 * @return Date in format
	 */
	public static String formatDate(Date date, String format) {
		
		if (date == null) {
			throw new IllegalArgumentException("Date can't be null.");
		}
		
		if (format == null || format.isEmpty()) {
			throw new IllegalArgumentException("Format can't be null.");
		}
		
		return new SimpleDateFormat(format).format(date);
	}
	
}
