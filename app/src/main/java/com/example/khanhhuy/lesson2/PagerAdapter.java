package com.example.khanhhuy.lesson2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.khanhhuy.lesson2.fragment.FragmentContact;
import com.example.khanhhuy.lesson2.fragment.FragmentLove;
import com.example.khanhhuy.lesson2.fragment.FragmentPersonal;

/**
 * Created by yeu_thuong on 10/9/2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    private  int mNumberOfTabs;

    public PagerAdapter(FragmentManager fragment, int numberOfTabs){
        super(fragment);
        mNumberOfTabs=numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                FragmentLove mFragmentLove = new FragmentLove();
                return mFragmentLove;
            case 1:
                FragmentContact mFragmentContact = new FragmentContact();
                return mFragmentContact;
            case 2:
                FragmentPersonal mFragmentPersonal = new FragmentPersonal();
                return mFragmentPersonal;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumberOfTabs;
    }
}
