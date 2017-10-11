package com.example.khanhhuy.lesson2;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;

import com.example.khanhhuy.lesson2.data.ContactDataSource;
import com.example.khanhhuy.lesson2.data.ContactRepository;
import com.example.khanhhuy.lesson2.data.model.Contact;

import java.util.List;

public class MainActivity extends AppCompatActivity{
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabLayout = (TabLayout) findViewById(R.id.tab_title);
        mViewPager = (ViewPager) findViewById(R.id.view_fragment);

        mTabLayout.addTab(mTabLayout.newTab().setText("Love"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Contact"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Pesonal"));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        mPagerAdapter = new PagerAdapter(getSupportFragmentManager(),mTabLayout.getTabCount());
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
