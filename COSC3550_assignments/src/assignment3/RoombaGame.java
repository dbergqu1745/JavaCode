package assignment3;

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
import javafx.scene.text.Text;

/* Author: Daniel Bergquist (daniel.bergquist@marquette.edu)
 * COSC 3550 Assignment 3 - Roomba Game
 * Due 2/12/18
 */
public class RoombaGame extends Application {
	final String APP_NAME = "Dust Bunnies";
	final int FRAMES_PER_SECOND = 25;
	final static double HEIGHT = 1000;
	final static double WIDTH = 1000;
	private int numBunnies = 15;
	private int currentTime = 0;
	private int currentFrame = 0;
	private double collisionLimit = Roomba.DIAMETER / 2 + DustBunny.DIAMETER / 2;
	private Text bunniesMessage;
	private Text timeMessage;
	private Text finishMessage;

	private String msg1 = " dust bunnies remain";
	private String msg2 = " dust bunny remains";
	private String msg3 = " seconds";
	private String msg4 = " second";

	// Game objects
	DustBunny[] bunnies = new DustBunny[numBunnies];
	Roomba roomba;
	
	Timeline mainLoop;

	void initialize() {

		bunniesMessage = new Text(30, 30, numBunnies + msg1);
		timeMessage = new Text(470, 30, "Time: " + currentTime + msg3);

		for (int i = 0; i < numBunnies; i++) {
			bunnies[i] = new DustBunny();
		}

		roomba = new Roomba(WIDTH / 2, HEIGHT / 2);
	}

	void setHandlers(Scene theScene) {
		theScene.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.RIGHT) {
				roomba.turn(false);
			} else if (e.getCode() == KeyCode.LEFT) {
				roomba.turn(true);
			}
		});
	}

	// detect collisions
	void update() {

		for (DustBunny db : bunnies) {
			db.updateBunny();

			// "if the current dust bunny is closer to the roomba than the collisionLimit"
			if (db.isActive() && db.isCloserThan(roomba, collisionLimit)) {
				db.suspend();
				numBunnies--;
			}
		}

		roomba.updateRoomba();

		if (numBunnies == 1)
			bunniesMessage.setText(numBunnies + msg2);
		else
			bunniesMessage.setText(numBunnies + msg1);

		if (currentTime == 1)
			timeMessage.setText("Time: " + currentTime + msg4);
		else
			timeMessage.setText("Time: " + currentTime + msg3);

		++currentFrame;
		if (currentFrame == FRAMES_PER_SECOND) {
			currentFrame = 0;
			++currentTime;
		}
		
		if (numBunnies == 0) {
			finishMessage = new Text(470, 490, "You vacuumed all the dustbunnies in " + 
									currentTime + " seconds!");
			mainLoop.stop();	
		}

		launch();
	}

	void launch() {
		for (DustBunny db : bunnies) {
			if (db.visible && db.active) {
				db.resume();
			}
		}

		if (!roomba.isActive()) {
			roomba.resume();
		}
	}

	void render(GraphicsContext context) {
		context.setFill(Color.CORAL);
		context.fillRect(0.0, 0.0, WIDTH, HEIGHT);

		for (DustBunny db : bunnies) {
			if (db.isActive())
				db.render(context);
		}

		roomba.render(context);
	}

	// Begin standard animation code
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage theStage) {
		theStage.setTitle(APP_NAME);

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
		KeyFrame kf = new KeyFrame(Duration.millis(1000 / FRAMES_PER_SECOND), e -> {
			// update position
			update();
			// draw frame
			render(gc);
		});
		mainLoop = new Timeline(kf);
		mainLoop.setCycleCount(Animation.INDEFINITE);
		mainLoop.play();

		// add 'bunnies left' message
		root.getChildren().add(bunniesMessage);

		// add time message
		root.getChildren().add(timeMessage);

		theStage.show();
	}
	// End standard animation code
}
