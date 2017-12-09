package lab6;

import java.util.Scanner;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Due 10/5/17
 * Lab 6 - Problem 1
 */

public class Square {
	
	/*
	 * Returns square of a
	 */
	public double square(double a) {
			return a * a;		
	}
	
	//checks and parses input
	public double checkInput() throws InvalidInputException {
		Scanner in = new Scanner(System.in);
		String b = "";
		
		//double b = Integer.parseInt(a);
		
		if (! in.hasNextDouble()) {
			throw new InvalidInputException("Invalid Input!");
		} else {
			return in.nextDouble();
		}
	}
	
	//prints square of number entered, if possible
	public static void main(String[] args) {
		Square sq = new Square();
		
		double a = 0;
		
		System.out.println("Enter a number:");
		try {
			a = sq.checkInput();
			System.out.println(a + "^2 = " + sq.square(a));
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
