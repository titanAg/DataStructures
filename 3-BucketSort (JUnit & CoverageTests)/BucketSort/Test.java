import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;

public class Test {

	/* Declaration of the test objects */
	
	BucketList<String> b;
	ArrayList<Entry<String>> everyone;
	Entry<String> jim, val, C, B, A, Aplus;
	
	/* Instantiation of the objects */
	
	@Before
	public void initialize() {
		everyone = new ArrayList<>();
		jim = new Entry<>(94 , "Jim");
		val = new Entry<>(93 , "Val");
		C = new Entry<>(68 , "C-Student");
		B = new Entry<>(72 , "B-Student");
		A = new Entry<>(84 , "A-Student");
		Aplus = new Entry<>(98 , "A-plus-Student");

		everyone.add(jim);
		everyone.add(val);
		everyone.add(C);
		everyone.add(B);
		everyone.add(A);
		everyone.add(Aplus);

	}

	/* Various tests follow */
	
	@org.junit.Test
	public void test1() {
		// BucketList constructor takes (min,max,numBuckets)
		b = new BucketList<String>(0,100,6);
		b.addAll(everyone);
		ArrayList<Entry<String>> list4 = new ArrayList<>();
		list4.add(C);
		list4.add(B);
		list4.add(A);
		ArrayList<Entry<String>> list5 = new ArrayList<>();
		list5.add(val);
		list5.add(jim);
		list5.add(Aplus);
//		System.out.println(list4);
//		System.out.println(list5);
//		System.out.println(b);
		
		// .equals in ArrayLists compares corresponding items
		assertTrue(b.getBucket(4).equals(list4)
					&& b.getBucket(5).equals(list5)
					&& b.getBucket(0).isEmpty()
					&& b.getBucket(1).isEmpty()
					&& b.getBucket(2).isEmpty()
					&& b.getBucket(3).isEmpty());
	}

	@org.junit.Test
	public void test2() {
		// BucketList constructor takes (min,max,numBuckets)
		b = new BucketList<String>(0,100,5);
		b.addAll(everyone);

		//TODO:
		
		// Figure out (on paper?) where these 6 Entry objects should
		// be in the case of 5 buckets. Then build a test
		// like in test1() to check each of the 5 buckets
		// for the correct contents (and correct order of contents)
		// (Note that list4 and list5 in test1 had their elements
		// added so that the resulting list is in sorted order so
		// that testing the corresponding bucket is easier.

		// Use whichever lists you need (see test1() )
		
		ArrayList<Entry<String>> list3 = new ArrayList<>();
		ArrayList<Entry<String>> list4 = new ArrayList<>();

		list4.add(Aplus); // ... add rest of Entry objects
		list4.add(jim);
		list4.add(val);
		list4.add(A);
		
		list3.add(B);
		list3.add(C);
		
//		System.out.println(list4);
//		System.out.println(list3);
//		System.out.println(b);
		
		assertTrue(b.getBucket(0).isEmpty()
				    && b.getBucket(1).isEmpty()
				    && b.getBucket(2).isEmpty()
				    && b.getBucket(3).containsAll(list3)
					&& b.getBucket(4).containsAll(list4)
					&& (b.getBucket(3).size() + b.getBucket(4).size()) == list3.size() + list4.size()
				// complete this test
					// &&... (add 
				    );
	}

	@org.junit.Test
	public void test3() {
		// BucketList constructor takes (min,max,numBuckets)
		b = new BucketList<String>(0,100,4);
		b.addAll(everyone);
		
		//TODO:
		// Write this test similar to test2(). But this time these
		// six Entry Objects are added into a BucketList with 4 buckets		
		ArrayList<Entry<String>> list2 = new ArrayList<>();
		ArrayList<Entry<String>> list3 = new ArrayList<>();
		
		list3.add(Aplus);
		list3.add(jim);
		list3.add(val);
		list3.add(A);
		
		list2.add(B);
		list2.add(C);
		
//		System.out.println(list3);
//		System.out.println(list2);
//		System.out.println(b);
		
		assertTrue(b.getBucket(0).isEmpty()
			    && b.getBucket(1).isEmpty()
			    && b.getBucket(2).containsAll(list2)
				&& b.getBucket(3).containsAll(list3)
				&& (b.getBucket(2).size() + b.getBucket(3).size()) == list2.size() + list3.size()); // change this assert
	}
	
