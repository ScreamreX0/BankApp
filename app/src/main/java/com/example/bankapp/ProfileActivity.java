package com.example.bankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bankapp.adapters.ProfileSettingsAdapter;

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
        full_name.setText(BankVarsAndConstants.userSurname + " " + BankVarsAndConstants.userName);

        // ListView
        settingRow[] settings = new settingRow[] {
                new settingRow("Изменение пароля"),
                new settingRow("Изменение логина"),
                new settingRow("История посещений"),
                new settingRow("Информация о приложении"),
                new settingRow("Выход")
        };
        ListView listView = findViewById(R.id.activity_profile_lv_main);
        ProfileSettingsAdapter profileSettingsAdapter = new ProfileSettingsAdapter(this, settings);
        listView.setAdapter(profileSettingsAdapter);
    }

    public static class settingRow {
        String name;

        public settingRow(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}