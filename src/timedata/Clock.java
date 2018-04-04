package timedata;

import files.Write;
import timedata.Calendar;

public class Clock {

	public static boolean decision = true;
	
	private static String time;
	private static String date;
	
	private static boolean choice = true;
	
	public static void clock(String username) {
		
		if(decision) {
			time = Calendar.getTime();
			date = Calendar.getDate();
			Write.addLogin(username, time, date, "IN");
			decision = false;
		}
		else {
			String out_time = Calendar.getTime();
			String out_date = Calendar.getDate();
			Write.addLogin(username, out_time, out_date, "OUT");
			getPayment(username, time, date, out_time, out_date);
			decision = true;
		}
		
	}
	
	public static void getPayment(String username, String time, String date, String out_time, String out_date) {
		
		double payment = 0.0;
		
		int early_number = Integer.valueOf(date.substring(6) + date.substring(3,5) + date.substring(0,2));
		int later_number = Integer.valueOf((out_date.substring(6) + out_date.substring(3,5)) + out_date.substring(0,2));

		double hours_worked = 0.0;
			
		if((later_number - early_number) > 0) {
			hours_worked = (2400 - Integer.parseInt(time)) + Integer.parseInt(out_time);
		}
		else {
			hours_worked = Integer.parseInt(out_time) - Integer.parseInt(time);
		}
		
		hours_worked = Calendar.convertTime(hours_worked);
		
		//double minutes = Double.parseDouble(String.valueOf(hours_worked).substring(3));
		
		payment = hours_worked * 7.90;
		
		Write.addPayment(username, hours_worked, payment);
		
	}
	
	public static String decision() {
		
		if(choice) {
			choice = false;
			return "In";
		}
		else {
			choice = true;
			return "Out";
		}
		
	}
		
}
