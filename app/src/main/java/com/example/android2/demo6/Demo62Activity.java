package com.example.android2.demo6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.android2.R;

public class Demo62Activity extends AppCompatActivity {
    Button btnstart,btnstop,btnbackground;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo62);
        btnstart = findViewById(R.id.demo62btnStart);
        btnstop = findViewById(R.id.demo62btnStop);
        btnbackground = findViewById(R.id.demo62btnBackgroundService);

        btnstart.setOnClickListener(v -> {
            startService(new Intent(Demo62Activity.this,ForcegroundService.class));

        });
        btnstop.setOnClickListener(v -> {
            startService(new Intent(Demo62Activity.this,ForcegroundService.class));
        });
        btnbackground.setOnClickListener(v -> {
            startService(new Intent(this, BackgroundService.class));
        });
    }
}