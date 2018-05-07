package com.example.lenovo.mycheckboxapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClicked(View view)
    {
        TextView textView=(TextView) findViewById(R.id.MyTextView);
        boolean checked=((CheckBox) view).isChecked();
        switch (view.getId())
        {
            case R.id.tea:
                if(checked)
                    textView.setText("Tea");
                break;
            case R.id.milk:
                if(checked)
                    textView.setText("Milk");
                break;
            default:
                textView.setText("");
        }
    }

}
