package com.androidapp.sensorlis;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView mTxtSensor;
    SensorManager sensorManager;
    List<Sensor> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtSensor = findViewById(R.id.mtxtSensor);
        mTxtSensor.setMovementMethod(new ScrollingMovementMethod());
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        list = sensorManager.getSensorList(Sensor.TYPE_ALL);

        mTxtSensor.append("#Sensors:" + list.size()+") \n\n");
        for (Sensor sensor:list)
        {
            mTxtSensor.append("Sensor name" + sensor.getName() + "\n");
            mTxtSensor.append("Sensor type" + sensor.getType() + "\n\n");
        }
    }
}