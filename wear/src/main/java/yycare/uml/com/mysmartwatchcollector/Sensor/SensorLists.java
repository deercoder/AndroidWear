package yycare.uml.com.mysmartwatchcollector.Sensor;

import android.hardware.Sensor;
import android.hardware.SensorManager;

import java.util.List;

/**
 * Created by changliu on 11/17/15.
 *
 * Description: functions for real Sensor instances in the devices, which includes:
 *              1) get the List of sensor that real exists in the device
 *              2) get specific instance of sensors like Gyroscope, Accelerometer, Light etc...
 */
public class SensorLists {

    // sensor manager for all sensors
    private SensorManager mSensorManager;

    // Sensor lists that really exist in the devices
    private List<Sensor> realSensors;

    // lists of various types of sensors(major types in Android Sensor Document)
    private Sensor mAccelerometer;
    private Sensor mAmbientTemperature;
    private Sensor mGravity;
    private Sensor mGyroscope;
    private Sensor mLight;
    private Sensor mLinearAcceleration;
    private Sensor mMagneticField;
    private Sensor mPressure;
    private Sensor mProximity;
    private Sensor mRelativeHumidity;
    private Sensor mRotationVector;

    // lists of pre-defined real sensor types
    private int realSensorTypes[] =  {
            Sensor.TYPE_ACCELEROMETER,
            Sensor.TYPE_AMBIENT_TEMPERATURE,
            Sensor.TYPE_GAME_ROTATION_VECTOR,
            Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR,
            Sensor.TYPE_GRAVITY,
            Sensor.TYPE_GYROSCOPE,
            /* NOT USING UNCALIBRATE: Sensor.TYPE_GYROSCOPE_UNCALIBRATED */
            Sensor.TYPE_HEART_RATE,
            Sensor.TYPE_LIGHT,
            Sensor.TYPE_LINEAR_ACCELERATION,
            Sensor.TYPE_MAGNETIC_FIELD,
            /* NOT USING UNCALIBRATE: Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED */
            Sensor.TYPE_PRESSURE,
            Sensor.TYPE_PROXIMITY,
            Sensor.TYPE_RELATIVE_HUMIDITY,
            Sensor.TYPE_ROTATION_VECTOR,
            Sensor.TYPE_SIGNIFICANT_MOTION,
            Sensor.TYPE_STEP_COUNTER,
            Sensor.TYPE_STEP_DETECTOR

            /* Deprecated: Sensor.TYPE_TEMPERATURE */
            /* Deprecated: Sensor.TYPE_ORIENTATION */
    };


    /**
     * Constructor, for constructing the SensorManager to use
     * @param sm
     */
    public SensorLists(SensorManager sm) {
        mSensorManager = sm;
    }

    /**
     *  Get the default sensor type using its type
     * @param type of the sensor, for example, Sensor.TYPE_PRESSURE, TYPE_ACCELEROMETER
     * @return the instance of the real sensor
     */
    public Sensor getSensor(int type) {
        Sensor mSensor = mSensorManager.getDefaultSensor(type);
        return mSensor;
    }

    /**
     * For get all sensor instances in the devices
     *
     * NOTE: some types may not exist in the realSensorTypes, they're defined by vendors,
     *       So android not support them, we have to reduce these type, otherwise it crashes
     *       for no such sensor types(like 65539 in Sony watch3)
     * @param arr: int array that stores the actual types of sensor in the device
     * @param size: the size of the array
     */
    public void getAllRealSensors(int arr[], int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < realSensorTypes.length; j++) {
                if (arr[i] == realSensorTypes[j]) {
                    realSensors.add(getSensor(arr[i]));
                }
            }
        }
    }


    /**
     * get default accelerometer sensor
     */
    public Sensor getDefaultAccelerometerSensor() {
        mAccelerometer = getSensor(Sensor.TYPE_ACCELEROMETER);
        return mAccelerometer;
    }

    /**
     * get default gyroscope sensor
     */
    public Sensor getDefaultGyroscopeSensor() {
        mGyroscope = getSensor(Sensor.TYPE_GYROSCOPE);
        return mGyroscope;
    }

    /***
     * get default ambient temperature sensor
     */
    public Sensor getDefaultAmbientTempSensor() {
        mAmbientTemperature = getSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        return mAmbientTemperature;
    }


    /**
     *  get default gravity sensor
     */
    public Sensor getDefaultGravitySensor() {
        mGravity = getSensor(Sensor.TYPE_GRAVITY);
        return mGravity;
    }

    /**
     * get default Light sensor
     */
    public Sensor getDefaultLightSensor() {
        mLight = getSensor(Sensor.TYPE_LIGHT);
        return mLight;
    }

    /**
     * get default LinearAcceleration sensor
     */
    public Sensor getDefaultLinearAccelerationSensor() {
        mLinearAcceleration = getSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        return mLinearAcceleration;
    }

    /***
     *  get default mMagneticField sensor
     */
    public Sensor getDefaultMagneticFieldSensor() {
        mMagneticField = getSensor(Sensor.TYPE_MAGNETIC_FIELD);
        return mMagneticField;
    }

    /**
     * get default mPressure sensor
     */
    public Sensor getDefaultPressureSensor() {
        mPressure = getSensor(Sensor.TYPE_PRESSURE);
        return mPressure;
    }

    /**
     * get default mProximity Sensor
     */
    public Sensor getDefaultProximitySensor() {
        mProximity = getSensor(Sensor.TYPE_PROXIMITY);
        return mProximity;
    }

    /**
     * get default mRelativeHumidity Sensor
     */
    public Sensor getDefaultRelativeHumiditySensor() {
        mRelativeHumidity = getSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        return mRelativeHumidity;
    }

    /**
     * get default mRotationVector Sensor
     */
    public Sensor getRotationVectorSensor() {
        mRotationVector= getSensor(Sensor.TYPE_ROTATION_VECTOR);
        return mRotationVector;
    }


}
