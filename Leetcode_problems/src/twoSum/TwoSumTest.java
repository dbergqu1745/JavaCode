package twoSum;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoSumTest {
	int[] output = new int[2];
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		int[] ints = {2, 7, 11, 15};
		int target = 9;
		
		output = TwoSum.twoSum(ints, target);
		
		assertEquals(0, output[0]);
		assertEquals(1, output[1]);
	}
	
	@Test
	public void testZeroes() {
		int[] ints = {0, 0, 0, 0};
		int target = 0;
		
		output = TwoSum.twoSum(ints, target);
		
		assertEquals(0, output[0]);
		assertEquals(3, output[1]);
	}
	
	@Test
	public void testMiddles() {
		int[] ints = {6, 6, 6, 6, 6, 6, 5, 4, 6, 6, 6, 6, 6, 6};
		int target = 9;
		
		output = TwoSum.twoSum(ints, target);
		
		assertEquals(6, output[0]);
		assertEquals(7, output[1]);
	}
	
	@Test
	public void testEnds() {
		int[] ints = {5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 4};
		int target = 9;
		
		output = TwoSum.twoSum(ints, target);
		
		assertEquals(0, output[0]);
		assertEquals(13, output[1]);
	}
	
	@Test
	public void testFailCase() {
		int[] ints = {5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 4};
		int target = 13;
		
		output = TwoSum.twoSum(ints, target);
		
		assertEquals(0, output[0]);
		assertEquals(0, output[1]);
	}

}
