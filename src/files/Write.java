package files;

import java.util.*;

public class Write {

	private static Formatter x;
	
	public static void openFile(String file) {
		
		if(file.equals("credentials")) {
			try {
				x = new Formatter("C:\\Users\\Dillon\\Desktop\\Eclipse\\Boss Time\\data\\credentials.txt");
			}
			catch(Exception e) {
				System.out.println("File doesn't exist");
			}
		}
	}
	
	public static void addCredentials(String username, String password) {
		
		openFile("credentials");
		x.format("%s%s", username , password );
		closeFile();
	}
	
	public static void closeFile() {
		x.close();
	}
	
	
}
