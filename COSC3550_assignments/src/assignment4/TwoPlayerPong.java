package assignment4;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.application.Application;

/*
 * Author: Daniel Bergquist (daniel.bergquist@marquette.edu)
 * COSC 3550 - Assignment 4
 * A variation of pong for two players wherein each player
 * controls two paddles on adjacent or opposite sides
 */
public class TwoPlayerPong extends Application {
	final String APP_NAME = "Two Player Pong";
	final static double WIDTH = 850;
	final static double HEIGHT = 850;
	final double FRAMES_PER_SECOND = 25;

	GraphicsContext gc;
	
	//game objects
	Paddle left;
	Paddle top;
	Paddle right;
	Paddle bottom;
	Ball ball;

	public void initialize() {
		
	}

	public void setHandlers(Scene scene) {
		scene.setOnKeyPressed(e -> {
			// player one uses WASD
			if (e.getCode() == KeyCode.W) {

			}
			if (e.getCode() == KeyCode.A) {

			}
			if (e.getCode() == KeyCode.S) {

			}
			if (e.getCode() == KeyCode.D) {

			}
			
			// Player two uses arrow keys
			if (e.getCode() == KeyCode.UP) {

			}
			if (e.getCode() == KeyCode.LEFT) {

			}
			if (e.getCode() == KeyCode.RIGHT) {

			}
			if (e.getCode() == KeyCode.DOWN) {

			}
		});
	}

	public void update() {

	}

	public void launch() {

	}

	public void render(GraphicsContext gc) {

	}

	public static void main(String[] args) {
		launch(args);
	}

	/*
	 * TODO: implement KeyFrame to drive the game's animation
	 */
	@Override
	public void start(Stage stage) {
		stage.setTitle(APP_NAME);

		Group root = new Group();
		Scene scene = new Scene(root);
		stage.setScene(scene);

		Canvas canvas = new Canvas(WIDTH, HEIGHT);
		root.getChildren().add(canvas);

		gc = canvas.getGraphicsContext2D();

		gc.setLineWidth(10);

		// setup
		initialize();
		setHandlers(scene);

		// Start animation sequence w/ a timeline
		KeyFrame keyFrame = new KeyFrame(Duration.millis(1000 / FRAMES_PER_SECOND), e -> {
			update();
			render(gc);
		});

		Timeline mainLoop = new Timeline(keyFrame);
		mainLoop.setCycleCount(Animation.INDEFINITE);
		mainLoop.play();

		stage.show();
	}
}
