 package files;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Write {

	private static FileWriter writer;
	private static BufferedWriter bw;
	
	public static void openFile(String file) {
		
		String path = "";
		
		if(file.equals("credentials")) {
			path = "C:\\Users\\Dillon\\Desktop\\Boss-Time-master\\data\\credentials.txt";
		}
		else if(file.equals("roles")) {
			path = "C:\\Users\\Dillon\\Desktop\\Boss-Time-master\\data\\roles.txt";
		}
		else if(file.equals("logins")) {
			path = "C:\\Users\\Dillon\\Desktop\\Boss-Time-master\\data\\logins.txt";
		}
		else if (file.equals("payment")) {
			path = "C:\\Users\\Dillon\\Desktop\\Boss-Time-master\\data\\payment.txt";
		}
		
		try {
			writer = new FileWriter(path, true);
			bw = new BufferedWriter(writer);
		}
		catch(Exception e) {
			System.out.println("File doesn't exist");
		}
		
	}
	
	public static void addCredentials(String username, String password) {
		
		openFile("credentials");
		
		try {
			bw.write(username + " ");
			bw.write(password);
			bw.write(System.lineSeparator()); //Next line
			closeFile();
		}
		catch(Exception e) {
			System.out.println("Couldn't write new record");
		}
	}

	public static void addRole(String username, String role) {
		
		openFile("roles");
		
		try {
			bw.write(username + " ");
			bw.write(role);
			bw.write(System.lineSeparator());
			closeFile();
		}
		catch(Exception e) {
			System.out.println("Could not add a user to the system");
		}
		
	}
	
	public static void addLogin(String username, String time, String date, String state) {
	
		openFile("logins");
		
		try {
			bw.write(username);
			bw.write(time);
			bw.write(date);
			bw.write(state);
			bw.write(System.lineSeparator());
			closeFile();
		}
		catch(Exception e){
			System.out.println("Couldn't add the login to the system");
		}
		
	}
		
	public static void addPayment(String username, int hours_worked, double payment) {
		
		openFile("payment");
		
		try {
			bw.write(username);
			bw.write(Integer.toString(hours_worked));
			bw.write(" " + Double.toString(payment));
			bw.write(System.lineSeparator());
			closeFile();
		}
		catch(Exception e) {
			System.out.println("Couldn't add payment to the system");
		}		
	}
	
	public static void closeFile() {
		try {
			bw.close();
		} catch (IOException e) {
			System.out.println("Error");
		}
	}
	
	
}
