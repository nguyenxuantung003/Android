package com.example.android2.demo5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.android2.R;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class Demo52MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo52_main);
        drawerLayout = findViewById(R.id.draw_layout_demo52);
        navigationView = findViewById(R.id.demo52_navicationview);
        viewPager = findViewById(R.id.demo53_viewPager);
        tabLayout = findViewById(R.id.demo53_Tablayout);
        addTabLayout(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.demo51item_menu_item1){
                    viewPager.setCurrentItem(0);
                    closeDrawer();

                    return true;
//                    Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                } else if(item.getItemId() == R.id.demo51item_menu_item2){
                    viewPager.setCurrentItem(1);
                    closeDrawer();
                    return true;
//                    Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                } else if(item.getItemId() == R.id.demo51item_menu_item3){
                    viewPager.setCurrentItem(2);
                    closeDrawer();
                    return true;
//                    Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

    }
    private void closeDrawer(){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    public void addTabLayout(ViewPager viewPager){
        // tao moi adapter
        demo53_Adapter demo53Adapter = new demo53_Adapter(getSupportFragmentManager());
        // them fragment vao adaper
        demo53Adapter.addFrag(new BlankFragment1(),"One");
        demo53Adapter.addFrag(new BlankFragment2(),"Two");
        demo53Adapter.addFrag(new BlankFragment3(),"Three");
        viewPager.setAdapter(demo53Adapter);
    }
}