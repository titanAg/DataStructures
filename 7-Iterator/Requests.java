//Kyle Orcutt

package cosc222Lab6Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * This class maintains customer requests of customer loyalty types: Platinum,
 * Gold, Silver, and Bronze. These will be implemented as loyalty 0, 1, 2, 3,
 * respectively. It implements the Iterable interface, meaning a user can create
 * an iterator to iterate through the items it contains.
 * 
 * The order in which customers should be iterated is through their loyalty rank
 * first, (platinum first, bronze last) and then in order in which these
 * customers were placed in the collection.
 * 
 * @author cosc222
 *
 */

public class Requests implements Iterable<Customer> {

	private int size;
	private ArrayList<LinkedList<Customer>> reqs;

	public Requests() {
		size = 0;

		reqs = new ArrayList<LinkedList<Customer>>();

		reqs.add(new LinkedList<>()); // index 0 is platinum
		reqs.add(new LinkedList<>()); // index 1 is gold
		reqs.add(new LinkedList<>()); // index 2 is silver
		reqs.add(new LinkedList<>()); // index 3 is bronze

	}

	/**
	 * Adds a customer by name,loyalty (0=platinum, 1=gold, 2=silver, 3=bronze)
	 * 
	 * @param name
	 * @param loy
	 */
	public void add(String name, int loy) {
		add(new Customer(name, loy));
	}

	public void add(Customer c) {
		if (c.getLoyalty() == -1)
			return;

		int loyalty = c.getLoyalty();
		size++;
		switch (loyalty) {
		case 0:
			reqs.get(0).add(c);
			 break;
		case 1:
			reqs.get(1).add(c);
			 break;
		case 2:
			reqs.get(2).add(c);
			 break;
		case 3:
			reqs.get(3).add(c);
			 break;
		}
	}

	@Override
	public Iterator<Customer> iterator() {
		Iterator<Customer> itr = new Iterator<Customer>() {

			private int index = 0;
			private int sizeSum0 = reqs.get(0).size();
			private int sizeSum1 = reqs.get(1).size() + sizeSum0;
			private int sizeSum2 = reqs.get(2).size() + sizeSum1;
			
			@Override

			public boolean hasNext() {
				return size >= index;
			}

			@Override
			public Customer next() {					
				if (hasNext()) {
					if (index < sizeSum0) {
						return reqs.get(0).get(index++);
					} else if (index < sizeSum1) {
						return reqs.get(1).get(index++ - sizeSum0);
					} else if (index < sizeSum2) {
						return reqs.get(2).get(index++ - sizeSum1);
					} else {
						return reqs.get(3).get(index++ - sizeSum2);
					}
				}
				return null;
			}

			@Override
			public void remove() {
				
				if (hasNext()) {
					if (index <= sizeSum0) {
						reqs.get(0).remove(index-- -1);
					} else if (index <= sizeSum1) {
						reqs.get(1).remove(index-- -sizeSum0-1);
					} else if (index <= sizeSum2) {
						reqs.get(2).remove(index-- -sizeSum1-1);
					} else {
						reqs.get(3).remove(index-- -sizeSum2-1);
					}
					sizeSum0 = reqs.get(0).size();
					sizeSum1 = reqs.get(1).size() + sizeSum0;
					sizeSum2 = reqs.get(2).size() + sizeSum1;
					size--;
				}
			}

		};
		return itr;
	}
}
