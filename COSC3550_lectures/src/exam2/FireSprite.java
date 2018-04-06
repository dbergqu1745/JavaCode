package exam2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class FireSprite {
	int x, y;
	int dx, dy;

	Image image;

	public FireSprite(int x1, int y1, Image i) {
		x = x1;
		y = y1;
		image = i;
		dx = 5;
		dy = 0;
	}

	public void update() {
		// Check for direction change
		if (((x - 10) % Cells.CELLSIZE == 0) && ((y - 10) % Cells.CELLSIZE == 0)) {
			if (Math.random() > 0.5) {
				dx = 5;
				dy = 0;
			} else {
				dx = 0;
				dy = 5;
			}
		}
		// Move a bit
		x += dx;
		y += dy;
		// Then check for right edge (and loop back to left)
		if (x > 6 * Cells.CELLSIZE)
			x = 0;
		// Check for bottom edge
		if (y > 5 * Cells.CELLSIZE)
			y = 0;
	}

	public void render(GraphicsContext gc) {
		gc.drawImage(image, x, y);
	}
}
