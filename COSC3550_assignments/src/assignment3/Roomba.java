package assignment3;

import java.awt.Image;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Line;

/*
 * Make the roomba the actual picture from the desktop
 */
public class Roomba extends Sprite{
	Image roombaImage;
	Color roombaColor = Color.BLACK;
	Color guideCircleColor = Color.ANTIQUEWHITE;
	double arcLengthAdjustment;
	static final int DIAMETER = 120;
	static double directionAngle;
	static double SPEED = 3;
	Line guideLine = new Line();
	
	public Roomba(double xi, double yi) {
		//Center the roomba initially
		x = xi - DIAMETER/2;
		y = yi - DIAMETER/2;
		directionAngle = 0;
		dx = 0;
		dy = 0;
	}
	
	boolean inBoundsXLeft(double x) {
		return x >= 0;
	}
	
	boolean inBoundsXRight(double x) {
		return x <= 1000;
	}
	
	boolean inBoundsYBottom(double x) {
		return x <= 1000;
	}
	
	boolean inBoundsYTop(double x) {
		return x >= 0;
	}
	
	double getCenterX() {
		return x + DIAMETER/2;
	}
	
	double getCenterY() {
		return y + DIAMETER/2;
	}
	
	void turn(boolean direc) {		
		if (direc) {
			--directionAngle;
		} else {
			++directionAngle;
		}
	}
	
	/*
	 * Does the roomba need to have its own update method?
	 * 
	 * Yes, when it reaches the edge of the play screen, it needs
	 * to turn around and go in the opposite direction like an
	 * actual roomba, and the direction angle needs to be updated
	 */
	void updateRoomba() {
		if (active) {
			
			//updating speed with direction
			dy = SPEED * Math.sin(directionAngle);
			dx = SPEED * Math.cos(directionAngle);
			
			updatePosition();
		}
	}
	
	//redraw roomba and guiding circle
	void render(GraphicsContext context) {
		if (visible) {
			context.setFill(roombaColor);
			context.fillOval(x - DIAMETER/2, y - DIAMETER/2, DIAMETER, DIAMETER);
			
			context.setFill(guideCircleColor);
			context.fillOval(x + (DIAMETER/2)*Math.cos(directionAngle), y + (DIAMETER/2)*Math.sin(directionAngle), 
							DIAMETER/6, DIAMETER/6);

		}
	}
}
