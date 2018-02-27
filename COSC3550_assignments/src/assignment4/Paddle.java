package assignment4;

import javafx.scene.paint.Color;

public class Paddle extends Sprite{
	double width = TwoPlayerPong.WIDTH / 10;
	final double THICCNESS = 20;
	Color color;
	boolean orientation;
	
	public Paddle(Color c, boolean orientation) {
		if (orientation) {
			x = TwoPlayerPong.WIDTH - width;
			y = 0;
		} else {
			x = 0;
			y = TwoPlayerPong.WIDTH - width;
		}
		color = c;
		visible = true;
		active = true;
	}
	
	void updatePaddle() {
		
	}
}
