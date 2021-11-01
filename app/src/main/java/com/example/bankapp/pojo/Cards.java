package com.example.bankapp.pojo;

import android.view.View;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bankapp.Interfaces.IMenuItem;
import com.example.bankapp.R;

import java.util.ArrayList;

public class Cards {
    public static ArrayList<BankCard> cards = new ArrayList<>();

    static {
        cards.add(new BankCard("Дебетовая карта", R.mipmap.ve, "1234 3214 1212 3213", 123.42f, false));
        cards.add(new BankCard("Дебетовая карта", R.mipmap.tristan, "4234 1231 4231 4112", 150.00f, false));
        cards.add(new BankCard("Дебетовая карта", R.mipmap.vi, "1534 1241 3522 3453", 200.50f, false));
    }

    public static BankCard currentCard = cards.get(0);

    public static class BankCard implements IMenuItem {
        String name;
        int image;
        String number;
        float money;
        boolean isBlocked;
        final int TYPE = 1;

        public boolean isBlocked() {
            return isBlocked;
        }

        public void setBlocked(boolean blocked) {
            isBlocked = blocked;
        }

        public BankCard(String name, int image, String number, float money, boolean isBlocked) {
            this.name = name;
            this.image = image;
            this.number = number;
            this.money = money;
            this.isBlocked = isBlocked;
        }

        public int getImage() {
            return image;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
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
}