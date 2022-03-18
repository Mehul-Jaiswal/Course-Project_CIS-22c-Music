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
        BST<Product> products_name = new BST<Product>();
        BST<Product> products_id = new BST<Product>();
        try {
            filereader = new FileReader("/Users/mehuljaiswal/eclipse-workspace/Course_project_cis22c/src/products.txt");
            buff = new BufferedReader(filereader);
            String line;

            while (readable) {

                line = buff.readLine();
                if (line == null) // finished reading
                {
                    readable = false;
                    break;
                }

                String[] vertices = line.split(",");
                //System.out.println(vertices[0]);
                // String name, String productId, String singer, double cost, double duration, String release_year, String genre, int numInStock
                products_name.insert(vertices[0]);
                products_id.insert(vertices[1]);
            }
            //System.out.println(products_name.inOrderString().toString());
            //System.out.println(products_id.inOrderString().toString());
            buff.close();
        } catch (IOException e) {
            System.out.println("readfile(): Problem reading file. " + e.toString());
        }
        return products_name;
    }
*/
