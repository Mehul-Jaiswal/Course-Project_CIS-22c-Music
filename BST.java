
/**
 * BST.java
 * @author Mehul Jaiswal
 * CIS 22C Lab 4
 */
import java.util.NoSuchElementException;
import java.util.ArrayList;
//import java.util.Comparator;

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
		insert(node.data);
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
	 * @param data the data to insert
	 */
	public void insert(Product data) {
		insert(data, root);
	}

	/**
	 * Helper method to insert Inserts a new value in the tree
	 * 
	 * @param data the data to insert
	 * @param node the current node in the search for the correct location in which
	 *             to insert
	 */
	private void insert(Product data, Node node) {
		if (isEmpty()) {
			root = new Node(data);
		} else {
			if (((String) node.data).compareTo((String) data) < 0) {
				if (node.right == null) {
					node.right = new Node(data);
				} else {
					insert(data, node.right);
				}
			} else {
				if (node.left == null) {
					node.left = new Node(data);
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
	 * @param data the value to search for
	 * @return whether the value is stored in the tree
	 */
	public Product searchByName(Product data) {
		if (isEmpty())
			return null;
		else
			return searchByName(data, root);
	}

	/**
	 * Helper method for the search method
	 * 
	 * @param data the data to search for
	 * @param node the current node to check
	 * @return whether the data is stored in the tree
	 */
	private Product searchByName(Product data, Node node) {
		// Product ob = new Product(" "," "," ",0.0,0.0," "," ",0);
		CompareByName ob = new CompareByName();
		int x = ob.compare(data, node.data);
		if (x == 0)
			return node.data;
		if (x < 0) {
			if (node.left == null)
				return null;
			else
				return searchByName(data, node.left);
		} else {
			if (node.right == null)
				return null;
			else
				return searchByName(data, node.right);
		}
	}

	/**
	 * Searches for a specified value in the tree
	 * 
	 * @param data the value to search for
	 * @return whether the value is stored in the tree
	 */
	public Product searchByUID(Product data) {
		if (isEmpty())
			return null;
		else
			return searchByUID(data, root);
	}

	/**
	 * Helper method for the search method
	 * 
	 * @param data the data to search for
	 * @param node the current node to check
	 * @return whether the data is stored in the tree
	 */
	private Product searchByUID(Product data, Node node) {
		CompareByID ob = new CompareByID();
		int x = ob.compare(data, node.data);
		if (x == 0)
			return node.data;
		if (x < 0) {
			if (node.left == null)
				return null;
			else
				return searchByUID(data, node.left);
		} else {
			if (node.right == null)
				return null;
			else
				return searchByUID(data, node.right);
		}
	}

//	/**
//	 * Determines whether two trees store identical data in the same structural
//	 * position in the tree
//	 * 
//	 * @param o another Object
//	 * @return whether the two trees are equal
//	 */
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	@Override
//	public boolean equals(Object o) {
//		return equals(root, ((BST) o).root);
//	}
//
//	/**
//	 * Helper method for the equals method
//	 * 
//	 * @param node1 the node of the first bst
//	 * @param node2 the node of the second bst
//	 * @return whether the two trees contain identical data stored in the same
//	 *         structural position inside the trees
//	 */
//	private boolean equals(Node node1, Node node2) {
//		if (node1 == null && node2 == null)
//			return true;
//
//		if (node1 != null && node2 != null) {
//			return ((node1.data == node2.data) && equals(node1.left, node2.left) && equals(node1.right, node2.right));
//		}
//
//		return false;
//	}

	/*** ADDITIONAL OPERATIONS ***/

	public void sortByPrimary() {
		list.clear();
		inOrderString();
	}

//    private void bubblesortByPrimary(){
//        int i, j;
//        Product temp;
//        int n = list.size();
//        boolean swapped;
//        for (i = 0; i < n - 1; i++)
//        {
//            swapped = false;
//            for (j = 0; j < n - i - 1; j++)
//            {
//                if (compare(list.get(j),list.get(j + 1)) > 0)
//                {
//                    // swap arr[j] and arr[j+1]
//                    temp = list.get(j);
//                    list.set(j, list.get(j + 1));
//                    list.set(j + 1, temp);
//                    swapped = true;
//                }
//            }
//
//            // If no two elements were
//            // swapped by inner loop, then break
//            if (swapped == false)
//                break;
//        }
//    }

	public void sortBySecondary() {
		list.clear();
		inOrderString();
		// bubblesortBySecondary();
	}

//    private void bubblesortBySecondary()
//    {
//        int i, j;
//        Product temp;
//        int n = list.size();
//        boolean swapped;
//        for (i = 0; i < n - 1; i++)
//        {
//            swapped = false;
//            for (j = 0; j < n - i - 1; j++)
//            {
//                if (compare(list.get(j),list.get(j + 1)) > 0)
//                {
//                    // swap arr[j] and arr[j+1]
//                    temp = list.get(j);
//                    list.set(j, list.get(j + 1));
//                    list.set(j + 1, temp);
//                    swapped = true;
//                }
//            }
//
//            // IF no two elements were
//            // swapped by inner loop, then break
//            if (swapped == false)
//                break;
//        }
//    }
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
		inOrder.append(node.data + " ");
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
