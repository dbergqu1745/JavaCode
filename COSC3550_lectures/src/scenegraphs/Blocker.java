package scenegraphs;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Blocker extends Rectangle{

	public Blocker(double x1, double y1)
	{
		super(x1, y1, 240, 10);
		setFill(Color.WHITE);
		
		RotateTransition rot = new RotateTransition(Duration.millis(2500), this);
		rot.setByAngle(360);
		rot.setInterpolator(Interpolator.LINEAR);
		rot.setCycleCount(Animation.INDEFINITE);
		rot.setAutoReverse(false);
		rot.play();
	}
}
