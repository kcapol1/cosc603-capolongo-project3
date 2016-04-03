package edu.towson.cis.cosc603.project4.vendingmachine;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class VendingMachineTest {

	/**  Declaring necessary test objects for {@link VendingMachine}. */
	static VendingMachine vendingMachine;

	/**
	 * Initializes the necessary test objects for the test cases to use.
	 * 
	 * @throws Exception the exception
	 */
	@BeforeClass
	public static void setUp() throws Exception {
        System.out.println("setUp");
        vendingMachine = new VendingMachine();
	}
	
	/**
	 * Test for the addItem() method of the {@link VendingMachine} class.
	 * Test constructor postcondition: all entries in itemArray are null, balance set to be 0
	 */
	@Test
	public void testVendingMachine() {
        System.out.println("testVendingMachine");
		assertNull(vendingMachine.getItem("A"));
		assertNull(vendingMachine.getItem("B"));
		assertNull(vendingMachine.getItem("C"));
		assertNull(vendingMachine.getItem("D"));
		assertEquals(0,vendingMachine.balance,0.001);
	}
	
	/**
	 * Test for the addItem() method of the {@link VendingMachine} class.
	 * Add items with normal input.
	 */
	@Test
	public void testAddItemA() {
        System.out.println("testAddItemA");
        vendingMachine.addItem(new VendingMachineItem("Snickers",1.50), "A");
        vendingMachine.addItem(new VendingMachineItem("York Peppermint Patty",1.50), "B");
        vendingMachine.addItem(new VendingMachineItem("Butterfinger",1.00), "C");
        vendingMachine.addItem(new VendingMachineItem("Baby Ruth",1.00), "D");
	}
	
	/**
	 * Test for the addItem() method of the {@link VendingMachine} class.
	 * Add an item to a slot that is already occupied. 
	 */
	@Test
	public void testAddItemB() {
        System.out.println("testAddItemB");
		try { // try inserting in slot A
			vendingMachine.addItem(new VendingMachineItem("Fith Avenue",1.00), "A");
		} catch (VendingMachineException e) {
			// test exception error message
			assertEquals("Slot A already occupied", e.getMessage());
		}
		
		try { // try inserting in slot B
			vendingMachine.addItem(new VendingMachineItem("Fith Avenue",1.00), "B");
		} catch (VendingMachineException e) {
			// test exception error message
			assertEquals("Slot B already occupied", e.getMessage());
		}
		
		try { // try inserting in slot C
			vendingMachine.addItem(new VendingMachineItem("Fith Avenue",1.00), "C");
		} catch (VendingMachineException e) {
			// test exception error message
			assertEquals("Slot C already occupied", e.getMessage());
		}
		try { // try inserting in slot D
			vendingMachine.addItem(new VendingMachineItem("Fith Avenue",1.00), "D");
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
		try { // try inserting in slot A
			vendingMachine.addItem(new VendingMachineItem("Fith Avenue",1.00), "E");
		} catch (VendingMachineException e) {
			// test exception error message
			assertEquals("Invalid code for vending machine item", e.getMessage());
		}
		
		try { // try inserting in slot B
			vendingMachine.addItem(new VendingMachineItem("Fith Avenue",1.00), "K");
		} catch (VendingMachineException e) {
			// test exception error message
			assertEquals("Invalid code for vending machine item", e.getMessage());
		}
		
		try { // try inserting in slot C
			vendingMachine.addItem(new VendingMachineItem("Fith Avenue",1.00), "P");
		} catch (VendingMachineException e) {
			// test exception error message
			assertEquals("Invalid code for vending machine item", e.getMessage());
		}
		try { // try inserting in slot D
			vendingMachine.addItem(new VendingMachineItem("Fith Avenue",1.00), "Z");
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
        vendingMachine = null;
	}
}
