package lab11;

import java.util.ArrayList;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Lab 11 - MyMathClass
 * Due 11/16/17
 */

public class MyMathClass <T extends Number> {
	public MyMathClass() {
		
	}
	
	public double average(ArrayList<T> array) {
		double total = 0;
		
		for (T val : array) {
			total += val.doubleValue();
		}
		
		return total / array.size();
	}
	
	public double standardDeviation(ArrayList<T> array) {
		double numerator = 0;
		double average = average(array);
		
		for (T val : array) {
			numerator += Math.pow(val.doubleValue() - average, 2);
		}
		
		return Math.pow(numerator / array.size(), .5);
	}

	public static void main(String[] args) {
//		ArrayList<Integer> nums = new ArrayList<Integer>();
//		MyMathClass<Integer> mmcList = new MyMathClass<Integer>();
		
//		ArrayList<Double> nums = new ArrayList<Double>();
//		MyMathClass<Double> mmcList = new MyMathClass<Double>();
		
//		ArrayList<Long> nums = new ArrayList<Long>();
//		MyMathClass<Long> mmcList = new MyMathClass<Long>();
		
		ArrayList<Short> nums = new ArrayList<Short>();
		MyMathClass<Short> mmcList = new MyMathClass<Short>();
		
		//change type for 'i' for each corresponding pair of lists
		for (short i = 1; i <= 10; i++) {
			nums.add(i);
		}
		
		
		
		System.out.println(mmcList.average(nums));
		System.out.println(mmcList.standardDeviation(nums));
	}
}
