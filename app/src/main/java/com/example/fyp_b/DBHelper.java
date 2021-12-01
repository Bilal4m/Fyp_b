package com.example.fyp_b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";


    public DBHelper(@Nullable Context context ) {

        super(context, "Login.db", null, 1);
    }

    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public void insert_Data(String p_name, String p_desc, byte[] image){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO IMG VALUES (NULL, ? , ? , ?)";


        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1 , p_name);
        statement.bindString(2, p_desc);
        statement.bindBlob(3, image);

        statement.executeInsert();

    }

    public Cursor getData (String sql){
        SQLiteDatabase database = getWritableDatabase();
        return database.rawQuery(sql, null);
    }


    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users (username TEXT primary key, email TEXT, password TEXT )");

        

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists users");


    }

    public Boolean insertdata (String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username" , username);
        contentValues.put("password", password);


        long result = MyDB.insert("users",null,contentValues);
        if (result ==-1)
            return false;
        else
            return true;

    }

    public Boolean checkuname (String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?" , new String[] {username});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkemail (String email){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where email = ? ", new String[] { email});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword (String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?  and password = ?  ",new String[]{username ,password} );
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

}


