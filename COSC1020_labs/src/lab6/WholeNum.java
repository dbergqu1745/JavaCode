package lab6;

import java.util.Scanner;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Due 10/5/17
 * Lab 6 - Problem 2
 */

public class WholeNum {
	
	//parses input to double if it can be parsed
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
	
	//loop executes until user enters compatible input
	public static void main(String[] args) {
		boolean goodInput = true;
		WholeNum wN = new WholeNum();
		double a = 0;
		
		do {
		System.out.println("Enter an integer:");
			try {
				a = wN.checkInput();
				System.out.println(a + " is a number");
				goodInput = true;
			} catch (InvalidInputException e)	{
				System.out.println(e.getMessage());
				goodInput = false;
			}
		
		} while (goodInput == false);
	}
}
