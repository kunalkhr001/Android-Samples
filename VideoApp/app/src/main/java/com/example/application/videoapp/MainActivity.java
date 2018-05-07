package com.example.application.videoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final VideoView myVideoView=(VideoView) findViewById(R.id.myVideoVIew);
        myVideoView.setVideoPath("https://www.youtube.com/watch?v=0ztYYAOcESo");
        myVideoView.start();
    }
}
