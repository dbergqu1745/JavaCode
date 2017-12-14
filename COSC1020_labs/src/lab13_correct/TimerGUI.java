package lab13_correct;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class TimerGUI extends JFrame implements ActionListener
{
	private JTextField text;
	private TimerAlarm alarmThread;
	private TimerInterface timerInterface;
	
	public TimerGUI()
	{	
		 setSize(100,200);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 text = new JTextField(4);
		 JButton playbtn = new JButton("play");
		 playbtn.addActionListener(this);
		 
		 JButton pausebtn = new JButton("pause");
		 pausebtn.addActionListener(this);
		 
		 FlowLayout layout = new FlowLayout();
		 setLayout(layout);
		 
		 add(text);
		 add(playbtn);
		 add(pausebtn);
		 
		 timerInterface = new AlarmAction();
		 alarmThread = new TimerAlarm(1000, timerInterface);
		 alarmThread.start();
	}
	 
    	 public static void main(String[] args)
     {
    		 TimerGUI timerGUI = new TimerGUI();
    		 timerGUI.setVisible(true);
	 }

		@Override
		public void actionPerformed(ActionEvent e) 
		{
		   String actionCommand = e.getActionCommand();
		   String time = text.getText();
		   int timeInterval = Integer.parseInt(time);
		   
		   if(actionCommand.equalsIgnoreCase("play"))
		   {
			   alarmThread.play(timeInterval);
		   }
		   else if(actionCommand.equalsIgnoreCase("pause"))
		   {
			   alarmThread.pause();
		   }
		   else
			   System.out.println("event not handled");
		}
    	
} 