	@org.junit.Test
	public void emptyTest() {
		// BucketList constructor takes (min,max,numBuckets)
		// Testing if we can construct in the negative range, and if
		// it will still perform "sort" without crashing if all buckets
		// are empty
		b = new BucketList<String>(-50,50,6);
		assertTrue(b.getNumBuckets()==6 && b.getSortedOrder().size()==0); 
	}

	@org.junit.Test
	public void perfectStudentTest() {
		// test where an Entry named "perfect" with a score of 100 will
		// be placed in a BucketList which stores grades from 0 to 100 and
		// having 10 buckets.
		
		b = new BucketList<String>(0,100,10);
		b.add(new Entry<>(100,"perfect"));
		assertTrue(b.getBucket(9).size()==1); 
	}

	@org.junit.Test
	public void outOfBoundsTest1() {
		// tests if we can add an Entry with key value larger than max
		
		b = new BucketList<String>(0,100,10);
		b.add(new Entry<>(110,"superPerfect"));
		assertTrue(b.getBucket(9).size()==1); 
	}

	@org.junit.Test
	public void outOfBoundsTest2() {
		// tests if we can add an Entry with key value less than min
		
		b = new BucketList<String>(0,100,10);
		b.add(new Entry<>(-110,"notSoPerfect"));
		assertTrue(b.getBucket(0).size()==1); 
	}

	@org.junit.Test
	public void additionalTest() {
		//tests if buckets are in sorted order. 
		
		b = new BucketList<String>(0,100,4);
		ArrayList<Entry<String>> list1 = new ArrayList<>();
		ArrayList<Entry<String>> list2 = new ArrayList<>();
		ArrayList<Entry<String>> list3 = new ArrayList<>();
		
		list1.add(A);
		list1.add(C);
		list1.add(new Entry<>(32,"tom"));
		
		list2.add(val);
		list2.add(Aplus);
		list2.add(new Entry<>(5,"bob"));
		
		list3.add(new Entry<>(12,"john"));
		list3.add(new Entry<>(35,"tina"));
		list3.add(new Entry<>(55,"mike"));
		
		
		b.addAll(list3);
		b.addAll(list1);
		b.addAll(list2);
		
		ArrayList<Entry<String>> test = b.getSortedOrder();
		boolean isInOrder = true;
		
		for (int i = 0; i < test.size()-1; i++) {
			if (test.get(i).getKey() > test.get(i+1).getKey())
				isInOrder = false;
		}
		
		assertTrue(isInOrder);
	}
	
	@org.junit.Test
	public void additionalTest2() {
		//tests toString() method.
		
		b = new BucketList<String>(0,100,2);
		ArrayList<Entry<String>> list2 = new ArrayList<>();
		ArrayList<Entry<String>> list3 = new ArrayList<>();
		
		list2.add(val);
		list2.add(Aplus);
		list2.add(new Entry<>(5,"bob"));
		
		list3.add(new Entry<>(12,"john"));
		list3.add(new Entry<>(35,"tina"));
		list3.add(new Entry<>(55,"mike"));
		
		b.addAll(list2);
		b.addAll(list3);
		
		String testString = "[[bob=5, john=12, tina=35][mike=55, Val=93, A-plus-Student=98]]";
		
		assertTrue(testString.contentEquals(b.toString()));
	}

	@org.junit.Test
	public void largeTest() {
		//TODO: Write an additional test that tests 1_000_000 items, placed into
		//50_000 buckets, with keys ranging from 0 to 99_999
		//Create 1million random Entries parameterized by <Object> and
		//only containing a null value

		int testSize = 1_000_000;
		int maxRandom = 100_000;
		//instantiate a bucketList with 50k buckets, and range 0 to 99_999

		// is min and max both inclusive??? YES!!! ... do I need -1 for maxRandom?
		b = new BucketList<String>(0,maxRandom-1,50_000);
		b.addAll(everyone);

		for (int i=0; i<testSize; i++) {
			Entry<Object> e = new Entry<>((int)(Math.random()*maxRandom),null);
			//add this entry to your
			Entry<String> s2 = (Entry<String>)(Entry<?>)e;
			b.add(s2);
		}
		ArrayList<Entry<Object>> sortedOutput;
		//sortedOutput = [your bucketList].getSortedOrder();
		//assert whether sortedOutput isSorted

		//if this test runs quickly, write an even larger test!


	}

}
