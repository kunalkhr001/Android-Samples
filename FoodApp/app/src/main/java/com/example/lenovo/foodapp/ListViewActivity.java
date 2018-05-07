package com.example.lenovo.foodapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends AppCompatActivity {


    String [] myString=new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};
    private ListView mListView;
    private ArrayAdapter mArrayAdapter;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        mListView=(ListView) findViewById(R.id.myListView);
        mArrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,myString);
        if(mListView!=null)
        {
            mListView.setAdapter(mArrayAdapter);
        }
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.v("PLACE",myString[i]);
            }
        });
    }
}
