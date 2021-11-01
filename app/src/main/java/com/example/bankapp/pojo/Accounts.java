package com.example.bankapp.pojo;

import com.example.bankapp.Interfaces.IMenuItem;

import java.util.ArrayList;

public class Accounts {
    public static ArrayList<BankAccount> bankAccounts = new ArrayList<>();
    static {
        bankAccounts.add(new BankAccount("123456789101112131415", 4235.41f));
        bankAccounts.add(new BankAccount("134528476223549867249", 1231.00f));
        bankAccounts.add(new BankAccount("296435628743986734893", 41211.00f));
        bankAccounts.add(new BankAccount("532984752394752394852", 1432.00f));
    }


    public static class BankAccount implements IMenuItem {
        String number;
        float money;
        final int TYPE = 2;

        public BankAccount(String number, float money) {
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

        public void setNumber(String number) {
            this.number = number;
        }
    }
}
