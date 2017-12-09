package lab1;

import java.util.Scanner;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Due 9/8/17
 * Assignment 1 - Pizza test
 */

public class PizzaTest {
	public static void main(String[] args) {
		Pizza za1 = new Pizza("large", 1, 1, 1);
		PizzaOrder order = new PizzaOrder(za1);
		Scanner in = new Scanner(System.in);
		String size;
		int cheese = 0;
		int pep = 0;
		int ham = 0;
		int sizeOrder = 0;
		String cont = "y";
		
		System.out.println("TESTING PIZZA CLASS:");
		do {
			System.out.println("Enter the size (\"small\", \"medium\", or \"large\") of the pizza: ");
			size = in.nextLine();
			
			System.out.println("Enter the desired number of cheese toppings:");
			cheese = in.nextInt();
			
			System.out.println("Enter the desired number of pepperoni toppings:");
			pep = in.nextInt();
			
			System.out.println("Enter the desired number of ham toppings:");
			ham = in.nextInt();
			
			za1.setSize(size);
			za1.setNumCheese(cheese);
			za1.setNumPepperoni(pep);
			za1.setNumHam(ham);
			
			System.out.println("Pizza information:");
			System.out.println(za1.getDescription());
			
			System.out.println("Would you like to enter another pizza? (respond with y or n)");
			cont = in.next();
			
		} while (cont.equals("y"));
		
		System.out.println("\nTESTING PIZZA ORDER CLASS:");
		System.out.println("Order with 1 pizza:");
		za1.setSize("medium");
		za1.setNumCheese(1);
		za1.setNumPepperoni(2);
		za1.setNumHam(2);
		
		order.setPizza1(za1);
		order.printReceipt();
		
		//2 pizzas
		System.out.println("\nOrder with 2 pizzas:");
		Pizza za2 = new Pizza ("large", 1, 7, 0);

		
		order.setPizza2(za2);
		order.printReceipt();
		System.out.println("Updated total cost: $" + order.calcTotal());
		
		//3 pizzas
		System.out.println("\nOrder with 3 pizzas:");
		Pizza za3 = new Pizza("small", 1, 3, 3);
		
		order.setPizza3(za3);
		order.printReceipt();
		System.out.println("Updated total cost: $" + order.calcTotal());
		
		in.close();
	}
}
