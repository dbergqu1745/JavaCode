package assignment4;

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public class LeftRightPaddle extends Sprite {
	public static double WIDTH = 100;
	public static double THICKNESS = 20;
	public boolean leftKey, rightKey;
	public Color color;
	
	public LeftRightPaddle(Color c, double xCoord, double yCoord) {
		leftKey = rightKey = false;
		dx = dy = 9;
		color = c;
		x = xCoord;
		y = yCoord;
	}
	
	public void move() {
		if (leftKey && (getLeftEdge() > 0))
			x -= dx;
		if (rightKey && (getRightEdge() < FourPaddlePong.WIDTH))
			x += dx;
	}
	
	public void render(GraphicsContext context) {
		context.setFill(color);
		context.fillRect(x, y, WIDTH, THICKNESS);
	}
	
	public double getRightEdge() {
		return this.x + WIDTH;
	}
	
	public double getLeftEdge() {
		return this.x;
	}
	
	public double getTopEdge() {
		return this.y;
	}
	
	public double getBottomEdge() {
		return this.y + THICKNESS;
	}
	
	public void setLeftKey(boolean value) {
		leftKey = value;
	}
	
	public void setRightKey(boolean value) {
		rightKey = value;
	}
}
