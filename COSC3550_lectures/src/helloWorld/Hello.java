package helloWorld;

import javafx.application.Application;
import javafx.stage.Stage;

public class Hello extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage) {
		stage.setTitle("Hello World");
		stage.show();
	}
}
