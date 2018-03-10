package pong;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Paddle {
	int x, y; // top-left corner

	boolean upKey = false, downKey = false;

	final static int WIDTH = 6;
	final static int HEIGHT = 40;
	final static int SPEED = 4;

	// Set x1 as the middle of the paddle
	public Paddle(int x1) {
		x = x1 - WIDTH / 2;
		y = Pong.EDGE;
	}

	public void move() {
		if (upKey && getTop() > 0)
			y -= SPEED;
		if (downKey && getBottom() < Pong.HEIGHT)
			y += SPEED;
	}

	public void render(GraphicsContext gc) {
		gc.setFill(Color.RED);
		gc.fillRect(x, y, WIDTH, HEIGHT);
	}

	public void setUpKey(Boolean val) {
		upKey = val;
	}

	public void setDownKey(Boolean val) {
		downKey = val;
	}

	// return the x-coord of middle of paddle
	public int getX() {
		return x + (WIDTH / 2);
	}

	public int getTop() {
		return y;
	}

	public int getBottom() {
		return y + HEIGHT;
	}
}
