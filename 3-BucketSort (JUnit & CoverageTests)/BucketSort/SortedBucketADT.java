import java.util.ArrayList;

public interface SortedBucketADT<V>{

	void add(Entry<V> t);

	ArrayList<Entry<V>> getBucketContents();


}
