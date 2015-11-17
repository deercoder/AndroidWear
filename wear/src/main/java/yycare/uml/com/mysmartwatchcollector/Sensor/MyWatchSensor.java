package yycare.uml.com.mysmartwatchcollector.Sensor;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.util.Log;

import java.util.List;

/**
 * Created by changliu on 11/16/15.
 */
public class MyWatchSensor {


    // for sensor data collection, get the manager
    private SensorManager mSensorManager;

    // List of member variables for managing sensors
    private List<Sensor> mListSensor;

    // lists of various types of sensors
    private MyWatchSensor mAccelerometer;
    private MyWatchSensor mAmbientTemperature;
    private MyWatchSensor mGravity;
    private MyWatchSensor mGyroscope;
    private MyWatchSensor mLight;
    private MyWatchSensor mLinearAcceleration;
    private MyWatchSensor mMagneticField;
    private MyWatchSensor mPressure;
    private MyWatchSensor mProximity;
    private MyWatchSensor mRelativeHumidity;
    private MyWatchSensor mRotationVector;

    // for debugging
    private String LOG_SENSOR = "MyWatchSensor";


    /**
     * Construction function for building the manager for using APIs of Sensors
     * @param sm: sensor manager from activity
     */
    public MyWatchSensor(SensorManager sm)
    {
        mSensorManager = sm;
    }

    /**
     * Return the sensor manager for register/unregister the sensor
     * @return SensorManager
     */
    public SensorManager getSensorManager() {
        return mSensorManager;
    }


    /**
     * This function is used for listing the sensor type for smart watch
     */
    public void listSensorType() {

        // get all the sensor lists, each sensor is an Object
        // we can also get the specific sensor using specific type like MyWatchSensor.GYROSCOPE, etc...
        List<android.hardware.Sensor> deviceSensors = mSensorManager.getSensorList(android.hardware.Sensor.TYPE_ALL);

        //

    }


    /**
     * Judge whether a specific type of sensor exists in the device
     */
    public boolean isSensorExisted(int type) {
        if (mSensorManager != null) {
            if (mSensorManager.getDefaultSensor(type) != null) {
                Log.d(LOG_SENSOR, "MyWatchSensor exists for type: " + type);
                return true;
            }
            else {
                Log.d(LOG_SENSOR, "MyWatchSensor not exist for type: " + type);
                return false;
            }
        }
        else {
            Log.e(LOG_SENSOR,"SensorManager is NULL");
            return false;
        }
    }


    /**
     *  Get the minimal interval for a sensor that senses data
     *  if returning 0, then it's a non-stream sensor, and only sense data when changes
     *  otherwise it is stream sensor and senses data in a fixed interval
     */
    public int getSenseInterval(android.hardware.Sensor sensor) {
        if (sensor != null) {
            int val = sensor.getMinDelay();
            if (val == 0) {
                Log.d(LOG_SENSOR, "non-stream sensor");
            }
            else {
                Log.d(LOG_SENSOR, "stream sensor");
            }
            return val;
        }
        else {
            Log.e(LOG_SENSOR, "NULL sensor!");
            return -1;
        }
    }

}
