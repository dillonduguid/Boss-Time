package application;

import java.util.Scanner;

import files.*;
import timedata.*;


public class Main {

	public static Scanner sc;
	
	public static void main(String [] args) {
		
		sc = new Scanner(System.in);
		
		System.out.println("Username?");
		String username = sc.nextLine();
		
		System.out.println("Password?");
		String password = sc.nextLine();
		
		boolean access = Read.checkCredentials(username, password);
		
		if(access) {
			System.out.println("You're in");
		}
		else {
			System.out.println("Access Denied");
		}
		
	}
}
