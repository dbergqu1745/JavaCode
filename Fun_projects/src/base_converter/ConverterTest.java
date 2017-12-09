package base_converter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ConverterTest {
	Converter c;

	@Before
	public void setUp() throws Exception {
		c = new Converter();
	}

	@Test (timeout = 100)
	public void testZero() {
		assertEquals("converter(): check the case where num is 0", "0", c.converter(0, 3));
	}
	
	@Test (timeout = 100)
	public void testTenBinary() throws Exception {
		assertEquals("converter(): check how the mehtod converts the number", "1010", c.converter(10, 2));
	}
	
	@Test (timeout = 100)
	public void testConverterTernary() throws Exception {
		assertEquals("converter(): check how the method computes the strings", "201", c.converter(19, 3));
	}
	
	@Test (timeout = 100)
	public void testConverterOctal() throws Exception {
		assertEquals("converter(): check how the method computes the strings", "45", c.converter(37, 8));
	}
	
	@Test
	public void testConverterPental() throws Exception {
		assertEquals("converter(): check how the method computes the string", "34", c.converter(19, 5));
	}
	
	@Test
	public void testConvertermoreThanTen() throws Exception {
		assertEquals("converter...(): check how the method converts the number", "1C7", c.converter(500, 17));
	}
}
