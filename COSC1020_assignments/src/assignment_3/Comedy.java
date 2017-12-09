package assignment_3;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Due 10/12/17
 * Assignment 3 - Comedy Movie Class
 */

public class Comedy extends Movie{

	public Comedy(String rat, int id, String title) {
		super(rat, id, title);
		lateFeeDaily = 2.5;
	}
	
	public double getLateFee(int days) {
		return 2.50 * days;
	}
}
