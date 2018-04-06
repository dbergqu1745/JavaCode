package exam2;

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
import javafx.scene.image.Image;

/*
 * Cells.java
 *
 * A simple cell-based map applet for Exam 2 in COSC3550
 *
 * updated by mike slattery - mar 2016
 */

public class Cells extends Application {
	final String appName = "Cells";
	final int FPS = 20; // frames per second
	final int WIDTH = 360;
	final int HEIGHT = 300;

	FireSprite fire;
	Image fireImage;
	int map[][] = new int[6][5];
	int counter = 0;

	public static final int CELLSIZE = 60;

	public void initialize() {
		// Setup the fire character
		fireImage = new Image("fire.gif");
		setupWorld();
	}

	void setupWorld() {
		// Initialize map
		for (int x = 0; x < 6; x++)
			for (int y = 0; y < 5; y++) {
				map[x][y] = 0;
			}
		// Place a few landmarks -> blue dots
		int c = 0;
		while (c < 3) {
			int a = (int) (6 * Math.random());
			int b = (int) (5 * Math.random());
			if (map[a][b] != 1) {
				map[a][b] = 1;
				c++;
			}
		}
		// Place flame
		c = 0;
		
		while (c == 0) {
			int a = (int) (6 * Math.random());
			int b = (int) (5 * Math.random());
			if (map[a][b] != 1) {
				fire = new FireSprite(a * CELLSIZE + 10, b * CELLSIZE + 10, fireImage);
				c++;
			}
		}
	}

	public void update() {
		counter++;
		if (counter > 150) {
			setupWorld();
			counter = 0;
		}
		fire.update();
	}

	public void render(GraphicsContext gc) {
		// draw the cell map
		for (int x = 0; x < 6; x++)
			for (int y = 0; y < 5; y++) {
				int tx = x * CELLSIZE;
				int ty = y * CELLSIZE;
				gc.setFill(Color.WHITE);
				gc.fillRect(tx, ty, CELLSIZE, CELLSIZE);
				gc.setStroke(Color.BLACK);
				gc.strokeRect(tx, ty, CELLSIZE - 1, CELLSIZE - 1);
				// Check for landmarks
				if (map[x][y] == 1) {
					gc.setFill(Color.BLUE);
					gc.fillOval(tx + 5, ty + 5, CELLSIZE - 10, CELLSIZE - 10);
				}
			}
		// Then draw the fire character
		fire.render(gc);
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
		Scene theScene = new Scene(root);
		theStage.setScene(theScene);

		Canvas canvas = new Canvas(WIDTH, HEIGHT);
		root.getChildren().add(canvas);

		GraphicsContext gc = canvas.getGraphicsContext2D();

		// Initial setup
		initialize();

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
