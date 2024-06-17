package com.speed.accelerometer_sensor;

import static android.widget.Toast.LENGTH_SHORT;

import static com.speed.accelerometer_sensor.R.string.ms;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MicrophoneInfo;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements SensorEventListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE); //typecast,return object hotay but sensor manager use karat ahe
        //sensorManager define
        if (sensorManager != null) {
            Sensor accleroSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);//in this stage we only defined sensor not put value
             //sensorManager register in  following method
            if (accleroSensor != null) {
                sensorManager.registerListener(this, accleroSensor, SensorManager.SENSOR_DELAY_NORMAL);

            }


        } else {
            Toast.makeText(this, R.string.sensor_services, LENGTH_SHORT).show();
        }





    }

    //abstract method of interface class 2 methods
    //values is taken from following method and uses the accelrometer sensor

    @Override
    public void onSensorChanged(SensorEvent event) {
        //WHICH SENSOR
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

            ((TextView) findViewById(R.id.txtValues)).setText("X: " + event.values[0] + ", Y:" + event.values[1] + ", Z: " + event.values[2]);



        }

    }

        @Override
        public void onAccuracyChanged (Sensor sensor,int i){

        }
    }
