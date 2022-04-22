public interface GenericSortedArray<E extends Comparable> {
	public void add(E n);
	public E getSmallest();
	public E getLargest();
	public E getMedian();
	public E get(E i);
	public E size();
	public boolean contains(E n);
	public String toString();
}
