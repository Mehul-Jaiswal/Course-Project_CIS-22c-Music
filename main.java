import java.util.Scanner;
public class main {

	
	static Scanner input = new Scanner(System.in);
	
	static HashTable<Customer> customerTable = new HashTable<>(10);
	static HashTable<Employee> employeeTable = new HashTable<>(10);
	
	static Heap<Order> priorityQueue = new Heap<Order>(data, compareByPriority); 
	//need to read: Order information from File (data), and need the comparator class

	public static void maintesting(String[] args) {
		
		
		
		System.out.println("Enter 1 to Create Account");
		System.out.println("Enter 2 to Login");
		int userInput = input.nextInt();
		if (userInput == 1) { 
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

			
		}
		else if (userInput == 2) {
			System.out.println("Enter 1 if you are a customer");
			System.out.println("Enter 2 if you are an employee");
			userInput = input.nextInt();
			if (userInput == 1) { 
				System.out.println("Enter username: ");
				String entered_username = input.nextLine();
				System.out.println("Enter password: ");
				String entered_password = input.nextLine();
				
				//customerTable.contains(new Customer(entered_us))

			}
			
			else if (userInput == 2) {
				System.out.println("Enter username: ");
				String entered_username = input.nextLine();
				System.out.println("Enter password: ");
				String entered_password = input.nextLine();
			
				if () { //if the username and password are valid for EMPLOYEE (Not manager)
					System.out.println("1. Search for an order by order ID");
					System.out.println("2. Search for an order by customer first and last name");
					System.out.println("3. View order with the highest priority");
					System.out.println("4. View all orders sorted by priority");
					System.out.println("5. Ship an order");
					System.out.println("6. Quit and Write to a File");
					
					userInput = input.nextInt();
					if (userInput == 1) {
						System.out.println("Enter order ID: ");
						Integer entered_order_id = input.nextInt();
						Order result = priorityQueue.search(entered_order_id, compareByOrderID); //need new comparator class, need to update return
						
						if (result != null) {
							result.toString();
						} else {
							System.out.println("There is no order with this ID.");
						}
						
					} else if (userInput == 2) {
						
						System.out.println("Enter Customer first and last name: ");
						String entered_order_name = input.nextLine();
						Order result = priorityQueue.search(entered_order_name, compareByCustomerName); //need new comparator class, need to update return
						
						if (result != null) {
							result.toString();
						} else {
							System.out.println("There is no order associated with this name.");
						}
						
					} else if (userInput == 3) {
						
						Order result = priorityQueue.getMax();
						if (result != null) {
							result.toString();
						} else {
							System.out.println("There are no orders at this time.");
						}
						
					} else if (userInput == 4) {
						System.out.println(priorityQueue.toString());
					} else if (userInput == 5) {
						Order shippedOrder = priorityQueue.getMax();
						priorityQueue.remove(1, compareByOrderID);
						
						//insert into customers linked list?
						
					} else if (userInput == 6) {
						
					}
					
				} else {
					
				}
			
			}
		}
		 

		
	}

}
