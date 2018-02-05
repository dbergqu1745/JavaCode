package skeetGame;

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
 * Skeet shooting demo Show motion under gravity, simple collision detection
 *
 * @author mike slattery
 * @version feb 2016
 */
public class Skeet extends Application {
	final String appName = "Skeet";
	final int FPS = 25; // frames per second
	final static double WIDTH = 500;
	final static double HEIGHT = 500;

	Sprite sprites[] = new Sprite[8];
	// Define constants for the array slots
	public static final int DISK = 0;
	public static final int BULLET = 1;
	public static final int FRAG_BASE = 2;

	Disk target;
	Bullet bullet;
	Gun gun;

	double hit_limit = (Disk.RADIUS + Bullet.RADIUS);
	int launch_delay = 0;

	/**
	 * Set up initial data structures/values
	 */
	void initialize() {
		// Fill in the sprites array
		// Notice I also create references to the Disk
		// and Bullet which retain the base classes.
		sprites[DISK] = target = new Disk();
		sprites[BULLET] = bullet = new Bullet();
		for (int i = 0; i < 6; i++)
			sprites[FRAG_BASE + i] = new Frag(i * 60, 60);
		// create the gun
		gun = new Gun(bullet);
	}

	void setHandlers(Scene scene) {
		scene.setOnMousePressed(e -> {
			if (!bullet.isActive())
				gun.fireBullet();
		});

		scene.setOnMouseMoved(e -> {
			gun.setX(e.getX());
		});
	}

	/**
	 * Update variables for one time step
	 */
	public void update() {
		for (int i = 0; i < sprites.length; i++)
			sprites[i].updateSprite();
		// Check for collisions here
		if (bullet.isActive() && target.isCloserThan(bullet, hit_limit)) {
			bullet.suspend();
			// We'll pass the sprites array containing the Frag objects
			// to the target and let it set the appropriate position/velocity
			// for the pieces.
			target.hit(sprites, FRAG_BASE);
			launch_delay = 50; // Set a counter to wait a bit before the next disk
		}
		// Check if we're ready for a new Disk
		launch();
	}

	void launch() {
		// If target is not active, reset and resume target.
		if (!target.isActive() && (--launch_delay < 0)) {
			target.setPosition(500, 200);
			target.setVelocity(-20.0, -18.0);
			target.resume();
		}
	}

	/**
	 * Draw the game world
	 */
	void render(GraphicsContext gc) {
		gc.setFill(Color.CYAN);
		gc.fillRect(0.0, 0.0, WIDTH, HEIGHT);

		gun.render(gc);

		for (int i = 0; i < sprites.length; i++)
			sprites[i].render(gc);
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
