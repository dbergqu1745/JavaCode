package flyGame;

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

/**
 * Fly swatting game
 * 
 * @author mike slattery
 * @version jan 2016
 */
public class Fly extends Application {
	final String appName = "Flyswatter Game";
	// frames per second
	final int FPS = 10; 
	final int WIDTH = 600;
	final int HEIGHT = 500;

	int fly_x, fly_y;
	boolean fly_alive = true;
	int swatter_x, swatter_y;
	// graphics context at global level to allow manipulation by methods
	GraphicsContext gc;

	/**
	 * Set up initial data structures/values
	 */
	void initialize() {
		fly_x = WIDTH / 2;
		fly_y = HEIGHT / 2;
		swatter_x = WIDTH - 100;
		swatter_y = HEIGHT - 100;
	}

	void setHandlers(Scene scene) {
		//handling mouse press event
		scene.setOnMousePressed(e -> {
			int x = (int) e.getX();
			int y = (int) e.getY();
			if (x - 15 < fly_x && fly_x < x + 15 && y - 15 < fly_y && fly_y < y + 15) {
				// Fly is killed
				fly_alive = false;
			}
		});

		//handling mouse move event
		scene.setOnMouseMoved(e -> {
			int x = (int) e.getX();
			int y = (int) e.getY();
			swatter_x = x;
			swatter_y = y;
			render(gc);
		});
	}

	/**
	 * Update variables for one time step
	 */
	public void update() {
		// update fly's position
		int dx = (int) (20 * Math.random() - 10);
		int dy = (int) (20 * Math.random() - 10);
		fly_x += dx;
		fly_y += dy;
		
		// If offscreen, move back to center
		if (fly_x < 0 || fly_x > WIDTH || fly_y < 0 || fly_y > HEIGHT) {
			fly_x = WIDTH / 2;
			fly_y = HEIGHT / 2;
		}
	}

	/**
	 * Draw the game world
	 */
	void render(GraphicsContext gc) {
		// fill background
		gc.setFill(Color.CYAN);
		gc.fillRect(0, 0, WIDTH, HEIGHT);

		// draw fly
		if (fly_alive) {
			gc.setFill(Color.BLACK);
			gc.fillOval(fly_x - 5, fly_y - 5, 10, 10);
		}

		// draw swatter
		gc.setStroke(Color.RED);
		gc.strokeRect(swatter_x - 15, swatter_y - 15, 30, 30);
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

		gc = canvas.getGraphicsContext2D();

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
