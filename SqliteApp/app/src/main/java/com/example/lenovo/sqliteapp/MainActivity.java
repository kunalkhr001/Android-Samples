package com.example.lenovo.sqliteapp;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName,editSurname,editMarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb=new DatabaseHelper(this);
        editName=(EditText) findViewById(R.id.editText);
        editName=(EditText) findViewById(R.id.editText2);
        editName=(EditText) findViewById(R.id.editText3);

    }

    public void addData(View view){


                        boolean isInserted=myDb.insertData(editName.getText().toString(),editSurname.getText().toString(),editMarks.getText().toString());
                        if (isInserted==true)
                            Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data Not Inserted",Toast.LENGTH_LONG).show();
                    }




    public void viewAll(View view)
    {
                     Cursor res=myDb.getAllData();
                        if(res.getCount()==0){}
                            showMessage("Error","No Data found");
                        StringBuffer buffer=new StringBuffer();
                        while (res.moveToNext()){
                            buffer.append("ID: "+res.getString(0)+"\nName: "+res.getString(1)+"\nSurname: "+res.getString(2)+"\nMarks: "+res.getString(3));
                        }

                        showMessage("Data",buffer.toString());
                    }





    public void showMessage(String title,String Message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


}
