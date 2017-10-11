package com.example.khanhhuy.lesson2.data;

import android.content.Context;

import com.example.khanhhuy.lesson2.data.local.ContactLocalDataSource;
import com.example.khanhhuy.lesson2.data.model.Contact;

import java.util.List;

/**
 * Created by yeu_thuong on 10/10/2017.
 */

public class ContactRepository implements ContactDataSource {
    private static ContactRepository sRepository;
    private ContactDataSource mLocalDataSource;

    public ContactRepository(ContactDataSource localDataSource) {
        mLocalDataSource = localDataSource;
    }

    public static ContactRepository getInstance(Context context) {
        if (sRepository == null) {
            sRepository = new ContactRepository(ContactLocalDataSource.getInstance(context));
        }
        return sRepository;
    }

    @Override
    public boolean insertContact(Contact contact) {
        return mLocalDataSource.insertContact(contact);
    }

    @Override
    public List<Contact> getContact() {
        return mLocalDataSource.getContact();
    }

    @Override
    public Contact getContactById(int id) {
        return mLocalDataSource.getContactById(id);
    }

    @Override
    public boolean updateContact(Contact contact) {
        return mLocalDataSource.updateContact(contact);
    }

    @Override
    public List<Contact> getContactByName(String name) {
        return mLocalDataSource.getContactByName(name);
    }
}
