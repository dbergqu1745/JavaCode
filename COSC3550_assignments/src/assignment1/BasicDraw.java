package assignment1;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Random;

/*
 * Author: Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * COSC 3550 Assignment 1
 * Basic scene to practice drawing shapes and
 * use different colors
 */
public class BasicDraw extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Assignment 1");

		// Creating nodes
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
		int buff = 10;
		int length = 600;

		int coord = 0;

		//for the size of the canvas
		for (int i = 0; i < 60; i++) {

			/*
			 * random doubles for making different
			 * colors with Color.color(dbl, dbl, dbl)
			 */
			for (int j = 0; j < 3; j++) {
				rands[j] = rand.nextDouble();
			}

			context.setFill(Color.color(rands[0], rands[1], rands[2]));

			// Alternating square and circle
			if (i % 2 == 0) {
				context.fillRect(coord, coord, length, length);
			} else {
				context.fillOval(coord, coord, length, length);
				
				/*
				 * offsetting the coordinates and adjusting the length
				 * before the next square-circle pair
				 */
				coord += buff;
				length -= 20;
			}
		}
	}
}
