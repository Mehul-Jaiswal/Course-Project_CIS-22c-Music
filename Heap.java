
/**
 * @author Ananya Batra
 * @author Bence Danko
 * Final Project
 */

import java.util.Comparator;
import java.util.ArrayList;

public class Heap<T> {

	private int heapSize;
	private ArrayList<T> heap;

	/**
	 * Constructors/
	 * 
	 * /** Constructor for the Heap class
	 * 
	 * @param data an unordered ArrayList Calls buildHeap
	 */
	public Heap(ArrayList<T> data, Comparator<T> comparator) {
		heapSize = data.size();
		heap = data;
		buildHeap(comparator);
	}

	/** Mutators */

	/**
	 * Converts an ArrayList into a valid max heap. Called by constructor Calls
	 * helper method heapify
	 */
	public void buildHeap(Comparator<T> comparator) {
//    	Build-Heap(A)
//
//    	n = Heap_size(A)
//
//    	for (i = floor(n/2) down to 1) //start at floor(n/2); we can ignore leaf nodes
//
//    	    Max-Heapify(A, i) //call Max-Heapify helper function

		for (int i = heapSize / 2; i > 0; i++) { // check
			heapify(i, comparator);
		}
	}

	/**
	 * helper method to buildHeap, remove, and sort bubbles an element down to its
	 * proper location within the heap
	 * 
	 * @param index an index in the heap
	 */
	private void heapify(int index, Comparator<T> comparator) throws IndexOutOfBoundsException {

//    	Max-Heapify(A, i)
//
//    	l = left(i) //get the index of the left child of A[i] and store as l
//
//    	r = right(i) //get the index of the right child of A[i] and store r
//
//    	//Check if l is off the end of the array (heap) AND compare A[i] to its left child
//
//    	if (l <= Heap_size(A) AND A[l] > A[i])
//
//    	    index_of_max = l //update index_of_max if left is bigger
//
//
//    	//Check if r is off the end of the array (heap) AND compare A[r] to current max value
//
//    	if (r <= Heap_size(A) AND A[r] > A[index_of_max]
//
//    	index_of_max = r //update index_of_max if right is bigger
//
//    	 
//
//    	if (i != index_of_max) //if A[i] was not bigger than its two children
//
//    	    A[i]<--->A[index_of_max] //swap, so now A[i] stored at A[index_of_max]
//
//    	    Max-Heapify(A, index_of_max) //recursively move through tree until restore heap property

		if (index < 1 || index > heapSize) {
			throw new IndexOutOfBoundsException("heapify: index out of bounds");
		}

		int indexOfMax = -1;
		int l = 2 * index;
		int r = 2 * index + 1;

		if (l <= heapSize && comparator.compare(heap.get(l), heap.get(index)) > 0) { // we need the comparator here?
			indexOfMax = l;
		}

		if (l <= heapSize && comparator.compare(heap.get(r), heap.get(indexOfMax)) > 0) { // we need the comparator
																							// here?
			indexOfMax = r;
		}

		if (index != indexOfMax) {
			T temp = heap.get(index);

			heap.set(index, heap.get(indexOfMax));
			heap.set(indexOfMax, temp);

			heapify(indexOfMax, comparator);
		}

	}

	/**
	 * Inserts the given data into heap Calls helper method heapIncreaseKey
	 * 
	 * @param key the data to insert
	 */
	public void insert(T key, Comparator<T> comparator) {
//    	HeapInsert(A, key)
//        Heap_size(A)++ //adding a new value to the heap
//
//        A[Heap_size(A)] = – //make space at end of array for new value
//
//       HeapIncreaseKey(A, Heap_size(A), key) //start at the last index, i=Heap_size(A)

		heapSize++;
		heapIncreaseKey(heapSize, key, comparator);

	}

	/**
	 * Helper method for insert. Bubbles an element up to its proper location
	 * 
	 * @param index the current index of the key
	 * @param key   the data
	 * @precondition
	 */
	private void heapIncreaseKey(int index, T key, Comparator<T> comparator) throws IndexOutOfBoundsException {

//    	HeapIncreaseKey(A, i, key)
//
//        if(key > A[i])
//
//            A[i] = key //write over existing value at i with key
//
//        while (i > 1 AND A[Parent(i)] < A[i])
//
//            //while the parent is smaller and you are not at the root node
//
//           A[i] <--> A[Parent(i)] //Swap parent and child
//
//           i = Parent(i) //keep track of current index of the key

		if (comparator.compare(key, heap.get(index)) > 0) {
			heap.set(index, key);
		}

		while (index > 1 && comparator.compare(heap.get(getParent(index)), heap.get(index)) < 0) {
			T temp = heap.get(index);

			heap.set(index, heap.get(getParent(index)));
			heap.set(getParent(index), temp);

			index = getParent(index);
		}

	}

