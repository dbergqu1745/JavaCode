package blockGame;

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
 * Block Chaser Game
 * Author: Daniel Bergquist
 * 
 * The point of the game is to navigate the player's block
 * to the randomly spawned block of the same color in the play area.
 * As the game progresses, the amount of randomly spawned blocks
 * increases.
 */
public class BlockChaser extends Application{
	final String APPNAME = "Block Chaser";
	final int FRAMES_PER_SECOND = 10;
	final int WIDTH = 1000;
	final int HEIGHT = 1000;
	
	int playerBlockX;
	int playerBlockY;
	
	GraphicsContext gc;
	
	public void initialize() {
		playerBlockX = WIDTH / 2;
		playerBlockY = HEIGHT / 2;
	}
	
	/*
	 * TODO: 
	 * Implement left, right, up, down arrow key presses
	 */
	public void setHandlers(Scene scene) {
		
	}
	
	/*
	 * TODO:
	 * update the variables for one time step
	 */
	public void update() {
		
	}
	
	/*
	 * TODO:
	 * Draw the game world
	 */
	public void render() {
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/*
	 * TODO:
	 * implement KeyFrame to drive the game's animation 
	 */
	@Override
	public void start(Stage theStage) {
		
	}
	
	
}
