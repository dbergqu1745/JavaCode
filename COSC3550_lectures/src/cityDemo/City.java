package cityDemo;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


/**
 * Draw a beautiful drone's eye view of a city
 * 
 * @author mike slattery
 * @version jan 2016
 */
public class City extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage theStage) {
		theStage.setTitle("City");

		Group root = new Group();
		Scene theScene = new Scene(root);
		theStage.setScene(theScene);

		Canvas canvas = new Canvas(600, 500);
		root.getChildren().add(canvas);

		GraphicsContext gc = canvas.getGraphicsContext2D();
		render(gc);

		theStage.show();
	}

	void render(GraphicsContext gc) {
		// Clear background
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, 600, 500);

		// Draw buildings
		gc.setFill(Color.GREY);
		gc.fillRect(70, 70, 140, 140);
		gc.fillRect(270, 70, 140, 140);
		gc.fillRect(70, 270, 140, 140);
		gc.fillRect(270, 270, 140, 140);

		// Draw car
		gc.setFill(Color.RED);
		gc.fillRect(220, 220, 40, 40);

	}
}