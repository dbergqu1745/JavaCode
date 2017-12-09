package lec11_27_17;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelDemo extends JFrame implements ActionListener {
	public static final int WIDTH = 300;
	public static final int HEIGHT = 200;

	private JPanel greenPanel;
	private JPanel whitePanel;
	private JPanel orangePanel;

	public static void main(String[] args) {
		PanelDemo gui = new PanelDemo();
		gui.setVisible(true);
	}

	public PanelDemo() {
		super("Ireland");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		JPanel biggerPanel = new JPanel();
		biggerPanel.setLayout(new GridLayout(1, 3));

		greenPanel = new JPanel();
		greenPanel.setBackground(Color.LIGHT_GRAY);
		biggerPanel.add(greenPanel);

		whitePanel = new JPanel();
		whitePanel.setBackground(Color.LIGHT_GRAY);
		biggerPanel.add(whitePanel);

		orangePanel = new JPanel();
		orangePanel.setBackground(Color.LIGHT_GRAY);
		biggerPanel.add(orangePanel);

		add(biggerPanel, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.LIGHT_GRAY);
		buttonPanel.setLayout(new FlowLayout());

		JButton greenButton = new JButton("Green");
		greenButton.setBackground(Color.GREEN);
		greenButton.addActionListener(this);
		buttonPanel.add(greenButton);

		JButton whiteButton = new JButton("White");
		whiteButton.setBackground(Color.WHITE);
		whiteButton.addActionListener(this);
		buttonPanel.add(whiteButton);

		JButton orangeButton = new JButton("Orange");
		orangeButton.setBackground(Color.ORANGE);
		orangeButton.addActionListener(this);
		buttonPanel.add(orangeButton);

		add(buttonPanel, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		String buttonString = e.getActionCommand();

		if (buttonString.equals("Green"))
			greenPanel.setBackground(Color.GREEN);
		else if (buttonString.equals("White"))
			whitePanel.setBackground(Color.WHITE);
		else if (buttonString.equals("Orange"))
			orangePanel.setBackground(Color.ORANGE);
		else
			System.out.println("Unexpected error.");
	}
}
