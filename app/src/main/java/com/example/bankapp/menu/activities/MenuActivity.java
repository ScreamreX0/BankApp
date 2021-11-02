package com.example.bankapp.menu.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bankapp._pojo.Items;
import com.example.bankapp.menu.adapters.MenuAdapter;
import com.example.bankapp.profile.activities.ProfileActivity;
import com.example.bankapp.R;
import com.example.bankapp._pojo.VarsAndConstants;
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
        // Bottom navigation view
        BottomNavigationView bottomNavigationView = findViewById(R.id.activity_menu_bnv_bottom_menu);
        ImageButton history = bottomNavigationView.findViewById(R.id.activity_menu_iv_history);
        history.setOnClickListener(v -> {
            Intent intent = new Intent(this, HistoryActivity.class);
            startActivity(intent);
        });

        // Navigation view
        ImageButton imageButton = findViewById(R.id.activity_menu_iv_profile);
        imageButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        });


        TextView fullname = findViewById(R.id.activity_menu_tv_user_full_name);
        fullname.setText(VarsAndConstants.userSurname + " " + VarsAndConstants.userName);

        ListView listView = findViewById(R.id.activity_menu_lv_main);
        listView.setAdapter(new MenuAdapter(this, new Items.IMenuItem[]{
                new Items.HeaderItem("Мои карты"),
                VarsAndConstants.cards.get(0),
                VarsAndConstants.cards.get(1),
                VarsAndConstants.cards.get(2),

                new Items.HeaderItem("Мои счета"),
                VarsAndConstants.accounts.get(0),
                VarsAndConstants.accounts.get(1),
                VarsAndConstants.accounts.get(2),
                VarsAndConstants.accounts.get(3),

                new Items.HeaderItem("Мои кредиты"),
                VarsAndConstants.credits.get(0),
                VarsAndConstants.credits.get(1),
                VarsAndConstants.credits.get(2),
                VarsAndConstants.credits.get(3)
        }));
    }

}