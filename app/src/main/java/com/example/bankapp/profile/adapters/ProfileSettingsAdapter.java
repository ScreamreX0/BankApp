package com.example.bankapp.profile.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.bankapp._pojo.VarsAndConstants;
import com.example.bankapp._pojo.Items;
import com.example.bankapp.menu.activities.HistoryActivity;
import com.example.bankapp.auth.activities.MainActivity;
import com.example.bankapp.R;
import com.example.bankapp.profile.activities.SertificateActivity;

public class ProfileSettingsAdapter extends ArrayAdapter<Items.SettingItem> {
    Context context;
    Items.SettingItem[] settingRow;

    public ProfileSettingsAdapter(@NonNull Context context, Items.SettingItem[] settingRow) {
        super(context, 0, settingRow);
        this.context = context;
        this.settingRow = settingRow;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("ViewHolder") View view = layoutInflater.inflate(R.layout.item_profile_settings, parent, false);

        // Click listener
        switch (settingRow[position].getName()) {
            case "Изменение пароля":
                view.setOnClickListener(v -> {
                    ConstraintLayout cl = (ConstraintLayout) layoutInflater.inflate(R.layout.dialog_change_password, parent, false);
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);

                    builder.setNegativeButton("Отмена", ((dialogInterface, i) -> {
                        dialogInterface.dismiss();
                    }));

                    builder.setPositiveButton("Изменить", ((dialogInterface, i) -> {
                        EditText editText = cl.findViewById(R.id.dialog_change_password_et_new_password);
                        if (!editText.getText().toString().equals("")) {
                            VarsAndConstants.userPassword = editText.getText().toString();
                            Toast.makeText(context, "Пароль успешно изменен", Toast.LENGTH_SHORT).show();
                        } else {
                            dialogInterface.cancel();
                            Toast.makeText(context, "Неверный формат", Toast.LENGTH_SHORT).show();
                        }
                    }));

                    builder.setView(cl);
                    builder.show();
                });
                break;
            case "Изменение логина":
                view.setOnClickListener(v -> {
                    ConstraintLayout cl = (ConstraintLayout) layoutInflater.inflate(R.layout.dialog_change_login, parent, false);

                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setNegativeButton("Отмена", ((dialogInterface, i) -> {
                        dialogInterface.dismiss();
                    }));

                    builder.setPositiveButton("Изменить", ((dialogInterface, i) -> {
                        EditText editText = cl.findViewById(R.id.dialog_change_login_et_new_login);
                        if (!editText.getText().toString().equals("")) {
                            VarsAndConstants.userLogin = editText.getText().toString();
                            Toast.makeText(context, "Логин успешно изменен", Toast.LENGTH_SHORT).show();
                        } else {
                            dialogInterface.cancel();
                            Toast.makeText(context, "Неверный формат", Toast.LENGTH_SHORT).show();
                        }
                    }));

                    builder.setView(cl);
                    builder.show();
                });
                break;
            case "История посещений":
                view.setOnClickListener(v -> {
                    Intent intent = new Intent(context, HistoryActivity.class);
                    context.startActivity(intent);
                });
                break;
            case "Информация о приложении":
                view.setOnClickListener(v -> {
                    Intent intent = new Intent(context, SertificateActivity.class);
                    context.startActivity(intent);
                });
                break;
            case "Выход":
                view.setOnClickListener(v -> {
                    Intent intent = new Intent(context, MainActivity.class);
                    context.startActivity(intent);
                });
                break;
        }

        // Set text
        TextView full_name = view.findViewById(R.id.row_profile_name);
        full_name.setText(settingRow[position].getName());

        return view;
    }
}