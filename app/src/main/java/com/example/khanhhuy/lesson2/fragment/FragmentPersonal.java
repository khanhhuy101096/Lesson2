package com.example.khanhhuy.lesson2.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.khanhhuy.lesson2.R;
import com.squareup.picasso.Picasso;

/**
 * Created by yeu_thuong on 10/9/2017.
 */

public class FragmentPersonal extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_fragment_personal, container, false);
    }
}
