
/**
 * BST.java
 * @author Mehul Jaiswal
 * @author Brandon Lee
 * CIS 22C Final Course Project
 */
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Comparator;

@SuppressWarnings("hiding")
public class BST<Product> {
	class Node {
		public Product data;
		public Node left;
		public Node right;

		public Node(Product data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	public Node root;
	private ArrayList<Product> list;

	/*** CONSTRUCTORS ***/

	/**
	 * Default constructor for BST sets root to null
	 */
	public BST() {
		root = null;
		list = new ArrayList<Product>();
	}

	/**
	 * Copy constructor for BST
	 * 
	 * @param bst the BST to make a copy of
	 */
	public BST(BST<Product> bst) {
		if (bst == null || bst.isEmpty()) {
			return;
		}
		copyHelper(bst.root);
	}

	/**
	 * Helper method for copy constructor
	 * 
	 * @param node the node containing data to copy
	 */
	private void copyHelper(Node node) {
		if (node == null) {
			return;
		}
		insert((String) node.data);
		copyHelper(node.left);
		copyHelper(node.right);
	}

	/*** ACCESSORS ***/

	/**
	 * Returns the data stored in the root
	 * 
	 * @precondition !isEmpty()
	 * @return the data stored in the root
	 * @throws NoSuchElementException when precondition is violated
	 */
	public Product getRoot() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("getRoot(): the tree is empty");
		}
		return root.data;
	}

	/**
	 * Determines whether the tree is empty
	 * 
	 * @return whether the tree is empty
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Returns the current size of the tree (number of nodes)
	 * 
	 * @return the size of the tree
	 */
	public int getSize() {
		return getSize(root);
	}

	/**
	 * Helper method for the getSize method
	 * 
	 * @param node the current node to count
	 * @return the size of the tree
	 */
	private int getSize(Node node) {
		if (node == null) {
			return 0;
		}
		return getSize(node.left) + getSize(node.right) + 1;
	}

	/**
	 * Returns the height of tree by counting edges.
	 * 
	 * @return the height of the tree
	 */
	public int getHeight() {
		return getHeight(root);
	}

	/**
	 * Helper method for getHeight method
	 * 
	 * @param node the current node whose height to count
	 * @return the height of the tree
	 */
	private int getHeight(Node node) {
		if (node == null) {
			return -1;
		}
		return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
	}

	/**
	 * Returns the smallest value in the tree
	 * 
	 * @precondition !isEmpty()
	 * @return the smallest value in the tree
	 * @throws NoSuchElementException when the precondition is violated
	 */
	public Product findMin() throws NoSuchElementException {
		if (root == null) {
			throw new NoSuchElementException("findMin(): the tree is null");
		}
		return findMin(root);
	}

	/**
	 * Helper method to findMin method
	 * 
	 * @param node the current node to check if it is the smallest
	 * @return the smallest value in the tree
	 */
	private Product findMin(Node node) {
		if (node.left == null) {
			return node.data;
		}
		return findMin(node.left);
	}

	/**
	 * Returns the largest value in the tree
	 * 
	 * @precondition !isEmpty()
	 * @return the largest value in the tree
	 * @throws NoSuchElementException when the precondition is violated
	 */
	public Product findMax() throws NoSuchElementException {
		if (root == null) {
			throw new NoSuchElementException("findMax(): the tre is null");
		}
		return findMax(root);
	}

	/**
	 * Helper method to findMax method
	 * 
	 * @param node the current node to check if it is the largest
	 * @return the largest value in the tree
	 */
	private Product findMax(Node node) {
		if (node.right == null) {
			return node.data;
		}
		return findMax(node.right);
	}

	/*** MUTATORS ***/

	/**
	 * Inserts a new node in the tree
	 * 
	 * @param vertices the data to insert
	 */
	public void insert(String data) {
		insert(data, root);
	}

	/**
	 * Helper method to insert Inserts a new value in the tree
	 * 
	 * @param data the data to insert
	 * @param node the current node in the search for the correct location in which
	 *             to insert
	 */
	@SuppressWarnings("unchecked")
	void insert(String data, Node node) {
		if (isEmpty()) {
			root = new Node((Product) data);
		} else {
			if (((String) node.data).compareTo((String) data) < 0) {
				if (node.right == null) {
					node.right = new Node((Product) data);
				} else {
					insert(data, node.right);
				}
			} else {
				if (node.left == null) {
					node.left = new Node((Product) data);
				} else {
					insert(data, node.left);
				}
			}
		}
	}

	/**
	 * Removes a value from the BST
	 * 
	 * @param data the value to remove
	 * @precondition !isEmpty()
	 * @throws IllegalStateException when BST is empty
	 */
	public void remove(Product data) throws IllegalStateException {
		if (root == null) {
			throw new IllegalStateException("The tree is empty");
		} else {
			root = remove(data, root);
		}
	}

	/**
	 * Helper method to the remove method
	 * 
	 * @param data the data to remove
	 * @param node the current node
	 * @return an updated reference variable
	 */
	private Node remove(Product data, Node node) {
		if (node == null) {
			return node;
		} else {
			if (((String) node.data).compareTo((String) data) < 0) {
				node.right = remove(data, node.right);
			} else if (((String) node.data).compareTo((String) data) > 0) {
				node.left = remove(data, node.left);
			} else {

				if (node.left == null) {
					return node.right;
				} else if (node.right == null) {
					return node.left;
				} else {
					node.data = findMin(node.right);
					node.right = remove(node.data, node.right);
				}
			}
		}
		return node;
	}

