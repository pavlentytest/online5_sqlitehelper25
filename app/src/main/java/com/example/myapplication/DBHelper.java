package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "usersdb25.db";
    public static final String TABLE_NAME = "users";
    public static final int DB_VERSION = 1;

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+ "("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT, "
                + "year INTEGER "
                + ");");
        db.execSQL("INSERT INTO "+TABLE_NAME + " (name, year) VALUES ('Ivanov Ivan',2010)");
        db.execSQL("INSERT INTO "+TABLE_NAME + " (name, year) VALUES ('Petrova Maria',2015)");
        db.execSQL("INSERT INTO "+TABLE_NAME + " (name, year) VALUES ('Sidorov Oleg',2006)");
        db.execSQL("INSERT INTO "+TABLE_NAME + " (name, year) VALUES ('Ivanova Olga',2011)");
        db.execSQL("INSERT INTO "+TABLE_NAME + " (name, year) VALUES ('Petrov Max',2009)");
    }

    public ArrayList<User> getAll() {
        ArrayList<User> list = new ArrayList<>();
        String sql = "SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToFirst()) {
            do {
                String name = cursor.getString(1);
                int year = cursor.getInt(2);
                list.add(new User(name, year));
            } while(cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
