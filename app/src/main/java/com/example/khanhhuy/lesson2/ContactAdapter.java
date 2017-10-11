package com.example.khanhhuy.lesson2;

import android.graphics.PorterDuff;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.khanhhuy.lesson2.data.model.Contact;
import com.squareup.picasso.Picasso;

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
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(mLayoutInflater.getContext(),v);
                popupMenu.inflate(R.menu.menu_control);
                Menu menu = popupMenu.getMenu();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.item_edit:
                                Log.e("khanhhuy","Edit");
                                break;
                            case R.id.item_delete:
                                Log.e("khanhhuy","Delete");
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
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
        private ImageView mImageFb;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextName = (TextView) itemView.findViewById(R.id.text_name);
            mTextPhone = (TextView) itemView.findViewById(R.id.text_phone);
            mImageFb = (ImageView) itemView.findViewById(R.id.image_fb);
        }

        public void binData(Contact contact){
            if (contact ==null) return;
            mTextName.setText(contact.getName());
            mTextPhone.setText(contact.getPhone());
            Picasso.with(itemView.getContext())
                    .load("https://cdn3.iconfinder.com/data/icons/free-social-icons/67/facebook_circle_color-256.png")
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.drawable.ic_error)
                    .into(mImageFb);
        }
    }

}
