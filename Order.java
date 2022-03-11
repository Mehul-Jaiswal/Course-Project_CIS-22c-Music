//Orders are added to the heap

//overnight shipping 1?
//rush shipping 2?
//standard shipping 3?

//order search:
//order id

//

import java.util.Comparator;
import java.util.LinkedList;

import Customer;
import Product;


public class Order {

 

	private int orderID;
	private Customer customer;
	private String date;
	private LinkedList<Product> orderContents; //fill in Product based on your own product class
	private int shippingSpeed; //or use enums
	private int priority; 

    

//getters, setters, constructors go here
	
//*****************CONSTRUCTORS********************
	
	/**
	 * Creates a new Order
	 * @param orderID orderID 
	 * @param costumer customer for order
	 * @param date of the order
	 * @param orderContents whats in the order
	 * @param shippingSpeed decided by customer
	 * @param priority for the heap 
	 */
	public Order(int orderID, Customer costumer, String date, LinkedList<Product> orderContents,
			int shippingSpeed, int priority) {
		
		this.orderID = orderID;
		this.customer = customer;
		this.date = date;
		this.orderContents<Product> = orderContents;
		this.shippingSpeed = shippingSpeed;
		
		
		this.priority = priority;
		
	}

	
//*****************GETTERS********************
	
	/**
	 * get the order ID
	 * @return the order ID
	 */
	public int getOrderID() {
		return orderID;
	}
	
	/**
	 * return the customer of the order
	 * @return customer of order
	 */
	public Customer getCustomer() {
		return customer;
	}
	
	/**
	 * return date of order
	 * @return date of order
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * return product list
	 * @return product list of order
	 */
	public LinkedList<Product> getOrderContents() {
		return orderContents;
	}
	
	/**
	 * get the speed of shipping
	 * @return speed of shipping
	 */
	public int getShippingSpeed() {
		return shippingSpeed;
	}
	
	/**
	 * get the priority of the order
	 * @return priority of the order
	 */
	public int getPriority() {
		return priority;
	}
	
	

//*****************SETTERS********************
	
	/**
	 * set the order ID
	 * @param orderID of the order
	 */
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	
	/**
	 * set the customer
	 * @param customer of the order
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	/**
	 * return date of order
	 * @return date of order
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * set the contents of the order
	 * @param orderContents of the order
	 */
	public void setOrderContents(LinkedList<Product> orderContents) {
		this.orderContents = orderContents;
	}
	
	/**
	 * set the shipping speed
	 * @param shippingSpeed of the order
	 */
	public void setShippingSpeed(int shippingSpeed) {
		 this.shippingSpeed = shippingSpeed;
	}
	
	/**
	 * set the priority of the order
	 * @param priority of the order
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
		
	

//*****************COMPARATORS********************
 
public class priorityComparator implements Comparator<Order> {

	public int compare(Order arg0, Order arg1) {
		return arg0.priority - arg1.priority;
	}
	
	public boolean equals(Object o) {
		if (o == this) {
	        return true;
	    } else if (!(o instanceof Order)) {
	        return false;
	    } else { // now safe to cast
	        Order p = (Order) o;
	        return priority == p.priority;         
	    }
	}
	
}

public class customerNameComparator implements Comparator<Order> {

	public int compare(Order arg0, Order arg1) {
		return String.compare(arg0.customer.getName(),arg1.customer.getName());
	}
	
	public boolean equals(Object o) {
		if (o == this) {
	        return true;
	    } else if (!(o instanceof Order)) {
	        return false;
	    } else { // now safe to cast
	        Order p = (Order) o;
	        return customer.getName().equals(p.customer.getName());         
	    }
	}
	
}

public class orderIDComparator implements Comparator<Order> {

	public int compare(Order arg0, Order arg1) {
		return 0;
	}
	
	public boolean equals(Order order) {
		return false;
	}
	
}


}

////Should also contain three Comparator classes, 
//each with an equals and compare method to make comparison 
//depending on priority, customer name or order id.
