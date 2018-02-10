package assignment3;

import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/* Author: Daniel Bergquist (daniel.bergquist@marquette.edu)
 * COSC 3550 Assignment 3 - Roomba Game
 * Due 2/12/18
 */
public class RoombaGame extends Application {
	final String APP_NAME = "Dust Bunnies";
	final int FRAMES_PER_SECOND = 25;
	final static int HEIGHT = 1000;
	final static int WIDTH = 1000;
	private int numBunnies = 15;
	
	//Game objects
	ArrayList<DustBunny> bunnies = new ArrayList<DustBunny>();
	Roomba roomba;
	
	void initialize() {
		for (int i = 0; i < numBunnies; i++) {
			bunnies.add(new DustBunny());
		}
		
		roomba = new Roomba();
	}
	
	//implement left and right arrow key handlers
	void setHandlers(Scene theScene) {
		
	}
	
	void update() {
		for (DustBunny db : bunnies) {
			db.updateBunny();
		}
		
		roomba.updateRoomba();
		
		launch();
	}
	
	void launch() {
		for (DustBunny db : bunnies) {
			if (!db.isActive()) {
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
			db.render(context);
		}
		
		roomba.render(context);
	}
	
	//Begin standard animation code
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
		Timeline mainLoop = new Timeline(kf);
		mainLoop.setCycleCount(Animation.INDEFINITE);
		mainLoop.play();

		theStage.show();
	}
	//End standard animation code
}
