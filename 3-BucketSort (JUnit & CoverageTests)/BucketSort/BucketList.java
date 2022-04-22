import java.util.ArrayList;
import java.util.Collection;

public class BucketList<V> implements BucketListADT<V> {

	private ArrayList<SortedBucket<V>> list;
	private int min;
	private int max;
	
	/**
	 * Constructor. Builds a list of buckets which
	 * supports Entry (key,value pairs)
	 * with expected key values from min to max 
	 * 
	 * @param min
	 * @param max
	 * @param n
	 */
	public BucketList(int min, int max, int n) {
		list = new ArrayList<SortedBucket<V>>();
		for (int i=0; i<n; i++){
			SortedBucket<V> bList = new SortedBucket<V>();
			list.add(bList);
		}
		this.min = min;
		this.max = max;
	}
	
	/**
	 * Adds the given Entry into the appropriate bucket in
	 * this list of buckets.
	 * @param item
	 */
	@Override
	public void add(Entry<V> item) {
		int n = list.size();
		// DO NOT CHANGE THIS FORMULA. This ensures items will be
		// added to the correct bucket.
		int indexToInsert = n*(item.getKey()-min)/(max-min+1);
		
		if (indexToInsert >= n) {
			indexToInsert = n-1;
		}
		else if (indexToInsert < 0) {
			indexToInsert = 0;
		}		
		(list.get(indexToInsert)).add(item);
	}
	
	/**
	 * Adds all entries in the Collection c to this List of Buckets
	 * @param c is a Collection of Entries
	 */
	@Override
	public void addAll(Collection<Entry<V>> c) {
		// Don't touch this.
		// Implement above method .add() for this to work.
		
		for (Entry<V> e : c)
			this.add(e);
	}
	
	/**
	 * @return Returns a single ArrayList of the whole
	 * sorted order of all buckets put together
	 * 
	 */
	@Override
	public ArrayList<Entry<V>> getSortedOrder() {
		ArrayList<Entry<V>> output = new ArrayList<Entry<V>>();
		
		for (int i = 0; i < list.size(); i++) {
			output.addAll(list.get(i).getBucketContents());
		}
		
		return output;
	}
	
	/**
	 * Returns an ArrayList of the bucket contents of bucket i
	 * @param i
	 * @return
	 */
	@Override
	public ArrayList<Entry<V>> getBucket(int i) {	
		SortedBucket<V> iBucket = list.get(i);
		
		return iBucket.getBucketContents();
	}
	
	/**
	 * Returns the number of buckets in this list of buckets
	 * @return int
	 */
	@Override
	public int getNumBuckets(){
		// Leave this alone.
		return list.size();
	}
	
	
	/* 
	 * Shows contents of all buckets, each bucket in [ ] brackets.
	 * Will show empty buckets as well.
	 */
	public String toString() {
		// Leave this alone
		StringBuilder output = new StringBuilder("[");
		for (SortedBucket<V> s: this.list) {
			output.append(s.toString());
		}
		output.append("]");
		return output.toString();
	}
}
