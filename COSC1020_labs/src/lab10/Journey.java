package lab10;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Lab 10 - due 11/9
 * Journey Class
 */

public class Journey {
	
	//computes cartesian distance
	public static double cartDist(double xBeg, double yBeg, double xEnd, double yEnd) {
		return Math.pow(Math.pow(xEnd - xBeg, 2) + Math.pow(yEnd - yBeg, 2), .5);
	}
	
	public static double computeSpeed(ArrayList<Waypoint> journey) {
		double totalDist = 0;
		int len = journey.size();
		
		for(int i = 1; i < len; i++) {
			totalDist += (cartDist(journey.get(i).getxCoord(), journey.get(i).getyCoord(),     
									journey.get(i - 1).getxCoord(), journey.get(i - 1).getyCoord()));
		}
		
		   //1 = .1 mi -> 1 mi           //1 sec -> 1 hour
		return (totalDist * .1) / ((double)journey.get(len - 1).getTimeStamp() / 3600.0);
	}
	
	public static void main(String[] args) {
		ArrayList<Waypoint> journey = new ArrayList<Waypoint>();
		journey.add(new Waypoint());
		int currPoint = 0;
		
		String outerControl;
		String innerControl;
		double xCoord, yCoord, time; 
		double prevTime = 0;
		Scanner in = new Scanner(System.in);
		
		//trip calculator
		do {
			System.out.println("Welcome to the trip calculator!");
			
			//enter points
			System.out.println("The very first point of the hike will be taken as 0,0");
			do {
				++currPoint;
				System.out.println("For point number " + currPoint + " enter the x-coordinate relative to point " + (currPoint - 1) 
									+ " in the scale of tenths of a mile below:");
				xCoord = in.nextDouble();
				
				System.out.println("For point number " + currPoint + " enter the y-coordinate relative to point " + (currPoint - 1) 
						+ " in the scale of tenths of a mile below:");
				yCoord = in.nextDouble();
				
				do {
					System.out.println("For point number " + currPoint + " enter the total time elapsed in seconds:");
					time = in.nextDouble();
					
					if (currPoint - 1 == 1) {
						continue;
					} else {
						prevTime = journey.get(currPoint - 1).getTimeStamp();
					}
					
				} while (time < prevTime);
				
				journey.add(new Waypoint(xCoord, yCoord, time));
				
				System.out.println("Would you like to enter another waypoint? (respond with y/n)");
				innerControl = in.next();
				
			} while (innerControl.equals("y"));
			
			//print avg
			System.out.println("Miles covered per hour of this hike: " + Journey.computeSpeed(journey));
			
			System.out.println("Would you like to enter another trip? (respond with y/n)");
			outerControl = in.next();
			
		} while (outerControl.equals("y"));
		
		System.out.println("Goodbye");
		in.close();
	}
}
