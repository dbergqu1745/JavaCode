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
import javafx.scene.paint.Color;
import javafx.application.Application;

/*
 * Author: Daniel Bergquist (daniel.bergquist@marquette.edu)
 * COSC 3550 - Assignment 4
 * A variation of pong for two players wherein each player
 * controls two paddles on adjacent or opposite sides
 */
public class FourPaddlePong extends Application {
	final String APP_NAME = "Four Paddle Pong";
	final static double WIDTH = 850;
	final static double HEIGHT = 850;
	final double FRAMES_PER_SECOND = 30;
	final double PIXEL_BUFFER = 10;

	final Color playerOneColor = Color.CORNFLOWERBLUE;
	final Color playerTwoColor = Color.CRIMSON;

	GraphicsContext gc;

	// game objects
	UpDownPaddle left, right;
	LeftRightPaddle top, bottom;
	// board for info about the game: score, active powerups, etc
	Ball ball;

	Sprite[] gameSprites = new Sprite[4];

	public void initialize() {
		left = new UpDownPaddle(playerOneColor, PIXEL_BUFFER, (HEIGHT / 2) + UpDownPaddle.HEIGHT);
		right = new UpDownPaddle(playerTwoColor, WIDTH - (UpDownPaddle.THICKNESS + PIXEL_BUFFER), (HEIGHT / 2) + UpDownPaddle.HEIGHT);
		
		top = new LeftRightPaddle(playerOneColor, (WIDTH / 2) + LeftRightPaddle.WIDTH, PIXEL_BUFFER);
		bottom = new LeftRightPaddle(playerTwoColor, (WIDTH / 2) + LeftRightPaddle.WIDTH, HEIGHT - (LeftRightPaddle.THICKNESS + PIXEL_BUFFER));
		
		ball = new Ball();

		gameSprites[0] = left;
		gameSprites[1] = right;
		gameSprites[2] = top;
		gameSprites[3] = bottom;
//		gameSprites[2] = ball;
	}

	public void setHandlers(Scene scene) {
		scene.setOnKeyPressed(e -> {
			// player one uses WASD for top and left paddles
			if (e.getCode() == KeyCode.W) {
				left.setUpKey(true);
			} else if (e.getCode() == KeyCode.S) {
				left.setDownKey(true);
			} else if (e.getCode() == KeyCode.D) {	
				top.setRightKey(true);
			} else if (e.getCode() == KeyCode.A) {
				top.setLeftKey(true);
			// Player two uses arrow keys for bottom and right paddles
			} else if (e.getCode() == KeyCode.UP) {
				right.setUpKey(true);
			} else if (e.getCode() == KeyCode.DOWN) {	
				right.setDownKey(true);
			} else if (e.getCode() == KeyCode.RIGHT) {	
				bottom.setRightKey(true);
			} else if (e.getCode() == KeyCode.LEFT) {
				bottom.setLeftKey(true);
			}
		});

		scene.setOnKeyReleased(e -> {
			// player one
			if (e.getCode() == KeyCode.W) {
				left.setUpKey(false);
			} else if (e.getCode() == KeyCode.A) {
				top.setLeftKey(false);
			} else if (e.getCode() == KeyCode.S) {
				left.setDownKey(false);
			} else if (e.getCode() == KeyCode.D) {
				top.setRightKey(false);
			}

			// player two
			else if (e.getCode() == KeyCode.UP) {
				right.setUpKey(false);
			} else if (e.getCode() == KeyCode.LEFT) {
				bottom.setLeftKey(false);
			} else if (e.getCode() == KeyCode.RIGHT) {
				bottom.setRightKey(false);
			} else if (e.getCode() == KeyCode.DOWN) {
				right.setDownKey(false);
			}
		});
	}

	public void update() {
		//checkForScore();
		
		top.move();
		bottom.move();
		left.move();
		right.move();
	}

	public void launch() {

	}

	public void render(GraphicsContext gc) {
		gc.setFill(Color.CORAL);
		gc.fillRect(0, 0, WIDTH, HEIGHT);
		
		left.render(gc);
		right.render(gc);
		top.render(gc);
		bottom.render(gc);

	}

	public static void main(String[] args) {
		launch(args);
	}

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
