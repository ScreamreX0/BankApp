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

import com.example.bankapp.BankVarsAndConstants;
import com.example.bankapp.ProfileActivity;
import com.example.bankapp.R;

public class ProfileSettingsAdapter extends ArrayAdapter<ProfileActivity.settingRow> {
    Context context;
    ProfileActivity.settingRow[] settingRow;

    public ProfileSettingsAdapter(@NonNull Context context, ProfileActivity.settingRow[] settingRow) {
        super(context, R.layout.row_profile_settings);

        this.context = context;
        this.settingRow = settingRow;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("ViewHolder") View row = layoutInflater.inflate(R.layout.row_profile_settings, parent, false);

        TextView full_name = row.findViewById(R.id.row_profile_name);
        full_name.setText(settingRow[position].getName());

        return row;
    }
}