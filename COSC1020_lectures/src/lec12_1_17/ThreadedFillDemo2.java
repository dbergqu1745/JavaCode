package lec12_1_17;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThreadedFillDemo2 extends JFrame implements ActionListener, Runnable {
	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;
	public static final int FILL_WIDTH = 300;
	public static final int FILL_HEIGHT = 100;
	public static final int CIRCLE_SIZE = 10;
	public static final int PAUSE = 100; // milliseconds
	private int count = 0;

	private JPanel box;

	// text field for number of circles to be accessed by entire program
	private JTextField numCircles;

	public static void main(String[] args) {
		ThreadedFillDemo2 gui = new ThreadedFillDemo2();
		gui.setVisible(true);
	}

	// separate thread to update the current count of squares
	private class UpdateThread extends Thread {

		// update the text field with the number of circles
		public void run() {
			while (true) {
				numCircles.setText("" + count);
				doNothing(PAUSE);
			}
		}
	}

	public ThreadedFillDemo2() {
		setSize(WIDTH, HEIGHT);
		setTitle("Threaded Fill Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		box = new JPanel();
		add(box, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());

		JButton startButton = new JButton("Start");
		startButton.addActionListener(this);
		buttonPanel.add(startButton);
		add(buttonPanel, BorderLayout.SOUTH);

		// Adding pause button
		JButton pauseButton = new JButton("Pause");
		pauseButton.addActionListener(this);
		buttonPanel.add(pauseButton);
		
		//Adding resume button
		JButton resumeButton = new JButton("Resume");
		resumeButton.addActionListener(this);
		buttonPanel.add(resumeButton);

		// adding text field next to start button
		numCircles = new JTextField("0", 5);
		numCircles.addActionListener(this);
		numCircles.setEditable(false);
		buttonPanel.add(numCircles);
	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.equals("Start")) {
			startThread();
		} 
//		else if (command.equals("Pause")) {
//			try {
//				
//			} catch (InterruptedException e1) {
//				System.out.println(e1.getMessage());
//				e1.printStackTrace();
//			}
//		}
	}

	public void run() {
		Graphics g = box.getGraphics();
		
		for (int y = 0; y < FILL_HEIGHT; y = y + CIRCLE_SIZE)
			for (int x = 0; x < FILL_WIDTH; x = x + CIRCLE_SIZE) {
				g.fillOval(x, y, CIRCLE_SIZE, CIRCLE_SIZE);
				++count;
				doNothing(PAUSE);
			}
	}

	public void startThread() {
		Thread theThread = new Thread(this);
		UpdateThread udThread = new UpdateThread();

		theThread.start();
		udThread.start();
	}

	public void doNothing(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			System.out.println("Unexpected interrupt");
			System.exit(0);
		}
	}
}
