package lab7;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Due 10/12/17
 * Lab 7 - Calendar Class
 */

public class Calendar {
	
	
	
	
	
	public static void main(String[] args) {
		Date[] dates = new Date[10];
		
		try {
			
		
		//incorrects
			dates[0] = new Date(-1, 12, 2000); //date out of bounds
			dates[1] = new Date(1, -1, 2000); //month out of bounds
			dates[2] = new Date(1, 2, 999); //year out of bounds
			dates[3] = new Date(29, 2, 1999); //incorrect leap year
			dates[4] = new Date(31, 9, 2000); //date-month mismatch
			
			//corrects
			dates[5] = new Date(23, 9, 1994); //me
			dates[6] = new Date(19, 2, 1998); //Julia
			dates[7] = new Date(15, 4, 1965); //Mom
			dates[8] = new Date(15, 9, 1965); //Dad
			dates[9] = new Date(16, 5, 2013);
		
		} catch (DayException day){
			System.out.println(day.getMessage());
		} catch (MonthException mon) {
			System.out.println(mon.getMessage());
		} catch (YearException yea) {
			System.out.println(yea.getMessage());
		}
		
	}
}
