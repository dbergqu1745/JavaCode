package lab13;

import java.awt.Toolkit;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Lab 13 - TimerAlarm class
 * Due 12/7/17
 */

public class TimerAlarm extends Thread {
	private int seconds;
	private String time = "";
	private AlarmAction action;
	public boolean isPlaying;

	public TimerAlarm(int sec, AlarmAction act) {
		seconds = sec * 1000;
		action = act;
		isPlaying = true;
	}

	public void run() {
		//AlarmAction action = new AlarmAction();

		while (true) {

			try {
				TimerAlarm.sleep(this.seconds);
			
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
			if (isPlaying) {
				this.action.alarmAction();
			}
		}
	}
}
