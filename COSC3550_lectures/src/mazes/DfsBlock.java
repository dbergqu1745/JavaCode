package mazes;

import java.awt.Point;
import java.util.Random;
import java.util.Stack;

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
 * Use depth-first search to generate a random rectangular maze. "Carve" maze
 * out of blocks rather than knocking down walls. Animate the construction of
 * the maze.
 * 
 * @author mike slattery
 * @version mar 2018
 */
public class DfsBlock extends Application {
	final String appName = "DfsBlock";
	final int FPS = 20; // frames per second
	final int WIDTH = 750;
	final int HEIGHT = 500;

	// Use simpler constants for block directions
	// (than original Dfs)
	public static final int WTOP = 0;
	public static final int WRGT = 1;
	public static final int WBOT = 2;
	public static final int WLFT = 3;

	int cells[][];
	Point current_cell;
	Stack<Point> hold;
	Random gen = new Random();
	int gridw = 14, gridh = 10, cellsize = 40;

	public void initialize() {
		int x, y;

		cells = new int[gridw][gridh];
		/*
		 * Fill in all the blocks
		 */
		for (x = 0; x < gridw; x++)
			for (y = 0; y < gridh; y++)
				cells[x][y] = 1;
		/*
		 * Then, mark the borders
		 */
		for (y = 0; y < gridh; y++) {
			cells[0][y] = 2;
			cells[gridw - 1][y] = 2;
		}

		for (x = 0; x < gridw; x++) {
			cells[x][0] = 2;
			cells[x][gridh - 1] = 2;
		}
		// Set starting point for maze construction
		current_cell = new Point(gen.nextInt(gridw - 2) + 1, gen.nextInt(gridh - 2) + 1);
		removeBlock(current_cell);
		hold = new Stack<Point>();
	}

	/**
	 * Try to add one more cell to the maze (using depth-first search)
	 */
	public void update() {
		Point nbr;

		nbr = findNewNbr(current_cell);
		if (nbr == null) {
			if (hold.isEmpty()) {
				current_cell = null;
				return;
			}
			current_cell = hold.pop();
		} else {
			removeBlock(nbr);
			hold.push(current_cell);
			current_cell = nbr;
		}
	}

	public void render(GraphicsContext gc) {
		int x, y;

		int basex = 10;
		int basey = 10;
		gc.setFill(Color.WHITE);
		gc.fillRect(basex, basey, gridw * cellsize, gridh * cellsize);
		gc.setFill(Color.BLACK);
		for (x = 0; x < gridw; x++)
			for (y = 0; y < gridh; y++) {
				if (cells[x][y] != 0) {
					gc.fillRect(basex + x * cellsize, basey + y * cellsize, cellsize, cellsize);
				}
			}
		/*
		 * Draw the current_cell as well
		 */
		gc.setFill(Color.RED);
		if (current_cell != null)
			gc.fillOval(basex + current_cell.x * cellsize, basey + current_cell.y * cellsize, cellsize, cellsize);
	}

	/*
	 * The following routines provide access to the underlying maze data structure.
	 */
	Point findNewNbr(Point p) {
		/*
		 * Return a neighboring block which is removable (or null if none such).
		 */
		int d = gen.nextInt(4);
		int k = 0;
		while (k < 4) {
			Point nbr = getNbr(p, d);
			if (isRemovable(nbr))
				return nbr;
			d = (d + 1) % 4;
			k++;
		}
		return null;
	}

	boolean isRemovable(Point p) {
		// Return whether or not the block at p
		// can be removed without breaking through
		// to the existing maze.
		Point nbr;

		if (cells[p.x][p.y] != 1)
			return false;
		int sum = 0;
		for (int d = 0; d < 4; d++) {
			nbr = getNbr(p, d);
			if (cells[nbr.x][nbr.y] != 0)
				sum++;
		}
		return sum == 3;
	}

	void removeBlock(Point p) {
		cells[p.x][p.y] = 0;
	}

	Point getNbr(Point p, int d) {
		// Return the neighboring point from p in
		// the direction d.
		switch (d) {
		case WTOP:
			return new Point(p.x, p.y - 1);
		case WRGT:
			return new Point(p.x + 1, p.y);
		case WBOT:
			return new Point(p.x, p.y + 1);
		case WLFT:
			return new Point(p.x - 1, p.y);
		}
		return null;
	}

	/*
	 * Begin boiler-plate code... [Animation with initialization]
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
