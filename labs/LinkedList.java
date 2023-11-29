
/**
 * Defines a doubly-linked list class
 * @author Mehul Jaiswal
 * @author Dinh Danh Nguyen
 */

import java.util.NoSuchElementException;

public class LinkedList<T> {
	private class Node {
		private T data;
		private Node next;
		private Node prev;

		public Node(T data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	private int length;
	private Node first;
	private Node last;
	private Node iterator;

	/**** CONSTRUCTORS ****/

	/**
	 * Instantiates a new LinkedList with default values
	 * 
	 * @postcondition Assign default value for member variable
	 */
	public LinkedList() {
		length = 0;
		first = null;
		last = null;
		iterator = null;

	}

	/**
	 * Converts the given array into a LinkedList
	 * 
	 * @param array the array of values to insert into this LinkedList
	 * @postcondition Assign the same value of the list as that of the array
	 */
	public LinkedList(T[] array) {
		length = 0;
		first = null;
		last = null;
		iterator = null;
		if (array == null) {
			return;
		}
		for (int i = 0; i < array.length; i++) {
			Node newNode = new Node(array[i]);
			if (first == null) {
				first = newNode;
				last = newNode;
			} else {
				last.next = newNode;
				newNode.prev = last;
				last = newNode;
			}
			++length;
		}

	}

	/**
	 * Instantiates a new LinkedList by copying another List
	 * 
	 * @param original the LinkedList to copy
	 * @postcondition a new List object, which is an identical, but separate, copy
	 *                of the LinkedList original
	 */
	public LinkedList(LinkedList<T> original) {

		if (original == null) {
			return;
		}
		if (original.length == 0) {
			length = 0;
			first = null;
			last = null;
			iterator = null;
		}

		else {

			Node temp = original.first;
			while (temp != null) {
				addLast(temp.data);
				temp = temp.next;
			}
			iterator = null;

		}

	}

	/**** ACCESSORS ****/

	/**
	 * Returns the value stored in the first node
	 * 
	 * @precondition checks if the list is not empty(length != 0)
	 * @return the value stored at node first
	 * @throws NoSuchElementException if the list is empty(when the precondition is
	 *                                violated)
	 */
	public T getFirst() throws NoSuchElementException {
		if (length == 0) {
			throw new NoSuchElementException("getFirst: " + "List is Empty. No data to access!");
		}
		return first.data;
	}

	/**
	 * Returns the value stored in the last node
	 * 
	 * @precondition check is list is not empty(length != 0)
	 * @return the value stored in the node last
	 * @throws NoSuchElementException if this list is empty(when the precondition is
	 *                                violated)
	 */
	public T getLast() throws NoSuchElementException {
		if (length == 0) {
			throw new NoSuchElementException("getLast: " + "List is Empty. No data to access!");
		}
		return last.data;
	}

	/**
	 * Returns the data stored in the iterator node
	 * 
	 * @precondition iterator !=null
	 * @throw NullPointerException throw exception if precondition is violated
	 */
	public T getIterator() throws NullPointerException {
		if (iterator == null) {
			throw new NullPointerException("getIterator(): iterator point to null");
		}
		return iterator.data;
	}

	/**
	 * Returns the current length of the LinkedList
	 * 
	 * @return the length of the LinkedList from 0 to n
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Returns whether the LinkedList is currently empty
	 * 
	 * @return whether the LinkedList is empty
	 */
	public boolean isEmpty() {
		return length == 0;
	}

	/**
	 * Returns whether the iterator is offEnd, i.e. null
	 * 
	 * @return whether the iterator is null
	 */
	public boolean offEnd() {
		return iterator == null;
	}

	/**** MUTATORS ****/

	/**
	 * Creates a new first element
	 * 
	 * @param data the data to insert at the front of the LinkedList
	 * @postcondition a new node is created in the head of the list
	 */
	public void addFirst(T data) {
		if (length == 0) {
			first = last = new Node(data);
		} else {
			Node N = new Node(data);
			N.next = first;
			first.prev = N;
			first = N;
		}
		length++;
	}

	/**
	 * Creates a new last element
	 * 
	 * @param data the data to insert at the end of the LinkedList
	 * @postcondition a new node created
	 */
	public void addLast(T data) {
		if (length == 0) {
			first = last = new Node(data);
		} else {
			Node n = new Node(data);
			last.next = n;
			n.prev = last;
			last = last.next; // alternately last = n;
		}
		length++;
	}

	/**
	 * Inserts a new element after the iterator
	 * 
	 * @param data the data to insert
	 * @precondition iterator!=null
	 * @throws NullPointerException throws a NullPointerException if precondition is
	 *                              violated
	 */
	public void addIterator(T data) throws NullPointerException {
		if (iterator == null) {
			throw new NullPointerException("addIterator: Iterator is null");
		}
		if (iterator == last) {
			addLast(data);
		} else {
			Node n = new Node(data);
			n.prev = iterator;
			n.next = iterator.next;
			iterator.next = n;
			iterator.next.prev = n;
			length++;
		}
	}

	/**
	 * removes the element at the front of the LinkedList
	 * 
	 * @precondition linked list is not empty
	 * @postcondition remove the node at first
	 * @throws NoSuchElementException if the list is empty, it throw exception
	 */
	public void removeFirst() throws NoSuchElementException {
		if (length == 0) { // precondition
			throw new NoSuchElementException("removeFirst(): Cannot remove from an empty List!");
		} else if (length == 1) { // edge case #1
			first = last = iterator = null;
		} else {
			if (iterator == first) { // edge case #2
				iterator = null;
			}
			// general case:
			first = first.next;
			first.prev = null;
		}
		--length;
	}

	/**
	 * removes the element at the end of the LinkedList
	 * 
	 * @precondition if the linked list is empty or not
	 * @postcondition remove the node at last
	 * @throws NoSuchElementException if the list is empty, it throw exception
	 */
	public void removeLast() throws NoSuchElementException {
		if (length == 0) { // precondition
			throw new NoSuchElementException("removeLast(): Cannot remove from an empty List!");
		} else if (length == 1) { // edge case #1
			first = last = iterator = null;
		} else {
			if (iterator == last) { // edge case #2
				iterator = null;
			}
			// general case:

			last = last.prev;
			last.next = null;
		}
		--length;
	}

	/**
	 * removes the element referenced by the iterator
	 * 
	 * @precondition iterator != null
	 * @postcondition remove the node that iterator point to
	 * @throws NullPointerException throw exception if iterator is null
	 */
	public void removeIterator() throws NullPointerException {
		if (iterator == null) {// precondition
			throw new NullPointerException("removeIterator(): iterator reference to null");
		}
		if (iterator == first) {// edge case 1

			removeFirst();

		} else if (iterator == last) {// edge case 2

			removeLast();
		} else {// general
			Node beforeIteratorNode = iterator.prev;
			Node afterIteratorNode = iterator.next;

			beforeIteratorNode.next = afterIteratorNode;
			afterIteratorNode.prev = beforeIteratorNode;

			iterator = null;
			length--;
		}
	}

	/**
	 * places the iterator at the first node
	 * 
	 * @postcondition set iterator to the first node
	 */
	public void positionIterator() {
		iterator = first;
	}

	/**
	 * Moves the iterator one node towards the last
	 * 
	 * @precondition iterator != null
	 * @postcondition iterator move the next node toward the end
	 * @throws NullPointerException throw exception if precondition is violated
	 */
	public void advanceIterator() throws NullPointerException {
		if (iterator == null) {
			throw new NullPointerException("advanceIterator(): the iterator is null");
		}
		iterator = iterator.next;
	}

	/**
	 * Moves the iterator one node towards the first
	 * 
	 * @precondition iterator != null
	 * @postcondition iterator move to the previous node toward the first
	 * @throws NullPointerException throw exception if precondition is violated
	 */
	public void reverseIterator() throws NullPointerException {
		if (iterator == null) {
			throw new NullPointerException("advanceIterator(): the iterator is null");
		}
		iterator = iterator.prev;
	}

	/**** ADDITIONAL OPERATIONS ****/

	/**
	 * Converts the LinkedList to a String, with each value separated by a blank
	 * line At the end of the String, place a new line character
	 * 
	 * @return the LinkedList as a String
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		Node temp = first;
		while (temp != null) {
			result.append(temp.data + " ");
			temp = temp.next;
		}
		return result.toString() + "\n";
	}

	/**
	 * Determines whether the given Object is another LinkedList, containing the
	 * same data in the same order
	 * 
	 * @param o another Object
	 * @return whether there is equality
	 */
	@SuppressWarnings("unchecked") // good practice to remove warning here
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof LinkedList)) {
			return false;
		} else {
			LinkedList<T> L = (LinkedList<T>) o;
			if (this.length != L.length) {
				return false;
			} else {
				Node temp1 = this.first;
				Node temp2 = L.first;
				while (temp1 != null || temp2 != null) {
					if ((temp1.data).equals(temp2.data)) {
						temp1 = temp1.next;
						temp2 = temp2.next;
					} else {
						return false;
					}
				}

			}
			return true;
		}
	}

	/** CHALLENGE METHODS */

	/**
	 * Zippers two LinkedLists to create a third List which contains alternating
	 * values from this list and the given parameter For example: [1,2,3] and
	 * [4,5,6] -> [1,4,2,5,3,6] For example: [1, 2, 3, 4] and [5, 6] -> [1, 5, 2, 6,
	 * 3, 4] For example: [1, 2] and [3, 4, 5, 6] -> [1, 3, 2, 4, 5, 6]
	 * 
	 * @param list the second LinkedList in the zipper
	 * @return a new LinkedList, which is the result of zippering this and list
	 * @postcondition this and list are unchanged
	 */
	public LinkedList<T> zipperLists(LinkedList<T> list) {
		if (this.length != 0 && list.length != 0) {
			LinkedList<T> temp = new LinkedList<T>();

			Node head = first;
			Node head1 = list.first;
			while (head1 != null || head != null) {
				if (head1 != null && head != null) {
					temp.addLast(head.data);
					temp.addLast(head1.data);

					head = head.next;
					head1 = head1.next;

				} else {
					if (head1 != null) {
						temp.addLast(head1.data);
						head1 = head1.next;
					}
					if (head != null) {
						temp.addLast(head.data);
						head = head.next;
					}

				}

			}

			return temp;
		} else {
			if (this.length == 0 && list.length == 0) {
				return new LinkedList<>();
			} else if (this.length == 0) {
				return new LinkedList<>(list);
			} else {
				return new LinkedList<>(this);
			}
		}
	}

	/**
	 * Determines whether a LinkedList is reversible, i.e. the data is the same
	 * written both forward and backward e.g. isReversible(1 2 3 2 1) -> true e.g.
	 * isReversible(A B B A) -> true
	 * 
	 * @return whether the list is reversible
	 */
	public boolean isReversible() {
		Node headTravel = first;
		Node tailTravel = last;
		if (length == 0) {
			return true;
		}
		int i = 0;
		while (i < length / 2) {
			if (!(headTravel.data.equals(tailTravel.data))) {
				System.out.println(headTravel.data);
				return false;
			}
			headTravel = headTravel.next;
			tailTravel = tailTravel.prev;
			++i;
		}

		return true;
	}

	// Additional Methods Lab5

	/**
	 * Determines at which index the iterator is located Indexed from 0 to length -
	 * 1
	 * 
	 * @return the index number of the iterator
	 * @precondition iterator!=null
	 * @throws NullPointerException when precondition is violated
	 */
	public int getIteratorIndex() throws NullPointerException {
		if (iterator == null) {
			throw new NullPointerException("Cannot getIteratorIndex(): Iterator is null");
		}
		return findIndex(iterator.data);
	}

	/**
	 * Searches the LinkedList for a given element's index
	 * 
	 * @param data the data whose index to locate
	 * @return the index of the data or -1 if the data is not contained in the
	 *         LinkedList
	 */
	public int findIndex(T data) {
		int i = 0;
		Node n = first;
		while (n != null) {

			if (n.data.equals(data)) {
				return i;
			}
			n = n.next;
			i++;
		}
		return -1;
	}

	/**
	 * Advances the iterator to location within the LinkedList specified by the
	 * given index
	 * 
	 * @param index the index at which to place the iterator.
	 * @precondition iterator==first
	 * @throws NullPointerException when the precondition is violated
	 */
	public void advanceIteratorToIndex(int index) throws NullPointerException {
		if (iterator != first) {
			throw new NullPointerException("Cannot advanceIteratorToIndex: because iterator is not at first");
		}
		int i = index;
		this.positionIterator();
		while (i != 0) {
			this.advanceIterator();
			i--;
		}
	}
}
