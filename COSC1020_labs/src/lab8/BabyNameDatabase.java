package lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Lab 8 - Due 10/26/17
 * Baby Name Database
 */
public class BabyNameDatabase {
	
	public static String[][] makeBase(String fileName) {
		String[][] nameDataBase = new String[1000][2];		
		Scanner fileIn = null;
		String line = "";
		String[] input;
		int curr = 0;
		
		File f = new File(fileName);
		

		try {
			fileIn = new Scanner(f);
			
			while (fileIn.hasNext()) {			
				line = fileIn.nextLine();
				input = line.split(" ");
				
				nameDataBase[curr][0] = input[0];
				nameDataBase[curr][1] = input[1];
				
				curr++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("No such file");
			System.exit(0);
		}
		
		fileIn.close();
		return nameDataBase;
	}
	
	public static String[] fetchNameAmount(String name, String[][] dataBaseBoys, String[][] dataBaseGirls) {
		String[] responses = {"", ""};
		boolean nameFound = false;
		int i = 0;
		
		do {
			if (name.equalsIgnoreCase(dataBaseBoys[i][0])) {
				responses[0] = dataBaseBoys[i][0] + " is ranked #" + (i + 1) + " in popularity among boys with " + dataBaseBoys[i][1] + " namings.";
				nameFound = true;
			}
			
			i++;
		} while (nameFound == false && i < 1000);
		
		if (nameFound == false) {
			responses[0] = name + " is not ranked in the top 1000 boy names.";
		}
		
		i = 0;
		nameFound = false;
		
		do {
			if (name.equalsIgnoreCase(dataBaseGirls[i][0])) {
				responses[1] = dataBaseGirls[i][0] + " is ranked #" + (i + 1) + " in popularity among girls with " + dataBaseGirls[i][1] + " namings.";
				nameFound = true;
			}
			
			i++;
		} while (nameFound == false && i < 1000);
		
		if (nameFound == false) {
			responses[1] = name + " is not ranked in the top 1000 girl names.";
		}
		
		return responses;
	}
	
	public static void printArray(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void main(String[] args) {
		String resp1 = "y";
		Scanner in = new Scanner(System.in);
		String name = "";
		String[] results = null;
		
		String[][] boyNames = makeBase("boynames.txt");
		String[][] girlNames = makeBase("girlnames.txt");
		
		
		do {
			System.out.println("Enter a name to search:");
			name = in.nextLine();
			
			results = fetchNameAmount(name, boyNames, girlNames);
			printArray(results);
			
			System.out.println("Would you like to search another name? (respond with y/n)");
			resp1 = in.nextLine();
			
		} while (resp1.equals("y"));
		
		System.out.println("Goodbye");
		in.close();
	}
}
