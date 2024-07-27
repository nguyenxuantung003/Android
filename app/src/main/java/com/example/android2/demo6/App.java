package com.example.android2.demo6;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    public static final String CHANNEL_ID="CHANEL_ID";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotifilecationChannel();
    }

    @SuppressLint("NewApi")
    private void createNotifilecationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.DONUT){
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "CHANNEl_ID",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            channel.setDescription("Thong bao cu the");
            NotificationManager manager = getSystemService(NotificationManager.class);
            if(manager != null){
                manager.createNotificationChannel(channel);
            }
        }
    }
}
