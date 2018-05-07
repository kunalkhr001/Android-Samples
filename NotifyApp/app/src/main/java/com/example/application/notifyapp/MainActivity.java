package com.example.application.notifyapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    NotificationCompat.Builder notification;
    private static final int uniqueID=40111;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notification=new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);
    }

    public void myButtonClicked(View view)
    {
        notification.setSmallIcon(R.drawable.apple);
        notification.setTicker("This is a ticker");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("This is the title");
        notification.setContentText("This is the text");

        Intent intent=new Intent(this,MainActivity.class);
        PendingIntent pendingIntent=new PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);
        NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID,notification.build());
    }
}
