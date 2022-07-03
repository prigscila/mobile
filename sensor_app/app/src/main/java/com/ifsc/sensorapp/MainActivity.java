package com.ifsc.sensorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener  {
    TextView textView;
    ImageView imageView;

    SensorManager sensorManager;
    Sensor accelerometer, magnetometer;

    private float[] lastAccelerometer = new float[3];
    private float[] lastMagnetometer = new float[3];
    private float[] rotationMatrix = new float[9];
    private float[] orientation = new float[3];

    boolean isLastAccelerometerArrayCopied = false;
    boolean isLastMagnetometerArrayCopied = false;

    long lastUpdatedTime = 0;
    float currentDegree = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(getApplicationContext().SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        magnetometer = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        sensorManager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_NORMAL);
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor == accelerometer) {
            updateSensor(event, lastAccelerometer);
            isLastAccelerometerArrayCopied = true;
        } else if (event.sensor == magnetometer) {
            updateSensor(event, lastMagnetometer);
            isLastMagnetometerArrayCopied = true;
        }

        if (shouldUpdateView()) {
            float rotationInDegrees = calculateRotationInDegrees();

            imageView.startAnimation(getRotationAnimation(rotationInDegrees));
            currentDegree = -rotationInDegrees;
            lastUpdatedTime = System.currentTimeMillis();

            int x = (int)rotationInDegrees;
            textView.setText(x + "º");
        }
    }

    private RotateAnimation getRotationAnimation(float rotationInDegrees) {
        RotateAnimation rotateAnimation = new RotateAnimation(
                currentDegree,
                -rotationInDegrees,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f
        );

        rotateAnimation.setDuration(250);
        rotateAnimation.setFillAfter(true);

        return rotateAnimation;
    }

    private float calculateRotationInDegrees() {
        SensorManager.getRotationMatrix(rotationMatrix, null, lastAccelerometer, lastMagnetometer);
        SensorManager.getOrientation(rotationMatrix, orientation);

        float azimuthInRadians = orientation[0];
        return (float) Math.toDegrees(azimuthInRadians);
    }

    private void updateSensor(SensorEvent event, float[] sensor) {
        System.arraycopy(event.values, 0, sensor, 0, event.values.length);
    }

    private boolean shouldUpdateView() {
        return isLastMagnetometerArrayCopied && isLastAccelerometerArrayCopied && System.currentTimeMillis() - lastUpdatedTime > 250;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) { }

    @Override
    public void onResume() {
        super.onResume();

        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onPause() {
        super.onPause();

        sensorManager.unregisterListener(this, accelerometer);
        sensorManager.unregisterListener(this, magnetometer);
    }
}