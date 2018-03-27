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
			String username = x.next();
			String password = x.next();
		
			if(login_username.equalsIgnoreCase(username)){
				if(login_password.equalsIgnoreCase(password)) {
					return true;
				}
			}
			
		}
		
		return false;
		
	}
	
	public static boolean checkCreateAccount(String create_username, String create_password) {
		
		openFile("credentials");
		
		boolean end = true;
		
		while(x.hasNext() && end) {
			String username = x.next();
			String password = x.next();
			
			if(create_username.equalsIgnoreCase(username)) {
				return false;
			}
			
		}
		
		return true;
		
	}
}
