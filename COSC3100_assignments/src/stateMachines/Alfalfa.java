package stateMachines;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Finite state machine that recognises "alfalfa"
 */

public class Alfalfa {
	private static int alfalfas = 0;

	static void countAlfalfas(String fileName) {

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
					if (c == 'a')
						state = 2;
					break;
				case 2:
					if (c == 'l')
						state = 3;
					break;
				case 3:
					if (c == 'f')
						state = 4;
					break;
				case 4:
					if (c == 'a')
						state = 5;
					break;
				case 5:
					if (c == 'l')
						state = 6;
					break;
				case 6:
					if (c == 'f')
						state = 7;
					break;
				case 7:
					if (c == 'a')
						state = 8;
					break;
				case 8:
					++alfalfas;
					break;
				default:
					state = 1;
				}
			}
		} catch (FileNotFoundException fe) {
			System.out.println(fe.getMessage());
			System.out.println("File not found!");
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		countAlfalfas("testfile");
		System.out.println("alfalfa was used " + alfalfas + " times.");

	}
}
