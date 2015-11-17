package yycare.uml.com.mysmartwatchcollector.SensorData;

/**
 * Created by changliu on 11/16/15.
 *
 * Description: data structure for sensor data
 */
public class SensorData {

    // MAX size for the array that stores the sensor data
    private int MAX_SIZE = 6;

    // array for storing one sensor data with multiple dimensions
    private double sensor[];

    // the max size of the array
    private int maxSize;


    public SensorData(double val[], int size) {
        maxSize = size;

        sensor = new double[MAX_SIZE];

        for (int i = 0; i < size; i++) {
            sensor[i] = val[i];
        }
    }
}
