package com.example.bankapp._pojo;

public class Items {

    public static class AtmItem {
        String address;
        String type;
        int startHour;
        int startMinute;
        int endHour;
        int endMinute;

        public AtmItem(String address, String type, int startHour, int startMinute, int endHour, int endMinute) {
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

    public static class ExchangeItem {
        int flag;
        String shortExchName;
        String ExchName;
        String buyPrice;
        String sellPrice;

        public ExchangeItem(int flag, String shortExchName, String exchName, String buyPrice, String sellPrice) {
            this.flag = flag;
            this.shortExchName = shortExchName;
            this.ExchName = exchName;
            this.buyPrice = buyPrice;
            this.sellPrice = sellPrice;
        }

        public int getFlag() {
            return flag;
        }

        public String getShortExchName() {
            return shortExchName;
        }

        public String getExchName() {
            return ExchName;
        }

        public String getBuyPrice() {
            return buyPrice;
        }

        public String getSellPrice() {
            return sellPrice;
        }
    }

    public interface IMenuItem {
        int getViewType();
    }

    static public class HistoryItem {
        String date;
        String time;

        public String getDate() {
            return date;
        }

        public String getTime() {
            return time;
        }

        public HistoryItem(String date, String time) {
            this.date = date;
            this.time = time;
        }
    }

    public static class HeaderItem implements IMenuItem {
        String name;
        final int TYPE = 0;

        public HeaderItem(String name) {
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

    public static class SettingItem {
        String name;

        public SettingItem(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
