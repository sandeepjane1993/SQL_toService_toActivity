package com.example.sande.sql_toservice_toactivity;

import android.provider.BaseColumns;

public class DbContract {

    DbContract(){}

    public static final class FeedEntry implements BaseColumns
    {
        public static final String TABLE_NAME = "Employee";
        public static final String EMP_NAME = "name";
        public static final String EMP_AGE = "age";
        public static final String EMP_EMAIL = "email";

    }
}
