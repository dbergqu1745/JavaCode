package assignment_1;

import java.util.Scanner;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Due 9/8/17
 * Assignment 1 - Pizza test
 */

public class PizzaTest {
	public static void main(String[] args) {
		Pizza pizza1 = new Pizza("large", 1, 1, 1);
		Scanner in = new Scanner(System.in);
		String size;
		int cheese = 0;
		int pep = 0;
		int ham = 0;
		String cont = "y";
		
		do {
			System.out.println("Enter the size (\"small\", \"medium\", or \"large\") of the pizza: ");
			size = in.nextLine();
			
			System.out.println("Enter the desired number of cheese toppings:");
			cheese = in.nextInt();
			
			System.out.println("Enter the desired number of pepperoni toppings:");
			pep = in.nextInt();
			
			System.out.println("Enter the desired number of ham toppings:");
			ham = in.nextInt();
			
			pizza1.setSize(size);
			pizza1.setNumCheese(cheese);
			pizza1.setNumPepperoni(pep);
			pizza1.setNumHam(ham);
			
			System.out.println("Pizza information:");
			System.out.println(pizza1.getDescription());
			
			System.out.println("Would you like to enter another pizza? (respond with y or n)");
			cont = in.next();
			
		} while (cont.equals("y"));
		
		in.close();
	}
}
