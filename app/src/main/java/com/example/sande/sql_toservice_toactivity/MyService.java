package com.example.sande.sql_toservice_toactivity;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

    FeedDao feeddao;
    private static final String TAG = "MyService";
    Employee e1,e2,e3,e4;

    @Override
    public void onCreate() {
        super.onCreate();
        feeddao = new FeedDao(this);
        feeddao.openDb();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "service started", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "In onStartCommand: " + Thread.currentThread().getId());
        insertData();
        sendBroadcast();
        return super.onStartCommand(intent, flags, startId);

        }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "service stopped", Toast.LENGTH_SHORT).show();
        //stopself();
    }

    public void insertData()
    {
         e1 = new Employee("sandeep",25,"Gmail");
         e2 = new Employee("Berry",34,"yahoo");
         e3 = new Employee("Cijan",26,"Rediff");
         e4 = new Employee("Yixin",23,"Outlook");

        feeddao.createRow(e1);
        feeddao.createRow(e2);
        feeddao.createRow(e3);
        feeddao.createRow(e4);


    }
    public void sendBroadcast()
    {
        Intent i = new Intent();
        i.setAction("sandeep");
        i.addCategory(Intent.CATEGORY_DEFAULT);
        i.putExtra("message",e1.getName() + e1.getEmail());
        sendBroadcast(i);
    }
}
