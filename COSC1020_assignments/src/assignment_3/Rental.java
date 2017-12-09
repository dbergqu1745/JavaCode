package assignment_3;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Due 10/12/17
 * Assignment 3 - Rental Class
 */

public class Rental extends Movie {
	Movie rented;
	int custID;
	int daysLate;
								
	public Rental (char genre, int customerID, int late, String title, int movieID, String rating) {
		if (genre == 'a') {
			rented = new Action(rating, movieID, title);
		} else if (genre == 'c') {
			rented = new Comedy(rating, movieID, title); 
		} else if (genre == 'd') {
			rented = new Drama(rating, movieID, title);
		}
		
		custID = customerID;
		daysLate = late;
	}
}
