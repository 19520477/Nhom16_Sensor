package com.example.nhom16_sensor;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProximitySensor extends AppCompatActivity implements SensorEventListener {
    private ImageView img_Bulb;
    private Button btnBack;
    private SensorManager sensorManager;
    private Sensor sensor;
    private static final int SENSOR_SENSITIVITY = 4;
    Boolean bulb = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.light_sensor);

        img_Bulb = findViewById(R.id.img_bulb);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProximitySensor.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.values[0] >= -SENSOR_SENSITIVITY && event.values[0] <= SENSOR_SENSITIVITY)
        {
            if(bulb)
            {
                img_Bulb.setImageResource(R.drawable.bulb_on);
                Toast.makeText(getApplicationContext(), "near", Toast.LENGTH_SHORT).show();
                bulb = false;
            }
            else return;
        }
        else
        {
            bulb = true;
            img_Bulb.setImageResource(R.drawable.bulb_off);
            Toast.makeText(getApplicationContext(), "far", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
