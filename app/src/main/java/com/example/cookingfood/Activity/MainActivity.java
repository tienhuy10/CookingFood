package com.example.cookingfood.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.cookingfood.Fragment.Home;
import com.example.cookingfood.Fragment.Notification;
import com.example.cookingfood.Fragment.Post;
import com.example.cookingfood.Fragment.Profile;
import com.example.cookingfood.Fragment.Saved;
import com.example.cookingfood.Fragment.ViewPagerAdapter;
import com.example.cookingfood.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FrameLayout viewPager;
    BottomNavigationView bottomNavigationView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.fragment_container);
        bottomNavigationView = findViewById(R.id.bottom_NavView);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if(itemId == R.id.home){
                    loadFragment(new Home(), false);

                } else if (itemId == R.id.saved) {
                    loadFragment(new Saved(), false);

                } else if (itemId == R.id.post) {
                    loadFragment(new Post(), false);

                } else if (itemId == R.id.notification) {
                    loadFragment(new Notification(), false);

                }else{
                    loadFragment(new Profile(), false);
                }
                return true;
            }
        });

        loadFragment(new Home(), true);

    }

    private void loadFragment(Fragment fragment, boolean isAppInitialized){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(isAppInitialized){
            fragmentTransaction.add(R.id.fragment_container, fragment);
        } else {
            fragmentTransaction.replace(R.id.fragment_container, fragment);
        }

        fragmentTransaction.commit();
    }

}