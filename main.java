import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

class main {

  static HashTable<Customer> customerTable = new HashTable<>(100);
	static HashTable<Employee> employeeTable = new HashTable<>(100);
  
	static Heap<Order> priorityQueue = new Heap<Order>(data, new priorityComparator1()); 
  
  public static void main(String[] args) {
  
  //hardcoded customers for testing. Will be deleted once filereader and filewriters are working properly
  customerTable.add(new Customer("ran", "barniv", "rbar", "mypassword", "1234 place", "sunnyvale", "california", "94087"));
  customerTable.add(new Customer("alex", "zhu zhou", "azhou", "password", "1234 place", "sunnyvale", "california", "94087"));
  customerTable.add(new Customer("guy", "john", "guyjohn", "mypassword", "1234 place", "sunnyvale", "california", "94087"));
  //hardcoded employees for testing. Will be deleted once filereader and filewriters are working properly
  employeeTable.add(new Employee(false, "first employee", "employee last", "employee1", "employee123"));
  employeeTable.add(new Employee(false, "second employee", "last", "employee2", "employee123567"));
  employeeTable.add(new Employee(true, "third employee", "some name", "employee3", "the-employee"));
    
  Scanner input = new Scanner();
  //System.out.println("***************Welcome to the Music Store***************");
  boolean mainPageOnline = true;
  boolean managerMenuOnline = false;
  boolean employeeMenuOnline = false;
  System.out.println("Welcome to Our Music Store!");
  while (mainPageOnline) { 
    
    System.out.println("Enter 1 to Create Account");
		System.out.println("Enter 2 to Login");
    System.out.println("Enter 3 to exit");
		
    String userInput = input.nextLine();
      
      
		//input.nextLine();
		if (userInput == "1") { 
			
				System.out.println("Enter your first name: ");
				String input_firstName = input.nextLine();
				System.out.println("Enter your last name: ");
				String input_lastName = input.nextLine();
				System.out.println("Enter a username: ");
				String input_username = input.nextLine();
				System.out.println("Enter a password: ");
				String input_password = input.nextLine();
				System.out.println("Enter your street address: ");
				String input_address = input.nextLine();
				System.out.println("Enter the city of your residence: ");
				String input_city = input.nextLine();
				System.out.println("Enter the state of your residence: ");
				String input_state = input.nextLine();
				System.out.println("Enter the zip code of your residence: ");
				String input_zip = input.nextLine();
				
				customerTable.add(new Customer(input_firstName, input_lastName, input_username, input_password, input_address, input_city, input_state, input_zip));

      System.out.println("Enter 1 to Search for the Product by Name");
      System.out.println("Enter 2 to Search for the Product by ID");
      System.out.println("Enter 3 to List the Product in Sorted by Name");
      System.out.println("Enter 4 to List the Product in Sorted by ID");
			int i = input.nextInt();
      if(i == 1){
        System.out.println("Please Enter the Product Name to Search");
        String input_name = input.nextLine();
        Product search_output = BST.searchByName(input_name);
        if(search_output!=null){
          
        }
        else{
          System.out.println("There are no Products with this name.");
        }
      }
			
		}
		else if (userInput == "2") {
			System.out.println("Enter 1 if you are a customer");
			System.out.println("Enter 2 if you are an employee");
			userInput = input.nextLine();
			if (userInput == "1") { 
				System.out.println("Enter username: ");
				String entered_username = input.next();
				System.out.println("Enter password: ");
				String entered_password = input.next();
				
				//System.out.println(customerTable.find(new Customer(entered_username, entered_password)));
        if (customerTable.find(new Customer(entered_username, entered_password)) != null) {
          System.out.println("Customer with username " + entered_username + " has successfully logged in!");
          
        }else {
          System.out.println("Unable to find account associated with that username/password");
        }
				

			}
			
			else if (userInput == "2") { 
				System.out.println("Enter username: ");
				String entered_username = input.next();
				System.out.println("Enter password: ");
				String entered_password = input.next();
				
				//System.out.println(employeeTable.find(new Employee(entered_username, entered_password)));
        
        Employee user = employeeTable.find(new Employee(entered_username, entered_password));

        if (user != null) {
          if (user.getIsManager()) {
          System.out.println("Manager with username " + entered_username + " has successfully logged in!");

            managerMenuOnline = true;
            } else {
            System.out.println("Employee with username " + entered_username + " has successfully logged in!");
            employeeMenuOnline = true;
            }
          
          
        } else {
          System.out.println("Unable to find account associated with that username/password");
        }

        
        
        while (employeeMenuOnline || managerMenuOnline) {
					System.out.println("Logged in as " + user.toString() + ": Employee Menu");
          
          System.out.println("1. Search for an order by order ID");
					System.out.println("2. Search for an order by customer first and last name");
					System.out.println("3. View order with the highest priority");
					System.out.println("4. View all orders sorted by priority");
					System.out.println("5. Ship an order");

          if (managerMenuOnline) {
            System.out.println("6. Enter a new product");
            System.out.println("7. Update existing product");
            System.out.println("8. Remove a product");
          }
          
          System.out.println("Q. Quit \n");

          System.out.println("Select an option: ");
					
					userInput = input.nextLine();
					if (userInput == "1") {
						System.out.println("Enter order ID: ");
						Integer entered_order_id = input.nextInt();
            input.nextLine();
						Order result = priorityQueue.search(entered_order_id, new compareByOrderID());
						
						if (result != null) {
							result.toString();
						} else {
							System.out.println("There is no order with this ID.");
						}
						
					} else if (userInput == "2") {
						
						System.out.println("Enter Customer first and last name: ");
						String entered_order_name = input.nextLine();
						Order result = priorityQueue.search(entered_order_name, new compareByCustomerName()); //need new comparator class, need to update return
						
						if (result != null) {
							result.toString();
						} else {
							System.out.println("There is no order associated with this name.");
						}
						
					} else if (userInput == "3") {
						
						Order result = priorityQueue.getMax();
						if (result != null) {
							result.toString();
						} else {
							System.out.println("There are no orders at this time.");
						}
						
					} else if (userInput == "4") {

            ArrayList<Order> orderedPriority = priorityQueue.sort();
            for(int i = orderedPriority.size() - 1; i >= 1; i--){
              System.out.print(orderedPriority.get(i) + " ");
            }
            System.out.println();
            
					} else if (userInput == "5") {
						Order shippedOrder = priorityQueue.getMax();
						priorityQueue.remove(1, new compareByOrderID());

            Customer customer = shippedOrder.getCustomer();
            
            customer.getShippedOrders().addLast();
            int indexOfShippedOrder =         
            customer.getUnshippedOrders().findIndex(shippedOrder);
            customer.getUnshippedOrders().positionIterator();
                
      customer.getUnshippedOrders().advanceIteratorToIndex(indexOfShippedOrder);
            customer.getUnshippedOrders().removeIterator();

            System.out.println("Order " + shippedOrder.getID() + " shipped!");

          else if (managerMenuOnline && userInput == "6") {
            System.out.println("Product name: ");
            String name = input.nextLine();
            System.out.println("UID: ");
            String UID = input.nextLine();
            System.out.println("Singer: ");
            String singer = input.nextLine();
            System.out.println("Song duration: ");
            double duration = input.nextDouble();
            input.nextLine();
            System.out.println("Genre: ");
            String genre = input.nextLine();
            System.out.println("Release Year: ");
            String release_year = input.nextLine();
            System.out.println("Cost: ");
            Double cost = input.nextDouble();
            input.nextLine();
            System.out.println("Number in stock: ");
            int numInStock = input.nextInt();
            input.nextLine();

            Product newProduct = Product(name, UID, singer, cost, duration, release_year, genre, numInStock);

          //add product to the catalogue
            
          } else if (managerMenuOnline && userInput == "7") {
            //Choose Product you would like to update first
            System.out.println("Enter 1 to update the cost: ");
            System.out.println("Enter 2 to update the number in stock: ");
            String userInput = input.nextLine();

            if(userInput == "1"){
              
            }
            if(userInput == "2"){
              
            }
          
          } else if (managerMenuOnline && userInput == "8") {
            System.out.println("Enter the product you would like to remove: ");
          }
            
					} else if (userInput == "Q") {
						employeeMenuOnline = false;
            managerMenuOnline == false;
					} else {
        System.out.println("Invalid option!");
          }
					
				} 
        
				

        
			
		} else if (userInput == "3") {
      //writefile
      System.exit();
    } else {
      System.out.println("Please type a valid option");
    }

    
  }

  }

  public void writeOrdersFile() throws FileNotFoundException {

    try {
      File out = new File("orders.txt");
      PrintWriter fileWriter = new PrintWriter(out);

      ArrayList<Order> priorityOrders = priorityQueue.sort();
      
      for (int i = 0; i < priorityOrders.size(); i++) {
        fileWriter.println(priorityOrders.get(i).getOrderID());
        fileWriter.println(priorityOrders.get(i).getCustomer().getName());
        fileWriter.println(priorityOrders.get(i).getDate());
        fileWriter.println(priorityOrders.orderContents.size()); //amount of orders
        for (int i = 0; i < priorityOrders.orderContents.size(); i++) {
          fileWriter.println(priorityOrders.orderContents.get(i).getName());
        }
        fileWriter.println(priorityOrders.get(i).shippingSpeed());
        fileWriter.println(priorityOrders.get(i).priority());
        fileWriter.close();
      }
	  
      } catch (FileNotFoundException e) {
        System.out.println("File orders.txt not found in folder");
      }
      
      
  }

  public void readOrdersFile() throws FileNotFoundException {
    try {
      File in new File("orders.txt");
      Scanner fileReader = new Scanner(in);

    while(fileReader.hasNext()) {

      LinkedList<Product> orderContents = new LinkedList<Product>();
      
      String orderID = fileReader.nextLine();
      String customerName = fileReader.nextLine();

      Customer customer = customerTable // how to get customer from name?
      
      String date = fileReader.nextLine();
      String amountOfOrders = fileReader.nextLine();
      int amountOfOrdersInt = Integer.parse(amountOfOrders);
      for (int i = 0; i < amountOfOrdersInt; i++) {
        String productName = fileReader.nextLine();
        orderContents.addLast( .find() ) //ADD PRODUCT BASED ON PRODUCT BST w/ NMAE
      } 
      String shippingSpeed = fileReader.nextLine();
      String priority = fileReader.nextLine();

      

      Order readOrder = new Order(Integer.parseInt(orderID), customerName, date, amount )
      
      priorityQueue.insert(readOrder);
      
    }

      fileReader.close();
      
    } catch (FileNotFoundException e) {
      System.out.println("File orders.txt not found in folder");
    }
  }



}
