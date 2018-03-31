package application;

import java.util.Scanner;
import files.Read;
import files.Write;

public class Accounts {
	
	public static void login(String username, String password) {
				
		//Check if user can log in 
		boolean access = Read.checkLogin(username, password);
		
		//Output log in screen
		if(access) {
			System.out.println("Logged In");
		}
		else {
			System.out.println("Access Denied");
		}
		
	}
	
	public static void create(String username, String password, String role) {
		
		//Check if user can create account 
		boolean success = Read.checkCreateAccount(username);
		boolean success2 = Read.checkRole(username);
		
		//Tell them if the account was created and write account record to file
		if(success && success2) {
			System.out.println("Account created");
			Write.addCredentials(username, password);
			Write.addRole(username, role);
		}
		else {
			System.out.println("Account can't be created");
		}
			
}
