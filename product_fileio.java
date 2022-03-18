import java.io.*;
public class product_fileio {

	
	public static void main(String args[]) throws IOException {
		File file = new File ("Object1.txt");
		
		file.createNewFile();
		
		FileReader test = new FileReader(file);
		
		Product [] array = new Product[80];
		
	}
}


/*
public static BST<Product> readfile()
	{
		boolean readable = true;
		BufferedReader buff;
		FileReader filereader;
		try {
			filereader = new FileReader("/Users/mehuljaiswal/eclipse-workspace/Course_project_cis22c/src/products.txt");
			buff = new BufferedReader(filereader);
			String line;
			while (readable) {
				BST<Product> products = new BST<Product>();
				line = buff.readLine();
				if (line == null) // finished reading
				{
					readable = false;
					break;
				} else {
					String[] words = line.split(",");
					for (int i = 0; i < words.size; i++) {
						products.insert(words[i]);
					}
				}
				
			}
			buff.close();
		} catch (IOException e) {
			System.out.println("readfile(): Problem reading file. " + e.toString());
		}
	}
*/
