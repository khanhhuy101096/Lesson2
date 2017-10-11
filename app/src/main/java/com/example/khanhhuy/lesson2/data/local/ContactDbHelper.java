package com.example.khanhhuy.lesson2.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yeu_thuong on 10/10/2017.
 */

public class ContactDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "contact.db";

    private static final String SQL_CREATE_CONTACTS = "CREATE TABLE "
            + ContactContract.ContactEntry.TABLE_NAME
            + " ("
            + ContactContract.ContactEntry._ID
            + " INTEGER PRIMARY KEY,"
            + ContactContract.ContactEntry.COLUMN_NAME
            + " TEXT,"
            + ContactContract.ContactEntry.COLUMN_PHONE_NUMBER
            + " TEXT,"
            + ContactContract.ContactEntry.COLUMN_EMAIL
            + " TEXT)";

    private static final String SQL_DELETE_CONTACTS =
            "DROP TABLE IF EXISTS " + ContactContract.ContactEntry.TABLE_NAME;

    public ContactDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_CONTACTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(SQL_DELETE_CONTACTS);
        sqLiteDatabase.execSQL(SQL_CREATE_CONTACTS);
    }
}
