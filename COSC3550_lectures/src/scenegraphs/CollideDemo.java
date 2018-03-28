package scenegraphs;

import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Basic scene graph demo
 * 
 * @author mike slattery
 * @version mar 2016
 */
public class CollideDemo extends Application {
	final String appName = "CollideDemo";
	final int FPS = 30; // frames per second
	final static int WIDTH = 600;
	final static int HEIGHT = 500;

	Scene theScene;
	Bubble ball;
	Blocker block;

	/**
	 * Set up initial data structures/values
	 */
	void initialize() {
		Random rnd = new Random();
		ball = new Bubble(20, Color.GREEN);
		// random 0 to 2 + (.0 to 1) * random (1 or -1)
		ball.vX = (3.0 + rnd.nextInt(5)) * (rnd.nextBoolean() ? 1 : -1);
		ball.vY = (3.0 + rnd.nextInt(5)) * (rnd.nextBoolean() ? 1 : -1);

		// random x between 0 to width of scene
		double newX = rnd.nextInt((int) theScene.getWidth());
		if (newX > (theScene.getWidth() - (ball.getRadius() * 2))) {
			newX = theScene.getWidth() - (ball.getRadius() * 2);
		}

		double newY = rnd.nextInt((int) theScene.getHeight());
		if (newY > (theScene.getHeight() - (ball.getRadius() * 2))) {
			newY = theScene.getHeight() - (ball.getRadius() * 2);
		}

		ball.setTranslateX(newX);
		ball.setTranslateY(newY);
		ball.setVisible(true);

		block = new Blocker(200, 240);
	}

	/**
	 * Update variables for one time step
	 */
	public void update() {
		ball.update();
		bounceOffWalls(ball);
		// Bounding boxes in scene coordinates
		// the closer the box gets to | or _, the more accurate the collision will look,
		// because the bounding box is computed based on the current angle of the box
		// if (block.getBoundsInParent().intersects(ball.getBoundsInParent()))
		// ball.setFill(Color.BLUE);

		// Bounding boxes in Blocker coordinates -> much more accurate
		if (block.intersects(block.sceneToLocal(ball.getBoundsInParent()))) {
			ball.setFill(Color.BLUE);
		}
	}

	private void bounceOffWalls(Bubble b) {
		// bounce off the walls when outside of boundaries

		if (b.getTranslateX() > theScene.getWidth() - 2 * b.getRadius() || b.getTranslateX() < 0) {
			// bounce the opposite direction
			b.vX = b.vX * -1;
			b.setFill(Color.RED);
		}
		if (b.getTranslateY() > theScene.getHeight() - 2 * b.getRadius() || b.getTranslateY() < 0) {
			b.vY = b.vY * -1;
			b.setFill(Color.GREEN);
		}
	}

	/*
	 * Begin boiler-plate code... [Animation with initialization]
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage theStage) {
		theStage.setTitle(appName);

		Group root = new Group();
		theScene = new Scene(root, WIDTH, HEIGHT);
		theScene.setFill(Color.BLACK);
		theStage.setScene(theScene);

		// Initial setup
		initialize();
		root.getChildren().addAll(ball, block);

		// Setup and start animation loop (Timeline)
		KeyFrame kf = new KeyFrame(Duration.millis(1000 / FPS), e -> {
			// update position
			update();
		});
		Timeline mainLoop = new Timeline(kf);
		mainLoop.setCycleCount(Animation.INDEFINITE);
		mainLoop.play();

		theStage.show();
	}
	/*
	 * ... End boiler-plate code
	 */
}
