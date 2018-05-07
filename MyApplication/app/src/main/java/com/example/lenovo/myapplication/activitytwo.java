package com.example.lenovo.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class activitytwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitytwo);
    }

    public void calcbmi(View view)
    {
        EditText e1=(EditText) findViewById(R.id.editText1);
        EditText e2=(EditText) findViewById(R.id.editText2);
        Button b1=(Button) findViewById(R.id.button2);
        TextView t1=(TextView) findViewById(R.id.newtext1);
        TextView t2=(TextView) findViewById(R.id.newtext2);

        double height=0,weight=0,bmi=0;
        String msg="";

        weight=Double.parseDouble(e1.getText().toString());
        height=Double.parseDouble(e2.getText().toString());

        bmi=height*height;
        bmi=weight/bmi;
        t1.setText(String.valueOf(bmi));

        if(bmi<18.5)
            msg="Underweight";
        else if(bmi>=18.5 && bmi<=25)
            msg="Normal";
        else if(bmi>25)
            msg="Overweight";

        t2.setText(msg);



    }
}
