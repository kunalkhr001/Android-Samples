package com.example.lenovo.fireapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;


public class MainActivity extends AppCompatActivity {


    private DatabaseReference ref;
    private EditText editText;
    private EditText editText2;
    private TextView mValue;
    private TextView textView2;
    private TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText) findViewById(R.id.editText);
        editText2=(EditText) findViewById(R.id.editText2);
        mValue=(TextView) findViewById(R.id.mValue);
        textView2=(TextView) findViewById(R.id.textView2);
        textView3=(TextView) findViewById(R.id.textView3);

        ref=FirebaseDatabase.getInstance().getReferenceFromUrl("https://fireapp-4a552.firebaseio.com/");
        /*
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String,String> map=(Map) dataSnapshot.getValue();


                String name=map.get("Name");
                String age=map.get("Age");
                String prof=map.get("Profession");

                mValue.setText(name);
                textView2.setText(age);
                textView3.setText(prof);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
            */
    }

    public void usersFetch(View view)
    {
        Intent i=new Intent(this,UsersFetch.class);
        startActivity(i);
    }

    public void email(View view)
    {
        Intent i=new Intent(this,EmailActivity.class);
        startActivity(i);
    }

    public void addData(View view)
    {
        String key=editText.getText().toString();
        String value=editText2.getText().toString();
        ref.child(key).setValue(value);
    }

}
