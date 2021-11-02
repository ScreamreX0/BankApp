package com.example.bankapp.profile.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bankapp._pojo.Items;
import com.example.bankapp.R;

public class HistoryAdapter extends ArrayAdapter<Items.HistoryItem> {
    Items.HistoryItem[] histories;
    Context context;

    public HistoryAdapter(@NonNull Context context, Items.HistoryItem[] histories) {
        super(context, 0, histories);

        this.context = context;
        this.histories = histories;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("ViewHolder") View row = layoutInflater.inflate(R.layout.item_history, parent, false);

        TextView date = row.findViewById(R.id.row_history_tv_date);
        TextView time = row.findViewById(R.id.row_history_tv_time);

        date.setText(histories[position].getDate());
        time.setText(histories[position].getTime());

        return row;
    }
}








