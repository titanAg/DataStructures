//Kyle Orcutt

package cosc222Lab6Iterator;

// TODO: there are 3 "to do" items below, and 1 bonus TODO
import static org.junit.Assert.*;

import java.util.Iterator;
import org.junit.Before;

public class Test {

	/* Declaration of the test objects */
	
	Requests r;
	Iterator<Customer> i;
	/* Instantiation of the objects */
	
	@Before
	public void initialize() {
		System.out.println(" Initializing");
		r = new Requests();
		
	}

	@org.junit.Test
	public void test1() {
		System.out.print("Test 1: ");
		r.add("Jim", 0);
		r.add("Jenny",1);
		r.add("Julie",2);
		r.add("Jason",2);
		r.add("Jessica",0);
		r.add("Jackie", 1);
		r.add("CowboyNeal", 2);
		r.add("Val", 3);
		Iterator<Customer> i = r.iterator();
		assertEquals(i.next().getName(),"Jim");
		assertEquals(i.next().getName(),"Jessica");
		assertEquals(i.next().getName(),"Jenny");
		assertEquals(i.next().getName(),"Jackie");
		assertEquals(i.next().getName(),"Julie");
		assertEquals(i.next().getName(),"Jason");
		assertEquals(i.next().getName(),"CowboyNeal");
		assertEquals(i.next().getName(),"Val");
		System.out.println("Check");
	}

	@org.junit.Test
	public void test2() {
		System.out.print("Test 2: ");
	//TODO: Test if it works if there are no customers in Platinum
		r.add("Jenny",1);
		r.add("Julie",2);
		r.add("Jason",2);
		r.add("Jackie", 1);
		r.add("CowboyNeal", 2);
		r.add("Val", 3);
		Iterator<Customer> i = r.iterator();
		assertEquals(i.next().getName(),"Jenny");
		assertEquals(i.next().getName(),"Jackie");
		assertEquals(i.next().getName(),"Julie");
		assertEquals(i.next().getName(),"Jason");
		assertEquals(i.next().getName(),"CowboyNeal");
		assertEquals(i.next().getName(),"Val");
		System.out.println("Check");
	}

	@org.junit.Test
	public void test3() {
		System.out.print("Test 3: ");
	//TODO: Test if it works if there are no customers in Platinum and none in Bronze
		r.add("Jenny",1);
		r.add("Julie",2);
		r.add("Jason",2);
		r.add("Jackie", 1);
		r.add("CowboyNeal", 2);
		Iterator<Customer> i = r.iterator();
		assertEquals(i.next().getName(),"Jenny");
		assertEquals(i.next().getName(),"Jackie");
		assertEquals(i.next().getName(),"Julie");
		assertEquals(i.next().getName(),"Jason");
		assertEquals(i.next().getName(),"CowboyNeal");
		System.out.println("Check");
	}

	@org.junit.Test
	public void test4() {
		System.out.print("Test 4: ");
	//TODO: Test if it works if all customers in Platinum and none in Bronze
		r.add("Jim", 1);
		r.add("Jenny",1);
		r.add("Julie",1);
		r.add("Jason",1);
		r.add("Jessica",1);
		r.add("Jackie", 1);
		r.add("CowboyNeal", 1);
		r.add("Val", 1);
		Iterator<Customer> i = r.iterator();
		assertEquals(i.next().getName(),"Jim");
		assertEquals(i.next().getName(),"Jenny");
		assertEquals(i.next().getName(),"Julie");
		assertEquals(i.next().getName(),"Jason");
		assertEquals(i.next().getName(),"Jessica");
		assertEquals(i.next().getName(),"Jackie");
		assertEquals(i.next().getName(),"CowboyNeal");
		assertEquals(i.next().getName(),"Val");
		System.out.println("Check");
	}

	@org.junit.Test
	public void test5() {
		System.out.print("Test 5: ");
		r.add("Jim", 0);
		r.add("Jenny",1);
		r.add("Julie",2);
		r.add("Jason",2);
		r.add("Jessica",0);
		r.add("Joseph",5);
		r.add("Jackie", 1);
		r.add("CowboyNeal", 2);
		r.add("Val", 3);
		Iterator<Customer> i = r.iterator();
		assertEquals(i.next().getName(),"Jim");
		assertEquals(i.next().getName(),"Jessica");
		assertEquals(i.next().getName(),"Jenny");
		assertEquals(i.next().getName(),"Jackie");
		assertEquals(i.next().getName(),"Julie");
		assertEquals(i.next().getName(),"Jason");
		assertEquals(i.next().getName(),"CowboyNeal");
		assertEquals(i.next().getName(),"Val");
		System.out.println("Check");
	}

	// test if removal works
	@org.junit.Test
	public void test6() {
		System.out.print("Test 6: ");
	//TODO: Test if i.remove() works
		r.add("Jim", 0);
		r.add("Jenny",1);
		r.add("Julie",2);
		r.add("Jason",2);
		r.add("Jessica",0);
		r.add("Jackie", 1);
		r.add("Mike", 1);
		r.add("CowboyNeal", 2);
		r.add("Val", 3);		
		Iterator<Customer> i = r.iterator();
		assertEquals(i.next().getName(),"Jim");
		i.remove();
		assertEquals(i.next().getName(),"Jessica");
		i.remove();
		assertEquals(i.next().getName(),"Jenny");
		i.remove();
		assertEquals(i.next().getName(),"Jackie");
		i.remove();
		assertEquals(i.next().getName(),"Mike");
		i.remove();
		assertEquals(i.next().getName(),"Julie");
		assertEquals(i.next().getName(),"Jason");
		i.remove();
		assertEquals(i.next().getName(),"CowboyNeal");
		assertEquals(i.next().getName(),"Val");
		i.remove();
		System.out.println("Check");
	}
	
}
