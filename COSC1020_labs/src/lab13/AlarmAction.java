package lab13;

import java.awt.Toolkit;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Lab 13 - TimerAlarmGui class
 * Due 12/7/17
 */

public class AlarmAction implements TimerInterface {
	
	public void alarmAction() {
		Toolkit.getDefaultToolkit().beep();
	}
}
