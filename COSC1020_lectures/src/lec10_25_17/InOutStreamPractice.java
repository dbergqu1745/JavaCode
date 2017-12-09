package lec10_25_17;

import java.io.*;

public class InOutStreamPractice {
	
	//Using fileInputStream
	public static double fileAverage(String fileName) {
		FileInputStream finStream = null;
		double total = 0;
		int count = 0;
		double value;
		
		try {
			finStream = new FileInputStream(fileName);
			
			while ((value = finStream.read()) != -1) {
				total += value;
				
				count++;
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(0);
		} catch (IOException e) {
			System.out.println("I/O error");
			System.exit(0);
		} 
		
		return total / count;
	}
	
	public static void main(String[] args) {
		double avg = InOutStreamPractice.fileAverage("practice_file.txt");
		
		System.out.println(avg);
	}
}
