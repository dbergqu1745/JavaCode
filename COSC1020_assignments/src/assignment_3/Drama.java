package assignment_3;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Due 10/12/17
 * Assignment 3 - Drama Movie Class
 */

public class Drama extends Movie {
	
	public Drama(String rat, int id, String title) {
		super(rat, id, title);
	}
	
	public double getLateFee(int days) {
		return days * 2.0;
	}
}
