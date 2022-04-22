import java.util.ArrayList;

public class SortedBucket<V> implements SortedBucketADT<V>{

	private ArrayList<Entry<V>> b;

	public SortedBucket() {
		b = new ArrayList<Entry<V>>();
	}

	/** 
	 *  Adds entry t to bucket in proper sorter order
	 */
	@Override
	public void add(Entry<V> t) {
		
		if (b.isEmpty()){
			b.add(t);
		} 
		else {
			for (int i = 0; i < b.size(); i++) {
				Entry<V> iEntry = b.get(i);
				
				if (t.getKey() == iEntry.getKey() || t.getKey() < iEntry.getKey()) {
					b.add(i,t);
					return;
				}
				else if (i == b.size()-1){
					b.add(i+1,t);
					return;
				}

			}
		}			
	}
	
	
	/**
	 * @return a sorted ArrayList of Entries in this bucket
	 */
	@Override
	public ArrayList<Entry<V>> getBucketContents() {
		// Don't touch.
		return b;
	}

	@Override
	public String toString() {
		// Don't touch.
		return b.toString();
	}
}
