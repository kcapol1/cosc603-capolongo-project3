/*
 * 
 */
package edu.towson.cis.cosc603.project4.rectangle;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The unit test Class for Rectangle.
 */
public class RectangleTest {
	
	/**  Declaring necessary test objects for {@link Rectangle}. */
	static Rectangle rect1;
	
	/** The rect2. */
	static Rectangle rect2;

	/**
	 * Initializes the necessary test objects for the test cases to use.
	 *
	 * @throws Exception the exception
	 */
	@BeforeClass
	public static void setUp() throws Exception {
//        System.out.println("setUp");
		rect1 = new Rectangle(new Point(2.0, 2.0), new Point(4.0, 7.0));
		rect2 = new Rectangle(new Point(2.0, 6.0), new Point(4.0, 3.0));
	}

	/**
	 * Test for the testGetP1() method of the {@link Rectangle} class.
	 */
	@Test
	public void testGetP1() {
//        System.out.println("testGetP1");
		assertEquals(2.0, rect1.getP1().x,0.001);
		assertEquals(2.0, rect1.getP1().y,0.001);
	}

	/**
	 * Test for the testGetP2() method of the {@link Rectangle} class.
	 */
	@Test
	public void testGetP2() {
//        System.out.println("testGetP2");
		assertEquals(4.0, rect1.getP2().x,0.001);
		assertEquals(7.0, rect1.getP2().y,0.001);
	}

	/**
	 * Test for the getArea() method of the {@link Rectangle} class.
	 */
	@Test
	public void testGetArea() {
//        System.out.println("testGetArea");
		assertEquals(10.0, rect1.getArea(),0.001);
		assertEquals(6.0, rect2.getArea(),0.001);
	}
	
	/**
	 * Test for the getDiagonal() method of the {@link Rectangle} class.
	 */
	@Test
	public void testGetDiagonal() {
//        System.out.println("testGetDiagonal");
		assertEquals(5.3852, rect1.getDiagonal(), 0.0001);
		assertEquals(3.6056, rect2.getDiagonal(), 0.0001);
	}
	
	/**
	 * Cleans up test objects after a test case is executed.
	 */
	@AfterClass
	public static void tearDown(){
//        System.out.println("tearDown");
		rect1 = null;
		rect2 = null;
	}
}
