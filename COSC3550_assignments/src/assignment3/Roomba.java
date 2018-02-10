package assignment3;

import java.awt.Image;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/*
 * Make the roomba the actual picture from the desktop
 */
public class Roomba extends Sprite{
	Image roombaImage;
	Color color = Color.BLACK;
	static final int RADIUS = 110;
	static double directionAngle; 
	
	public Roomba() {
		x = 500 - RADIUS;
		y = 500 - RADIUS;
		directionAngle = 90;
		dx = 3;
		dy = 0;
	}
	
//	void turn(boolean direc) {
//		if (direc)
//			directionAngle += -.5;
//		else
//			directionAngle += .5;
//	}
	
	@Override
	void updatePosition() {
		if (directionAngle )
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
			updatePosition();
		}
	}
	
	void render(GraphicsContext context) {
		if (visible) {
			context.setFill(color);
			context.fillOval(x - RADIUS, y - RADIUS, RADIUS, RADIUS);
		}
	}
}
