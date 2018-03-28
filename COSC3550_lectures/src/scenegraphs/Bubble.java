package scenegraphs;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Bubble extends Circle {

	public double vX = 0;
	public double vY = 0;
	
    public Bubble(double radius, Color fill) {
		super(radius, radius, radius);
		setFill(fill);
    }

    /**
     * Change the velocity of the atom particle.
     */
    public void update() {
        setTranslateX(getTranslateX() + vX);
        setTranslateY(getTranslateY() + vY);
    }
}
