package lab13_correct;

import java.awt.Toolkit;

public class AlarmAction implements TimerInterface
{
	@Override
	public void alarmAction() 
	{
		Toolkit.getDefaultToolkit().beep();	
	}
  
}
