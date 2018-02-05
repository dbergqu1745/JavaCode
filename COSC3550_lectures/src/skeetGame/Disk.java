package skeetGame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class Disk extends Sprite {
	Color color = Color.RED;
	public static final double RADIUS = 20;

	void updateSprite() {
		if (active) {
			updatePosition();
			// If we've dropped off the screen, suspend the Disk
			if (y > Skeet.HEIGHT)
				suspend();
		}
	}

	void hit(Sprite sprites[], int base) {
		int i;

		// turn off the disk and all of the frags
		// (and set each frag to the current disk position
		suspend();
		for (i = 0; i < 6; i++) {
			sprites[base + i].suspend();
			sprites[base + i].setPosition(x, y);
		}
		//
		// Now, slightly modify the velocity for each frag
		// so that the pieces will scatter.
		// We take advantage of the fact that we control everything
		// to slow down the pieces a bit so it looks cooler!
		double slow_dx = dx / 3.0;
		double slow_dy = dy / 2.0;
		double scale = 1.0; // this adjusts how fast all the pieces scatter
		sprites[base + 0].setVelocity(slow_dx + 1.2 * scale, slow_dy - 0.5 * scale);
		sprites[base + 1].setVelocity(slow_dx + 0.0 * scale, slow_dy - 1.8 * scale);
		sprites[base + 2].setVelocity(slow_dx - 2.0 * scale, slow_dy - 1.5 * scale);
		sprites[base + 3].setVelocity(slow_dx - 1.0 * scale, slow_dy + 0.0 * scale);
		sprites[base + 4].setVelocity(slow_dx + 0.0 * scale, slow_dy + 0.5 * scale);
		sprites[base + 5].setVelocity(slow_dx + 1.5 * scale, slow_dy + 0.5 * scale);
		for (i = 0; i < 6; i++)
			sprites[base + i].resume();
	}

	void render(GraphicsContext gc) {
		if (visible) {
			gc.setFill(color);
			gc.fillOval(x - RADIUS, y - RADIUS, 2 * RADIUS, 2 * RADIUS);
		}
	}
}
