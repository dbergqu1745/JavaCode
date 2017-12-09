package lab12;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Lab 12 - Better calculator
 * Due 11/30/17
 */

public class Calculator extends JFrame implements ActionListener {
	public static final int WIDTH = 400;
	public static final int HEIGHT = 200;
	public static final int NUMBER_OF_DIGITS = 30;

	private JTextField ioField;
	private JTextField ioField2;
	private double result = 0.0;
	private String operand = "";

	public static void main(String[] args) {
		Calculator aCalculator = new Calculator();
		aCalculator.setVisible(true);
	}

	public Calculator() {
		setTitle("Lab 12 Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setLayout(new BorderLayout());

		JPanel textPanel = new JPanel();
		JPanel buttonsPanel = new JPanel();
		
		GridLayout calcLayout = new GridLayout(3, 3);
		GridLayout textLayout = new GridLayout(2, 0);

		ioField = new JTextField("Enter numbers here.", NUMBER_OF_DIGITS);
		ioField2 = new JTextField("Answer appears here.", NUMBER_OF_DIGITS);
		ioField.setBackground(Color.WHITE);
		ioField2.setBackground(Color.WHITE);
		
		textPanel.setLayout(textLayout);
		
		textPanel.add(ioField);
		textPanel.add(ioField2);
		
		add(textPanel, BorderLayout.NORTH);
		

		//JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBackground(Color.ORANGE);
		buttonsPanel.setLayout(calcLayout);

		JButton addButton = new JButton("+");
		addButton.addActionListener(this);
		buttonsPanel.add(addButton);

		JButton subtractButton = new JButton("-");
		subtractButton.addActionListener(this);
		buttonsPanel.add(subtractButton);

		JButton multiplyButton = new JButton("*");
		multiplyButton.addActionListener(this);
		buttonsPanel.add(multiplyButton);

		JButton divideButton = new JButton("/");
		divideButton.addActionListener(this);
		buttonsPanel.add(divideButton);

		JButton _zero = new JButton("0");
		_zero.addActionListener(this);
		buttonsPanel.add(_zero);

		JButton _one = new JButton("1");
		_one.addActionListener(this);
		buttonsPanel.add(_one);

		JButton _two = new JButton("2");
		_two.addActionListener(this);
		buttonsPanel.add(_two);

		JButton _three = new JButton("3");
		_three.addActionListener(this);
		buttonsPanel.add(_three);

		JButton _four = new JButton("4");
		_four.addActionListener(this);
		buttonsPanel.add(_four);

		JButton _five = new JButton("5");
		_five.addActionListener(this);
		buttonsPanel.add(_five);

		JButton _six = new JButton("6");
		_six.addActionListener(this);
		buttonsPanel.add(_six);

		JButton _seven = new JButton("7");
		_seven.addActionListener(this);
		buttonsPanel.add(_seven);

		JButton _eight = new JButton("8");
		_eight.addActionListener(this);
		buttonsPanel.add(_eight);

		JButton _nine = new JButton("9");
		_nine.addActionListener(this);
		buttonsPanel.add(_nine);
		
		JButton _dec = new JButton(".");
		_dec.addActionListener(this);
		buttonsPanel.add(_dec);

		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		buttonsPanel.add(clearButton);

		JButton clearAllButton = new JButton("Clear All");
		clearAllButton.addActionListener(this);
		buttonsPanel.add(clearAllButton);

		add(buttonsPanel, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			assumingCorrectNumberFormats(e);
		} catch (NumberFormatException e2) {
			ioField.setText("Error: Reenter Number.");
		}
	}

	// Throws NumberFormatException.
	public void assumingCorrectNumberFormats(ActionEvent e) {
		String actionCommand = e.getActionCommand();

		// numbers
		if (actionCommand.equals("0")) {
			operand += "0";
			ioField.setText(operand);
		} else if (actionCommand.equals("1")) {
			operand += "1";
			ioField.setText(operand);
		} else if (actionCommand.equals("2")) {
			operand += "2";
			ioField.setText(operand);
		} else if (actionCommand.equals("3")) {
			operand += "3";
			ioField.setText(operand);
		} else if (actionCommand.equals("4")) {
			operand += "4";
			ioField.setText(operand);
		} else if (actionCommand.equals("5")) {
			operand += "5";
			ioField.setText(operand);
		} else if (actionCommand.equals("6")) {
			operand += "6";
			ioField.setText(operand);
		} else if (actionCommand.equals("7")) {
			operand += "7";
			ioField.setText(operand);
		} else if (actionCommand.equals("8")) {
			operand += "8";
			ioField.setText(operand);
		} else if (actionCommand.equals("9")) {
			operand += "9";
			ioField.setText(operand);
		} else if (actionCommand.equals(".")) {
			operand += ".";
			ioField.setText(operand);

			// operators
		} else if (actionCommand.equals("+")) {
			result = result + stringToDouble(ioField.getText());
			ioField2.setText(Double.toString(result));
			operand = "";
		} else if (actionCommand.equals("-")) {
			result = result - stringToDouble(ioField.getText());
			ioField2.setText(Double.toString(result));
			operand = "";
		} else if (actionCommand.equals("*")) {
			result = result * stringToDouble(ioField.getText());
			ioField2.setText(Double.toString(result));
			operand = "";
		} else if (actionCommand.equals("/")) {
			if (stringToDouble(ioField.getText()) == 0) {
				ioField2.setText("Invalid operation");
			} else {
				result = result / stringToDouble(ioField.getText());
				ioField2.setText(Double.toString(result));
				operand = "";
			}

			// etc.
		} else if (actionCommand.equals("Clear")) {
			result = 0.0;
			ioField.setText("0.0");
		} else if (actionCommand.equals("Clear All")) {
			result = 0.0;
			operand = "";
			ioField.setText("0.0");
			ioField2.setText("0.0");
		} else
			ioField.setText("Unexpected error.");
	}

	// Throws NumberFormatException.
	private static double stringToDouble(String stringObject) {
		return Double.parseDouble(stringObject.trim());
	}

}
