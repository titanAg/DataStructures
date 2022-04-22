import java.util.Arrays;
public class TestSortedArray {

	public static void main(String[] args) {

		// When you create your own class MySortedArray, replace
		// BadSortedArray with MySortedArray in the next line:
		SortedArray testList = new BadSortedArray();
		testList.add(10);

		// Test 1
		// test if getSmallest is indeed 10
		System.out.print("Test 1: ");
		System.out.println(testList.getSmallest()==10);

		// Test 2
		// test if getLargest is indeed 10
		System.out.print("Test 2: ");
		System.out.println(testList.getLargest()==10);

		// Test 3
		// test if getMedian is indeed 10
		System.out.print("Test 3: ");
		System.out.println(testList.getMedian()==10);

		testList.add(3);
		testList.add(8);
		testList.add(14);
		
		// Test 4
		// test if it is in sorted order:
		boolean isSorted = true;
		for (int i=1; i<testList.size(); i++)
			if (testList.get(i) < testList.get(i-1))
				isSorted = false;
		System.out.print("Test 4: ");
		System.out.println(isSorted);

		
		testList.add(13);
		testList.add(15);

		// Test 5 
		// test if it displays properly:
		System.out.print("Test 5: ");
		String answer = "[3, 8, 10, 13, 14, 15]";
		System.out.println(answer.equals(testList.toString()));
		
		testList.add(19);
		// Test 6
		// test if it displays properly:
		System.out.print("Test 6: ");
		String ans = "[3, 8, 10, 13, 14, 15, 19]";
		System.out.println(ans.equals(testList.toString()));
		
		testList.add(2);
		// Test 7
		// test if getSmallest finds 2:
		System.out.print("Test 7: ");
		System.out.println(testList.getSmallest() == 2);

		testList = new BadSortedArray(10);
		testList.add(3);
		testList.add(2);
		testList.add(1);

		// Test 8
		// test if getLargest finds 3:
		System.out.print("Test 8: ");
		System.out.println(testList.getLargest() == 3);

		// Test 9
		// test if getSmallest finds 1:
		System.out.print("Test 9: ");
		System.out.println(testList.getSmallest() == 1);

		testList = new BadSortedArray(5);
		
		// Test 10
		// Test if getLargest() returns 0 if array is empty
		System.out.print("Test 10: ");
		System.out.println(testList.getLargest() == 0);

		// Test 11
		// Test if getSmallest() returns 0 if array is empty
		System.out.print("Test 11: ");
		System.out.println(testList.getSmallest() == 0);
		
		
		// Test 12
		// Test if getMedian() returns 0 if array is empty
		System.out.print("Test 12: ");
		System.out.println(testList.getMedian() == 0);
		
		testList = new BadSortedArray(10);
		testList.add(5);
		testList.add(9);
		testList.add(2);
		
		// Test 13
		// Test if .contains() returns true if it finds an item
		// in the array
		System.out.print("Test 13: ");
		System.out.println(testList.contains(5));
		
		// Test 14
		// Verify that .contains() returns false for an item
		// not in the array
		System.out.print("Test 14: ");
		System.out.println(!testList.contains(99));
		
		testList = new BadSortedArray(15);
		testList.add(106);
		testList.add(97);
		testList.add(-5);
		testList.add(46);
		testList.add(-38);
		testList.add(22);
		testList.add(-5);
		testList.add(129);
		testList.add(11);
		testList.add(-22);
		testList.add(4);
		testList.add(2);
		testList.add(56);
		testList.add(97);
		testList.add(23);
		// Test 15
		System.out.print("Test 15: ");
		System.out.println(testList.toString());
		
		// Test 16
		testList.remove(97);
		System.out.print("Test 16: ");
		System.out.println(testList.toString());
	}

}
