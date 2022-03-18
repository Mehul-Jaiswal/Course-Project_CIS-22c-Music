import java.io.*;
public class product_fileio {

	
	public static void main(String args[]) throws IOException {
		File file = new File ("Object1.txt");
		
		file.createNewFile();
		
		FileReader test = new FileReader(file);
		
		Product [] array = new Product[80];
		
	}
}
