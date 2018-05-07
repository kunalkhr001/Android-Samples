package com.example.lenovo.foodapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;




public class MyDownloadTask extends AppCompatActivity {

    TextView myTextView;
    Button myButton;
    ProgressBar mySpinner;
    ImageView myImageView;

    String myUrl="http://www.freeiconspng.com/uploads/food-salad-21.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_download_task);
        myTextView=(TextView) findViewById(R.id.myTextView);
        myButton=(Button) findViewById(R.id.myButton);
        mySpinner=(ProgressBar) findViewById(R.id.mySpinner);
        myImageView=(ImageView) findViewById(R.id.myImageView);
    }

    public class MyTask extends AsyncTask<String,Integer,Bitmap> {

        @Override
        protected Bitmap doInBackground(String... strings) {
            int count;
            String fileLocation="/sdcard/myfile.png";

            try {
                URL url=new URL(strings[0]);
                URLConnection connection=url.openConnection();
                connection.connect();

                int length=connection.getContentLength();

                InputStream input=new BufferedInputStream(url.openStream(),8192);

                OutputStream output=new FileOutputStream(fileLocation);

                byte data[]=new byte[1024];
                long total=0;

                while ((count=input.read(data))!=-1)
                {
                    total+=count;
                    publishProgress((int)((total*100)/length));
                    output.write(data,0,count);
                }

                output.flush();
                output.close();
                input.close();

            }catch (Exception e){
                Log.e("Error: ",e.getMessage());
            }
            return BitmapFactory.decodeFile(fileLocation);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            myButton.setEnabled(false);
            myTextView.setText("Working on something important!!");
            mySpinner.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            myTextView.setText("Picture Downloaded");
            myButton.setEnabled(true);
            mySpinner.setVisibility(View.GONE);
            myImageView.setImageBitmap(bitmap);
            myImageView.setVisibility(View.VISIBLE);

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            mySpinner.setProgress(values[0]);
            myTextView.setText(values[0]+"% Complete.........");

        }
    }

    public void onClickButton(View view)
    {
        MyTask task=new MyTask();
        task.execute(myUrl);
    }

}


