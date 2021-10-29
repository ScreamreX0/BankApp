package com.example.bankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bankapp.Interfaces.IMenuItem;
import com.example.bankapp.adapters.MenuAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

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
                new CardRow(R.mipmap.ve, "1234 3214 1212 3213", 123.42f),
                new CardRow(R.mipmap.tristan, "4234 1231 4231 4112", 150.00f),
                new CardRow(R.mipmap.vi, "1534 1241 3522 3453", 200.50f),

                new HeaderRow("Мои счета"),
                new BankAccountRow("123456789101112131415", 4235.41f),
                new BankAccountRow("134528476223549867249", 1231.00f),
                new BankAccountRow("296435628743986734893", 41211.00f),
                new BankAccountRow("532984752394752394852", 1432.00f),

                new HeaderRow("Мои кредиты"),
                new CreditRow("26.10.2021", 1233.00f),
                new CreditRow("26.11.2021", 1235.00f),
                new CreditRow("26.12.2021", 1210.00f),
                new CreditRow("26.01.2022", 1543.00f),
        }));
    }

    public static class CardRow implements IMenuItem {
        int image;
        String number;
        float money;
        final int TYPE = 1;

        public CardRow(int image, String number, float money) {
            this.image = image;
            this.number = number;
            this.money = money;
        }

        public int getImage() {
            return image;
        }

        public String getNumber() {
            return number;
        }

        public float getMoney() {
            return money;
        }

        public String getHideNumber() {
            StringBuilder stringBuilder = new StringBuilder();
            String[] splitedNumber = number.split(" ");

            stringBuilder.append(splitedNumber[0]).append("***").append(splitedNumber[3]);

            return String.valueOf(stringBuilder);
        }

        @Override
        public int getViewType() {
            return TYPE;
        }
    }

    public static class BankAccountRow implements IMenuItem {
        String number;
        float money;
        final int TYPE = 2;

        public BankAccountRow(String number, float money) {
            this.number = number;
            this.money = money;
        }

        public String getHideNumber() {
            return "****" + number.substring(14, 20);
        }

        public String getNumber() {
            return number;
        }

        public float getMoney() {
            return money;
        }

        @Override
        public int getViewType() {
            return TYPE;
        }
    }

    public static class CreditRow implements IMenuItem {
        String paymentDate;
        float money;
        final int TYPE = 3;

        public CreditRow(String paymentDate, float money) {
            this.paymentDate = paymentDate;
            this.money = money;
        }

        public String getPaymentDate() {
            return paymentDate;
        }

        public float getMoney() {
            return money;
        }

        @Override
        public int getViewType() {
            return TYPE;
        }
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