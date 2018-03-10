package pong;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Pong.java
 *
 * Pong game for two human players.
 *
 * @author mike slattery
 * @version jan 2016
 */
public class Pong extends Application {
	final String appName = "Pong";
	final int FPS = 30; // frames per second
	final static int WIDTH = 600;
	final static int HEIGHT = 500;
	final static int EDGE = 30;

	Ball ball;
	Paddle pleft, pright;
	ScoreBoard score;

	/**
	 * Set up initial data structures/values
	 */
	void initialize() {
		ball = new Ball();
		pleft = new Paddle(EDGE);
		pright = new Paddle(WIDTH - EDGE);
		score = new ScoreBoard();
	}

	void setHandlers(Scene scene) {
		scene.setOnKeyPressed(e -> {
			KeyCode c = e.getCode();
			switch (c) {
			case A:
				pleft.setUpKey(true);
				break;
			case Z:
				pleft.setDownKey(true);
				break;
			case SEMICOLON:
				pright.setUpKey(true);
				break;
			case PERIOD:
				pright.setDownKey(true);
				break;
			default:
				break;
			}
		});

		scene.setOnKeyReleased(e -> {
			KeyCode c = e.getCode();
			switch (c) {
			case A:
				pleft.setUpKey(false);
				break;
			case Z:
				pleft.setDownKey(false);
				break;
			case SEMICOLON:
				pright.setUpKey(false);
				break;
			case PERIOD:
				pright.setDownKey(false);
				break;
			default:
				break;
			}
		});
	}

	/**
	 * Update variables for one time step
	 */
	public void update() {
		pleft.move();
		pright.move();
		ball.move();
		ball.checkHit(pleft);
		ball.checkHit(pright);
		checkScore();
	}

	void checkScore() {
		boolean scored = false;
		if (ball.getX() < EDGE) {
			score.bumpRight();
			scored = true;
		}
		if (ball.getX() > WIDTH - EDGE) {
			score.bumpLeft();
			scored = true;
		}
		if (scored)
			ball.reset();
	}

	/**
	 * Draw the game world
	 */
	void render(GraphicsContext gc) {
		// fill background
		gc.setFill(Color.CYAN);
		gc.fillRect(0, 0, WIDTH, HEIGHT);
		// draw game objects
		pleft.render(gc);
		pright.render(gc);
		score.render(gc);
		ball.render(gc);
	}

	/*
	 * Begin boiler-plate code... [Animation and events with initialization]
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage theStage) {
		theStage.setTitle(appName);

		Group root = new Group();
		Scene theScene = new Scene(root);
		theStage.setScene(theScene);

		Canvas canvas = new Canvas(WIDTH, HEIGHT);
		root.getChildren().add(canvas);

		GraphicsContext gc = canvas.getGraphicsContext2D();

		// Initial setup
		initialize();
		setHandlers(theScene);

		// Setup and start animation loop (Timeline)
		KeyFrame kf = new KeyFrame(Duration.millis(1000 / FPS), e -> {
			// update position
			update();
			// draw frame
			render(gc);
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
