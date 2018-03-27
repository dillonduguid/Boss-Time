package files;
import java.io.*;
import java.util.Formatter;

public class Open {
	
	private static Formatter x;
	
	public static void openFile(String file) {
		
		try {
			if(file.equalsIgnoreCase("credentials")) {
			x = new Formatter("C:\\Users\\Dillon\\Desktop\\Eclipse\\Boss Time\\data\\credentials.txt");
			}
		}
		catch(Exception e) {
			System.out.println("Error");
		}
		
	}
	
}
