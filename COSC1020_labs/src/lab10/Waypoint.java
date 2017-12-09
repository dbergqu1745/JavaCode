package lab10;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Lab 10 - due 11/9
 * Waypoint Class
 */

public class Waypoint {
	private double xCoord;
	private double yCoord;
	private double timeStamp;
	
	public Waypoint() {
		xCoord = 0; 
		yCoord = 0;
		timeStamp = 0;
	}
	
	public Waypoint(double x, double y, double time) {
		xCoord = x;
		yCoord = y;
		timeStamp = time;
	}

	public double getxCoord() {
		return xCoord;
	}

	public double getyCoord() {
		return yCoord;
	}

	public double getTimeStamp() {
		return timeStamp;
	}

	public void setxCoord(double xCoord) {
		this.xCoord = xCoord;
	}

	public void setyCoord(double yCoord) {
		this.yCoord = yCoord;
	}

	public void setTimeStamp(int timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
