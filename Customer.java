

public class Customer extends User {
	
	private String address;
	private String city;
	private String state;
	private String zip;
	private LinkedList<Order> shippedOrders;
	private LinkedList<Order> unshippedOrders;

	
	public Customer() {
		firstName = null;
		lastName = null;
		username = null;
		password = null;
		address = null;
		city = null;
		state = null;
		zip = null;
	}

  public Customer(String username) {
		this.username = username;
  }
	
	public Customer(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Customer(String firstName, String lastName, String username, String password, String address, String city, String state, String zip) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public String getAddress() {
		return address;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getZip() {
		return zip;
	}
	
	public void setAddress(String newAddress) {
		address = newAddress;
	}
	public void setCity(String newCity) {
		city = newCity;
	}
	public void setState(String newState) {
		state = newState;
	}
	public void setZip(String newZip) {
		zip = newZip;
	}
  public LinkedList<Order> getshippedOrders(){
    return shippedOrders;
  }
  public LinkedList<Order> getunshippedOrders(){
    return unshippedOrders;
  }
  public void setshippedOrders(LinkedList<Order> so){
    shippedOrders = so;
  }
  public void setunshippedOrders(LinkedList<Order> uso){
    unshippedOrders = uso;
  }

  @Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		else if (!(o instanceof Customer)) {
			return false;
		}
		else {
			Customer myCustomer = (Customer) o;
			if (this.password.equals(myCustomer.password) && this.username.equals(myCustomer.username)) {
				return true;
			}
			else {
				return false;
			}
		}
		
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
