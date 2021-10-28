package com.example.bankapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.example.bankapp.adapters.BranchesAtmAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BranchesAtmActivity extends AppCompatActivity {
    ListView mainListView;
    Button mainWindowButton;
    AtmRow[] atmRows;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branches_atm);

        //checkPermissions();
        init();
    }

    private void init() {
        mainWindowButton = findViewById(R.id.activity_branches_atm_main_btn_window);
        mainWindowButton.setOnClickListener(l -> {
            Intent mainActivity = new Intent(this, MainActivity.class);
            startActivity(mainActivity);
        });

        atmRows = new AtmRow[] {
                new AtmRow("Москва, ул. 50 лет победы д. 3", "Банкомат", 4, 10, 20, 0),
                new AtmRow("Москва, ул. 30 лет победы д. 4", "Отделение", 4, 10, 20, 0),
                new AtmRow("Москва, ул. 20 лет победы д. 5", "Банкомат", 8, 20, 18, 30),
                new AtmRow("Москва, ул. 10 лет победы д. 6", "Отделение", 5, 5, 23, 30),
                new AtmRow("Москва, ул. 12 лет победы д. 7", "Отделение", 3, 30, 20, 45),
                new AtmRow("Москва, ул. 35 лет победы д. 8", "Банкомат", 5, 15, 21, 0),
                new AtmRow("Москва, ул. 40 лет победы д. 9", "Банкомат", 6, 59, 15, 30),
                new AtmRow("Москва, ул. 40 лет победы д. 10", "Отделение", 10, 15, 23, 0),
                new AtmRow("Москва, ул. 15 лет победы д. 11", "Банкомат", 3, 5, 19, 50),
                new AtmRow("Москва, ул. 50 лет победы д. 20", "Отделение", 4, 5, 18, 0)
        };

        mainListView = findViewById(R.id.activity_branches_atm_lv_list);
        BranchesAtmAdapter adapter = new BranchesAtmAdapter(this, atmRows);
        mainListView.setAdapter(adapter);
    }

    public static class AtmRow {
        String address;
        String type;
        int startHour;
        int startMinute;
        int endHour;
        int endMinute;

        public AtmRow(String address, String type, int startHour, int startMinute, int endHour, int endMinute) {
            this.address = address;
            this.type = type;
            this.startHour = startHour;
            this.startMinute = startMinute;
            this.endHour = endHour;
            this.endMinute = endMinute;
        }

        public String getAddress() {
            return address;
        }

        public String getType() {
            return type;
        }

        public int getStartHour() {
            return startHour;
        }

        public int getStartMinute() {
            return startMinute;
        }

        public int getEndHour() {
            return endHour;
        }

        public int getEndMinute() {
            return endMinute;
        }
    }

    public static boolean isWork(int startHour, int startMinute, int endHour, int endMinute) {
        @SuppressLint("SimpleDateFormat") String[] currentTime = new SimpleDateFormat("HH:mm")
                .format(new Date())
                .split(":");

        int currentHour = Integer.parseInt(currentTime[0]);
        int currentMinutes = Integer.parseInt(currentTime[1]);

        if (currentHour > startHour) {
            if (currentHour < endHour) {
                return true;
            } else if (currentHour == endHour) {
                return currentMinutes < endMinute;
            } else {
                return false;
            }
        } else if (currentHour == startHour) {
            return currentMinutes > startMinute;
        } else {
            return false;
        }
    }

    public static String addZero(int number) {
        if (String.valueOf(number).length() == 1) {
            return "0" + number;
        }
        return String.valueOf(number);
    }

    private void checkPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 100);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 100 && grantResults[0] == RESULT_OK) {
            checkPermissions();
        }
    }
}


