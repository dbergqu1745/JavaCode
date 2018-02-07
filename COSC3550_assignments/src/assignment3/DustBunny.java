package assignment3;

import javafx.scene.paint.Color;
import java.util.Random;
import javafx.scene.canvas.GraphicsContext;

public class DustBunny extends Sprite {
	Color color = Color.GRAY;
	public static final double RADIUS = 20;
	Random rand = new Random();
	
//	public DustBunny() {
//		dx = (double)rand.nextInt(30);
//		dy = (double)rand.nextInt(30);
//		//x = (double)rand.nextInt(500) - RADIUS;
//		//y = (double)rand.nextInt(500) - RADIUS;
//		visible = true;
//		active = true;
//	}
	
	boolean inBoundsXLeft(double x) {
		return x <= 0;
	}
	
	boolean inBoundsXRight(double x) {
		return x >= 1000;
	}
	
	boolean inBoundsYBottom(double x) {
		return x >= 1000;
	}
	
	boolean inBoundsYTop(double x) {
		return x <= 0;
	}
	
	void updateBunny() {
		if (active) {
			updatePosition();
		
			//checking the current location of the dust bunny
			if (!inBoundsXLeft(this.x)) {
				this.setPosition(1000, this.y);
			}
			
			if (!inBoundsXRight(this.x)) {
				this.setPosition(0, this.y);
			}
			
			if (!inBoundsYBottom(this.y)) {
				this.setPosition(this.x, 0);
			}
			
			if (!inBoundsYTop(this.y)) {
				this.setPosition(this.x, 1000);
			}
		}
	}
	
	void render(GraphicsContext context) {
		if (visible) {
			context.setFill(color);
			context.fillOval(x - RADIUS, y - RADIUS, RADIUS, RADIUS);
		}
	}
}
