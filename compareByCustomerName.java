import java.util.Comparator;

public class customerNameComparator implements Comparator<Order> {
	
  /**
     * Compares two Customer objects by primary key - name to determine ordering
     * Returns 0 if the two items are equal
     * Return -1 if this Customer's name comes alphabetically
     * before the other Customer's name.
     * Returns 1 if the other Customer's name comes
     * alphabetically before this Customer's name
     * @param the other Customer object to compare to this
     * @return 0 (same Customer), -1 (this Customer ordered first)
     * or 1 (the other Customer ordered first)
     */
  @Override
	public int compare(Order arg0, Order arg1) {
		return String.compare(arg0.customer.getName(), arg1.customer.getName());
	}
	
  /**
  * Compares two Customer objects by
  */
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
