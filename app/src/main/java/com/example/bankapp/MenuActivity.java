package com.example.bankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bankapp.Interfaces.IMenuItem;
import com.example.bankapp.adapters.MenuAdapter;
import com.example.bankapp.pojo.Accounts;
import com.example.bankapp.pojo.BankVarsAndConstants;
import com.example.bankapp.pojo.Cards;
import com.example.bankapp.pojo.Credits;
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
        fullname.setText(BankVarsAndConstants.userSurname + " " + BankVarsAndConstants.userName);

        ListView listView = findViewById(R.id.activity_menu_lv_main);
        listView.setAdapter(new MenuAdapter(this, new IMenuItem[]{
                new HeaderRow("Мои карты"),
                Cards.cards.get(0),
                Cards.cards.get(1),
                Cards.cards.get(2),

                new HeaderRow("Мои счета"),
                Accounts.bankAccounts.get(0),
                Accounts.bankAccounts.get(1),
                Accounts.bankAccounts.get(2),
                Accounts.bankAccounts.get(3),

                new HeaderRow("Мои кредиты"),
                Credits.bankCredits.get(0),
                Credits.bankCredits.get(1),
                Credits.bankCredits.get(2),
                Credits.bankCredits.get(3)
        }));
    }

    public static class HeaderRow implements IMenuItem {
        String name;
        final int TYPE = 0;

        public HeaderRow(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public int getViewType() {
            return TYPE;
        }
    }
}