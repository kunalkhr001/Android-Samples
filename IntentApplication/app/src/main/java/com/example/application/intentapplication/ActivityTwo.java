package com.example.application.intentapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Bundle firstData=getIntent().getExtras();
        if(firstData==null)
            return;
        String firstMessage=firstData.getString("firstMessage");
        final TextView secondText=(TextView) findViewById(R.id.SecondText);
        secondText.setText(firstMessage);
    }

}
