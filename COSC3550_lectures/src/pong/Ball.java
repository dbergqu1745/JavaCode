package pong;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball {
	int x, y; // center of ball
	int vx, vy; // velocity vector

	final static int RADIUS = 12;

	public Ball() {
		reset();
	}

	public void render(GraphicsContext gc) {
		gc.setFill(Color.BLUE);
		gc.fillOval(x - RADIUS, y - RADIUS, 2 * RADIUS, 2 * RADIUS);
	}

	// start the ball in mid-screen with a somewhat
	// random direction
	public void reset() {
		x = Pong.WIDTH / 2;
		y = Pong.HEIGHT / 4;
		if (Math.random() < 0.5)
			vx = -7;
		else
			vx = 7;
		vy = (int) (2 + 3 * Math.random());
	}

	public int getX() {
		return x;
	}

	public void checkHit(Paddle p) {
		int px = p.getX();
		if (Math.abs(px - x) > RADIUS)
			return;
		int py1 = p.getTop();
		int py2 = p.getBottom();
		if ((y < py1) || (y > py2))
			return;
		// reverse direction
		vx = -vx;
	}

	public void move() {
		x += vx;
		y += vy;
		// Bounce off top and bottom of screen
		if (y < RADIUS || y + RADIUS > Pong.HEIGHT)
			vy = -vy;
	}
}
