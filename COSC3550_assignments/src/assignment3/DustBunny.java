package assignment3;

import javafx.scene.paint.Color;
import java.util.Random;
import javafx.scene.canvas.GraphicsContext;

public class DustBunny extends Sprite {
	Color color = Color.GRAY;
	public static final double DIAMETER = 30;
	Random rand = new Random();
	
	public DustBunny() {
		dx = (double)rand.nextInt(15);
		dy = (double)rand.nextInt(15);
		x = (double)rand.nextInt(500) - DIAMETER;
		y = (double)rand.nextInt(500) - DIAMETER;
		visible = true;
		active = true;
	}
	
	boolean inBoundsXLeft(double x) {
		return x >= 0;
	}
	
	boolean inBoundsXRight(double x) {
		return x <= 1000;
	}
	
	boolean inBoundsYBottom(double x) {
		return x <= 1000;
	}
	
	boolean inBoundsYTop(double x) {
		return x >= 0;
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
		//System.out.println("rendered" + visible + active);
		if (visible) {
			context.setFill(color);
			context.fillOval(x - DIAMETER, y - DIAMETER, DIAMETER, DIAMETER);
			//System.out.println(x + " " + y + " " + RADIUS + color + dx + dy);
		}
	}
}
