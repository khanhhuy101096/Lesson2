package com.example.khanhhuy.lesson2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.khanhhuy.lesson2.data.model.Contact;

import java.util.List;

/**
 * Created by yeu_thuong on 10/10/2017.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    private LayoutInflater mLayoutInflater;
    private List<Contact> mContacts;

    public ContactAdapter(List<Contact> contacts){
        mContacts=contacts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mLayoutInflater == null) {
            mLayoutInflater = LayoutInflater.from(parent.getContext());
        }
        View v = mLayoutInflater.inflate(R.layout.item_contact,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.binData(mContacts.get(position));
    }

    @Override
    public int getItemCount() {
        return mContacts!=null?mContacts.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mTextName;
        private TextView mTextPhone;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextName = (TextView) itemView.findViewById(R.id.text_name);
            mTextPhone = (TextView) itemView.findViewById(R.id.text_phone);
        }

        public void binData(Contact contact){
            if (contact ==null) return;
            mTextName.setText(contact.getName());
            mTextPhone.setText(contact.getPhone());
        }

    }
}
