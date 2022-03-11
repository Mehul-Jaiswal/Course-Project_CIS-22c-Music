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
    public int compare(Product p1, Product p2) {
        if (p1.getUID().compareTo(p2.getUID()) == 0)
            return 0;
        else if (p1.getUID().compareTo(p2.getUID()) < 0)
            return -1;
        else //(p1.getUID().compareTo(p2.getUID()) > 0)
            return 1;
	}
}
