package romanToInt;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RomanToIntTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMin() {
		assertEquals(1, RomanToInt.romToInt("i"));
	}
	
	@Test
	public void test2() {
		assertEquals(21, RomanToInt.romToInt("xxi"));
	}
	
	@Test
	public void test3() {
		assertEquals(55, RomanToInt.romToInt("lv"));
	}
	
	@Test
	public void test4() {
		assertEquals(73, RomanToInt.romToInt("lxxiii"));
	}
	
	@Test
	public void testBefore1() {
		assertEquals(19, RomanToInt.romToInt("xix"));
	}
	
	@Test
	public void testBefore2() {
		assertEquals(40, RomanToInt.romToInt("xl"));
	}
	
	@Test
	public void testBefore3() {
		assertEquals(390, RomanToInt.romToInt("cccxc"));
	}
	
	@Test
	public void testBefore4() {
		assertEquals(400, RomanToInt.romToInt("cd"));
	}
	
	@Test
	public void test2Before1() {
		assertEquals(44, RomanToInt.romToInt("xliv"));
	}
	
	@Test
	public void test2Before2() {
		assertEquals(1494, RomanToInt.romToInt("mcdxciv"));
	}
	
	@Test
	public void testMax() {
		assertEquals(3999, RomanToInt.romToInt("mmmcmxcix"));
	}
	
	@Test
	public void testTrailing8() {
		assertEquals(98, RomanToInt.romToInt("xcviii"));
	}

}
