package fruitnigga;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;
public class Time {
	private  int secondsPassed=0;

    /**
     * @return the secondsPassed
     */
    public  int getSecondsPassed() {
        return secondsPassed;
    }

    /**
     * @param aSecondsPassed the secondsPassed to set
     */
    public  void setSecondsPassed(int aSecondsPassed) {
        secondsPassed = aSecondsPassed;
    }
	private int milli=0;
	boolean m;
	 Timer timer =new Timer();
        
TimerTask task=new TimerTask() {
public void run() {
	    setMilli(getMilli() + 1);
	if( getMilli()>=1000) {
		setSecondsPassed(getSecondsPassed() + 1);
		setMilli(0);
	}

}   };

public void start() {
	timer.scheduleAtFixedRate(task,1,1);
}

    /**
     * @return the milli
     */
    public int getMilli() {
        return milli;
    }

    /**
     * @param milli the milli to set
     */
    public void setMilli(int milli) {
        this.milli = milli;
    }
    public void stop()
    {
        
        timer.cancel();
        
        //timer.purge();
    }


}
