package files;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Write {

	private static FileWriter writer;
	private static BufferedWriter bw;
	
	public static void openFile(String file) {
		
		if(file.equals("credentials")) {
			try {
				writer = new FileWriter("C:\\Users\\Dillon\\Desktop\\Eclipse\\Boss Time\\data\\credentials.txt", true);
				bw = new BufferedWriter(writer);
			}
			catch(Exception e) {
				System.out.println("File doesn't exist");
			}
		}
		else if(file.equals("roles")) {
			try {
				writer = new FileWriter("C:\\Users\\Dillon\\Desktop\\Eclipse\\Boss Time\\data\\roles.txt", true);
				bw = new BufferedWriter(writer);
			}
			catch(Exception e) {
				System.out.println("File doesn't exist");
			}
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
	
	public static void closeFile() {
		try {
			bw.close();
		} catch (IOException e) {
			System.out.println("Error");
		}
	}
	
	
}
