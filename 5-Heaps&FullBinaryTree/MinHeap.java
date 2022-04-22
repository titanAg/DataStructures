//Kyle Orcutt

import java.util.Collections;

import org.w3c.dom.Node;

/**
 * MinHeap of Comparables. Two E objects which extend Comparable can
 * be compared by e1.compareTo(e2), and if this results in a negative
 * value, e1 comes before e2. If it results in a positive value, e2 comes
 * first.
 * This class extends fullBinaryTree, meaning we can use the left and right
 * child functions to get the index of child nodes. But it must also support
 * heap functionality, like up-heap, trickle-down, and extract-min.
 * @param <E>
 */

public class MinHeap<E extends Comparable<E>>
extends FullBinaryTree<E>
implements HeapADT<E> {

	/**
	 * Constructs the underlying ArrayList<E> called 'nodes' 
	 */
	public MinHeap() {
		// Nothing to change here.
		super();
	}
	
	@Override
	public E poll() {
		E first = nodes.get(0);
		nodes.remove(0);
		
		if (!nodes.isEmpty()) {
			E last = nodes.get(nodes.size()-1);
			nodes.remove(nodes.size()-1);
			nodes.add(0,last);
			trickleDown(0);
		}
		
		return first;
	}

	private void trickleDown(int i) {
		int size = nodes.size();
		boolean hasLeft = leftChild(i) < size;
		boolean hasRight = rightChild(i) < size;
		
		if (hasLeft && hasRight && nodes.get(leftChild(i)).compareTo(nodes.get(rightChild(i))) > 0) {
			if (nodes.get(i).compareTo(nodes.get(rightChild(i))) > 0) {
				Collections.swap(nodes, i, rightChild(i));
				trickleDown(rightChild(i));
			}
		}else if (hasLeft) {
			if (nodes.get(i).compareTo(nodes.get(leftChild(i))) > 0) {
				Collections.swap(nodes, i, leftChild(i));
				trickleDown(leftChild(i));
			}
		}else {
			return;
		}
	}

	@Override
	public E peek() {
		return nodes.get(0);
	}
	
	@Override
	public void add(E e) {
		nodes.add(e);
		upHeap(nodes.size()-1);
	}

	private void upHeap(int index) {
		if (index > 0 && nodes.get(index).compareTo(nodes.get(parent(index))) < 0) {
			Collections.swap(nodes, index, parent(index));
			upHeap(parent(index));
		}else {
			return;
		}
	}
	
	public String toString() {
		// Nothing to change here.
		return nodes.toString();
	}
}
