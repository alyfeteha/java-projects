/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruitnigga;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Lenovo
 */
public class ArcadeTime {
    private  int secondsPassed=60;

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
	private int milli=1000;
	boolean m;
	 Timer timer =new Timer();
        
TimerTask task=new TimerTask() {
public void run() {
	    setMilli(getMilli() -1);
	if( getMilli()==0) {
		setSecondsPassed(getSecondsPassed() -1);
		setMilli(1000);
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
