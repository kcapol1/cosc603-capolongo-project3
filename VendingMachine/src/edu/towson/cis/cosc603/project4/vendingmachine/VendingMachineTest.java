package edu.towson.cis.cosc603.project4.vendingmachine;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class VendingMachineTest {

	/**  Declaring necessary test objects for {@link VendingMachine}. */
	static VendingMachine vendingMachine1;
	static VendingMachine vendingMachine2;
	static VendingMachine vendingMachine3;
	static VendingMachine vendingMachine4;
	static VendingMachine vendingMachine5;

	/**
	 * Initializes the necessary test objects for the test cases to use.
	 * 
	 * @throws Exception the exception
	 */
	@BeforeClass
	public static void setUp() throws Exception {
        System.out.println("setUp");
        vendingMachine1 = new VendingMachine();
        vendingMachine2 = new VendingMachine();
        vendingMachine3 = new VendingMachine();
        vendingMachine4 = new VendingMachine();
        vendingMachine5 = new VendingMachine();
	}
	
	/**
	 * Test for the addItem() method of the {@link VendingMachine} class.
	 * Test constructor postcondition: all entries in itemArray are null, balance set to be 0
	 */
	@Test
	public void testVendingMachine() {
        System.out.println("testVendingMachine");
		assertNull(vendingMachine1.getItem("A"));
		assertNull(vendingMachine1.getItem("B"));
		assertNull(vendingMachine1.getItem("C"));
		assertNull(vendingMachine1.getItem("D"));
		assertEquals(0,vendingMachine1.balance,0.001);
	}
	
	/**
	 * Test for the addItem() method of the {@link VendingMachine} class.
	 * Add items with normal input.
	 */
	@Test
	public void testAddItemA() {
        System.out.println("testAddItemA");
        vendingMachine2.addItem(new VendingMachineItem("Snickers",1.50), "A");
		assertEquals("Snickers",vendingMachine2.getItem("A").getName());
		assertEquals(1.50,vendingMachine2.getItem("A").getPrice(),0.001);
 
		vendingMachine2.addItem(new VendingMachineItem("York Peppermint Patty",1.25), "B");
		assertEquals("York Peppermint Patty",vendingMachine2.getItem("B").getName());
		assertEquals(1.25,vendingMachine2.getItem("B").getPrice(),0.001);

		vendingMachine2.addItem(new VendingMachineItem("Butterfinger",1.00), "C");
		assertEquals("Butterfinger",vendingMachine2.getItem("C").getName());
		assertEquals(1.00,vendingMachine2.getItem("C").getPrice(),0.001);

		vendingMachine2.addItem(new VendingMachineItem("Baby Ruth",0.75), "D");
		assertEquals("Baby Ruth",vendingMachine2.getItem("D").getName());
		assertEquals(0.75,vendingMachine2.getItem("D").getPrice(),0.001);
	}
	
	/**
	 * Test for the addItem() method of the {@link VendingMachine} class.
	 * Add an item to a slot that is already occupied. 
	 */
	@Test
	public void testAddItemB() {
        System.out.println("testAddItemB");
        vendingMachine3.addItem(new VendingMachineItem("Pretzels",0.75), "A");
		try { // try inserting in slot A
			vendingMachine3.addItem(new VendingMachineItem("Fith Avenue",1.00), "A");
		} catch (VendingMachineException e) {
			// test exception error message
			assertEquals("Slot A already occupied", e.getMessage());
		}
        vendingMachine3.addItem(new VendingMachineItem("Peanuts",1.00), "B");
		try { // try inserting in slot B
			vendingMachine3.addItem(new VendingMachineItem("Fith Avenue",1.00), "B");
		} catch (VendingMachineException e) {
			// test exception error message
			assertEquals("Slot B already occupied", e.getMessage());
		}
        vendingMachine3.addItem(new VendingMachineItem("Granola Bar",1.25), "C");
		try { // try inserting in slot C
			vendingMachine3.addItem(new VendingMachineItem("Fith Avenue",1.00), "C");
		} catch (VendingMachineException e) {
			// test exception error message
			assertEquals("Slot C already occupied", e.getMessage());
		}
		vendingMachine3.addItem(new VendingMachineItem("Rasins",0.50), "D");
		try { // try inserting in slot D
			vendingMachine3.addItem(new VendingMachineItem("Fith Avenue",1.00), "D");
		} catch (VendingMachineException e) {
			// test exception error message
			assertEquals("Slot D already occupied", e.getMessage());
		}
	}
	
	/**
	 * Test for the addItem() method of the {@link VendingMachine} class.
	 * Add an item with an invalid code.
	 */
	@Test
	public void testAddItemC() {
        System.out.println("testAddItemC");
        vendingMachine4.addItem(new VendingMachineItem("Snickers",1.50), "A");
		vendingMachine4.addItem(new VendingMachineItem("Butterfinger",1.00), "C");

		try { // try inserting in slot A
			vendingMachine4.addItem(new VendingMachineItem("Fith Avenue",1.00), "E");
		} catch (VendingMachineException e) {
			// test exception error message
			assertEquals("Invalid code for vending machine item", e.getMessage());
		}
		
		try { // try inserting in slot B
			vendingMachine4.addItem(new VendingMachineItem("Fith Avenue",1.00), "K");
		} catch (VendingMachineException e) {
			// test exception error message
			assertEquals("Invalid code for vending machine item", e.getMessage());
		}
		
		try { // try inserting in slot C
			vendingMachine4.addItem(new VendingMachineItem("Fith Avenue",1.00), "P");
		} catch (VendingMachineException e) {
			// test exception error message
			assertEquals("Invalid code for vending machine item", e.getMessage());
		}
		
		try { // try inserting in slot D
			vendingMachine4.addItem(new VendingMachineItem("Fith Avenue",1.00), "Z");
		} catch (VendingMachineException e) {
			// test exception error message
			assertEquals("Invalid code for vending machine item", e.getMessage());
		}
		assertNotNull(vendingMachine4.getItem("A"));
		assertNull(vendingMachine4.getItem("B"));
		assertNotNull(vendingMachine4.getItem("C"));
		assertNull(vendingMachine4.getItem("D"));
	}
	
	/**
	 * Test for the removeItem() method of the {@link VendingMachine} class.
	 * Remove items from occupied slots with invalid codes.
	 */
	@Test
	public void testRemoveItemA() {
        System.out.println("testRemoveItemA");
		vendingMachine5.addItem(new VendingMachineItem("York Peppermint Patty",1.25), "B");
		vendingMachine5.addItem(new VendingMachineItem("Baby Ruth",0.75), "D");

		try { // try removing item from slot E
	        vendingMachine5.removeItem("E");
		} catch (VendingMachineException e) {
			// test exception error message
			assertEquals("Invalid code for vending machine item", e.getMessage());
		}
        
		try { // try removing item from slot P
	        vendingMachine5.removeItem("P");
		} catch (VendingMachineException e) {
			// test exception error message
			assertEquals("Invalid code for vending machine item", e.getMessage());
		}

		try { // try removing item from slot Z
	        vendingMachine5.removeItem("Z");
		} catch (VendingMachineException e) {
			// test exception error message
			assertEquals("Invalid code for vending machine item", e.getMessage());
		}
		assertNull(vendingMachine5.getItem("A"));
		assertNotNull(vendingMachine5.getItem("B"));
		assertNull(vendingMachine5.getItem("C"));
		assertNotNull(vendingMachine5.getItem("D"));
	}
	
	/**
	 * Test for the removeItem() method of the {@link VendingMachine} class.
	 * Remove items from occupied slots with expected input.
	 * 
	 */
	@Test
	public void testRemoveItemB() {
        System.out.println("testRemoveItemB");
//        vendingMachine.removeItem("A");
//        assertNull(vendingMachine.getItem("A"));
//        vendingMachine.removeItem("B");
//        assertNull(vendingMachine.getItem("B"));
//        vendingMachine.removeItem("C");
//        assertNull(vendingMachine.getItem("C"));
//        vendingMachine.removeItem("D");
//       assertNull(vendingMachine.getItem("D"));
	}
	
	/**
	 * Test for the removeItem() method of the {@link VendingMachine} class.
	 * Remove items from empty slots.
	 */
	@Test
	public void testRemoveItemC() {
        System.out.println("testRemoveItemC");
		try { // try removing item from slot A
//	        vendingMachine.removeItem("A");
		} catch (VendingMachineException e) {
			// test exception error message
			assertEquals("Invalid code for vending machine item", e.getMessage());
		}
	}
	
	/**
	 * Test for the removeItem() method of the {@link VendingMachine} class.
	 * Remove items from empty slots with invalid codes.
	 */
	@Test
	public void testRemoveItemD() {
        System.out.println("testRemoveItemD");
		try { // try removing item from slot E
//	        vendingMachine.removeItem("E");
		} catch (VendingMachineException e) {
			// test exception error message
			assertEquals("Invalid code for vending machine item", e.getMessage());
		}
	}
	
	/**
	 * Cleans up test objects after a test case is executed.
	 */
	@AfterClass
	public static void tearDown(){
        System.out.println("tearDown");
        vendingMachine1 = null;
        vendingMachine2 = null;
        vendingMachine3 = null;
        vendingMachine4 = null;
        vendingMachine5 = null;
	}
}
