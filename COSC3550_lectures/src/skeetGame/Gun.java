package skeetGame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class Gun {
	// set up left and right limits on gun movement
	final double x_lo = 5;
	final double x_hi = Skeet.WIDTH - 40;

	double x = x_lo;
	final double y = Skeet.HEIGHT - 23;

	Color color = Color.BLACK;

	Bullet bullet;

	Gun(Bullet b) {
		bullet = b;
	}

	public void setX(double x1) {
		x = x1;
		// Check for limits
		if (x < x_lo)
			x = x_lo;
		else if (x > x_hi)
			x = x_hi;
	}

	void render(GraphicsContext gc) {
		gc.setFill(color);
		gc.fillRect(x - 5, y, 10, 20);
	}

	public void fireBullet() {
		bullet.setPosition(x, y);
		bullet.setVelocity(0.0, -40.0);
		bullet.resume();
	}

}