	/**
	 * removes the element at the specified index Calls helper method heapify
	 * 
	 * @param index the index of the element to remove
	 */
	public void remove(int index, Comparator<T> comparator) throws IndexOutOfBoundsException {

		if (index < 1 || index > heapSize) {
			throw new IndexOutOfBoundsException("remove: index out of bounds");
		}

		heap.set(index, heap.get(heapSize));
		heap.remove(heapSize);
		heapify(index, comparator);
		heapSize--;
	}

	/** Accessors */

	/**
	 * returns the maximum element (highest priority)
	 * 
	 * @return the max value
	 */
	public T getMax() {
		if (heapSize < 1) {
			return null;
		}

		return heap.get(1);
	}

	/**
	 * returns the index of the element given
	 * 
	 * @param data the element searched for
	 * @return int index of element location
	 */
	public int search(T data, Comparator<T> comparator) {

		for(int i = 1; i <= heapSize; i++) {
			if(comparator.compare(data, heap.get(i)) == 0) {
				return i;
			}
		}
		return -1;

	}

	/**
	 * returns the location (index) of the parent of the element stored at index
	 * 
	 * @param index the current index
	 * @return the index of the parent
	 * @precondition 1 <= index <= heapSize
	 * @throws IndexOutOfBoundsException
	 */
	public int getParent(int index) throws IndexOutOfBoundsException {
		if (index < 1 || index > heapSize) {
			throw new IndexOutOfBoundsException("getParent(): Index is out of bounds");
		}
		return (int) Math.floor(index / 2);

	}

	/**
	 * returns the location (index) of the left child of the element stored at index
	 * 
	 * @param index the current index
	 * @return the index of the left child
	 * @precondition 1 <= index <= heapSize
	 * @throws IndexOutOfBoundsException
	 */
	public int getLeft(int index) throws IndexOutOfBoundsException {	
		int result = (2 * index);
		
		if (index < 1 || result > heapSize) {
			throw new IndexOutOfBoundsException("getLeft(): Index is out of bounds");
		}
		
		
		return result;
	}

	/**
	 * returns the location (index) of the right child of the element stored at
	 * index
	 * 
	 * @param index the current index
	 * @return the index of the right child
	 * @precondition 1 <= index <= heapSize
	 * @throws IndexOutOfBoundsException
	 */
	public int getRight(int index) throws IndexOutOfBoundsException {
		
		int result = (2 * index + 1);
		
		if (index < 1 || result > heapSize) {
			throw new IndexOutOfBoundsException("getLeft(): Index is out of bounds");
		}
		
		
		return result;
	}

	/**
	 * returns the heap size (current number of elements)
	 * 
	 * @return the size of the heap
	 */
	public int getHeapSize() {
		return heapSize;
	}

	/**
	 * Gets the element at the specified index
	 * 
	 * @param index at which to access
	 * @return the element at index *
	 * @precondition 1 <= index <= heapSize
	 * @throws IndexOutOfBoundsException
	 */
	public T getElement(int index) throws IndexOutOfBoundsException {
		if (index < 1 || index > heapSize) {
			throw new IndexOutOfBoundsException("getElement(): Index is out of bounds");
		}
		return heap.get(index);
	}

	/** Additional Operations */

	/**
	 * Creates a String of all elements in the heap
	 */
	@Override
	public String toString() {
		return heap.toString();
	}

	/**
	 * Uses the heap sort algorithm to sort the heap into ascending order Calls
	 * helper method heapify
	 * 
	 * @return an ArrayList of sorted elements
	 * @postcondition heap remains a valid heap
	 */
	public ArrayList<T> sort(Comparator<T> comparator) {

//    	HeapSort(A)
//
//        n = Heap_size(A);
//
//        for (i = n down to 2)
//
//            A[1] <--> A[i] //swap
//
//            Heap_size(A)-- //consider your heap to be one smaller
//
//            Max-Heapify(A,1) //restore max heap property
		Heap<T> result = new Heap<T>(heap, comparator);

		for (int i = heapSize; i >= 2; i--) {
			T temp = result.heap.get(1);

			result.heap.set(1, result.heap.get(i));
			result.heap.set(i, temp);

			result.heapSize--;

			result.heapify(1, comparator);
		}

		return result.heap;

	}

}
