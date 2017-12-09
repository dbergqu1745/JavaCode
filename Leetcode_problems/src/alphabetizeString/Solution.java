package alphabetizeString;

import java.util.Arrays;

//Question from Accelogix technical interview

public class Solution {
	
	public static String alphabetizeString(String preWord) {
		char[] sortWord = preWord.toCharArray();
		int len = preWord.length();
		preWord = "";
		
		Arrays.sort(sortWord);
		
		for (int i = 0; i < len; i++) {
			preWord += sortWord[i];
		}
		
		return preWord;
	}
	
	public static void main(String[] args) {
		
		
		System.out.println(Solution.alphabetizeString("daniel"));
	}
}
