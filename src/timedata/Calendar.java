package timedata;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Calendar {

	private static SimpleDateFormat dateformat = new SimpleDateFormat("yy/MM/dd");
	private static SimpleDateFormat timeformat = new SimpleDateFormat("HHmm");
	private static Date thedate = new Date();;

	public static String getTime() {
			
		String time = timeformat.format(thedate);
		
		return time;
	}
	
	public static String getDate() {
				
		String date = dateformat.format(thedate);
		
		return date;
	}
	
}
