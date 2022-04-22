import java.util.Arrays;

public class BadSortedArray implements SortedArray {

	private int[] numbers;
	private int size = 0;
	
	/** Constructor. Parameter n specifies the initial size of the
	 * internal array (hidden).
	 * @param n
	 */
	public BadSortedArray(int n) {
		size = 0;
		numbers = new int[n];
	}
	
	public BadSortedArray() {
		size = 0;
		numbers = new int[6];
	}
	
	public void add(int n) {
		if (size == 0) {
			numbers[0] = n;
			size++;
			return;
		}
		if (numbers.length == size) {
			// array is full. Need to resize it
			int[] biggerArray = new int[2*numbers.length];
			for (int i=0; i<numbers.length; i++)
				biggerArray[i] = numbers[i];
			numbers = biggerArray;
		}
		
		// add the new number at the end of the list of numbers
		numbers[size] = n;
		size++;

		for (int i = size-1; i > 0; i--) {
			if (numbers[i] < numbers[i-1]) {
				// swap them
				int temp = numbers[i];
				numbers[i] = numbers[i-1];
				numbers[i-1] = temp;
			}
		}
	}

	public int getSmallest() {
		return numbers[0];
	}

	public int getLargest() {
		int largest = (size == 0? size : numbers[size-1]);
		return largest;
	}

	public double getMedian() {
		if (size == 0)
			return 0;
		else if (size % 2 == 1)
			return numbers[size/2];
		else
			return (numbers[size/2] + numbers[size/2-1])/2.0;
	}

	public String toString() {
		int[] trueArray = new int[size];
		for (int i = 0; i < size; i++) {
			trueArray[i] = numbers[i];
		}
		return Arrays.toString(trueArray);
	}

	public int get(int i) {
		return numbers[i];
	}
	
	public int size() {
		return size;
	}
	
	//This function has a (worst-case) runtime of O(log(n)) 
	//where n represents the number of elements in the array.
	// Best-case / average-case runtime (respectively): O(1) / O(log(n))
	public boolean contains(int n) {		
		int search = Arrays.binarySearch(numbers, 0, size, n);
		return search >= 0 ? true : false;
	}
	
	public void remove(int n) {
		if (size == 0)
			return;
		
		int nCount = 0;
		//count number of n occurrences
		for (int i = 0; i < size; i++) {
			if (numbers[i] == n)
				nCount++;
		}
		
		//build new smaller array with n elements removed
		int[] smallerArray = new int[size-nCount];
		int smallerArrayIndex = 0;
		for (int i = 0; i < size; i++) {
			if (numbers[i] != n) {
				smallerArray[smallerArrayIndex] = numbers[i];
				smallerArrayIndex++;
			}
		}
		numbers = smallerArray;
		size = numbers.length; 
	}
	
}
