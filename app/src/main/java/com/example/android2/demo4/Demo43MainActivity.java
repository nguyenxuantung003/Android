package com.example.android2.demo4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.android2.R;
import com.google.android.material.tabs.TabLayout;

public class Demo43MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayoutl;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo43_main);
        viewPager = findViewById(R.id.demo43viewpage);
        tabLayoutl= findViewById(R.id.demo43tablayout);
        addTabLayout(viewPager);

        tabLayoutl.setupWithViewPager(viewPager);

    }
    public void addTabLayout(ViewPager viewPager){
        Demo43Adapter adapter = new Demo43Adapter(getSupportFragmentManager());
        // them fragment vao adapter
        adapter.AddFrag(new BlankFragment41(),"ONE");
        adapter.AddFrag(new BlankFragment42(),"TWO");
        adapter.AddFrag(new BlankFragment43(),"Three");
        viewPager.setAdapter(adapter);
    }
}