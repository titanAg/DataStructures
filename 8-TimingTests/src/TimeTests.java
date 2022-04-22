//Kyle Orcutt

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.ConcurrentSkipListSet;

public class TimeTests {
	/* Result Report:
  	    Tests for trie:
		Add: 227 milliseconds.
		contains: 134 milliseconds.
		remove: 155 milliseconds.
		
		Tests for linkedlist:
		Add: 31 milliseconds.
		contains: 495637 milliseconds.
		remove: 413324 milliseconds.
		
		Tests for hashset:
		Add: 71 milliseconds.
		contains: 62 milliseconds.
		remove: 56 milliseconds.
		
		Tests for skiplist:
		Add: 293 milliseconds.
		contains: 322 milliseconds.
		remove: 345 milliseconds.

	 */
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> arraylist = new ArrayList<>();

		LowerCaseTrie trie = new LowerCaseTrie();
		LinkedList<String> linkedlist = new LinkedList<>();
		HashSet<String> hashset = new HashSet<>();
		ConcurrentSkipListSet<String> skiplist = new ConcurrentSkipListSet<>();
		
		FileReader f = new FileReader("englishWords.txt");
		Scanner sc = new Scanner(f);
		System.out.print("Loading all words... ");
		while (sc.hasNext()) {
			String s = sc.nextLine();
			arraylist.add(s);
		}
		sc.close();
		System.out.println("Done");
		
		int numTrials = 200000;
		
		//Time test for trie
		System.out.println("Tests for trie:");
		long startTime = System.nanoTime();
		
		for (int i=0; i<numTrials; i++) {
			int randomIndex = (int)(Math.random()*arraylist.size());
			String randomWord = arraylist.get(randomIndex);
			trie.add(randomWord);
		}
		long endTime = System.nanoTime();
		long duration = (endTime - startTime)/1000000;
		System.out.println("Add: " + duration + " milliseconds.");
		
		startTime = System.nanoTime();
		for (int i=0; i<numTrials; i++) {
			int randomIndex = (int)(Math.random()*arraylist.size());
			String randomWord = arraylist.get(randomIndex);
			trie.contains(randomWord);
		}
		
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("contains: " + duration + " milliseconds.");
		
		startTime = System.nanoTime();
		for (int i=0; i<numTrials; i++) {
			int randomIndex = (int)(Math.random()*arraylist.size());
			String randomWord = arraylist.get(randomIndex);
			trie.remove(randomWord);
		}
		
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("remove: " + duration + " milliseconds.");
		
		
		//Time test for add on linkedlist
		System.out.println("\nTests for linkedlist:");
		startTime = System.nanoTime();
		
		for (int i=0; i<numTrials; i++) {
			int randomIndex = (int)(Math.random()*arraylist.size());
			String randomWord = arraylist.get(randomIndex);
			linkedlist.add(randomWord);
		}
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("Add: " + duration + " milliseconds.");
		
		startTime = System.nanoTime();
		for (int i=0; i<numTrials; i++) {
			int randomIndex = (int)(Math.random()*arraylist.size());
			String randomWord = arraylist.get(randomIndex);
			linkedlist.contains(randomWord);
		}
		
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("contains: " + duration + " milliseconds.");
		
		startTime = System.nanoTime();
		for (int i=0; i<numTrials; i++) {
			int randomIndex = (int)(Math.random()*arraylist.size());
			String randomWord = arraylist.get(randomIndex);
			linkedlist.remove(randomWord);
		}
		
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("remove: " + duration + " milliseconds.");
		
		
		//Time test for add on hashset
		System.out.println("\nTests for hashset:");
		startTime = System.nanoTime();
		
		for (int i=0; i<numTrials; i++) {
			int randomIndex = (int)(Math.random()*arraylist.size());
			String randomWord = arraylist.get(randomIndex);
			hashset.add(randomWord);
		}
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("Add: " + duration + " milliseconds.");
		
		startTime = System.nanoTime();
		for (int i=0; i<numTrials; i++) {
			int randomIndex = (int)(Math.random()*arraylist.size());
			String randomWord = arraylist.get(randomIndex);
			hashset.contains(randomWord);
		}
		
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("contains: " + duration + " milliseconds.");
		
		startTime = System.nanoTime();
		for (int i=0; i<numTrials; i++) {
			int randomIndex = (int)(Math.random()*arraylist.size());
			String randomWord = arraylist.get(randomIndex);
			hashset.remove(randomWord);
		}
		
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("remove: " + duration + " milliseconds.");
		
		
		//Time test for add on skiplist
		System.out.println("\nTests for skiplist:");
		startTime = System.nanoTime();
		
		for (int i=0; i<numTrials; i++) {
			int randomIndex = (int)(Math.random()*arraylist.size());
			String randomWord = arraylist.get(randomIndex);
			skiplist.add(randomWord);
		}
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("Add: " + duration + " milliseconds.");
		
		startTime = System.nanoTime();
		for (int i=0; i<numTrials; i++) {
			int randomIndex = (int)(Math.random()*arraylist.size());
			String randomWord = arraylist.get(randomIndex);
			skiplist.contains(randomWord);
		}
		
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("contains: " + duration + " milliseconds.");
		
		startTime = System.nanoTime();
		for (int i=0; i<numTrials; i++) {
			int randomIndex = (int)(Math.random()*arraylist.size());
			String randomWord = arraylist.get(randomIndex);
			skiplist.remove(randomWord);
		}
		
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;
		System.out.println("remove: " + duration + " milliseconds.");

	}
}
