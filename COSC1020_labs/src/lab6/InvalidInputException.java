package lab6;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Due 10/5/17
 * Lab 6 - Invalid Input Exception class
 */

public class InvalidInputException extends Exception {
	String message;
	
	/*
	 * No-parameter constructor
	 */
	public InvalidInputException() {
		super();
	}
	
	
	/*
	 * Constructor w/ message
	 */
	public InvalidInputException(String msg) {
		super(msg);
	}
}
