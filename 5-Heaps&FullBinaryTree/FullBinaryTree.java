//Kyle Orcutt

import java.util.ArrayList;

public class FullBinaryTree <E> {

	protected ArrayList<E> nodes;
	
	public FullBinaryTree() {
		//Do not edit.
		nodes = new ArrayList<E>();
	}
	
	public int size() {
		//Do not edit.
		return nodes.size();
	}
	
	/**
	 * Returns the INDEX of where the left child would be, if it exists.
	 */
	protected static int leftChild(int i) {
		return 2*i+1;
	}
	
	/**
	 * Returns the INDEX of where the right child would be, if it exists.
	 */
	protected static int rightChild(int i) {
		return 2*i+2;
	}
	
	/**
	 * Returns the index of the parent node of i. For convenience, the
	 * parent of the root is the root.
	 */
	public int parent(int i) {
		return i == 0 ? 0 : (i-1)/2;
	}

	/**
	 * Adds an element to the full binary tree, just at the end of the tree.
	 * This method is not really used -- you should be overwriting it
	 * in your MinHeap class.
	 * @param e
	 */
	public void add(E e) {
		//Do not edit.
		nodes.add(e);
	}
}
