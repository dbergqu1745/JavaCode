package skeetGame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

class Frag extends Sprite {
	Color color = Color.GRAY;
	public static final double RADIUS = 20;
	int start_angle, arc_angle;

	Frag(int s, int a) {
		start_angle = s;
		arc_angle = a;
	}

	void updateSprite() {
		if (active) {
			updatePosition();
			// If we've dropped off the screen, suspend the Frag
			if (y > Skeet.HEIGHT)
				suspend();
		}
	}

	void render(GraphicsContext gc) {
		if (visible) {
			gc.setFill(color);
			gc.fillArc(x - RADIUS, y - RADIUS, 2 * RADIUS, 2 * RADIUS, start_angle, arc_angle, ArcType.ROUND);
		}
	}
}
