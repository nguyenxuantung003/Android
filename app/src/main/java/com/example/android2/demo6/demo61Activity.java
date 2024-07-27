package com.example.android2.demo6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.widget.Button;

import com.example.android2.R;

public class demo61Activity extends AppCompatActivity {

    Button btn1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo61);
        btn1 = findViewById(R.id.demo61btn);
        btn1.setOnClickListener(v -> {
            senNotifilecation();
        });
    }

    @SuppressLint("MissingPermission")
    private void senNotifilecation() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,App.CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_menu_camera)
                .setContentTitle("Thong bao ")
                .setContentText("Thong bao cu the")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(1,builder.build());
    }
}