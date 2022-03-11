/**
 * Product.java
 * @author Mehul Jaiswal
 * CIS 22C, course project Team 1
 */
public class Product {
    private String name;
    private String UID;
    private String singer;
    private double duration;
    private String genre;
    private String release_year;
    private double cost;
    private int numInStock;

    /**
     * Constructor for the Product class
     * @param name the Product's name
     * @param UID the Product's UID
     * @param singer of the product
     * @param cost the product
     * @param duration of the product
     * @param release year of the product
     * @param genre of the product
     * @param number of the stocks of the product
     */
    public Product(String name, String UID, String singer, double cost, double duration, String release_year, String genre, int numInStock) {
        this.name = name;
        this.UID = UID;
        this.duration = duration;
        this.singer = singer;
        this.cost = cost;
        this.genre = genre;
        this.release_year = release_year;
        this.numInStock = numInStock;
    }

    /**
     * Accesses the Release Year of the Product
     * @return the Product's name
     */
    public String getReleaseYear() {
        return release_year;
    }

    /**
     * Accesses the genre of the Product
     * @return the Product's name
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Accesses the duration of the Product
     * @return the Product's name
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Accesses the id of the Product
     * @return the name of the product
     */
    public String getName() {
        return name;
    }

    public String getUID() {
        return UID;
    }
    
    /**
     * Access the singer of the Product
     * @return the singer of the Product
     */
    public String getSinger() {
        return singer;
    }

    /**
     * Access the cost of the Product in dollars
     * @return the Product's cost in dollars
     */
    public double getCost() {
        return cost;
    }
    
    /**
     * Accesses the number of stock of the Product
     * @return the Product's name
     */
    public int getNumInStock() {
        return numInStock;
    }

    /**
     * Sets the duration of the Product
     * @param name the Product's name
     */
    public void setDuration(double duration) {
        this.duration = duration;
    }

    /**
     * Sets the name of the Product
     * @param productId the Product's productId
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the id of the Product
     * @param productId the Product's productId
     */
    public void setUID(String UID) {
        this.UID = UID;
    }
    
    /**
     * Sets the singer of the Product
     * @param unitPrice the unitPrice of the Product
     */
    public void setSinger(String singer) {
        this.singer = singer;
    }

    /**
     * Sets the release year of the Product
     * @return the Product's name
     */
    public void setReleaseYear(String release_year) {
        this.release_year = release_year;
    }

    /**
     * Sets the genre of the Product
     * @return the Product's name
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    /**
     * Sets the cost of the Product
     * in dollars
     * @param cost the cost of the Product
     * in dollars
     */
    public void setCost(double cost) {
        this.cost = cost;
    }
    
    /**
     * Sets the number in stock of the Product
     * @param name the Product's name
     */
    public void setNuminStock(int numInStock) {
        this.numInStock = numInStock;
    }

    /**
     * Formats the Music Album for display, using
     * the following format:
     * <name>,<UID>,<singer>,<cost>,<duration>,<release year>,<genre>,<number of stock>
     */
    @Override 
    public String toString() {
        String result = name + "," + UID + "," + singer + "," + cost + "," + duration + "," + release_year + "," + genre + "," + numInStock + "\n";
        return result;
    }

    /**
     * Determines whether two Product objects are
     * equal by comparing names and productIds
     * @param otherProduct the second Product object
     * @return whether the Products are equal
     */
    @Override 
    public boolean equals(Object o) {
        return ((Product)o).getName().equals(name);
    }

//    /**
//     * Compares two Product objects to determine ordering
//     * Returns 0 if the two items are equal
//     * Return -1 if this Product's name comes alphabetically
//     * before the other Product's name.
//     * Returns 1 if the other Product's name comes
//     * alphabetically before this Product's name
//     * If the two Product's names are the same, will
//     * differentiate by product's productIds (alphabetical
//     * comparison)
//     * @param the other Product object to compare to this
//     * @return 0 (same Product), -1 (this Product ordered first)
//     * or 1 (the other Product ordered first)
//     */
//    public int compareTo(Product p2) {
//        if (this.equals(p2))
//            return 0;
//        else if (name.compareTo(p2.getName()) > 0)
//            return 1;
//        else if (name.compareTo(p2.getName()) < 0)
//            return -1;
//        else {
//            if (UID.compareTo(p2.getUID()) < 0)
//                return -1;
//            else
//                return 1;
//        }
//    }

    /**
     * Returns a consistent hash code for
     * each Product by summing the Unicode values
     * of each character in the key
     * Key = name + productId
     * @return the hash code
     */
    @Override public int hashCode() {
        String key = name + UID; //define key for this class
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum += (int) key.charAt(i);
        }
        return sum;
    }
}
