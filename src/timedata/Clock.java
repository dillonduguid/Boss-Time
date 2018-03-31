package timedata;

import files.Write;
import timedata.Calendar;

public class Clock {

	public static boolean decision = true;
	
	public static void clock(String username) {
				
		String time = "";
		String date = "";
		
		if(decision) {
			time = Calendar.getTime();
			date = Calendar.getDate();
			System.out.println("In date: " + date);
			Write.addLogin(username, time, date, "IN");
			decision = false;
		}
		else {
			String out_time = Calendar.getTime();
			String out_date = Calendar.getDate();
			System.out.println("Out date: " + out_date);
			Write.addLogin(username, out_time, date, "OUT");
			getPayment(username, time, date, out_time, out_date);
			decision = true;
		}
		
	}
	
	public static void getPayment(String username, String time, String date, String out_time, String out_date) {
		
		double payment = 0.0;

		System.out.println("This is the date" + date);
		
		int early_number = Integer.valueOf(date.substring(6) + date.substring(3,5) + date.substring(0,2));
		int later_number = Integer.valueOf((out_date.substring(6) + out_date.substring(3,5)) + out_date.substring(0,2));

		int hours_worked = 0;
			
		if((later_number - early_number) > 0) {
			hours_worked = (2400 - Integer.parseInt(time)) + Integer.parseInt(out_time);
		}
		else {
			hours_worked = Integer.parseInt(out_time) - Integer.parseInt(time);
		}
		
		hours_worked = Calendar.convertTime(hours_worked);
		
		payment = hours_worked * 7.90;
		
		System.out.println(hours_worked + " and " + payment);
		Write.addPayment(username, hours_worked, payment);
		
		
	}
		
}
