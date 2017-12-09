package phoneNumberLetters17;

import java.util.*;

/*
 * Given a digit string, return all possible letter combinations that the number could represent.
 * 2 -> a, b, c
 * 3 -> d, e, f
 * 4 -> g, h, i
 * 5 -> j, k, l
 * 6 -> m, n, o
 * 7 -> p, q, r, s
 * 8 -> t, u, v 
 * 9 -> w, x, y, z
 * ====
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * ====
 * Division of labor:
 * 
 * Each number in the digit string is mapped to 3 or 4 possible letters 
 */

class Solution {
	/*
	public List<String> letterCombinations(String digits) {
        
		List<String> combinations;
        char[] indDigits = digits.toCharArray();
        int digitsLen = indDigits.length;
        int valueLen;
        char digit;
        String letters = "";
        
        char[] _2 = {'a', 'b', 'c'};
        char[] _3 = {'d', 'e', 'f'};
        char[] _4 = {'g', 'h', 'i'};
        char[] _5 = {'j', 'k', 'l'};
        char[] _6 = {'m', 'n', 'o'};
        char[] _7 = {'p', 'q', 'r', 's'};
        char[] _8 = {'t', 'u', 'v'};
        char[] _9 = {'w', 'x', 'y', 'z'};
        
        HashMap<Character, char[]> phoneButtons = new HashMap<Character, char[]>(8);
        
        phoneButtons.put('2', _2);
        phoneButtons.put('3', _3);
        phoneButtons.put('4', _4);
        phoneButtons.put('5', _5);
        phoneButtons.put('6', _6);
        phoneButtons.put('7', _7);
        phoneButtons.put('8', _8);
        phoneButtons.put('9', _9);
        
        
        for (int i = 0; i < digitsLen; i++) {
        		
        		digit = indDigits[i];
        		valueLen = phoneButtons.get(digit).length;
        		
        		for (int j = 0; j < valueLen; j++) {
        			
        			letters += phoneButtons.get(digit)[j];
        		}
        }
        
        return combinations;
    }
    
    */
}
