package Model.Classes;

import java.awt.event.ActionListener;
import javax.swing.Timer;

public class PathFinderTimer 
{
    private Timer timer;

    public void start(int delayParameter, ActionListener actionListenerParameter)
    {
        this.stop();
        this.timer = new Timer(delayParameter, actionListenerParameter);
        this.timer.setRepeats(true);
		this.timer.setInitialDelay(0);
        this.timer.start();
    }

    public void stop()
    {
        if(this.timer != null)
        {
            this.timer.stop();
        }
    }
}
