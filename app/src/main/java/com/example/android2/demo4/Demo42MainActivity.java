package com.example.android2.demo4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;

import com.example.android2.R;

public class Demo42MainActivity extends AppCompatActivity {
    Button btnan,btnhien;
    BlankFragment41 frg;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo42_main);
        btnan = findViewById(R.id.demo42btnan);
        btnhien = findViewById(R.id.demo42btnhien);
        btnan.setOnClickListener(v -> {
            FragmentManager fragmentManager = getSupportFragmentManager();
            frg = (BlankFragment41) fragmentManager.findFragmentById(R.id.demo41Fg1);
            fragmentManager.beginTransaction()
                    .hide(frg)
                    .commit();
        });
        btnhien.setOnClickListener(v -> {
            FragmentManager fragmentManager = getSupportFragmentManager();
            frg = (BlankFragment41) fragmentManager.findFragmentById(R.id.demo41Fg1);
            fragmentManager.beginTransaction()
                    .show(frg)
                    .commit();
        });
    }
}