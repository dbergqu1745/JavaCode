package scroll1;

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
 * * A simple game demonstrating scrolling landscape This version has jumping
 * (but not falling), but no scrolling.
 *
 * @author mike slattery
 * @version feb 2016
 */
public class Scroll extends Application {
	final String appName = "Scroll";
	final int FPS = 25; // frames per second
	final static double WIDTH = 800;
	final static double HEIGHT = 600;

	HeroSprite hero;
	Grid grid;

	/**
	 * Set up initial data structures/values
	 */
	void initialize() {
		grid = new Grid();
		hero = new HeroSprite(grid, 100, 500);
		setLevel1();
	}

	public void setLevel1() {
		// Put in a ground level
		for (int i = 0; i < Grid.MWIDTH; i++)
			grid.setBlock(i, Grid.MHEIGHT - 1);

		// Now place specific blocks (depends on current map size)
		grid.setBlock(10, 13);
		grid.setBlock(11, 13);
		grid.setBlock(11, 12);
		grid.setBlock(12, 13);
		grid.setBlock(12, 12);
		grid.setBlock(12, 11);
	}

	void setHandlers(Scene scene) {
		scene.setOnKeyPressed(e -> {
			KeyCode key = e.getCode();
			switch (key) {
			case J:
				hero.dir = 1;
				break;
			case K:
				hero.dir = 2;
				break;
			// add a Jump key here
			case A:
				hero.jmp = 1;
				break;
			default:
				break;
			}
		});
		scene.setOnKeyReleased(e -> {
			KeyCode key = e.getCode();
			if ((key == KeyCode.J) || (key == KeyCode.K))
				hero.dir = 0;
		});
	}

	/**
	 * Update variables for one time step
	 */
	public void update() {
		hero.update();
	}

	/**
	 * Draw the game world
	 */
	void render(GraphicsContext gc) {
		gc.setFill(Color.WHITE);
		gc.fillRect(0.0, 0.0, WIDTH, HEIGHT);

		grid.render(gc);
		hero.render(gc);
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
