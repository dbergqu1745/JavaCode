package assignment_2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Assignment 2 - Rational number test class
 * Due 9/22/17
 */

public class TestRationalNumber {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testToString() {
		RationalNumber rn = new RationalNumber(1, 2);
		
		assertEquals(rn.toString(), "1/2");
	}
	
	@Test
	public void testEquals() {
		RationalNumber rn1 = new RationalNumber(1, 2);
		RationalNumber rn2 = new RationalNumber(1, 2);
		
		assertTrue(rn1.equals(rn2));
	}
	
	@Test
	public void testIsEquivalent() {
		RationalNumber rn1 = new RationalNumber(1, 2);
		RationalNumber rn2 = new RationalNumber(2, 4);
		
		assertTrue(rn1.isEquivalent(rn2));
	}
	
	@Test
	public void testAddVersionOne() {
		RationalNumber rn1 = new RationalNumber(1, 2);
		RationalNumber rn2 = new RationalNumber(1, 4);
		
		RationalNumber sum = RationalNumber.add(rn1, rn2);
		
		assertEquals(sum.toString(), "3/4");
	}
	
	@Test
	public void testAddVersionTwo() {
		RationalNumber rn1 = new RationalNumber(1, 2);
		RationalNumber rn2 = new RationalNumber(1, 4);
		
		rn1.add(rn2);
		
		assertEquals(rn1.toString(), "3/4");
	}
	
	@Test
	public void testSubtractVersionOne() {
		RationalNumber rn1 = new RationalNumber(24, 27);
		RationalNumber rn2 = new RationalNumber(1, 2);
		
		RationalNumber sum = RationalNumber.subtract(rn1, rn2);
		
		assertEquals(sum.toString(), "7/18");
	}
	
	@Test
	public void testSubtractVersionTwo() {
		RationalNumber rn1 = new RationalNumber(1, 2);
		RationalNumber rn2 = new RationalNumber(1, 4);
		
		rn1.subtract(rn2);
		
		assertEquals(rn1.toString(), "1/4");
	}
	
	@Test
	public void testMultiplyVersionOne() {
		RationalNumber rn1 = new RationalNumber(24, 27);
		RationalNumber rn2 = new RationalNumber(3, 4);
		
		RationalNumber prod = RationalNumber.multiply(rn1, rn2);
		
		assertEquals(prod.toString(), "2/3");
	}
	
	@Test
	public void testMultiplyVersionTwo() {
		RationalNumber rn1 = new RationalNumber(0, 1);
		RationalNumber rn2 = new RationalNumber(0, 2);
		
		rn1.multiply(rn2);
		
		assertEquals(rn1.toString(), "0/2");
	}
	
	@Test
	public void testDivideVersionOne() {
		RationalNumber rn1 = new RationalNumber(24, 27);
		RationalNumber rn2 = new RationalNumber(1, 2);
		
		RationalNumber quot = RationalNumber.divide(rn1, rn2);
		
		assertEquals(quot.toString(), "16/9");
	}
	
	@Test
	public void testDivideVersionTwo() {
		RationalNumber rn1 = new RationalNumber(9, 37);
		RationalNumber rn2 = new RationalNumber(3, 1);
		
		rn1.divide(rn2);
		
		assertEquals(rn1.toString(), "3/37");
	}

}
