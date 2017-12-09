package lab7;

public class Date {
	private int date;
	private String month;
	private int year;
	
	//tells whether a year is a leap year or not
	public static boolean leapYear(int year) {
		if (year % 100 == 0){
			return year % 400 == 0;
		} else {
			return year % 4 == 0;
		}
	}
	
	//helps with 30-day v 31-day months
	public static boolean isSpecialMonth(int m) {
		return (m == 9 || m == 4 || m == 6 || m == 11);
	}
	
	//constructs a date object and handles errors
	public Date(int d, int m, int y) throws DayException, MonthException, YearException {
		boolean isLeapYear = leapYear(y);
		
		//check month bounds
		if (m > 12 || m < 1) {
			throw new MonthException("ERROR: Month out of bounds");
		} else {
			switch (d) {
			case 1:
				month = "January";
				break;
			case 2:
				month = "February";
				break;
			case 3:
				month = "March";
				break;
			case 4:
				month = "April";
				break;
			case 5:
				month = "May";
				break;
			case 6:
				month = "June";
				break;
			case 7:
				month = "July";
				break;
			case 8:
				month = "August";
				break;
			case 9:
				month = "September";
				break;
			case 10:
				month = "October";
				break;
			case 11:
				month = "November";
				break;
			case 12:
				month = "December";
				break;
			}
		}
		
		//month bounds
		if (d > 31 || d <= 0) {
			throw new DayException("Day out of bounds");
		} else {
			date = d;
		}
		
		//year bounds
		if (y > 3000 || y < 1000) {
			throw new YearException("Year out of bounds");
		} else {
			year = y;
		}
		
		//date edge cases
		//thirty days hath september, april, june and november
		if (d > 30 && isSpecialMonth(m)){
			throw new DayException("ERROR: Month-date mismatch");
		//all the rest have 31
		} else if (d == 31 && !isSpecialMonth(m)) {
			throw new DayException("ERROR: Month-date mismatch");
		} else if (d == 29) {
			if (m == 2 && !leapYear(y)) {
				throw new DayException("ERROR: " + Integer.toString(y) + " is not a valid leap year");
			}
		}
		
		
		
	}
}
