package lab2;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Due 9/14/17
 * Assignment 2 - Pizza and PizzaOrder test class using Junit
 */
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PizzaTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalcCost() {
		Pizza pizza = new Pizza("large", 1, 1, 2);
		double realCost = 22.0;
		
		assertTrue(pizza.calcCost() == realCost);
	}
	
	@Test
	public void testCalcTotal() {
		PizzaOrder order66 = new PizzaOrder(5);
		Pizza pizza1 = new Pizza("large", 1, 1, 2);
		Pizza pizza2 = new Pizza("large", 1, 1, 2);
		Pizza pizza3 = new Pizza("large", 1, 1, 2);
		Pizza pizza4 = new Pizza("large", 1, 1, 2);
		Pizza pizza5 = new Pizza("large", 1, 1, 2);
		
		order66.setNumPizzas(0, pizza1);
		order66.setNumPizzas(1, pizza2);
		order66.setNumPizzas(2, pizza3);
		order66.setNumPizzas(3, pizza4);
		order66.setNumPizzas(4, pizza5);
		
		assertTrue(order66.calcTotal() == 110);
	}
//	
	
//	
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}

}
