package yycare.uml.com.mysmartwatchcollector.Thread;

import android.hardware.SensorManager;
import android.util.Log;

/**
 * Created by Chang Liu on 11/23/15.
 *
 *
 * Description: thread class for saving sensor data into database/file system
 */
public class saveThread extends Thread{

    private SensorManager mSensorManager;

    // interaval of saving frequence
    private int interval;

    // debugging tags
    private String LOG_TAG = "saveThread";

    // instance of thread
    private Thread thread;

    // thread name for tagging
    private String threadName;

    public saveThread(int val, String name) {
        interval = val;
        threadName = name;
    }

    /**
     * This function is the actual running after start, it will execute when the thread is ready
     */
    public void run() {
        // select different saving function
        saveAccelerometer();
    }

    /**
     * The start point of thread, after calling start() it will execute the whole thread and
     * waits for running
     */
    public void start() {
        Log.v(LOG_TAG, "starting thread");
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }


    /**
     * Some operations for saving accelerometer data
     */
    public void saveAccelerometer(/*float[] data*/) {

    }

    /**
     * Some operations for saving Gyroscope data
     */
    public void saveGyroscope() {

    }

}
