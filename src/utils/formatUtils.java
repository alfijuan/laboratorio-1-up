package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class formatUtils {
	

	public static Date formatDate(String value) { 
		Date result = null;

		String dateFormat = "yyyyMMdd";
		String timeZone = "GMT-3" ;
		
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, new Locale("es", "ARG"));
		sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
		try {
			result = sdf.parse(value);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
