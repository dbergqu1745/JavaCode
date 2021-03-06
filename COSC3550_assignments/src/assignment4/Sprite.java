package assignment4;

import javafx.scene.canvas.GraphicsContext;

/*
 * Same Sprite class from lectures, with gravity removed
 */
class Sprite {
	//current position
	double x, y;
	
	//directional velocity
	double dx, dy;
	
	boolean active = false;
	boolean visible = false;

	void updatePosition() {
		x += dx;
		y += dy;

		//dy += GRAVITY;
	}

	void setPosition(double x2, double y2) {
		x = x2;
		y = y2;
	}

	void setVelocity(double a, double b) {
		dx = a;
		dy = b;
	}

	boolean isCloserThan(Sprite s, double dist) {
		// Return true if Sprite s is closer to
		// the current Sprite (this) than specified
		// distance dist.
		double dx = x - s.x;
		double dy = y - s.y;
		return dx * dx + dy * dy < dist * dist;
	}

	boolean isActive() {
		return active;
	}

	void suspend() {
		active = false;
		visible = false;
	}

	void resume() {
		active = true;
		visible = true;
	}

	void updateSprite() {
	}

	void render(GraphicsContext gc) {
	}
}
