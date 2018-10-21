package com.example.sande.sql_toservice_toactivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.sande.sql_toservice_toactivity.DbContract.*;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ToService";
    private static final int DATABASE_VERSION = 1;
    private static final String sql = " CREATE TABLE " +
            FeedEntry.TABLE_NAME + " ( " +
            FeedEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            FeedEntry.EMP_NAME + " TEXT, " +
            FeedEntry.EMP_AGE + " INTEGER, " +
            FeedEntry.EMP_EMAIL + " TEXT) ";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME);
        onCreate(db);
    }
}
