package com.example.khanhhuy.lesson2.data.local;

import android.provider.BaseColumns;

/**
 * Created by yeu_thuong on 10/10/2017.
 */

public class ContactContract {
    public ContactContract(){

    }
    public static class ContactEntry implements BaseColumns{
        public static final String TABLE_NAME="tabl_contact";
        public static final String COLUMN_NAME="name";
        public static final String COLUMN_PHONE_NUMBER="phone";
        public static final String COLUMN_EMAIL="email";
    }
}
