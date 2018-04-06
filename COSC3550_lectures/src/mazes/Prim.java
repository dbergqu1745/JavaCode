package mazes;

/*
 * Prim.java
 *
 * Use Prim's algorithm to generate a random rectangular
 * maze.
 * Animate the construction of the maze.
 *
 * written by mike slattery - mar 1999
 */
import java.awt.*;
import java.util.*;
import java.applet.*;

public class Prim extends Applet implements Runnable
{
	public static final int WTOP = 1;
	public static final int WRGT = 2;
	public static final int WBOT = 4;
	public static final int WLFT = 8;

	int cells[][];
	Point current_cell;
	Vector inlist;
	Vector outlist;
	Vector frontlist;
	int gridw, gridh, cellsize;
	Image offscreen;
	Graphics offgr;
	Thread t;

	public void init()
	{
		int x, y;
		String param;

		/* Get applet params */
		param = getParameter("gridw");
		gridw = Integer.parseInt(param);
		param = getParameter("gridh");
		gridh = Integer.parseInt(param);
		param = getParameter("cellsize");
		cellsize = Integer.parseInt(param);

		cells = new int[gridw][gridh];
		/* Or together the wall bits to show that all
		 * the walls are up.
		 */
		int full = WTOP | WBOT | WLFT | WRGT;
		for (x = 0; x < gridw; x++)
			for (y = 0; y < gridh; y++)
				cells[x][y] = full;
		/* Then, mark the borders
		 */
		int left = WLFT << 4;
		int right = WRGT << 4;
		for (y = 0; y < gridh; y++)
		{
			cells[0][y] |= left;
			cells[gridw-1][y] |= right;
		}
		int top = WTOP << 4;
		int bottom = WBOT << 4;
		for (x = 0; x < gridw; x++)
		{
			cells[x][0] |= top;
			cells[x][gridh-1] |= bottom;
		}
		offscreen = createImage((gridw+2)*cellsize, (gridh+2)*cellsize);
		offgr = offscreen.getGraphics();
	}

	public void start()
	{
		t = new Thread(this);
		t.start();
	}

	public void stop()
	{
		t.stop();
		t = null;
	}

	public void run()
	{
		int dir, x, y;

		/*
		 * Implement Prim's algorithm to build maze
		 */
		outlist = new Vector(gridw*gridh);
		inlist = new Vector(10,10);
		frontlist = new Vector(10,10);
		for (x = 0; x < gridw; x++)
			for (y = 0; y < gridh; y++)
				outlist.addElement(new Point(x,y));
		current_cell = (Point)rndElement(outlist);
		inlist.addElement(current_cell);
		moveNbrs(current_cell);

		while (!frontlist.isEmpty())
		{
			current_cell = (Point)rndElement(frontlist);
			inlist.addElement(current_cell);
			moveNbrs(current_cell);
			dir = findInNbr(current_cell);
			removeWall(current_cell, dir);
			/*
			 * Break for the animation effect
			 */
			repaint();
			try
			{
				Thread.sleep(50);
			} catch (Exception e) {};
		}
		/*
		 * All done
		 */
		current_cell = null;
		repaint();
	}

	public void update(Graphics g)
	{
		paint(offgr);
		g.drawImage(offscreen,0,0,this);
	}

	public void paint(Graphics g)
	{
		int val, x ,y;

		int basex = 10;
		int basey = 10;
		g.setColor(Color.white);
		g.fillRect(basex, basey, gridw*cellsize, gridh*cellsize);
		g.setColor(Color.black);
		for (x = 0; x < gridw; x++)
			for (y = 0; y < gridh; y++)
			{
				val = cells[x][y];
				if ((val & WTOP) != 0)
					g.drawLine(basex+x*cellsize, basey+y*cellsize,
						basex+(x+1)*cellsize, basey+y*cellsize);
				if ((val & WRGT) != 0)
					g.drawLine(basex+(x+1)*cellsize-1, basey+y*cellsize,
						basex+(x+1)*cellsize-1, basey+(y+1)*cellsize);
				if ((val & WBOT) != 0)
					g.drawLine(basex+x*cellsize, basey+(y+1)*cellsize-1,
						basex+(x+1)*cellsize, basey+(y+1)*cellsize-1);
				if ((val & WLFT) != 0)
					g.drawLine(basex+x*cellsize, basey+y*cellsize,
						basex+x*cellsize, basey+(y+1)*cellsize);
			}
		/*
		 * Draw the current_cell as well
		 */
		g.setColor(Color.red);
		if (current_cell != null)
			g.fillOval(basex+current_cell.x*cellsize, basey+current_cell.y*cellsize,
				cellsize, cellsize);
	}

