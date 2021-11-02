package com.example.bankapp.profile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bankapp.R;
import com.example.bankapp._pojo.Items;
import com.example.bankapp.menu.activities.MenuActivity;
import com.example.bankapp._pojo.VarsAndConstants;
import com.example.bankapp.profile.adapters.ProfileSettingsAdapter;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        init();
    }

    @SuppressLint("SetTextI18n")
    private void init() {
        // AppBar
        TextView full_name = findViewById(R.id.activity_profile_tv_user_full_name);
        full_name.setText(VarsAndConstants.userSurname + " " + VarsAndConstants.userName);

        findViewById(R.id.activity_profile_tv_back).setOnClickListener(v -> {
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        });

        // ListView
        Items.SettingItem[] settings = new Items.SettingItem[] {
                new Items.SettingItem("Изменение пароля"),
                new Items.SettingItem("Изменение логина"),
                new Items.SettingItem("История посещений"),
                new Items.SettingItem("Информация о приложении"),
                new Items.SettingItem("Выход")
        };
        ListView listView = findViewById(R.id.activity_profile_lv_main);
        ProfileSettingsAdapter profileSettingsAdapter = new ProfileSettingsAdapter(this, settings);
        listView.setAdapter(profileSettingsAdapter);
    }

}