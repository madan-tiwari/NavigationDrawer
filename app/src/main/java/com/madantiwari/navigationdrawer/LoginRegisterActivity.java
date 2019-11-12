package com.madantiwari.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.madantiwari.navigationdrawer.adapter.ViewPagerAdapter;
import com.madantiwari.navigationdrawer.fragment.LoginFragment;
import com.madantiwari.navigationdrawer.fragment.RegisterFragment;

public class LoginRegisterActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);

            viewPager=findViewById(R.id.viewPager);
            tabLayout=findViewById(R.id.tabId);

            tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FFFFFF"));
            ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
            viewPagerAdapter.addFragment(new LoginFragment(), "Login");
            viewPagerAdapter.addFragment(new RegisterFragment(), "Register");

            viewPager.setAdapter(viewPagerAdapter);
            tabLayout.setupWithViewPager(viewPager);
        }
    }







