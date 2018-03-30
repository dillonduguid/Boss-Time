package application;

import java.util.Scanner;

public class Main{

	private static Scanner sc;
	private static boolean loop = true;
	
	public static void main(String [] args) {
		
		sc = new Scanner(System.in);
		
		while(loop) {
			loop = option1();
		}
		
		loop = true;
	
	}
	
	public static boolean option1() {
		
		int option = 0;
		
		do {
			
			System.out.println("1 - Login");
			System.out.println("2 - Create");
			
			option = sc.nextInt();
			
			if(!(option == 1 || option == 2)) {
				System.out.println("You must choose a menu option");
			}
			
			if(option == 1) {
				login();
				return false;
			}
			else if (option == 2) {
				create();
				option = 0;
			}
			
		}while(option == 0);
		
		return true;
				
	}
	
	public static void login() {
		
		String username = "";
		String password = "";
		
		System.out.println("Enter your username:");
		username = sc.next();
		
		System.out.println("Enter your password:");
		password = sc.next();
		
		Accounts.login(username, password);
		
	}
	
	public static void create() {
		
		String username = "";
		String password = "";
		String role = "";
		
		System.out.println("New username: ");		
		username = sc.next();
		
		System.out.println("New password: ");
		password = sc.next();
		
		System.out.println("New role: ");
		role = sc.next();
		
		Accounts.create(username, password, role);
		
	}
	
}