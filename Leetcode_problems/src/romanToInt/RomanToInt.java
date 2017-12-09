package romanToInt;

import java.util.HashMap;

/*
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 												  i    mmmcmxcix
 */

public class RomanToInt {
	public static int romToInt(String roman) {
		int sum = 0;
		int len = roman.length() - 1;
		char[] romanChars = roman.toCharArray();
		HashMap<Character, Integer> numerals = new HashMap<Character, Integer>(7);
		
		numerals.put('i', 1);
		numerals.put('v', 5);
		numerals.put('x', 10);
		numerals.put('l', 50);
		numerals.put('c', 100);
		numerals.put('d', 500);
		numerals.put('m', 1000);
		
		for (int i = len; i >= 0;) {
			if ((i != 0) && (numerals.get(romanChars[i]) > numerals.get(romanChars[i - 1]))) {
				sum += (numerals.get(romanChars[i]) - numerals.get(romanChars[i - 1]));
				i -= 2;
			} else {
				sum += numerals.get(romanChars[i]);
				i--;
			}
		}
		return sum;
	}
}
