package com.example.application.intentapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG="com.example.application.intentapplication";
    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"OnStart called");
        Runnable r=new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++)
                {
                    long futuretime= System.currentTimeMillis()+5000;
                    while (System.currentTimeMillis()<futuretime)
                    {
                        synchronized (this)
                        {
                            try {
                                wait(futuretime-System.currentTimeMillis());
                                Log.i(TAG,"Service is running");
                            }catch (Exception e){}
                        }
                    }
                }
            }
        };
                 Thread myThread=new Thread(r);
                 myThread.start();
                return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"Destroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
