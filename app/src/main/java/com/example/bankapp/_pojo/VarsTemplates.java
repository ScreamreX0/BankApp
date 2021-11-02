package com.example.bankapp._pojo;

public class VarsTemplates {
    public static class BankAccount implements Items.IMenuItem {
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

    public static class BankCredit implements Items.IMenuItem {
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

    public static class BankCard implements Items.IMenuItem {
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
