package check_writer;

import java.util.ArrayList;

/* Problem: 
 * Given a dollar amount between 0.00 and 999,999.00, create a program that will 
 * provide a worded representation of a dollar amount on a check.
 * 
 * 400120.0 -> Four hundred thousand, one hundred twenty dollars and zero cents.
 */
public class CheckWriter {
	
	public int[] numToArray(int amount) {
		String numString = String.valueOf(amount);
		int len = numString.length();
		
		int numAsArray[] = new int[len];
		
		for (int i = 0; i < len; i++) {
			numAsArray[i] = numString.charAt(i);
		}
		
		return numAsArray;
	}
	
	public String buildString(ArrayList<Integer> places) {
		String num = "";
		
		
		
		return num;
	}
	
	public static void main(String[] args) {
		CheckWriter cw = new CheckWriter();
		
		
	}
}
/* 
 *  
 */
