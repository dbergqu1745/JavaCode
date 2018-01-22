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
		double[] rands = new double[3];
		int buff = 5;
		int length = 600;
		int xCoordRect = 0;
		int yCoordRect = 0;
		int xCoordCircle;
		int yCoordCircle;
		
		
		for (int i = 300; i >= 0; i--) {
			
			//random doubles for making different 
			//colors with Color.color(dbl, dbl, dbl)
			for (int j = 0; j < 3; j++) {
				rands[j] = rand.nextDouble();
			}
			
			context.setFill(Color.color(rands[0], rands[1], rands[2]));
			
			//Alternating square and circle
			//TODO: finish implementing circle draw part
			if (i % 2 == 0) {
				context.fillRect(xCoordRect, yCoordRect, length, length);
			} else {
				//context.fillOval(x, y, w, h);
			}
			
			xCoordRect += buff;
			yCoordRect += buff;
			length -= 10;
		}
		
	}
}
