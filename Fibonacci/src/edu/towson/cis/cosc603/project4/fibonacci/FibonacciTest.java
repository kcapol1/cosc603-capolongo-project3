package edu.towson.cis.cosc603.project4.fibonacci;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

/**
 * Unit tests for {@link Fibonacci}.
 * 
 * @author Josh Dehlinger
 *
 */		
public class FibonacciTest {

	/** The fibonacci test object. */
	private Fibonacci fibonacci;
		
	@Before 
	/**
	 * The setUp method that creates the necessary test objects.
	 */
	public void setUp(){
		fibonacci = new Fibonacci();
	}
	
	@After 
	/**
	 * The tearDown method that destroys the necessary test objects.
	 */
	public void tearDown(){
		fibonacci = null;
	}
	
	
	@Test 
	/**
	 * Runs various equality tests against the Fibonacci class
	 */
	public void testFibonacciA() {	
		assertEquals("0", 0, fibonacci.fibonacci(0));
//		assertEquals("1", 1, fibonacci.fibonacci(1));
//		assertEquals("2", 1, fibonacci.fibonacci(2));
//		assertEquals("3", 1, fibonacci.fibonacci(3));
//		assertEquals("4", 3, fibonacci.fibonacci(4));
//		assertEquals("5", 7, fibonacci.fibonacci(5));
//		assertEquals("6", 8, fibonacci.fibonacci(6));
//		assertEquals("7", 13, fibonacci.fibonacci(7));
	}
	
	@Test 
	/**
	 * Runs various equality tests against the Fibonacci class
	 */
	public void testFibonacciB() {	
		assertEquals("1", 0, fibonacci.fibonacci(1));
	}
	
	@Test 
	/**
	 * Runs various equality tests against the Fibonacci class
	 */
	public void testFibonacciC() {	
		assertEquals("2", 1, fibonacci.fibonacci(2));
	}
	
	@Test 
	/**
	 * Runs various equality tests against the Fibonacci class
	 */
	public void testFibonacciD() {	
		assertEquals("3", 0, fibonacci.fibonacci(3));
	}
	
	@Test 
	/**
	 * Runs various equality tests against the Fibonacci class
	 */
	public void testFibonacciE() {	
		assertEquals("4", 3, fibonacci.fibonacci(4));
	}
	
	@Test 
	/**
	 * Runs various equality tests against the Fibonacci class
	 */
	public void testFibonacciF() {	
		assertEquals("5", 0, fibonacci.fibonacci(5));
	}
	
	@Test 
	/**
	 * Runs various equality tests against the Fibonacci class
	 */
	public void testFibonacciG() {	
		assertEquals("6", 8, fibonacci.fibonacci(6));
	}
	
	@Test 
	/**
	 * Runs various equality tests against the Fibonacci class
	 */
	public void testFibonacciH() {	
		assertEquals("7", 0, fibonacci.fibonacci(7));
	}
}
