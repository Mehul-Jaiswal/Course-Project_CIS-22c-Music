/**
 * CompareByID.java
 * @author Mehul Jaiswal
 * CIS 22C, course project Team 1
 */
import java.util.Comparator;

public class CompareByID implements Comparator<Product>{
	/**
     * Compares two Product objects by secondary key to determine ordering
     * Returns 0 if the two items are equal
     * Return -1 if this Product's UID comes alphabetically
     * before the other Product's UID.
     * Returns 1 if the other Product's productId comes
     * alphabetically before this Product's productId
     * @param the other Product object to compare to this
     * @return 0 (same Product), -1 (this Product ordered first)
     * or 1 (the other Product ordered first)
     */
	@Override
    public int compare(Product p1, Product p2) {
	Product s1=(Product)p1;  
	Product s2=(Product)p2;
    	return s1.getUID().compareTo(s2.getUID());
	}
}
