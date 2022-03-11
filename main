import java.util.Scanner;
public class main {

	
	static Scanner input = new Scanner(System.in);
	
	static HashTable<Customer> customerTable = new HashTable<>(10);
	static HashTable<Employee> employeeTable = new HashTable<>(10);

	

	public static void main(String[] args) {
		
		
		
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
			
			else if (userInput == 2) { }
		}
		 

		
	}

}
