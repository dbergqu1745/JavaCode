package lec11_29_17;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AdderSubtracter extends JFrame implements ActionListener{
	
	JFrame window = new JFrame("Adder/Subtracter");
	
	
	JButton plus = new JButton("+");
	JButton minus = new JButton("-");
	
	//implementation of actionperformed
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void main(String[] args) {
		AdderSubtracter as = new AdderSubtracter();
		as.setVisible(true);
	}

	
}
