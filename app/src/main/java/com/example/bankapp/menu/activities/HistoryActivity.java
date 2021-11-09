package com.example.bankapp.menu.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bankapp._pojo.Items;
import com.example.bankapp.R;
import com.example.bankapp.profile.adapters.HistoryAdapter;
import com.example.bankapp._pojo.VarsAndConstants;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Init();
    }

    @SuppressLint("SetTextI18n")
    private void Init() {
        // AppBar
        TextView fullName = findViewById(R.id.activity_history_tv_user_full_name);
        fullName.setText(VarsAndConstants.userSurname + " " + VarsAndConstants.userName);

        // ListView
        ListView listView = findViewById(R.id.activity_history_lv_main);
        listView.setAdapter(new HistoryAdapter(this, new Items.HistoryItem[]{
                new Items.HistoryItem("31.10.2021", "12:09"),
                new Items.HistoryItem("31.10.2021", "12:15"),
                new Items.HistoryItem("31.10.2021", "12:10"),
                new Items.HistoryItem("31.10.2021", "12:45"),
                new Items.HistoryItem("31.10.2021", "15:54"),
                new Items.HistoryItem("31.10.2021", "20:10")
        }));
    }

}