package com.example.fyp_b;

import android.content.Context;

import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;



public class MyDataBase extends SQLiteOpenHelper {



    public MyDataBase(Context context, String dbname,
                      SQLiteDatabase.CursorFactory factory, int dbversion) {
        super(context, dbname, factory, dbversion);

    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tableimage(image blob);");

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



}

