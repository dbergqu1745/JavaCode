package assignment4;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class UpDownPaddle extends Sprite {
	public static double HEIGHT = 100;
	public static double THICKNESS = 20;
	public boolean upKey, downKey;
	public Color color;

	// initial coordinates and color
	public UpDownPaddle(Color c, double xCoord, double yCoord) {
		upKey = downKey = false;
		dx = dy = 9;
		color = c;
		x = xCoord;
		y = yCoord;
//		x = FourPaddlePong.PIXEL_BUFFER;
//		y = (FourPaddlePong.HEIGHT / 2) + HEIGHT;
	}

	public void move() {
		if (upKey && (getTopEdge() > 0))
			y -= dy;
		if (downKey && (getBottomEdge() < FourPaddlePong.HEIGHT))
			y += dy;
	}
	
	public void render(GraphicsContext context) {
		context.setFill(color);
		context.fillRect(x, y, THICKNESS, HEIGHT);
	}

	// for collision with the right paddle
	public double getLeftEdge() {
		return this.x;
	}

	// for collision with the left paddle
	public double getRightEdge() {
		return this.x + THICKNESS;
	}

	public double getTopEdge() {
		return this.y;
	}

	public double getBottomEdge() {
		return this.y + HEIGHT;
	}
	
	public void setUpKey(boolean value) {
		upKey = value;
	}
	
	public void setDownKey(boolean value) {
		downKey = value;
	}
}
