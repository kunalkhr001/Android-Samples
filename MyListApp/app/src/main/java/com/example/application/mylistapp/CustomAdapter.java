package com.example.application.mylistapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by lenovo on 7/8/2017.
 */

class CustomAdapter extends ArrayAdapter<String> {
    public CustomAdapter(Context context, String[] Fruits) {
        super(context,R.layout.custom_row,Fruits);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater myInflater=LayoutInflater.from(getContext());
        View CustomView=myInflater.inflate(R.layout.custom_row,parent,false);

        String singlefruititem=getItem(position);
        TextView myText=(TextView) CustomView.findViewById(R.id.myText);

        ImageView myImage=(ImageView) CustomView.findViewById(R.id.myImage);

        myText.setText(singlefruititem);
        myImage.setImageResource(R.drawable.apple);

        return CustomView;
    }
}
