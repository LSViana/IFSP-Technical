package JoaoSupermarket.Util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {
	// Pattern used to format dates
	private static String DATE_PATTERN = "dd/MM/yyyy";
	// DateFormatter objects to perform the formatting
	private static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);
	// Return the Date as a formatted string
	public static String format(LocalDate date) {
		if(date == null)
			return null;
			return DATE_FORMATTER.format(date);
	}
	// Return the string as a Date
	public static LocalDate parse(String dateString) {
		try {
			return DATE_FORMATTER.parse(dateString, LocalDate::from);
		}
		catch(Exception exc) {
			return null;
		}
	}
	// Checks the string whether it is a valid date
	public static boolean validDate(String dateString) {
		// Try parsing the string
		return DateUtil.parse(dateString) != null;
	}
	public static String getDate_Pattern() {
		return DATE_PATTERN;
	}
}