	/*** ADDITIONAL OPERATIONS ***/

	/**
	 * Searches for a specified value in the tree
	 * 
	 * @param data the value to search for
	 * @return whether the value is stored in the tree
	 */
	public boolean search(Product data) {
		if (root == null) {
			return false;
		} else {
			return search(data, root);
		}
	}

	/**
	 * Helper method for the search method
	 * 
	 * @param data the data to search for
	 * @param node the current node to check
	 * @return whether the data is stored in the tree
	 */
	private boolean search(Product data, Node node) {
		if (((String) node.data).compareTo((String) data) == 0) {
			return true;
		} else if (((String) node.data).compareTo((String) data) < 0) {
			if (node.right == null) {
				return false;
			} else {
				return search(data, node.right);
			}
		} else {
			if (node.left == null) {
				return false;
			} else {
				return search(data, node.left);
			}
		}
	}

	/**
	 * Searches for a specified value in the tree
	 * 
	 * @param input_name the value to search for
	 * @return whether the value is stored in the tree
	 */
	public Product searchByName(String input_name, Comparator<Product> comparator) {
		if (isEmpty())
			return null;
		else
			return searchByName(input_name, root, comparator);
	}

	/**
	 * Helper method for the search method
	 * 
	 * @param data the data to search for
	 * @param node the current node to check
	 * @return whether the data is stored in the tree
	 */
	@SuppressWarnings("unchecked")
	private Product searchByName(String data, Node node, Comparator<Product> comparator) {
		// Product ob = new Product(" "," "," ",0.0,0.0," "," ",0);
		// CompareByName ob = new CompareByName();
		int x = comparator.compare((Product) data, node.data);
		if (x == 0)
			return node.data;
		if (x < 0) {
			if (node.left == null)
				return null;
			else
				return searchByName(data, node.left, comparator);
		} else {
			if (node.right == null)
				return null;
			else
				return searchByName(data, node.right, comparator);
		}
	}

	/**
	 * Searches for a specified value in the tree
	 * 
	 * @param data the value to search for
	 * @return whether the value is stored in the tree
	 */
	public Product searchByUID(String data, Comparator<Product> comparator) {
		if (isEmpty())
			return null;
		else
			return searchByUID(data, root, comparator);
	}

	/**
	 * Helper method for the search method
	 * 
	 * @param data the data to search for
	 * @param node the current node to check
	 * @return whether the data is stored in the tree
	 */
	@SuppressWarnings("unchecked")
	private Product searchByUID(String data, Node node, Comparator<Product> comparator) {
		// CompareByID ob = new CompareByID();
		int x = comparator.compare((Product) data, node.data);
		if (x == 0)
			return node.data;
		if (x < 0) {
			if (node.left == null)
				return null;
			else
				return searchByUID(data, node.left, comparator);
		} else {
			if (node.right == null)
				return null;
			else
				return searchByUID(data, node.right, comparator);
		}
	}

	/***
	 * ADDITIONAL OPERATIONS
	 * 
	 * @return
	 ***/

	public void sortByPrimary() {
		list.clear();
		inOrderString();

	}

	public void sortBySecondary() {
		list.clear();
		inOrderString();
	}

	// ************Strings************
	/**
	 * Returns a String containing the data in post order
	 * 
	 * @return a String of data in post order
	 */
	public String preOrderString() {
		StringBuilder str = new StringBuilder();
		preOrderString(root, str);
		return str + "\n";
	}

	/**
	 * Helper method to preOrderString Inserts the data in pre order into a String
	 * 
	 * @param node     the current Node
	 * @param preOrder a String containing the data
	 */
	private void preOrderString(Node node, StringBuilder preOrder) {
		if (node == null) {
			return;
		}
		preOrder.append(node.data + " ");
		preOrderString(node.left, preOrder);
		preOrderString(node.right, preOrder);
	}

	/**
	 * Returns a String containing the data in order
	 * 
	 * @return a String of data in order
	 */
	public String inOrderString() {
		StringBuilder str = new StringBuilder();
		inOrderString(root, str);
		return str.append("\n").toString();
	}

	/**
	 * Helper method to inOrderString Inserts the data in order into a String
	 * 
	 * @param node    the current Node
	 * @param inOrder a String containing the data
	 */
	private void inOrderString(Node node, StringBuilder inOrder) {
		if (node == null) {
			return;
		}
		inOrderString(node.left, inOrder);
		inOrder.append(node.data + "\n ");
		list.add(node.data);
		inOrderString(node.right, inOrder);
	}

	/**
	 * Returns a String containing the data in post order
	 * 
	 * @return a String of data in post order
	 */
	public String postOrderString() {
		StringBuilder str = new StringBuilder();
		postOrderString(root, str);
		return str + "\n";
	}

	/**
	 * Helper method to postOrderString Inserts the data in post order into a String
	 * 
	 * @param node      the current Node
	 * @param postOrder a String containing the data
	 */
	private void postOrderString(Node node, StringBuilder postOrder) {
		if (node == null) {
			return;
		}
		postOrderString(node.left, postOrder);
		postOrderString(node.right, postOrder);
		postOrder.append(node.data + " ");
	}

	public ArrayList<Product> getProducts() {
		return list;
	}

}
