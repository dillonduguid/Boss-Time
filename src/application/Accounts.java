package application;

import java.util.Scanner;
import files.Read;

public class Accounts {
	
	public static void login(String username, String password) {
				
		boolean access = Read.checkCredentials(username, password);
		
		if(access) {
			System.out.println("Logged In");
			//CHECK WHICH ACCOUNT THEY HAVE
			//SEND THEM TO CORRECT SCREEN
		}
		else {
			System.out.println("Access Denied");
		}
		
	}
	
	public static void create(String username, String password, String role) {
		
		boolean success = Read.checkCreateAccount(username, password);
		
		if(success) {
			System.out.println("Create account");
			//CALL FUNCTION THAT WRITES USERNAME AND JOB ROLE TO FILE
		}
		else {
			System.out.println("I'm sorry, there's already an account with that username in the system");
		}
		
	}
	
	
}
