package lab13_correct;


public class TimerAlarm extends Thread
{
   private TimerInterface actionObj;
   private int time;
   private boolean active;
   
   public TimerAlarm(int t, TimerInterface obj)
   {
	  time = t;
	  actionObj = obj;
   }
   
   /**
	* Methods to disable or enable the timer.
	*/
	public void pause()
	{
		active = false;
	}

	public void play(int timeInterval)
	{
		active = true;
		time = timeInterval;
	}
   
   public void run()
   {
	   while (true)
		{
			// Sleep
			try
			{
				Thread.sleep(time);
			}
			catch (Exception e)
			{
				System.out.println(e);
				System.exit(-1);
			}
			// Invoke timer action if the timer is active
			if (active)
			{
				actionObj.alarmAction();
			}
		}
   }
}
