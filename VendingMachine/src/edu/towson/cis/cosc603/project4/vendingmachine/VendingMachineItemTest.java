package edu.towson.cis.cosc603.project4.vendingmachine;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;




public class VendingMachineItemTest {

	/**  Declaring necessary test objects for {@link VendingMachineItem}. */
	static VendingMachineItem item1;
	static VendingMachineItem item2;
	static VendingMachineItem item3;
	static VendingMachineItem item4;

	/**
	 * Initializes the necessary test objects for the test cases to use.
	 * Test normal expected input.
	 * Test zero item price input.
	 * Test negative item price input.
	 * Test zero length item name input.
	 * 
	 * @throws Exception the exception
	 */
	@BeforeClass
	public static void setUp() throws Exception {
        System.out.println("setUp");
		// normal expected input
		item1 = new VendingMachineItem("Snickers", 1.00);
		// zero price input
		item2 = new VendingMachineItem("Baby Ruth", 0.00);
		// negative price input
		try {
			item3 = new VendingMachineItem("York Peppermint Patty", -1.00);
		} catch (VendingMachineException e) {
			// test exception error message
			assertEquals("Price cannot be less than zero", e.getMessage());
	    }
		// zero length name
		item4 = new VendingMachineItem("", 1.00);
	}
	
	/**
	 * Test for the getName() method of the {@link VendingMachineItem} class.
	 */
	@Test
	public void testGetName() {
        System.out.println("testGetName");
		assertEquals("Snickers", item1.getName());
		assertEquals("Baby Ruth", item2.getName());
		assertNull(item3);
		assertEquals("", item4.getName());
	}
	
	/**
	 * Test for the getPrice() method of the {@link VendingMachineItem} class.
	 */
	@Test
	public void testGetPrice() {
        System.out.println("testGetPrice");
		assertEquals(1.00, item1.getPrice(),0.001);
		assertEquals(0.00, item2.getPrice(),0.001);
		assertNull(item3);
		assertEquals(1.00, item4.getPrice(),0.001);
	}
	
	/**
	 * Cleans up test objects after a test case is executed.
	 */
	@AfterClass
	public static void tearDown(){
        System.out.println("tearDown");
		item1 = null;
		item2 = null;
		item3 = null;
		item4 = null;
	}
}
