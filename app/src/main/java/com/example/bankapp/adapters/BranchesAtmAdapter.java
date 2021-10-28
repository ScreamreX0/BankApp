package com.example.bankapp.adapters;

import static com.example.bankapp.BranchesAtmActivity.addZero;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bankapp.BranchesAtmActivity;
import com.example.bankapp.R;

public class BranchesAtmAdapter extends ArrayAdapter<BranchesAtmActivity.AtmRow> {
    Context context;
    BranchesAtmActivity.AtmRow[] atmRows;

    public BranchesAtmAdapter(Context context, BranchesAtmActivity.AtmRow[] atmRows) {
        super(context, R.layout.activity_branches_atm, atmRows);
        this.context = context;
        this.atmRows = atmRows;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("ViewHolder") View row = layoutInflater.inflate(R.layout.row_branches, parent, false);

        // Init
        TextView address = row.findViewById(R.id.row_branches_tv_address);
        TextView type = row.findViewById(R.id.row_branches_tv_type);
        TextView works = row.findViewById(R.id.row_branches_tv_atm);
        TextView time = row.findViewById(R.id.row_branches_tv_time);

        address.setText(atmRows[position].getAddress());
        type.setText(atmRows[position].getType());

        if (BranchesAtmActivity.isWork(atmRows[position].getStartHour(), atmRows[position].getStartMinute(),
                atmRows[position].getEndHour(), atmRows[position].getEndMinute())) {
            works.setText("Открыто");
            works.setTextColor(Color.GREEN);
        } else {
            works.setText("Закрыто");
            works.setTextColor(Color.RED);
        }

        time.setText(String.format("Часы работы %s:%s-%s:%s",
                addZero(atmRows[position].getStartHour()),
                addZero(atmRows[position].getStartMinute()),
                addZero(atmRows[position].getEndHour()),
                addZero(atmRows[position].getEndMinute()))
        );
        return row;
    }

}
