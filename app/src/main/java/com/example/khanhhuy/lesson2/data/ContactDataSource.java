package com.example.khanhhuy.lesson2.data;

import com.example.khanhhuy.lesson2.data.model.Contact;

import java.util.List;

/**
 * Created by yeu_thuong on 10/10/2017.
 */

public interface ContactDataSource {
    boolean insertContact(Contact contact);

    List<Contact> getContact();

    Contact getContactById(int id);

    boolean updateContact(Contact contact);

    List<Contact> getContactByName(String name);
}
