package com.example.bankapp.auth.adapters;

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

public class ExchangeRatesAdapter extends ArrayAdapter<Items.ExchangeItem> {
    Context context;
    Items.ExchangeItem[] rowArr;

    public ExchangeRatesAdapter(Context context, Items.ExchangeItem[] rowArr) {
        super(context, R.layout.item_exchanges, rowArr);
        this.context = context;
        this.rowArr = rowArr;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("ViewHolder") View row = layoutInflater.inflate(R.layout.item_exchanges, parent, false);

        // Init
        ImageView flagIV = row.findViewById(R.id.row_exchanges_iv_flag);
        TextView shortExchName = row.findViewById(R.id.row_exchanges_tv_short_exch_name);
        TextView exchName = row.findViewById(R.id.row_exchanges_tv_exch_name);
        TextView buyPrice = row.findViewById(R.id.row_exchanges_tv_buy_price);
        TextView sellPrice = row.findViewById(R.id.row_exchanges_tv_sell_price);

        flagIV.setImageResource(rowArr[position].getFlag());
        shortExchName.setText(rowArr[position].getShortExchName());
        exchName.setText(rowArr[position].getExchName());
        buyPrice.setText(rowArr[position].getBuyPrice());
        sellPrice.setText(rowArr[position].getSellPrice());
        return row;
    }
}
