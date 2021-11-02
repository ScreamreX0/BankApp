package com.example.bankapp.menu.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bankapp.R;
import com.example.bankapp._pojo.Items;
import com.example.bankapp._pojo.VarsTemplates;

public class MenuAdapter extends ArrayAdapter<Items.IMenuItem> {
    Context context;
    Items.IMenuItem[] items;

    public static final int CARD = 1;
    public static final int BANK_ACCOUNT = 2;
    public static final int CREDIT = 3;
    public static final int HEADER = 0;

    public MenuAdapter(@NonNull Context context, Items.IMenuItem[] items) {
        super(context, 0, items);

        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    @SuppressLint({"ViewHolder", "SetTextI18n"})
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row;

        if (items[position].getViewType() == CARD) {
            row = layoutInflater.inflate(R.layout.item_menu_card, parent, false);

            VarsTemplates.BankCard item = ((VarsTemplates.BankCard) items[position]);

            // НОМЕР КАРТЫ
            ((TextView) row.findViewById(R.id.row_menu_card_tv_card_number)).setText(item.getHideNumber());

            // ДЕНЬГИ НА КАРТЕ
            ((TextView) row.findViewById(R.id.row_menu_card_tv_money)).setText(item.getMoney() + " рублей");

            // ИКОНКА КАРТЫ
            ((ImageView) row.findViewById(R.id.row_menu_card_iv_card)).setImageResource(item.getImage());

        } else if (items[position].getViewType() == BANK_ACCOUNT) {
            row = layoutInflater.inflate(R.layout.item_menu_bank_account, parent, false);

            VarsTemplates.BankAccount item = ((VarsTemplates.BankAccount) items[position]);

            // НОМЕР СЧЕТА
            ((TextView) row.findViewById(R.id.row_menu_bank_account_tv_current_account)).setText(item.getHideNumber());

            // ДЕНЬГИ НА СЧЕТУ
            ((TextView) row.findViewById(R.id.row_menu_bank_account_tv_money)).setText(item.getMoney() + " рублей");

        } else if (items[position].getViewType() == CREDIT) {
            row = layoutInflater.inflate(R.layout.item_menu_credit, parent, false);

            VarsTemplates.BankCredit item = ((VarsTemplates.BankCredit) items[position]);

            // ДАТА ПЛАТЫ
            ((TextView) row.findViewById(R.id.row_menu_credit_tv_date)).setText(item.getPaymentDate());

            // КОЛ-ВО ДЕНЕГ
            ((TextView) row.findViewById(R.id.row_menu_credit_tv_money)).setText(item.getMoney() + " рублей");
        } else {
            row = layoutInflater.inflate(R.layout.item_menu_header, parent, false);

            Items.HeaderItem item = ((Items.HeaderItem) items[position]);

            // Заголовок
            ((TextView) row.findViewById(R.id.row_menu_header_tv_name)).setText(item.getName());
        }

        return row;
    }
}
