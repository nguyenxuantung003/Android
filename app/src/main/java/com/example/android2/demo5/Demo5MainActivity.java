package com.example.android2.demo5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.android2.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Demo5MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo5_main);
        bottomNavigationView = findViewById(R.id.demo51_bottomnavication);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.demo51item_menu_item1){
                    Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                } else if(item.getItemId() == R.id.demo51item_menu_item2){
                    Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                } else if(item.getItemId() == R.id.demo51item_menu_item3){
                    Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
}