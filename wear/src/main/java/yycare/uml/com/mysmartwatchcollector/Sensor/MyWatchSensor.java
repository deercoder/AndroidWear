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

    // lists of sensor type for current device
    private int sensorTypes[];
    private int sensorNumb;


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
     * This function is used for listing the sensor type for smart watch, some may not belong to
     * the major/common types listed in Android DevDoc.
     */
    public void listAllSensorType() {

        // get all the sensor lists, each sensor is an Object
        // we can also get the specific sensor using specific type like MyWatchSensor.GYROSCOPE, etc...
        List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);

        // for debugging, print out all the sensor types
        for (int i = 0; i < deviceSensors.size(); i++) {
            Sensor mTestSensor = deviceSensors.get(i);
            Log.d(LOG_SENSOR, "Sensor index is " + i);
            Log.d(LOG_SENSOR, "Sensor name is " + mTestSensor.getName());
            Log.d(LOG_SENSOR, "Sensor type is " + mTestSensor.getType());
            Log.d(LOG_SENSOR, "Sensor String is " + mTestSensor.toString());
        }

        // for debugging and future extension
        setSensorTypes();
    }


    /**
     * Setting the array of sensor types and the actual sensor number
     * This information can be used in future for adding more features, or using more sensors
     */
    public void setSensorTypes() {
        List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        sensorNumb = deviceSensors.size();
        sensorTypes = new int[sensorNumb];
        for (int i = 0; i < sensorNumb; i++) {
            sensorTypes[i] = deviceSensors.get(i).getType();
        }
    }

    public void listTypes() {
        if (sensorTypes != null) {
            for (int i = 0; i < sensorNumb; i++) {
                Log.d(LOG_SENSOR, "types ===== " + sensorTypes[i]);
            }
        }
    }



    /**
     *  for listing Accelerometer sensor
     *
     *  NOTE: may have multiple sensors for the same type, we should use List
     */
    public void listAccelerometerSensor() {
        List<Sensor> accelerometerSensors = mSensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
        for (int i = 0; i < accelerometerSensors.size(); i++) {
            Sensor mTestSensor = accelerometerSensors.get(i);
            Log.d(LOG_SENSOR, "Sensor String is " + mTestSensor.toString());
            Log.d(LOG_SENSOR, "Sensor type is " + mTestSensor.getType() + " name is  " + mTestSensor.getName() + " index is " + i);
        }
    }

    /**
     *  for listing Ambient Temperature sensor
     *
     *  NOTE: may have multiple sensors for the same type, we should use List
     *        For some devices(Sony watch3), there is no such types of sensors, so it's empty
     */
    public void listmAmbientTemperatureSensor() {
        List<Sensor> ambientTemperatureSensors = mSensorManager.getSensorList(Sensor.TYPE_AMBIENT_TEMPERATURE);
        for (int i = 0; i < ambientTemperatureSensors.size(); i++) {
            Sensor mTestSensor = ambientTemperatureSensors.get(i);
            Log.d(LOG_SENSOR, "Sensor String is " + mTestSensor.toString());
            Log.d(LOG_SENSOR, "Sensor type is " + mTestSensor.getType() + " name is  " + mTestSensor.getName() + " index is " + i);
        }
    }

    /**
     *  for listing Gyroscope sensor
     *
     *  NOTE: may have multiple sensors for the same type, we should use List
     *
     */
    public void listGyroscopeSensor() {
        List<Sensor> gyroscopeSensors = mSensorManager.getSensorList(Sensor.TYPE_GYROSCOPE);
        for (int i = 0; i < gyroscopeSensors.size(); i++) {
            Sensor mTestSensor = gyroscopeSensors.get(i);
            Log.d(LOG_SENSOR, "Sensor String is " + mTestSensor.toString());
            Log.d(LOG_SENSOR, "Sensor type is " + mTestSensor.getType() + " name is  " + mTestSensor.getName() + "index is " + i);
        }
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
