package com.example.nhom16_sensor;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ViewListSensor extends AppCompatActivity {
    private SensorManager mgr;
    private TextView txtList;
    private Button btnBack;
    private Button btnLight;
    private Button btnProximity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_sensor);
        mgr = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

        findViewById();

        List<Sensor> sensorList = mgr.getSensorList(Sensor.TYPE_ALL);
        StringBuilder strBuilder = new StringBuilder();
        for(Sensor s: sensorList){
            strBuilder.append(s.getName()+"\n");
        }
        txtList.setVisibility(View.VISIBLE);
        txtList.setText(strBuilder);

        handleClick(btnBack, MainActivity.class);
        handleClick(btnLight, LightSensor.class);
        handleClick(btnProximity, ProximitySensor.class);
    }

    public void findViewById()
    {
        txtList = (TextView)findViewById(R.id.sensorslist);
        btnBack = findViewById(R.id.btn_back);
        btnLight = findViewById(R.id.btn_light);
        btnProximity = findViewById(R.id.btn_proximity);
    }

    private void handleClick(Button btn, Class activity)
    {
        btn.setOnClickListener(v -> {
            Intent intent = new Intent(this, activity);
            startActivity(intent);
        });
    }
}
