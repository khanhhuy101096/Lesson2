package com.example.khanhhuy.lesson2.data.local;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.khanhhuy.lesson2.data.ContactDataSource;
import com.example.khanhhuy.lesson2.data.model.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yeu_thuong on 10/10/2017.
 */

public class ContactLocalDataSource extends ContactDbHelper implements ContactDataSource {
    private static ContactDataSource sSource;

    public static ContactDataSource getInstance(Context context){
        if (sSource == null) {
            sSource = new ContactLocalDataSource(context);
        }
        return sSource;
    }

    public ContactLocalDataSource(Context context) {
        super(context);
    }

    @Override
    public boolean insertContact(Contact contact) {
        if (contact == null) return false;
        SQLiteDatabase db = getWritableDatabase();
        long result = db.insert(ContactContract.ContactEntry.TABLE_NAME, null,
                contact.getContentValues());
        return result != -1;
    }

    @Override
    public List<Contact> getContact() {
        List<Contact> contacts = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                ContactContract.ContactEntry._ID, ContactContract.ContactEntry.COLUMN_NAME,
                ContactContract.ContactEntry.COLUMN_PHONE_NUMBER,
                ContactContract.ContactEntry.COLUMN_EMAIL
        };

        Cursor cursor = db.query(ContactContract.ContactEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        if (cursor != null && cursor.moveToFirst()) {
            contacts = new ArrayList<>();
            do {
                contacts.add(new Contact(cursor));
            } while (cursor.moveToNext());
        }
        if (cursor != null) {
            cursor.close();
        }
        db.close();
        return contacts;
    }

    @Override
    public Contact getContactById(int id) {
        Contact contact = null;
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                ContactContract.ContactEntry._ID, ContactContract.ContactEntry.COLUMN_NAME,
                ContactContract.ContactEntry.COLUMN_PHONE_NUMBER,
                ContactContract.ContactEntry.COLUMN_EMAIL
        };

        String selection = ContactContract.ContactEntry._ID + "=?";
        String[] selectionArgs = { String.valueOf(id) };

        Cursor cursor = db.query(ContactContract.ContactEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        if (cursor != null && cursor.moveToFirst()) {
            contact = new Contact(cursor);
        }
        if (cursor != null) {
            cursor.close();
        }
        db.close();
        return contact;
    }

    @Override
    public boolean updateContact(Contact contact) {
        if (contact == null) return false;
        SQLiteDatabase db = getWritableDatabase();
        String whereClause = ContactContract.ContactEntry._ID + "=?";
        String[] whereArgs = { String.valueOf(contact.getId()) };
        long result = db.update(ContactContract.ContactEntry.TABLE_NAME, contact.getContentValues(),
                whereClause, whereArgs);
        return result != -1;
    }

    @Override
    public List<Contact> getContactByName(String name) {
        List<Contact> contacts = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                ContactContract.ContactEntry._ID, ContactContract.ContactEntry.COLUMN_NAME,
                ContactContract.ContactEntry.COLUMN_PHONE_NUMBER,
                ContactContract.ContactEntry.COLUMN_EMAIL
        };

        String whereClause = ContactContract.ContactEntry.COLUMN_NAME + " LIKE ?";
        String[] whereArgs = { name };

        Cursor cursor = db.query(ContactContract.ContactEntry.TABLE_NAME,
                projection,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );
        if (cursor != null && cursor.moveToFirst()) {
            contacts = new ArrayList<>();
            do {
                contacts.add(new Contact(cursor));
            } while (cursor.moveToNext());
        }
        if (cursor != null) {
            cursor.close();
        }
        db.close();
        return contacts;
    }
}
