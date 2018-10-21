package com.example.sande.sql_toservice_toactivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class FeedDao {

    SQLiteDatabase db;
    DbHelper dbhelper;

    FeedDao(Context context){
        dbhelper = new DbHelper(context);
    }
    public void openDb(){
        db = dbhelper.getWritableDatabase();
    }
    public void  closeDb()
    {
        db.close();
    }


    public void createRow(Employee employee)
    {
        ContentValues cv = new ContentValues();
        cv.put(DbContract.FeedEntry.EMP_NAME,employee.getName());
        cv.put(DbContract.FeedEntry.EMP_AGE,employee.getAge());
        cv.put(DbContract.FeedEntry.EMP_EMAIL,employee.getEmail());
        db.insert(DbContract.FeedEntry.TABLE_NAME,null,cv);
    }

    public List<Employee> getRow()
    {
        List<Employee> list = new ArrayList<>();
        Cursor cursor = db.query(DbContract.FeedEntry.TABLE_NAME,null,null,null,null,
                null,null);
        if(cursor.moveToFirst())
        {
            do {
                {
                    Employee e = new Employee();
                    e.setName(cursor.getString(1));
                    e.setAge(cursor.getInt(2));
                    e.setEmail(cursor.getString(3));
                    list.add(e);
                }
            }while (cursor.moveToNext());
        }
        cursor.close();
        return  list;
    }
}
