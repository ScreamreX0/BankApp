package com.example.bankapp.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bankapp.HistoryActivity;
import com.example.bankapp.R;

public class HistoryAdapter extends ArrayAdapter<HistoryActivity.History> {
    HistoryActivity.History[] histories;
    Context context;

    public HistoryAdapter(@NonNull Context context, HistoryActivity.History[] histories) {
        super(context, 0, histories);

        this.context = context;
        this.histories = histories;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("ViewHolder") View row = layoutInflater.inflate(R.layout.row_history, parent, false);

        TextView date = row.findViewById(R.id.row_history_tv_date);
        TextView time = row.findViewById(R.id.row_history_tv_time);

        date.setText(histories[position].getDate());
        time.setText(histories[position].getTime());

        return row;
    }
}








