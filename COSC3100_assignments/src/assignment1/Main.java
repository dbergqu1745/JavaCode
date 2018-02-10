package assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	private static int dodos = 0;

	static void countDodos(String fileName) {

		File f = new File(fileName + ".txt");
		Scanner fileIn;
		String words = "";
		int state = 1;

		try {
			fileIn = new Scanner(f);

			while (fileIn.hasNext()) {
				words += fileIn.next();
			}

			int len = words.length();
			char c;

			for (int i = 0; i < len; i++) {
				c = words.charAt(i);

				switch (state) {
				case 1:
					if (c == 'D')
						state = 2;
					else
						state = 1;
					break;
				case 2:
					if (c == 'D') 
						state = 2;
					else if (c == 'o')
						state = 3;
					else
						state = 1;
					break;
				case 3:
					if (c == 'D')
						state = 2;
					else if (c == 'd')
						state = 4;
					else
						state = 1;
					break;
				case 4:
					if (c == 'D')
						state = 2;
					else if (c == 'o')
						state = 5;
					else
						state = 1;
					break;
				case 5:
					System.out.println("Dodo found");
					dodos++;
					if (c == 'D')
						state = 2;
					else 
						state = 1;
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
		System.out.println("Dodo was used " + dodos + " times.");

	}
}