	/*
	 * The following routines provide access to the underlying
	 * maze data structure.
	 */
	int findInNbr(Point p)
	{
		/* Return a random direction in which the point p has
		 * a neighbor which is in inlist.
		 */
		int d = rnd(4)-1;
		int k = 0;
		while (k < 4)
		{
			switch(d)
			{
				case 0:	/* Top nbr? */
					if ((cells[p.x][p.y] & (WTOP<<4)) != 0) break;
					if (inlist.indexOf(new Point(p.x,p.y-1)) >= 0)
						return WTOP;
					break;
				case 1: /* Right nbr? */
					if ((cells[p.x][p.y] & (WRGT<<4)) != 0) break;
					if (inlist.indexOf(new Point(p.x+1,p.y)) >= 0)
						return WRGT;
					break;
				case 2: /* Bottom nbr? */
					if ((cells[p.x][p.y] & (WBOT<<4)) != 0) break;
					if (inlist.indexOf(new Point(p.x,p.y+1)) >= 0)
						return WBOT;
					break;
				case 3: /* Left nbr? */
					if ((cells[p.x][p.y] & (WLFT<<4)) != 0) break;
					if (inlist.indexOf(new Point(p.x-1,p.y)) >= 0)
						return WLFT;
					break;
			}
			d = (d+1) % 4;
			k++;
		}
		return 0; // This shouldn't ever happen
	}

	void moveNbrs(Point p)
	{
		Point s;

		/*
		 * Move any neighbors of p which are in outlist from
		 * outlist to frontlist.
		 */
		if ((cells[p.x][p.y] & (WTOP<<4)) == 0)
		{
			s = new Point(p.x, p.y-1);
			movePoint(s, outlist, frontlist);
		}
		if ((cells[p.x][p.y] & (WRGT<<4)) == 0)
		{
			s = new Point(p.x+1, p.y);
			movePoint(s, outlist, frontlist);
		}
		if ((cells[p.x][p.y] & (WBOT<<4)) == 0)
		{
			s = new Point(p.x, p.y+1);
			movePoint(s, outlist, frontlist);
		}
		if ((cells[p.x][p.y] & (WLFT<<4)) == 0)
		{
			s = new Point(p.x-1, p.y);
			movePoint(s, outlist, frontlist);
		}
	}

	void movePoint(Point p, Vector v, Vector w)
	{
		/*
		 * If p is element of v, move it to w
		 */
		int i = v.indexOf(p);
		if (i >= 0)
		{
			v.removeElementAt(i);
			w.addElement(p);
		}
	}

	void removeWall(Point p, int d)
	{
		/* Exclusive or bit with cell to drop wall
		 */
		cells[p.x][p.y] ^= d;
		/*
		 * And drop neighboring wall as well
		 */
		switch(d)
		{
			case WTOP: cells[p.x][p.y-1] ^= WBOT;
				break;
			case WRGT: cells[p.x+1][p.y] ^= WLFT;
				break;
			case WBOT: cells[p.x][p.y+1] ^= WTOP;
				break;
			case WLFT: cells[p.x-1][p.y] ^= WRGT;
				break;
		}
	}

	// Utility routines
	int rnd(int n)
	{
		return (int)(Math.random()*n+1);
	}

	Object rndElement(Vector v)
	{
		int i = rnd(v.size())-1;
		Object s = v.elementAt(i);
		v.removeElementAt(i);
		return s;
	}

}

