package assignment_3;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Due 10/12/17
 * Assignment 3 - Movie Class
 */

public class Movie {
	private String rating;
	int idNumber;
	String movieTitle;
	double lateFeeDaily = 2.0;
	
	//Getters and Setters
	public String getRating() {
		return rating;
	}
	
	public int getIdNumber() {
		return idNumber;
	}
	
	public String getTitle() {
		return movieTitle;
	}
	
	
	public void setRating(String rating) {
		this.rating = rating;
	}
	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}
	public void setTitle(String title) {
		this.movieTitle = title;
	}
	
	public Movie() {
		
	}
	
	public Movie(String rat, int id, String title) {
		rating = rat;
		idNumber = id;
		movieTitle = title;
	}
		
	//Overridden equals
	public boolean equals(Movie mov) {
		return this.idNumber == mov.idNumber;
	}
	
	public double getLateFee(int days) {
		return lateFeeDaily * days;
	}
	
	public void printMovie() {
		System.out.println("==================");
		System.out.println("Title: " + this.movieTitle);
		System.out.println("Rating: " + this.getRating());
	}
}
