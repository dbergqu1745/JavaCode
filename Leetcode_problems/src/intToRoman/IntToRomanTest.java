package intToRoman;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IntToRomanTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMin() {
		assertEquals("i", IntToRoman.intToRoman(1));
	}
	
	@Test
	public void testMax() {
		assertEquals("mmmcmxcix", IntToRoman.intToRoman(3999));
	}
	
	@Test
	public void test1() {
		assertEquals("xxi", IntToRoman.intToRoman(21));
	}
	
	@Test
	public void test2() {
		assertEquals("lv", IntToRoman.intToRoman(55));
	}
	
	@Test
	public void test3() {
		assertEquals("lv", IntToRoman.intToRoman(55));
	}
	
	@Test
	public void test4() {
		assertEquals("lxxiii", IntToRoman.intToRoman(73));
	}
	
	@Test
	public void testBefore1() {
		assertEquals("xix", IntToRoman.intToRoman(19));
	}
	
	@Test
	public void testBefore2() {
		assertEquals("xl", IntToRoman.intToRoman(40));
	}
	
	@Test
	public void testBefore3() {
		assertEquals("cccxc", IntToRoman.intToRoman(390));
	}
	
	@Test
	public void testBefore4() {
		assertEquals("cd", IntToRoman.intToRoman(400));
	}
	
	@Test
	public void test2Before1() {
		assertEquals("xliv", IntToRoman.intToRoman(44));
	}
	
	@Test
	public void test2Before2() {
		assertEquals("mcdxciv", IntToRoman.intToRoman(1494));
	}
	
	@Test
	public void testTrailing8() {
		assertEquals("xcviii", IntToRoman.intToRoman(98));
	}
	
	

}
