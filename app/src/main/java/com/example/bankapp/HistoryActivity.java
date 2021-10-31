package com.example.bankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bankapp.adapters.HistoryAdapter;

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
        fullName.setText(BankVarsAndConstants.userSurname + " " + BankVarsAndConstants.userName);

        findViewById(R.id.activity_history_tv_back).setOnClickListener(v -> {
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        });

        // ListView
        ListView listView = findViewById(R.id.activity_history_lv_main);
        listView.setAdapter(new HistoryAdapter(this, new History[]{
                new History("31.10.2021", "12:09"),
                new History("31.10.2021", "12:15"),
                new History("31.10.2021", "12:10"),
                new History("31.10.2021", "12:45"),
                new History("31.10.2021", "15:54"),
                new History("31.10.2021", "20:10")
        }));
    }

    static public class History {
        String date;
        String time;

        public String getDate() {
            return date;
        }

        public String getTime() {
            return time;
        }

        public History(String date, String time) {
            this.date = date;
            this.time = time;
        }
    }

}