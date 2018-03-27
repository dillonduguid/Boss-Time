package timedata;

import timedata.Calendar;

public class Clock {

	private static boolean decision= false;
	
	public static void clock() {
				
		if(decision) {
			String time = Calendar.getTime();
			String date = Calendar.getDate();
			decision = false;
		}
		else {
			getTimeWorked();
			decision = true;
		}
		
	}
	
	public static void getTimeWorked() {
		
	}
	
}
