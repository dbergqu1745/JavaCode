package assignment1;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.animation.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/*
 * Author: Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * COSC 3550 Assignment 1
 * Basic scene to practice drawing shapes and
 * use different colors
 */
public class BasicDraw extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Assignment 1");
		
		//Creating nodes
		Group root = new Group();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		
		Canvas canvas = new Canvas(600, 600);
		root.getChildren().add(canvas);
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		render(gc);
		
		stage.show();
	}
	
	void render(GraphicsContext context) {
		Random rand = new Random();
		int buff = 5;
		int xCoord = 0;
		int yCoord = 0;
		double n = 0.0;
		
		//squares just get smaller and are all gray
		for (int i = 600; i >= 0; i -= buff) {
			n = rand.nextDouble();
			context.setFill(Color.color(n, n, n));
			
			if (i % 2 == 0) {
				context.fillRect(xCoord, yCoord, i, i);
			} else {
				
			}
			
			xCoord += buff;
			yCoord += buff;
		}
		
	}
}
