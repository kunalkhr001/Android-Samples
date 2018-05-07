package com.example.lenovo.fireapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class EmailActivity extends AppCompatActivity {

    private EditText emailtext;
    private EditText passtext;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mauthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        mAuth=FirebaseAuth.getInstance();
        mauthStateListener=new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()!=null)
                {
                    Intent i=new Intent(EmailActivity.this,AccountActivity.class);
                    startActivity(i);
                }
            }
        };


        emailtext=(EditText) findViewById(R.id.editText3);
        passtext=(EditText) findViewById(R.id.editText4);
    }

    public void startSignIn(View view)
    {
        String email=emailtext.getText().toString();
        String pass=passtext.getText().toString();
        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(pass))
        {
            Toast.makeText(EmailActivity.this,"Empty Fields",Toast.LENGTH_LONG).show();
        }
        else
        {
            mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!task.isSuccessful())
                    {
                        Toast.makeText(EmailActivity.this,"Sign-in Problem",Toast.LENGTH_LONG).show();
                    }

                }
            });
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        //mAuth.addAuthStateListener(mauthStateListener);
    }
}
