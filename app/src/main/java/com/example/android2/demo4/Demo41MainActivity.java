package com.example.android2.demo4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.android2.R;

public class Demo41MainActivity extends AppCompatActivity {
    Button btn;
    EditText txt;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo41_main);
        btn = findViewById(R.id.demo41btn1);
        txt = findViewById(R.id.demo41txt1);
        btn.setOnClickListener(v -> {
            FragmentManager fragmentManager = getSupportFragmentManager();
            BlankFragment41 fagment41 = (BlankFragment41) fragmentManager.findFragmentById(R.id.Fg41);
            fagment41.txt1.setText(txt.getText().toString());
        });
    }
}