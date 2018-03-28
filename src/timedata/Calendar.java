package timedata;

import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Date;

public class Calendar {

	private static SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yy");
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
		
	public static int convertTime(int hours_worked) {
		
		if(hours_worked < 1300) {
			System.out.println(String.valueOf(hours_worked));
			
			hours_worked = hours_worked - 100;
			return hours_worked;
		}
		else {
			return (hours_worked - 300) / 100;
		}
		
	}
	
}
