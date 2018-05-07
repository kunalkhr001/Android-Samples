package com.example.lenovo.jsonapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private String TAG=MainActivity.class.getSimpleName();
    private ListView lv;
    ArrayList<HashMap<String,String>> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactList=new ArrayList<>();
        lv=(ListView) findViewById(R.id.list);
        new GetContacts().execute();
    }

    private class GetContacts extends AsyncTask<Void,Void,Void>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this,"Json data is downloading",Toast.LENGTH_LONG).show();

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ListAdapter adapter=new SimpleAdapter(MainActivity.this,contactList,R.layout.list_item,new String[]{"email","mobile"},new int[]{R.id.email,R.id.mobile});
            lv.setAdapter(adapter);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            HTTPHandler sh=new HTTPHandler();
            String url="https://api.androidhive.info/contacts/";
            String jsonStr=sh.makeServiceCall(url);
            Log.e(TAG,"Response from URL: "+jsonStr);
            if(jsonStr!=null)
            {
                try {
                    JSONObject jsonObj=new JSONObject(jsonStr);
                    JSONArray contacts=jsonObj.getJSONArray("contacts");
                    for(int i=0;i<contacts.length();i++)
                    {
                        JSONObject c=contacts.getJSONObject(i);
                        String id=c.getString("id");
                        String name=c.getString("name");
                        String email=c.getString("email");
                        String address=c.getString("address");
                        String gender=c.getString("gender");

                        JSONObject phone=c.getJSONObject("phone");
                        String mobile=phone.getString("mobile");
                        String home=phone.getString("home");
                        String office=phone.getString("office");

                        HashMap<String,String> contact=new HashMap<>();
                        contact.put("id",id);
                        contact.put("name",name);
                        contact.put("email",email);
                        contact.put("mobile",mobile);

                        contactList.add(contact);


                    }
                }catch (final JSONException e)
                {
                    Log.e(TAG,"JSON parsing error: "+e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),"JSON parsing error: "+e.getMessage(),Toast.LENGTH_LONG).show();

                        }
                    });
                }


            }

            else
            {
                Log.e(TAG,"COuldnt get json from server. ");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),"Couldnt get json from server. Check lofcat for possible errors",Toast.LENGTH_LONG).show();

                    }
                });
            }
            return null;

        }
    }


}
