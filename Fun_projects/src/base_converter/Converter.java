package base_converter;

/*
 * CS 180 - programming assignment for fun
 * This program can convert any number in base 10 to a base less than 36 (0-9 A-Z)
 */

import javax.swing.*;

public class Converter {
	
	
	public String converter(int num, int base) {
		String converted = ""; //converted number as a string
		String[] possible = new String[base]; //all possible expressions of a remainder
		String[] alph = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
				"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", 
				"U", "V", "W", "X", "Y", "Z"};
		
		if (num == 0)
			return "0";
		else if (base == 0)
			return "this is not mathematically possible";
		else if (base == 10)
			return Integer.toString(num);
		else if (base > 36)
			return "Sorry, that feature is not available at this time";
		else if (base < 36) {
			for (int i = 0; i < base; i++) {
				if (i < 10)
					possible[i] = Integer.toString(i);
				else if (i >= 10)
					possible[i] = alph[i - 10];
			}
			while (true) {
				converted = possible[num % base] + converted;
				if (base > num)
					break;
				num /= base;
			}
		}
		
		return converted;
	}
	
	public boolean checkForLetters(String num) {
		char[] nums = num.toCharArray();
		
		for (char c : nums) {
			if (!Character.isDigit(c)) {
				JOptionPane.showMessageDialog(null, "Unacceptable input",
						"Warning!", JOptionPane.WARNING_MESSAGE);
				return false;
			}
		}
		return true;
	}
	
	public void converterGUI() {
		boolean bool1 = true;
		boolean bool2 = true;
		boolean bool3 = true;
		String msg = "Base Converter";
		String num = "";
		String base = "";
		
		JOptionPane.showMessageDialog(null, "Welcome to the base converter", msg, JOptionPane.INFORMATION_MESSAGE);
		
		do {
			
			do {
				num = JOptionPane.showInputDialog(null, "Enter a number in base 10", msg, JOptionPane.QUESTION_MESSAGE);
				bool2 = checkForLetters(num);
			} while (!bool2);
			
			do {
				base = JOptionPane.showInputDialog(null, "Enter the base to which you would like to convert " + num, msg, JOptionPane.QUESTION_MESSAGE);
				bool3 = checkForLetters(base);
			} while (!bool3);
			
			JOptionPane.showMessageDialog(null, num + " in base " + base + " is: " + converter(Integer.parseInt(num), Integer.parseInt(base)), msg, JOptionPane.PLAIN_MESSAGE);
			
			int choice = JOptionPane.showConfirmDialog(null, "Would you like to continue?", msg, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if (choice == JOptionPane.YES_OPTION)
				bool1 = true;
			else if (choice == JOptionPane.NO_OPTION)
				bool1 = false;
		} while(bool1);
	}
	
	public static void main(String[] args) {
		Converter c = new Converter();
		c.converterGUI();
	}
}
