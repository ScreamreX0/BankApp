package com.example.bankapp.menu.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.bankapp.R;
import com.example.bankapp._pojo.VarsAndConstants;
import com.example.bankapp.menu.fragments.CardsFragment;
import com.example.bankapp.profile.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        init();

    }

    @SuppressLint("SetTextI18n")
    private void init() {
        // Appbar
        ((TextView)findViewById(R.id.activity_menu_tv_user_full_name)).setText(VarsAndConstants.userSurname + " " + VarsAndConstants.userName);

        // Fragments
        openFragment(new CardsFragment(), getSupportFragmentManager().beginTransaction(), R.id.activity_menu_container);

        ImageView profile_icon = findViewById(R.id.activity_menu_iv_profile);
        profile_icon.setOnClickListener(view -> {
            openFragment(new ProfileFragment(), getSupportFragmentManager().beginTransaction(), R.id.activity_menu_container);
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.activity_menu_bnv_bottom_menu);
        

    }

    private void openFragment(Fragment fragment, FragmentTransaction fragmentTransaction, int container) {
        fragmentTransaction.replace(container, fragment).commit();
    }
}