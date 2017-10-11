package com.example.khanhhuy.lesson2.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.khanhhuy.lesson2.ContactAdapter;
import com.example.khanhhuy.lesson2.R;
import com.example.khanhhuy.lesson2.data.ContactDataSource;
import com.example.khanhhuy.lesson2.data.ContactRepository;
import com.example.khanhhuy.lesson2.data.model.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yeu_thuong on 10/9/2017.
 */

public class FragmentContact extends Fragment{
    private RecyclerView mRecyclerContact;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Contact> mContacts;
    private ContactDataSource mRepository;
    private ContactAdapter mAdapter;
    private ImageView mImageAdd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_contact, container, false);

        mRecyclerContact = (RecyclerView) view.findViewById(R.id.recycler_contact);
        mImageAdd= (ImageView) view.findViewById(R.id.image_add);

        mLayoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerContact.setLayoutManager(mLayoutManager);
        mRepository = ContactRepository.getInstance(getActivity());
        mContacts = new ArrayList<>();
        insertData();
        getData();
        mAdapter = new ContactAdapter(mContacts);
        mRecyclerContact.setAdapter(mAdapter);

        mImageAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
                Log.e("khanhhuy","add new");
            }
        });

        return view;
    }

    private void insertData() {
        Contact contact = new Contact(0,"huy","01665833107","khanhhuy101096@gmail.com");
        mRepository.insertContact(contact);
    }

    private void getData() {
        mContacts = mRepository.getContact();
    }
}
