//Kyle Orcutt

import java.util.ArrayList;

public class UseExample {

	public static void main(String[] args) {
		String[] words = {"word", "so", "many", "words","i",
				"sure", "do", "enjoy", "java", "programming",
				"and", "this", "seems", "to", "be", "enough"};
		
		int[] numbers = {100, 32, 65, 87, 1, -2, -65, 10000, 56,
				      -500, 3, 504, -6, 34, 750, 1000, 89};
		
		double[] partNumbs = {100.23, 32.32, 32.34, 87.45, 1.98, -2.98, -65.09, 100.287, 56.234,
			      -500.34, 3.12, 504.345, -6.123, 32.235, 750.987, 100.876, 87.987};

		ArrayList<String> sorted = heapSort(words);

		System.out.println(sorted);
		/* Should output:
		 * [and, be, do, enjoy, enough, i, java, many, programming, seems, so, sure, this, to, word, words]
		 */
	}

	private static ArrayList<String> heapSort(String[] words) {
		ArrayList<String> output = new ArrayList<String>();
		MinHeap<String> m = new MinHeap<>();

		for (String s:words)
			m.add(s);
		
		while (m.size() > 0) {
			output.add(m.poll());
		}
		return output;
	}

}
