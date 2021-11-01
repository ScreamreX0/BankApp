package com.example.bankapp.pojo;

import com.example.bankapp.Interfaces.IMenuItem;

import java.util.ArrayList;

public class Credits {
    public static ArrayList<BankCredit> bankCredits = new ArrayList<>();

    static {
        bankCredits.add(new BankCredit("26.10.2021", 1233.00f));
        bankCredits.add(new BankCredit("26.11.2021", 1235.00f));
        bankCredits.add(new BankCredit("26.12.2021", 1210.00f));
        bankCredits.add(new BankCredit("26.01.2022", 1543.00f));
    }

    public static class BankCredit implements IMenuItem {
        String paymentDate;
        float money;
        final int TYPE = 3;

        public BankCredit(String paymentDate, float money) {
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

        public void setPaymentDate(String paymentDate) {
            this.paymentDate = paymentDate;
        }
    }
}
