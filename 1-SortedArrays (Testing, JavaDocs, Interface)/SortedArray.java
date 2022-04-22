public interface SortedArray {
	
	/** Adds the number n to the array and places it in sorted
	 * order. Re-sizes the array if necessary.
	 * @param n
	 */
	public void add(int n);
	
	/**
	 * Returns the smallest item in the array
	 * @return
	 */
	public int getSmallest();
	
	/** Returns the largest item in the array
	 * @return
	 */
	public int getLargest();
	
	/**
	 * Returns the middle number of the array. If there are
	 * an even number of elements, the median is the average of
	 * the two middle numbers
	 * @return
	 */
	public double getMedian();

	/**
	 * Gets the element at position i, where the smallest item
	 * is kept at position 0.
	 * @param i
	 * @return
	 */
	public int get(int i);
	
	/** Returns the number of elements in the array
	 * @return
	 */
	public int size();
	
	
	/**
	 * Determines if this SortedArray contains an element n, and
	 * returns true if n is contained in the array, and returns
	 * false if does not exist in the array.
	 * @param n
	 * @return
	 */
	public boolean contains(int n);
	
	/**
	 * This method returns a string representation of this SortedArray
	 * @return
	 */
	public String toString();
	
	/**
	 * Removes all occurrences specified int element i from Array. 
	 * @param i
	 */
	public void remove(int i);
}
