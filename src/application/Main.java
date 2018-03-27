package application;

import java.util.Scanner;

import files.*;
import timedata.*;


public class Main {

	public static Scanner sc;
	
	public static void main(String [] args) {
		
		System.out.println("Username?");
		String username = sc.nextLine();
		
		System.out.println("Password?");
		String password = sc.nextLine();
		
		Open.openFile("credentials");
		
	}
}
