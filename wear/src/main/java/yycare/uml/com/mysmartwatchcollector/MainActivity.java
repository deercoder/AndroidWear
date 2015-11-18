package yycare.uml.com.mysmartwatchcollector;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.BoxInsetLayout;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

// import external packages
import yycare.uml.com.mysmartwatchcollector.Sensor.MyWatchSensor;
import yycare.uml.com.mysmartwatchcollector.Sensor.SensorLists;


public class MainActivity extends WearableActivity implements SensorEventListener{

    private static final SimpleDateFormat AMBIENT_DATE_FORMAT =
            new SimpleDateFormat("HH:mm", Locale.US);

    private BoxInsetLayout mContainerView;
    private TextView mTextView;
    private TextView mClockView;

    // MyWatchSensor is to manuplate the sensor class and member
    private MyWatchSensor myWatchSensor;

    // Sensor Manager to register/unregister
    private SensorManager mSensorManager;

    // sensor instances
    private SensorLists mSensorList;

    // for logging and debugging
    private String LOG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAmbientEnabled();
        initSensor();
        initSensorInstances();
        testSensor();

        mContainerView = (BoxInsetLayout) findViewById(R.id.container);
        mTextView = (TextView) findViewById(R.id.text);
        mClockView = (TextView) findViewById(R.id.clock);
    }

    @Override
    public void onEnterAmbient(Bundle ambientDetails) {
        super.onEnterAmbient(ambientDetails);
        updateDisplay();
    }

    @Override
    public void onUpdateAmbient() {
        super.onUpdateAmbient();
        updateDisplay();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        unregisterSensor();
    }


    @Override
    public void onExitAmbient() {
        updateDisplay();
        super.onExitAmbient();
    }

    private void updateDisplay() {
        if (isAmbient()) {
            mContainerView.setBackgroundColor(getResources().getColor(android.R.color.black));
            mTextView.setTextColor(getResources().getColor(android.R.color.white));
            mClockView.setVisibility(View.VISIBLE);

            mClockView.setText(AMBIENT_DATE_FORMAT.format(new Date()));
        } else {
            mContainerView.setBackground(null);
            mTextView.setTextColor(getResources().getColor(android.R.color.black));
            mClockView.setVisibility(View.GONE);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int accuracy = event.accuracy;
        Sensor s = event.sensor;
        long timestamp = event.timestamp;
        float[] values = event.values;

        Log.d(LOG_TAG, "accuracy = " + accuracy + " timestamp = " + timestamp + " sensor's info " + s.toString());
        for (int i = 0; i < values.length; i++) {
            Log.d(LOG_TAG, "value " + i + " = " + values[i]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


    public void initSensor() {
        myWatchSensor =  new MyWatchSensor((SensorManager) getSystemService(Context.SENSOR_SERVICE));
        mSensorManager = myWatchSensor.getSensorManager();
    }

    public void testSensor() {
        myWatchSensor.listAllSensorType();
        myWatchSensor.listAccelerometerSensor();
        myWatchSensor.listmAmbientTemperatureSensor();
        myWatchSensor.listGyroscopeSensor();
        myWatchSensor.listTypes();
    }


    public void registerSensor(Sensor mSensor) {
        mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void unregisterSensor() {
        mSensorManager.unregisterListener(this);
    }


    /**
     * This function is to initialize the actual sensor instance,
     * It will be used for registered the listener to collect data
     */
    public void initSensorInstances() {
        mSensorList = new SensorLists(mSensorManager);
    }

    public void registerSensorListener() {

        Sensor mLight = mSensorList.getDefaultLightSensor();
        Sensor mAccelerometer = mSensorList.getDefaultAccelerometerSensor();
        registerSensor(mLight);
        registerSensor(mAccelerometer);
    }

    public void unregisterSensorListener() {
        mSensorManager.unregisterListener(this);
    }




}


