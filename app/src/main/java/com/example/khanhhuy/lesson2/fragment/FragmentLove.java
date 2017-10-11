package com.example.khanhhuy.lesson2.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
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

public class FragmentLove extends Fragment {
    private ImageView mImageGlide;
    private ImageView mImagePicasso;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_love, container, false);
        mImageGlide = (ImageView) view.findViewById(R.id.image_glide);
        mImagePicasso = (ImageView) view.findViewById(R.id.image_picasso);

        Glide.with(this)
                .load("https://cdn3.iconfinder.com/data/icons/free-social-icons/67/facebook_circle_color-256.png")
                .placeholder(R.mipmap.ic_launcher)
                .error(R.drawable.ic_error)
                .into(mImageGlide);

        Picasso.with(getContext())
                .load("https://cdn3.iconfinder.com/data/icons/free-social-icons/67/facebook_circle_color-256.png")
                .placeholder(R.mipmap.ic_launcher)
                .error(R.drawable.ic_error)
                .into(mImagePicasso);

        return view;
    }
}
