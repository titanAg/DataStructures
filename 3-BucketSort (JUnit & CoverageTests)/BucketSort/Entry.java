/**
 * A (key,value) pair class. Key is int type. 
 *
 * @param <V>
 */
public class Entry <V> {
	private int key;
	private V val;
	
	public Entry(int k, V v) {
		key = k;
		val = v;
	}

	public int getKey() {
		return this.key;
	}

	public V getValue() {
		return this.val;
	}

	public String toString() {
		return this.getValue()+"="+this.getKey();
	}
}
