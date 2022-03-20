
public class Employee extends User{

	private boolean isManager;
	
	public Employee() {
		isManager = false;
		firstName = null;
		lastName = null;
		username = null;
		password = null;
	}
	
	public Employee(Boolean isManager, String firstName, String lastName, String username, String password) {
		this.isManager = isManager;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}
	
	public Employee(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Boolean getIsManager() {
		return isManager;
	}
	public void promoteToManager() {
		isManager = true;
	}
	
	@Override
	public int hashCode() {
		String key = username + password; //define key for this class
		int sum = 0;
		for (int i = 0; i < key.length(); i++) {
			sum += (int) key.charAt(i);
		}
		
		return sum;
	}
	
	
	
}
