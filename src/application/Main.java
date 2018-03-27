package application;

import files.*;
import timedata.*;

public class Main {
	
	public static void main(String [] args) {
		
		Accounts.create("peter ", "dillon123 ", "Employee");
		Accounts.login("peter", "dillon123");	
		
	}
}
