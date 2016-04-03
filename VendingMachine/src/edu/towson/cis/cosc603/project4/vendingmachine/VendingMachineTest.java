package edu.towson.cis.cosc603.project4.vendingmachine;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class VendingMachineTest {

	/**  Declaring necessary test objects for {@link VendingMachine}. */
	static VendingMachine vendingMachine1; // empty vending machine
	static VendingMachine vendingMachine2;
	static VendingMachine vendingMachine3;
	static VendingMachine vendingMachine4;
	static VendingMachine vendingMachine5; // object to test balance
	static VendingMachine vendingMachine6;
	static VendingMachine vendingMachine7; // object to test makePurchase

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
        vendingMachine6 = new VendingMachine();
        vendingMachine7 = new VendingMachine();
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
		assertNotNull(vendingMachine3.getItem("A"));
		assertNotNull(vendingMachine3.getItem("B"));
		assertNotNull(vendingMachine3.getItem("C"));
		assertNotNull(vendingMachine3.getItem("D"));
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

		try { // try inserting in slot E
			vendingMachine4.addItem(new VendingMachineItem("Fith Avenue",1.00), "E");
		} catch (VendingMachineException e) {
			// test exception error message
			assertEquals("Invalid code for vending machine item", e.getMessage());
		}
		
		try { // try inserting in slot K
			vendingMachine4.addItem(new VendingMachineItem("Fith Avenue",1.00), "K");
		} catch (VendingMachineException e) {
			// test exception error message
			assertEquals("Invalid code for vending machine item", e.getMessage());
		}
		
		try { // try inserting in slot P
			vendingMachine4.addItem(new VendingMachineItem("Fith Avenue",1.00), "P");
		} catch (VendingMachineException e) {
			// test exception error message
			assertEquals("Invalid code for vending machine item", e.getMessage());
		}
		
		try { // try inserting in slot Z
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
	 * Remove items from empty vending machine with invalid codes.
	 */
	@Test
	public void testRemoveItemA() {
        System.out.println("testRemoveItemA");

        try { // try removing item from slot E
	        vendingMachine1.removeItem("E");
		} catch (VendingMachineException e) {
			// test exception error message
			assertEquals("Invalid code for vending machine item", e.getMessage());
		}
        
		try { // try removing item from slot P
	        vendingMachine1.removeItem("P");
		} catch (VendingMachineException e) {
			// test exception error message
			assertEquals("Invalid code for vending machine item", e.getMessage());
		}

		try { // try removing item from slot Z
	        vendingMachine1.removeItem("Z");
		} catch (VendingMachineException e) {
			// test exception error message
			assertEquals("Invalid code for vending machine item", e.getMessage());
		}

		assertNull(vendingMachine1.getItem("A"));
		assertNull(vendingMachine1.getItem("B"));
		assertNull(vendingMachine1.getItem("C"));
		assertNull(vendingMachine1.getItem("D"));
	}
	
	/**
	 * Test for the removeItem() method of the {@link VendingMachine} class.
	 * Remove items from occupied slots with expected input.
	 */
	@Test
	public void testRemoveItemB() {
        System.out.println("testRemoveItemB");
        vendingMachine6.addItem(new VendingMachineItem("Snickers",1.50), "A");
        vendingMachine6.removeItem("A");
        assertNull(vendingMachine6.getItem("A"));
 
		vendingMachine6.addItem(new VendingMachineItem("York Peppermint Patty",1.25), "B");
        vendingMachine6.removeItem("B");
        assertNull(vendingMachine6.getItem("B"));

		vendingMachine6.addItem(new VendingMachineItem("Butterfinger",1.00), "C");
        vendingMachine6.removeItem("C");
        assertNull(vendingMachine6.getItem("C"));

		vendingMachine6.addItem(new VendingMachineItem("Baby Ruth",0.75), "D");
        vendingMachine6.removeItem("D");
        assertNull(vendingMachine6.getItem("D"));
	}
	
	/**
	 * Test for the removeItem() method of the {@link VendingMachine} class.
	 * Remove items from empty vending machine with valid codes.
	 */
	@Test
	public void testRemoveItemC() {
        System.out.println("testRemoveItemC");
		try { // try removing item from slot A
	        vendingMachine1.removeItem("A");
		} catch (VendingMachineException e) {
			// test exception error message
			assertEquals("Slot A is empty -- cannot remove item", e.getMessage());
		}

		try { // try removing item from slot B
	        vendingMachine1.removeItem("B");
		} catch (VendingMachineException e) {
			// test exception error message
			assertEquals("Slot B is empty -- cannot remove item", e.getMessage());
		}
		
		try { // try removing item from slot C
	        vendingMachine1.removeItem("C");
		} catch (VendingMachineException e) {
			// test exception error message
			assertEquals("Slot C is empty -- cannot remove item", e.getMessage());
		}
		
		try { // try removing item from slot D
	        vendingMachine1.removeItem("D");
		} catch (VendingMachineException e) {
			// test exception error message
			assertEquals("Slot D is empty -- cannot remove item", e.getMessage());
		}
		assertNull(vendingMachine1.getItem("A"));
		assertNull(vendingMachine1.getItem("B"));
		assertNull(vendingMachine1.getItem("C"));
		assertNull(vendingMachine1.getItem("D"));
	}
	
	/**
	 * Test for the insertMoney() method of the {@link VendingMachine} class.
	 * Test balance with normal input values.
	 */
	@Test
	public void testInsertMoneyA() {
        System.out.println("testInsertMoneyA");
        Double currentBalance = vendingMachine5.balance;
        vendingMachine5.insertMoney(1.00);
        currentBalance += 1.00;
		assertEquals(currentBalance,vendingMachine5.balance,0.001);
		vendingMachine5.insertMoney(0.00);
		currentBalance += 0.00;
		assertEquals(currentBalance,vendingMachine5.balance,0.001);
		vendingMachine5.insertMoney(0.25);
		currentBalance += 0.25;
		assertEquals(currentBalance,vendingMachine5.balance,0.001);
		vendingMachine5.insertMoney(0.75);
		currentBalance += 0.75;
		assertEquals(currentBalance,vendingMachine5.balance,0.001);
	}
	
	
	/**
	 * Test for the insertMoney() method of the {@link VendingMachine} class.
	 * Test balance with negative input values.
	 */
	@Test
	public void testInsertMoneyB() {
        System.out.println("testInsertMoneyB");
        Double currentBalance = vendingMachine5.balance;
        try {
        	vendingMachine5.insertMoney(-1.00);
        } catch  (VendingMachineException e) {
			// test exception error message
			assertEquals("Invalid amount.  Amount must be >= 0", e.getMessage());
        }
		assertEquals(currentBalance,vendingMachine5.balance,0.001);

		vendingMachine5.insertMoney(1.00);
        currentBalance += 1.00;
		assertEquals(currentBalance,vendingMachine5.balance,0.001);

        try {
        	vendingMachine5.insertMoney(-0.25);
        } catch  (VendingMachineException e) {
			// test exception error message
			assertEquals("Invalid amount.  Amount must be >= 0", e.getMessage());
        }
		assertEquals(currentBalance,vendingMachine5.balance,0.001);

		vendingMachine5.insertMoney(1.00);
        currentBalance += 1.00;
		assertEquals(currentBalance,vendingMachine5.balance,0.001);

        try {
        	vendingMachine5.insertMoney(-0.75);
        } catch  (VendingMachineException e) {
			// test exception error message
			assertEquals("Invalid amount.  Amount must be >= 0", e.getMessage());
        }
		assertEquals(currentBalance,vendingMachine5.balance,0.001);
	}
	
	/**
	 * Test for the getBalance() method of the {@link VendingMachine} class.
	 * Test balance with normal input values.
	 */
	@Test
	public void testGetBalanceA() {
        System.out.println("testGetBalanceA");
        Double currentBalance = vendingMachine5.balance;

        vendingMachine5.insertMoney(0.00);
		assertEquals(currentBalance,vendingMachine5.getBalance(),0.001);

		vendingMachine5.insertMoney(1.00);
        currentBalance += 1.00;
		assertEquals(currentBalance,vendingMachine5.getBalance(),0.001);

		vendingMachine5.insertMoney(0.75);
        currentBalance += 0.75;
		assertEquals(currentBalance,vendingMachine5.getBalance(),0.001);
	}

	/**
	 * Test for the getBalance() method of the {@link VendingMachine} class.
	 * Test balance with negative input values.
	 */
	@Test
	public void testGetBalanceB() {
        System.out.println("testGetBalanceB");
        Double currentBalance = vendingMachine5.balance;

        try {
        	vendingMachine5.insertMoney(-0.75);
        } catch  (VendingMachineException e) {
			// test exception error message
			assertEquals("Invalid amount.  Amount must be >= 0", e.getMessage());
        }
		assertEquals(currentBalance,vendingMachine5.getBalance(),0.001);

		vendingMachine5.insertMoney(0.75);
        currentBalance += 0.75;

        try {
        	vendingMachine5.insertMoney(-1.75);
        } catch  (VendingMachineException e) {
			// test exception error message
			assertEquals("Invalid amount.  Amount must be >= 0", e.getMessage());
        }
		assertEquals(currentBalance,vendingMachine5.getBalance(),0.001);
	}

	/**
	 * Test for the makePurchase() method of the {@link VendingMachine} class.
	 * Test making a purchase from an empty vending machine.
	 */
	@Test
	public void testMakePurchaseA() {
        System.out.println("testMakePurchaseA");
		assertFalse(vendingMachine7.makePurchase("A"));
		assertFalse(vendingMachine7.makePurchase("B"));
		assertFalse(vendingMachine7.makePurchase("C"));
		assertFalse(vendingMachine7.makePurchase("D"));
	}
	
	/**
	 * Test for the makePurchase() method of the {@link VendingMachine} class.
	 * Test the amount of the item is subtracted from the balance
	 * and the item slot is empty with normal input values.
	 */
	@Test
	public void testMakePurchaseB() {
        System.out.println("testMakePurchaseB");
		Double currentBalance;
		vendingMachine7.addItem(new VendingMachineItem("Snickers",1.50), "A");
 		vendingMachine7.addItem(new VendingMachineItem("York Peppermint Patty",1.25), "B");
		vendingMachine7.addItem(new VendingMachineItem("Butterfinger",1.00), "C");
		vendingMachine7.addItem(new VendingMachineItem("Baby Ruth",1.25), "D");
		vendingMachine7.insertMoney(5.00);
		currentBalance = vendingMachine7.getBalance();
		vendingMachine7.makePurchase("A");
        currentBalance -= 1.50;		
		assertNull(vendingMachine7.getItem("A"));
		assertEquals(currentBalance,vendingMachine7.getBalance(),0.001);
		vendingMachine7.makePurchase("C");
        currentBalance -= 1.00;		
		assertNull(vendingMachine7.getItem("C"));
		assertEquals(currentBalance,vendingMachine7.getBalance(),0.001);
		vendingMachine7.makePurchase("B");
        currentBalance -= 1.25;		
		assertNull(vendingMachine7.getItem("B"));
		assertEquals(currentBalance,vendingMachine7.getBalance(),0.001);
		vendingMachine7.makePurchase("D");
        currentBalance -= 1.25;		
		assertNull(vendingMachine7.getItem("D"));
		assertEquals(currentBalance,vendingMachine7.getBalance(),0.001);	
	}
	
	/**
	 * Test for the makePurchase() method of the {@link VendingMachine} class.
	 * Test making a purchase for an item with insufficient balance.
	 */
	@Test
	public void testMakePurchaseC() {
        System.out.println("testMakePurchaseC");
        vendingMachine7.addItem(new VendingMachineItem("Snickers",1.50), "A");
 		vendingMachine7.addItem(new VendingMachineItem("York Peppermint Patty",1.25), "B");
		vendingMachine7.addItem(new VendingMachineItem("Butterfinger",1.00), "C");
		vendingMachine7.addItem(new VendingMachineItem("Baby Ruth",1.25), "D");
		assertFalse(vendingMachine7.makePurchase("A"));
		vendingMachine7.insertMoney(0.25);
		assertFalse(vendingMachine7.makePurchase("B"));
		vendingMachine7.insertMoney(0.5);
		assertFalse(vendingMachine7.makePurchase("C"));
		assertFalse(vendingMachine7.makePurchase("D"));
	}
	
	/**
	 * Test for the makePurchase() method of the {@link VendingMachine} class.
	 * Test making a purchase for an item with invalid slot code.
	 */
	@Test
	public void testMakePurchaseD() {
        System.out.println("testMakePurchaseD");
        try {
        	vendingMachine7.makePurchase("E");
        } catch  (VendingMachineException e) {
			// test exception error message
			assertEquals("Invalid code for vending machine item", e.getMessage());
        }
        
        try {
        	vendingMachine7.makePurchase("P");
        } catch  (VendingMachineException e) {
			// test exception error message
			assertEquals("Invalid code for vending machine item", e.getMessage());
        }
        
        try {
        	vendingMachine7.makePurchase("Z");
        } catch  (VendingMachineException e) {
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
        vendingMachine6 = null;
        vendingMachine7 = null;
	}
}
