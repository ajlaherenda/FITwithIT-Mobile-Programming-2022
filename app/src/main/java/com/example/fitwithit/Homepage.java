package com.example.fitwithit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Homepage extends AppCompatActivity {
    public static final String EXTRA_IMAGE = "EXTRA_IMAGE";
    public static final String EXTRA_TITLE = "EXTRA_TITLE";
    public static final String EXTRA_DESC = "EXTRA_DESC";

    private String name;

    
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);



        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String message = extras.getString(Login.EXTRA_NAME);
            name = message;
        }





        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        viewPager = findViewById(R.id.fragmentsContainer);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.getMenu().getItem(position).setChecked(true);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setUpAdapter(viewPager);
    }


    public void setUpAdapter(ViewPager viewpager)
    {

        ViewPagerAdapter viewPageAdapter= new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPageAdapter.addFragment(new HomeFragmentClass(name));
        viewPageAdapter.addFragment(new QuotesFragmentClass());
        viewPageAdapter.addFragment(new HamsterRollFragmentClass());
        viewPageAdapter.addFragment(new ProfileFragmentClass(name));
        viewPager.setAdapter(viewPageAdapter);

    }
        private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener= new BottomNavigationView.OnNavigationItemSelectedListener(){


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case (R.id.Home):
                        viewPager.setCurrentItem(0);
                        return true;
                    case (R.id.quote):
                        viewPager.setCurrentItem(1);
                        return true;
                    case (R.id.hamster):
                        viewPager.setCurrentItem(2);
                        return true;
                    case (R.id.profile):
                        viewPager.setCurrentItem(3);
                        return true;
                    default:
                        return false;

                }
            }
        }; 
}
