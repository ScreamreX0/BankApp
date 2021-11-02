package com.example.bankapp._pojo;

import com.example.bankapp.R;

import java.util.ArrayList;

public class VarsAndConstants {
    // VARIABLES AND CONSTANTS
    public static String authKey = null;
    public static String userLogin = "hello";
    public static String userPassword = "world";
    public static String userName = "Руслан";
    public static String userSurname = "Ихсанов";

    public static ArrayList<VarsTemplates.BankCredit> credits = new ArrayList<>();
    public static ArrayList<VarsTemplates.BankCard> cards = new ArrayList<>();
    public static ArrayList<VarsTemplates.BankAccount> accounts = new ArrayList<>();


    // BANK CREDITS
    static {
        VarsAndConstants.credits.add(new VarsTemplates.BankCredit("26.10.2021", 1233.00f));
        VarsAndConstants.credits.add(new VarsTemplates.BankCredit("26.11.2021", 1235.00f));
        VarsAndConstants.credits.add(new VarsTemplates.BankCredit("26.12.2021", 1210.00f));
        VarsAndConstants.credits.add(new VarsTemplates.BankCredit("26.01.2022", 1543.00f));
    }


    // BANK CARDS
    static {
        VarsAndConstants.cards.add(new VarsTemplates.BankCard("Дебетовая карта", R.mipmap.ve, "1234 3214 1212 3213", 123.42f, false));
        VarsAndConstants.cards.add(new VarsTemplates.BankCard("Дебетовая карта", R.mipmap.tristan, "4234 1231 4231 4112", 150.00f, false));
        VarsAndConstants.cards.add(new VarsTemplates.BankCard("Дебетовая карта", R.mipmap.vi, "1534 1241 3522 3453", 200.50f, false));
    }

    public static VarsTemplates.BankCard currentCard = cards.get(0);


    // BANK ACCOUNTS
    static {
        VarsAndConstants.accounts.add(new VarsTemplates.BankAccount("123456789101112131415", 4235.41f));
        VarsAndConstants.accounts.add(new VarsTemplates.BankAccount("134528476223549867249", 1231.00f));
        VarsAndConstants.accounts.add(new VarsTemplates.BankAccount("296435628743986734893", 41211.00f));
        VarsAndConstants.accounts.add(new VarsTemplates.BankAccount("532984752394752394852", 1432.00f));
    }

}