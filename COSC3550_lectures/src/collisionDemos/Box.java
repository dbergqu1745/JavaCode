package collisionDemos;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Box {
	// Just need one random generator shared
	// by all the boxes (so make it static)
	static Random rng = new Random();

	int x, y; // top-left corner
	int w, h; // width and height
	int vx, vy; // velocity vector

	public Box() {
		// Choose random size and movement
		w = 20 + rng.nextInt(51);
		h = 20 + rng.nextInt(51);
		vx = 2 + rng.nextInt(7);
		if (rng.nextDouble() < 0.5)
			vx = -vx;
		vy = 2 + rng.nextInt(7);
		if (rng.nextDouble() < 0.5)
			vy = -vy;
		// Choose random position on the Canvas
		x = 5 + rng.nextInt(FloatingBoxes.WIDTH - w - 10);
		y = 5 + rng.nextInt(FloatingBoxes.HEIGHT - h - 10);
	}

	public void move() {
		x += vx;
		y += vy;
		// Check for walls
		if ((x + w > FloatingBoxes.WIDTH) || (x < 0))
			vx = -vx;
		if ((y < 0) || (y + h > FloatingBoxes.HEIGHT)) {
			vy = -vy;
		}
	}

	public boolean overlaps(Box b) {
		//box1.overlaps(box2)
		return (b.x <= this.x + this.w) &&
				(b.y <= this.y + this.h) &&
				(this.x <= b.x + b.y) &&
				(this.y <= b.y + b.h);
	}

	public void reverse() {
		vx = -vx;
		vy = -vy;
	}

	public void render(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(x, y, w, h);
	}
}
