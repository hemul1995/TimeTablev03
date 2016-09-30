package com.example.dima.timetablev03;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Dima on 30.09.2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper implements BaseColumns {

    // имя базы данных
    private static final String DATABASE_NAME = "mydatabase.db";
    // версия базы данных
    private static final int DATABASE_VERSION = 1;

    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

     /*public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }*/

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists TimeLessons" +
                "(" +
                "'id' integer primary key autoincrement," +
                "'day' nvarchar(30)," +
                "'time' nvarchar(20)," +
                "'lesson' nvarchar(255)," +
                "'teacher1' nvarchar(255)," +
                "'teacher2' nvarchar(255)," +
                "'kab' nvarchar(20)," +
                "'odd' nvarchar(3)" +
                ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("create table if not exists isBase" +
                "(" +
                "'id' integer" +
                ");");
    }

}
