package blockGame;

import java.util.Random;

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

/*
 * Block Painter
 * Author: Daniel Bergquist (daniel.bergquist@marquette.edu)
 * 
 * Click the mouse and drag to draw a line on the canvas that
 * randomly changes color over time
 */
public class BlockPainter extends Application {
	final String APPNAME = "Block Painter";
	final int FRAMES_PER_SECOND = 10;
	final int WIDTH = 1000;
	final int HEIGHT = 850;
	
	int colorRed = 0;
	int colorBlue = 0;
	int colorGreen = 0;
	double playerBlockX;
	double playerBlockY;
	
	Random rand = new Random();

	GraphicsContext gc;

	public void initialize() {
		playerBlockX = WIDTH / 2;
		playerBlockY = HEIGHT / 2;
	}

	public void setHandlers(Scene scene) {
		
		//painting
		scene.setOnMousePressed(e ->{
			playerBlockX = e.getSceneX();
			playerBlockY = e.getSceneY();
			
			gc.moveTo(playerBlockX, playerBlockY);
			
			render(gc);
		});
		
		scene.setOnMouseDragged(e -> {
			playerBlockX = e.getSceneX();
			playerBlockY = e.getSceneY();
			
			gc.lineTo(playerBlockX, playerBlockY);
			
			render(gc);
		});
		
		//moving 'brush' around the screen
		scene.setOnMouseMoved(e -> {
			int x = (int)e.getX();
			int y = (int)e.getY();
			
			playerBlockX = x;
			playerBlockY = y;
			
			gc.fillRect(playerBlockX, playerBlockY, 50, 10);
			
			render(gc);
		});
	}

	/*
	 * TODO: update the variables for one time step
	 */
	public void update() {
		colorRed = rand.nextInt(256);
		colorBlue = rand.nextInt(256);
		colorGreen = rand.nextInt(256);
		
		gc.setFill(Color.rgb(colorRed, colorGreen, colorBlue));
		gc.fillRect(playerBlockX, playerBlockY, 50, 10);
	}

	/*
	 * TODO: Draw the game world
	 */
	public void render(GraphicsContext gc) {
		gc.setFill(Color.BLUE);
		gc.fillRect(0, 0, WIDTH, HEIGHT);
		
		gc.setStroke(Color.rgb(colorRed, colorGreen, colorBlue));
		gc.setFill(Color.rgb(colorRed, colorGreen, colorBlue));
		gc.fillRect(playerBlockX, playerBlockY, 50, 10);
		
		gc.stroke();
	}

	public static void main(String[] args) {
		launch(args);
	}

	/*
	 * TODO: implement KeyFrame to drive the game's animation
	 */
	@Override
	public void start(Stage stage) {
		stage.setTitle(APPNAME);

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
