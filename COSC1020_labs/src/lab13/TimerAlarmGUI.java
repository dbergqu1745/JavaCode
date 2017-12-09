package lab13;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Lab 13 - TimerAlarmGui class
 * Due 12/7/17
 */

public class TimerAlarmGUI implements ActionListener {
	String time = "";
	JTextField textBox = new JTextField("Enter time interval in seconds", 30);
	
	public TimerAlarmGUI() {
		// constructing application interface
		JFrame outerWindow = new JFrame();
		outerWindow.setTitle("Timer Alarm");
		outerWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		outerWindow.setSize(300, 300);
		outerWindow.setLayout(new GridLayout(3, 1));

		// Text box
		
		outerWindow.add(textBox);

		// Play button
		JButton playButton = new JButton("Play");
		playButton.addActionListener(this);
		outerWindow.add(playButton);

		// Pause button
		JButton pauseButton = new JButton("Pause");
		pauseButton.addActionListener(this);
		outerWindow.add(pauseButton);

		outerWindow.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		TimerAlarm timerAlarm = new TimerAlarm(Integer.valueOf(textBox.getText()), new AlarmAction());;
		
		if (cmd.equals("Play")) {
			timerAlarm.isPlaying = true;
			//timerAlarm.start();
		} else if (cmd.equals("Pause")) {
			//timerAlarm = new TimerAlarm(Integer.valueOf(textBox.getText()), new AlarmAction());
			timerAlarm.isPlaying = false;
		}
		timerAlarm.start();
	}
	
	public static void main(String[] args) {
		TimerAlarmGUI program = new TimerAlarmGUI();

	}
}
