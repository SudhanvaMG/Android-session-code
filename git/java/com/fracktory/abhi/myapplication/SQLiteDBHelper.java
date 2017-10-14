package com.fracktory.abhi.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Abhi™ on 13-Oct-17.
 */

public class SQLiteDBHelper extends SQLiteOpenHelper {
    private static final String name = "info.db";
    private static final int version=1;


    public static final String TABLE_NAME = "profile";
    public static final String COLUMN_NAME =  "name";
    public static final String COLUMN_PASS =  "password";
    public static final String COLUMN_ID =  "userid";

    private static final String CREATE_TABLE_QUERY =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " TEXT, " +
                    COLUMN_NAME + " TEXT, "+
                    COLUMN_PASS + " TEXT" +
                    ")";

    public SQLiteDBHelper(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
