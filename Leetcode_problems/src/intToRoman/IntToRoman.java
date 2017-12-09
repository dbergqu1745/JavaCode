package intToRoman;

/*
 * Returns String representation of number as roman numerals from i to mmmcmxcix
 * 																1      3999
 * 1000s place + 100s place + 10s place + 1s place
 * divide by 1000, save remainder
 * divide by 100, save remainder
 * divide by 10, save remainder
 * divide by 1, save remainder
 */

public class IntToRoman {
	public static String intToRoman(int num) {
		String romanString;
		
		final String[][] NUMERALS = {{"", "i", "ii", "iii", "iv", "v", "vi", "vii", "viii", "ix"},
									{"", "x", "xx", "xxx", "xl", "l", "lx", "lxx", "lxxx", "xc"},
									{"", "c", "cc", "ccc", "cd", "d", "dc", "dcc", "dccc", "cm"},
									{"", "m", "mm", "mmm"}};
		
		romanString = "" + NUMERALS[3][num / 1000] + 
						  NUMERALS[2][(num % 1000) / 100] + 
						  NUMERALS[1][(num % 100) / 10] + 
						  NUMERALS[0][(num % 10) / 1];
		
		return romanString;
	}
	
//	public static void main(String[] args) {
//		System.out.println(3999 + " in roman numerals is " + IntToRoman.intToRoman(3999));
//	}
}
