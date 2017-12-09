package hashmappractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * This program creates a histogram representing the number of times a word occurs in a body of text
 * ====
 * Division of labor:
 * 	a method opens the file, reads the next word into an arraylist of Strings 
 *   if the word is already present in the arraylist, increment the word's counter in the neighboring arraylist
 *   else, add the word to the string arraylist and add a zero to the neighboring arraylist
 */

public class Histogram {
	
//	public static void buildHistogram(String fileName, ArrayList<int[]> counterList, ArrayList<String> wordList) {
	public static void buildHistogram(String fileName, HashMap<String, int[]> histogram) {
		
		
		File f;
		Scanner in;
		String input;
		int[] initialCount;
		//int ind;
		
		try {
			f = new File(fileName);
			in = new Scanner(f);
			
			while (in.hasNext()) {
				input = in.next();
				
				//Remove punctuation, convert to all lowercase
				input = input.replaceAll("\\p{Punct}", "").toLowerCase();
				
//				if (!wordList.contains(input)) { //dual arraylist
				if (input.equals("")) {
					continue;
				} else if (!(histogram.containsKey(input))  ) { //hashmap
					
					//HashMap
					initialCount = new int[1];
					initialCount[0] = 1;
					
					//Dual ArrayList
//					wordList.add(input);
//					counterList.add(initialCount);
					
					histogram.put(input, initialCount);
				
				} else {
					
					//dual ArrayList
//					ind = wordList.indexOf(input);
//					++(counterList.get(ind)[0]);
					
					//HashMap
					++(histogram.get(input)[0]);
					//System.out.println("Existing word: " + input + ", count: " + counterList.get(ind)[0] + "\n");
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			System.exit(0);
		}		
	}
	
	public static void main(String[] args) {
//		ArrayList<int[]> counterList = new ArrayList<int[]>();
//		ArrayList<String> wordList = new ArrayList<String>();
		HashMap<String, int[]> histogram = new HashMap<String, int[]>();
		
		
		//Histogram.buildHistogram("paradiseLost.txt", counterList, wordList);
		Histogram.buildHistogram("declaration.txt", histogram);
		
//		for (int i = 0; i < counterList.size(); i++) {
//			System.out.printf("%-20s %d%n", wordList.get(i), counterList.get(i)[0]);
//			//System.out.println(wordList.get(i) + " " + counterList.get(i)[0]);
//		}
		
		for (String s : histogram.keySet()) {
			int val = histogram.get(s)[0];
			System.out.printf("%-20s %d%n", s, val);
		}
	}
}