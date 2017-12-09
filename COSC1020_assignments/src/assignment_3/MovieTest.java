package assignment_3;

import java.util.ArrayList;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Due 10/12/17
 * Assignment 3 - Rental test class
 */

public class MovieTest {
	
	public static double calcLateFees(ArrayList<Rental> rentals) {
		int total = 0;
		
		for (Rental r : rentals) {
			total += r.rented.getLateFee(r.daysLate);
		}
		
		return total;
	}
	
	public static void main(String[] args) {
		ArrayList<Rental> rentals = new ArrayList<Rental>(5);
		
		/*
		 public Rental (int ID, int late, String title, int id, String rating) {
			super(rating, id, title);
			custID = ID;
			daysLate = late;
		 }
		 */
		
		rentals.add(new Rental('c', 12345, 3, "Elf", 128, "PG"));
		rentals.add(new Rental('a', 12346, 6, "Casino Royale", 4, "PG-13"));
		rentals.add(new Rental('d', 12347, 8, "The Room", 129, "PG"));
		rentals.add(new Rental('c', 12335, 6, "Step Brothers", 127, "R"));
		rentals.add(new Rental('a', 15345, 3, "Ocean's 11", 38, "PG-13"));
		rentals.add(new Rental('d', 12745, 5, "Trainspotting", 23, "R"));
		
		
		
		System.out.println("Total late fee: $" + calcLateFees(rentals) );
		
	}
}
