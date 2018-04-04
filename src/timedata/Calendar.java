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
		
		int minutes = Integer.parseInt(time.substring(2));
		System.out.println(time);
		String hours = time.substring(0, 2);
		
		//round to every quarter hour
		if(minutes > 14 && minutes < 30) {
			minutes = 15;
		}
		else if(minutes > 29 && minutes < 45) {
			minutes = 30;
		}
		else if(minutes > 44 && minutes < 60) {
			minutes = 45;
		}
		
		time = hours + String.valueOf(minutes);
				
		return time;
		
	}
	
	public static String getDate() {
				
		String date = dateformat.format(thedate);
		
		return date;
	}
		
	public static double convertTime(double hours_worked) {
		
		if(hours_worked < 1300) {	
			return hours_worked / 100;
		}
		else {
			hours_worked = (hours_worked - 200) / 100;
			return hours_worked;
		}
		
	}
	
}
