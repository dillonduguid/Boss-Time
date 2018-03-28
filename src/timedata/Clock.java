package timedata;

import files.Write;
import timedata.Calendar;

public class Clock {

	private static boolean decision= true;
	
	public static void clock(String username, String password) {
				
		String time = "";
		String date = "";
		
		if(decision) {
			time = Calendar.getTime();
			date = Calendar.getDate();
			Write.addLogin(username, password, time, date, "IN");
			decision = false;
		}
		else {
			String out_time = Calendar.getTime();
			String out_date = Calendar.getDate();
			Write.addLogin(username, password, out_time, date, "OUT");
			getPayment(username, time, date, out_time, out_date);
			decision = true;
		}
		
	}
	
	public static int getPayment(String username, String time, String date, String out_time, String out_date) {
		
		double payment = 0.0;
		
		int early_number = Integer.valueOf((date.substring(6, 8) + date.substring(3,5)) + date.substring(0,2));
		int later_number = Integer.valueOf((out_date.substring(6, 8) + out_date.substring(3,5)) + out_date.substring(0,2));

		int hours_worked = 0;
			
		if((later_number - early_number) > 0) {
			hours_worked = (2400 - Integer.parseInt(time)) + Integer.parseInt(out_time);
		}
		else {
			hours_worked = Integer.parseInt(out_time) - Integer.parseInt(time);
		}
		
		Calendar.convertTime(hours_worked);
		
		return hours_worked;
		
		//Write.addPayment(username, hours_worked, payment);
		
		
	}
		
}
