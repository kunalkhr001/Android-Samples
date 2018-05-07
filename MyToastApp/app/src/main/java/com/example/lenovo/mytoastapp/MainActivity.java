package com.example.lenovo.mytoastapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View view)
    {
        CharSequence text="This is a toast";
        int duration= Toast.LENGTH_LONG;
        Toast toast=Toast.makeText(this,text,duration);
        toast.show();
    }

}
