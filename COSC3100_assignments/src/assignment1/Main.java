package assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	private static int[] dodos = new int[2];
	
	static void countDodos(String fileName) {
		
		File f = new File(fileName + ".rtf");
		Scanner fileIn;
		String word = "";
		
		try {
			fileIn = new Scanner(f);
			
			while (fileIn.hasNext()) {
				word = fileIn.next();
				word = word.replaceAll("\\p{P}", "");
				
				//using switch statement to implement state machine
				switch (word) {
				case "Dodo":
					dodos[0]++;
					break;
				case "dodo": 
					dodos[1]++;
					break;
				}
			}
		} catch (FileNotFoundException fe) {
			System.out.println(fe.getMessage());
			System.out.println("File not found!");
			System.exit(0);
		}
		
	}
	
	public static void main(String[] args) {
		countDodos("wonderland");
		
		System.out.println("Dodo was used " + dodos[0] + " times.");
		System.out.println("dodo was used " + dodos[1] + " times.");
	}
}
