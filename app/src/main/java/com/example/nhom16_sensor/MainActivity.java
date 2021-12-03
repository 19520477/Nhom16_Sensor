package com.example.nhom16_sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnView;
    private Button btnLight;
    private Button btnProximity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();

        handleClick(btnView, ViewListSensor.class);
        handleClick(btnLight, LightSensor.class);
        handleClick(btnProximity, ProximitySensor.class);
    }

    private void findViewById() {
        btnView = findViewById(R.id.btn_view);
        btnLight = findViewById(R.id.btn_light_sensor);
        btnProximity = findViewById(R.id.btn_proximity_sensor);
    }

    private void handleClick(Button btn, Class activity)
    {
        btn.setOnClickListener(v -> {
            Intent intent = new Intent(this, activity);
            startActivity(intent);
        });
    }
}