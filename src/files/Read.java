package files;

import java.io.*;
import java.util.*;

public class Read {
	
	private static Scanner x;
	
	public static void openFile(String file) {
		
		if(file.equals("credentials")){
			try {
				x = new Scanner(new File("C:\\Users\\Dillon\\Desktop\\Eclipse\\Boss Time\\data\\credentials.txt"));
			}
			catch(Exception e) {
				System.out.println("Couldn't find file");
			}
		}
		
	}
	
	public static boolean checkCredentials(String login_username, String login_password) {
		
		//READ FILE, COMPARE WITH username AND password PARAMETERS, RETURN TRUE OR FALSE
		openFile("credentials");
		
		boolean end = true;
		
		
		while(x.hasNext() && end) {
			String username = "";
			String password = "";
			
			if(x.hasNext()) {
				username = x.next();
				password = x.next();
			}
			
			if(login_username.equalsIgnoreCase(username)){
				if(login_password.equalsIgnoreCase(password)) {
					closeFile();
					return true;
				}
			}
				
		}
		closeFile();
		return false;
		
	}
	
	public static boolean checkCreateAccount(String create_username) {
		
		openFile("credentials");
		
		boolean end = true;
		
		if(x.hasNext()) {
			while(x.hasNext() && end) {
				String username = "";
				
				if(x.hasNext()) {
					username = x.next();
				}
				
				if(create_username.equalsIgnoreCase(username)) {
					closeFile();
					return false;
				}
				
			}
		}
		closeFile();
		return true;
		
	}
	
	public static void closeFile() {
		x.close();
	}
}
