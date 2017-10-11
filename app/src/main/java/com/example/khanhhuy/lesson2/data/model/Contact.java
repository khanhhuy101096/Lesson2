package com.example.khanhhuy.lesson2.data.model;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.khanhhuy.lesson2.data.local.ContactContract;

/**
 * Created by yeu_thuong on 10/10/2017.
 */

public class Contact {
    private int mId;
    private String mName;
    private String mPhone;
    private String mEmail;

    public Contact(int id, String name, String phone, String email) {
        mId = id;
        mName = name;
        mPhone = phone;
        mEmail = email;
    }

    public Contact(Cursor cursor) {
        mName = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.COLUMN_NAME));
        mPhone = cursor.getString(
                cursor.getColumnIndex(ContactContract.ContactEntry.COLUMN_PHONE_NUMBER));
        mEmail = cursor.getString(
                cursor.getColumnIndex(ContactContract.ContactEntry.COLUMN_EMAIL));
        mId = cursor.getInt(cursor.getColumnIndex(ContactContract.ContactEntry._ID));
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public ContentValues getContentValues() {
        ContentValues contentValues = new ContentValues();
        if (mName != null) {
            contentValues.put(ContactContract.ContactEntry.COLUMN_NAME, mName);
        }
        if (mPhone != null) {
            contentValues.put(ContactContract.ContactEntry.COLUMN_PHONE_NUMBER, mPhone);
        }
        if (mEmail != null) {
            contentValues.put(ContactContract.ContactEntry.COLUMN_EMAIL, mEmail);
        }
        if (mId != 0) {
            contentValues.put(ContactContract.ContactEntry._ID, mId);
        }
        return contentValues;
    }
}
