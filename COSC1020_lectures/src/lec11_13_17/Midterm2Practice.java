package lec11_13_17;

import java.util.ArrayList;

public class Midterm2Practice {

	// Question 1.
	/**
	 * Returns the index of the smallest value among a[startIndex], a[startIndex+1],
	 * ... a[numberUsed - 1]
	 */
	 // Hint1: Use Comparable
	// Hint2: Replace the comparison operator with compareTo method
	static int indexOfSmallest(int startIndex, double[] a) {
		double min = a[startIndex];
		int indexOfMin = startIndex;
		startIndex++;
		int len = a.length;

		for (int i = startIndex; i < len; i++) {
			if (a[i] < min) {
				min = a[i];
				indexOfMin = i;
			}
		}
		return indexOfMin;
	}

	// Question 2
	// Implement the following method to find the average of the values in the
	// arraylist parameter
	static double getAverage(ArrayList<Double> dList) {
		double average = 0;
		
		for (double d : dList) {
			average += d;
		}
		
		return average / ((double)dList.size());	
	}

	// Question 3
	// return a list containing names that have 3 or less characters.
	// e.g. if list contains {"antique", "boutique", "cat", "is"}, then return new
	// list containing
	// {"cat", "is"}
	static ArrayList<String> getShortNamesFromList(ArrayList<String> list) {
		ArrayList<String> newList = new ArrayList<String>();
	
		for (String s : list) {
			if (s.length() <= 3) {
				newList.add(s);
			}
		}
		
		return newList;
	}
	
	public static void main(String[] args) {
	}
}


