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
 * Use depth-first search to generate a random rectangular maze. Animate the
 * construction of the maze.
 * 
 * @author mike slattery
 * @version mar 2016
 */
public class Dfs extends Application {
	final String appName = "Dfs";
	final int FPS = 20; // frames per second
	final int WIDTH = 800;
	final int HEIGHT = 800;

	public static final int WTOP = 1; //0000 0001
	public static final int WRGT = 2; //0000 0010
	public static final int WBOT = 4; //0000 0100
	public static final int WLFT = 8; //0000 1000

	int cells[][];
	Point current_cell;
	Stack<Point> hold;
	Random gen = new Random();
	int total, count;
	int gridw = 15, gridh = 15, cellsize = 50;

	public void initialize() {
		int x, y;

		cells = new int[gridw][gridh];
		/*
		 * Or together the wall bits to show that all the walls are up.
		 */
		int full = WTOP | WBOT | WLFT | WRGT; //0000 1111
		for (x = 0; x < gridw; x++)
			for (y = 0; y < gridh; y++)
				cells[x][y] = full;
				//all the cells are walls now
		/*
		 * Then, mark the borders
		 */
		int left = WLFT << 4;  //1000 0000
		int right = WRGT << 4; //0010 0000
		for (y = 0; y < gridh; y++) {
			cells[0][y] |= left;
			cells[gridw - 1][y] |= right;
		}
		
		int top = WTOP << 4;    //0001 0000
		int bottom = WBOT << 4; //0100 0000
		for (x = 0; x < gridw; x++) {
			cells[x][0] |= top;
			cells[x][gridh - 1] |= bottom;
		}
		
		total = gridw * gridh;
		// Set starting point for maze construction
		current_cell = new Point(gen.nextInt(gridw), gen.nextInt(gridh));
		count = 1;
		hold = new Stack<Point>();
	}

	/**
	 * Try to add one more cell to the maze (using depth-first search)
	 */
	public void update() {
		int dir;

		if (count < total) {
			dir = findNewNbr(current_cell);
			if (dir == 0)
				current_cell = hold.pop();
			else {
				removeWall(current_cell, dir);
				count++;
				hold.push(current_cell);
				current_cell = getNbr(current_cell, dir);
			}
		}
	}

	public void render(GraphicsContext gc) {
		int val, x, y;

		int basex = 10;
		int basey = 10;
		gc.setFill(Color.WHITE);
		gc.fillRect(basex, basey, gridw * cellsize, gridh * cellsize);
		gc.setStroke(Color.BLACK);
		for (x = 0; x < gridw; x++)
			for (y = 0; y < gridh; y++) {
				val = cells[x][y];
				if ((val & WTOP) != 0)
					gc.strokeLine(basex + x * cellsize, basey + y * cellsize, basex + (x + 1) * cellsize,
							basey + y * cellsize);
				if ((val & WRGT) != 0)
					gc.strokeLine(basex + (x + 1) * cellsize - 1, basey + y * cellsize, basex + (x + 1) * cellsize - 1,
							basey + (y + 1) * cellsize);
				if ((val & WBOT) != 0)
					gc.strokeLine(basex + x * cellsize, basey + (y + 1) * cellsize - 1, basex + (x + 1) * cellsize,
							basey + (y + 1) * cellsize - 1);
				if ((val & WLFT) != 0)
					gc.strokeLine(basex + x * cellsize, basey + y * cellsize, basex + x * cellsize,
							basey + (y + 1) * cellsize);
			}
		/*
		 * Draw the current_cell as well
		 */
		gc.setFill(Color.RED);
		if ((count < total) && (current_cell != null))
			gc.fillOval(basex + current_cell.x * cellsize, basey + current_cell.y * cellsize, cellsize, cellsize);
	}

	/*
	 * The following routines provide access to the underlying maze data structure.
	 */
	int findNewNbr(Point p) {
		/*
		 * Return a direction in which the point p has a neighbor which hasn't been
		 * visited yet (we test this by checking that all its walls are intact).
		 */
		int full = WTOP | WBOT | WLFT | WRGT;
		int d = gen.nextInt(4);
		int k = 0;
		while (k < 4) {
			switch (d) {
			case 0: /* Top nbr? */
				if ((cells[p.x][p.y] & (WTOP << 4)) != 0)
					break;
				/*
				 * Mask with 0xF to get bottom 4 bits
				 */
				if ((cells[p.x][p.y - 1] & 0xF) == full)
					return WTOP;
				break;
			case 1: /* Right nbr? */
				if ((cells[p.x][p.y] & (WRGT << 4)) != 0)
					break;
				if ((cells[p.x + 1][p.y] & 0xF) == full)
					return WRGT;
				break;
			case 2: /* Bottom nbr? */
				if ((cells[p.x][p.y] & (WBOT << 4)) != 0)
					break;
				if ((cells[p.x][p.y + 1] & 0xF) == full)
					return WBOT;
				break;
			case 3: /* Left nbr? */
				if ((cells[p.x][p.y] & (WLFT << 4)) != 0)
					break;
				if ((cells[p.x - 1][p.y] & 0xF) == full)
					return WLFT;
				break;
			}
			d = (d + 1) % 4;
			k++;
		}
		return 0;
	}

	void removeWall(Point p, int d) {
		/*
		 * Exclusive or bit with cell to drop wall
		 */
		cells[p.x][p.y] ^= d;
		/*
		 * And drop neighboring wall as well
		 */
		switch (d) {
		case WTOP:
			cells[p.x][p.y - 1] ^= WBOT;
			break;
		case WRGT:
			cells[p.x + 1][p.y] ^= WLFT;
			break;
		case WBOT:
			cells[p.x][p.y + 1] ^= WTOP;
			break;
		case WLFT:
			cells[p.x - 1][p.y] ^= WRGT;
			break;
		}
	}

	Point getNbr(Point p, int d) {
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
