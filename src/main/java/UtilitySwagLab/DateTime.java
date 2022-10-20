package UtilitySwagLab;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {

	public static String dateTime() {
		DateTimeFormatter format12 = DateTimeFormatter.ofPattern("MM-dd-YYYY , hh.mm.ss");
		LocalDateTime Current = LocalDateTime.now();
		String Dt = Current.format(format12);
		return Dt;
	}
}