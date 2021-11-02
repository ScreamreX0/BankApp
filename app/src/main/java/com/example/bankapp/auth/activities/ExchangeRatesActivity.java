package com.example.bankapp.auth.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bankapp.R;
import com.example.bankapp._pojo.Items;
import com.example.bankapp.auth.adapters.ExchangeRatesAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExchangeRatesActivity extends AppCompatActivity {
    Items.ExchangeItem[] rowsArr;
    ListView listView;
    TextView currentDateTV;
    Button mainMenuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange_rates);

        init();
    }

    @SuppressLint("SimpleDateFormat")
    private void init() {
        mainMenuBtn = findViewById(R.id.activity_exchange_rates_btn_main_menu);
        currentDateTV = findViewById(R.id.activity_exchange_rates_tv_current_date);

        currentDateTV.setText(new SimpleDateFormat("yyyy.MM.dd").format(new Date()));

        mainMenuBtn.setOnClickListener(v -> {
            Intent mainMenuIntent = new Intent(this, MainActivity.class);
            startActivity(mainMenuIntent);
        });

        rowsArr = new Items.ExchangeItem[] {
                new Items.ExchangeItem(R.mipmap.uk, "UK", "United Kingdom", "100", "96"),
                new Items.ExchangeItem(R.mipmap.at, "AT", "Austria", "50", "46"),
                new Items.ExchangeItem(R.mipmap.ai, "AI", "United Kingdom", "60", "65"),
                new Items.ExchangeItem(R.mipmap.alderney, "AL", "United Kingdom", "123", "125"),
                new Items.ExchangeItem(R.mipmap.am, "UK", "United Kingdom", "321", "332"),
                new Items.ExchangeItem(R.mipmap.aw, "UK", "United Kingdom", "10", "12"),
                new Items.ExchangeItem(R.mipmap.bb, "UK", "United Kingdom", "23", "20"),
                new Items.ExchangeItem(R.mipmap.ck, "UK", "United Kingdom", "141", "140"),
                new Items.ExchangeItem(R.mipmap.gg, "UK", "United Kingdom", "422", "420"),
                new Items.ExchangeItem(R.mipmap.ge, "UK", "United Kingdom", "141", "143"),
                new Items.ExchangeItem(R.mipmap.gt, "UK", "United Kingdom", "345", "347"),
                new Items.ExchangeItem(R.mipmap.hk, "UK", "United Kingdom", "664", "661"),
                new Items.ExchangeItem(R.mipmap.lu, "UK", "United Kingdom", "311", "334"),
                new Items.ExchangeItem(R.mipmap.mf, "UK", "United Kingdom", "411", "412"),
                new Items.ExchangeItem(R.mipmap.me, "UK", "United Kingdom", "321", "412"),
                new Items.ExchangeItem(R.mipmap.mq, "UK", "United Kingdom", "102", "110"),
                new Items.ExchangeItem(R.mipmap.mp, "UK", "United Kingdom", "122", "130"),
        };

        listView = findViewById(R.id.activity_exchange_rates_lv_list);
        ExchangeRatesAdapter exchangeRatesAdapter = new ExchangeRatesAdapter(this, rowsArr);
        listView.setAdapter(exchangeRatesAdapter);
    }

}