package application;

import java.util.Scanner;
import files.Read;
import files.Write;

public class Accounts {
	
	public static void login(String username, String password) {
				
		boolean access = Read.checkLogin(username, password);
		
		if(access) {
			System.out.println("Logged In");
			//CHECK WHICH ACCOUNT THEY HAVE (employee or manager)
			//SEND THEM TO CORRECT SCREEN
		}
		else {
			System.out.println("Access Denied");
		}
		
	}
	
	public static void create(String username, String password, String role) {
		
		boolean success = Read.checkCreateAccount(username);
		
		if(success) {
			System.out.println("Create account");
			Write.addCredentials(username, password);
			//get role from user
			addRole(username, role);
		}
		else {
			System.out.println("Sorry, there's already an account with that username in the system");
		}
		
	}
	
	public static void addRole(String username, String role) {
		
		boolean success = Read.checkRole(username);
		
		if(success) {
			System.out.println("Add Role");
			Write.addRole(username, role);
		}
		else {
			System.out.println("Sorry, there's already a username with that role");
		}
		
	}
	
	
}
