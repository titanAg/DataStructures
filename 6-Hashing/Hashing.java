//Kyle Orcutt
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Hashing {

	// with 341116 words, a table size of 1mil keeps the load factor low
	static final int tableSize = 1000000;

	public static void main(String[] args) throws IOException {

		for (int k = 1; k <= 45; k++) {

			// Leave these two lines alone for opening the input file
			FileReader f = new FileReader("englishWords.txt");
			Scanner sc = new Scanner(f);

			// This creates your hashtable or simulated hashtable of size tableSize
			int[] counts = new int[tableSize];
			int collisionCount = 0;
			// This loop runs through the words in the file
			while (sc.hasNext()) {
				String s = sc.nextLine();

				int bucket = hash(s,k);
				counts[bucket] += 1;

				if (counts[bucket] > 1) {
					collisionCount++;
				}
			}
			
			int maxK_Bucket = counts[0];
			for (int i = 0; i < counts.length; i++) {
				if (counts[i] > maxK_Bucket)
					maxK_Bucket = counts[i];
			}
			
			System.out.println("k value = " + k + " resulted in " + collisionCount + " collisions");
			System.out.println("k value = " + k + " maximum bucket size was " + maxK_Bucket);
			
			// Leave this line alone to close the input file
			f.close();
		}
	}
	
	public static int hash(String s, int k) {
		int value = 0;
		int n = s.length();
		
		for (int i = 0; i < n; i++) {
				value = (value * k) + s.charAt(i);
		}

		//In order to handle integer overflow, I have 
		//taken mod tablesize of the hash value for the string.
		//If the result of the mod function was negative, 
		//I added tableSize to the hash value.
		value = value % tableSize;
		if (value < 0)
			value += tableSize;
		return value;
	}
}

/***********************************************************
 * Report your best k values here (you can output all k values
 * and then visually inspect your output for your 3 best
 * k values). Give your 3 best k-values for the smallest total
 * number of collisions, and also give your 3 best k-values for
 * the smallest value for the max-bucket-size.
 * 
 * k 29, 31, 43 were the best k's for both collisions and max bucket size 
 * 
 * k value = 29 resulted in 51783 collisions
 * k value = 29 maximum bucket size was 6
 * k value = 31 resulted in 51789 collisions
 * k value = 31 maximum bucket size was 6
 * k value = 43 resulted in 51850 collisions
 * k value = 43 maximum bucket size was 5
 * 
 */

