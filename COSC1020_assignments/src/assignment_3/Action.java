package assignment_3;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Due 10/12/17
 * Assignment 3 - Action Movie Class
 */

public class Action extends Movie{
	
	public Action(String rat, int id, String title) {
		super(rat, id, title);
		lateFeeDaily = 3.0;
	}
	
	public double getLateFee(int days) {
		return 3.0 * days;
	}

}
