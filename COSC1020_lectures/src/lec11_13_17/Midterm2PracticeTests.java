package lec11_13_17;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Midterm2PracticeTests {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {

	}

	@Test
	void testIndexOfSmallestBeg() {
		double[] a = { 0, 2, 3, 8, 9, 5 };

		assertEquals(Midterm2Practice.indexOfSmallest(0, a), 0);
	}

	@Test
	void testIndexOfSmallestLast() {
		double[] a = { 2, 2, 3, 8, 9, 5, 0 };

		assertEquals(Midterm2Practice.indexOfSmallest(2, a), 6);
	}

	@Test
	void testIndexOfSmallest() {
		double[] a = { 2, 2, 3, 8, 0, 5, 10 };

		assertEquals(Midterm2Practice.indexOfSmallest(5, a), 5);
	}

	@Test
	void testGetAverage1() {
		ArrayList<Double> d = new ArrayList<Double>();

		for (int i = 0; i < 20; i++) {
			d.add((double) i + 1);
		}

		assertEquals(Midterm2Practice.getAverage(d), 10.5);
	}

	@Test
	void testGetAverage2() {
		ArrayList<Double> d = new ArrayList<Double>();

		for (int i = 2; i < 20; i +=2) {
			d.add((double) i + 19);
		}
		
		assertEquals(Midterm2Practice.getAverage(d), 29);
	}
	
	@Test
	void testGetAverageZeroes() {
		ArrayList<Double> d = new ArrayList<Double>();

		for (int i = 0; i < 20; i++) {
			d.add(0.0);
		}
		
		assertEquals(Midterm2Practice.getAverage(d), 0);
	}
	
	@Test
	void testGetAverageNegatives() {
		ArrayList<Double> d = new ArrayList<Double>();

		for (int i = 0; i < 20; i++) {
			d.add(-1 * ((double)(i + 1)));
		}
		
		assertEquals(Midterm2Practice.getAverage(d), -10.5);
	}
	
	@Test
	void testGetShortNames() {
		ArrayList<String> strings = new ArrayList<String>();
		ArrayList<String> testList = new ArrayList<String>();
		
		testList.add("asdf");
		testList.add("a");
		testList.add("as");
		testList.add("cat");
		testList.add("Daniel");
		
		strings.add("a");
		strings.add("as");
		strings.add("cat");
		
		
		testList = Midterm2Practice.getShortNamesFromList(testList);
		
		assertEquals(testList, strings);
	}
	
	@Test
	void testGetShortNamesWithEmptyString() {
		ArrayList<String> strings = new ArrayList<String>();
		ArrayList<String> testList = new ArrayList<String>();
		
		testList.add("asdf");
		testList.add("a");
		testList.add("");
		testList.add("as");
		testList.add("cat");
		testList.add("Daniel");
		
		strings.add("a");
		strings.add("");
		strings.add("as");
		strings.add("cat");
		
		testList = Midterm2Practice.getShortNamesFromList(testList);
		
		assertEquals(testList, strings);
	}
	
	@Test
	void testGetShortNames2() {
		ArrayList<String> resultList = new ArrayList<String>();
		ArrayList<String> testList = new ArrayList<String>();
		String temp = "";
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				temp += "a";
				
				if (temp.length() <= 3) {
					testList.add(temp);
				}
			
				resultList.add(temp);
			}
		}
		resultList = Midterm2Practice.getShortNamesFromList(resultList);
		
		assertEquals(resultList, testList);
	}
	
	@Test
	void testDouble21() {
		Double2 d1 = new Double2(19.9);
		Double2 d2 = new Double2(20.0);

		assertTrue(d1.compareTo(d2) < 0);
	}
	
	@Test
	void testDouble22() {
		Double2 d1 = new Double2(20.0);
		Double2 d2 = new Double2(19.9);

		assertTrue(d1.compareTo(d2) > 0);
	}
	
	@Test
	void testDouble23() {
		Double2 d1 = new Double2(20.0);
		Double2 d2 = new Double2(20.0);

		assertTrue(d1.compareTo(d2) == 0);
	}
	
	@Test
	void testDouble24() {
		Double2 d1 = new Double2(20.00001);
		Double2 d2 = new Double2(20.000001);

		assertTrue(d1.compareTo(d2) > 0);
	}
	
	@Test
	void testDouble25() {
		Double2 d1 = new Double2(20.00000000000000000001);
		Double2 d2 = new Double2(20.000000000000000000001);

		assertTrue(d1.compareTo(d2) > 0);
	}
}
