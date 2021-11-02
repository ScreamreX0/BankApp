package com.example.bankapp.menu.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
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

import com.example.bankapp.R;
import com.example.bankapp._pojo.VarsAndConstants;
import com.example.bankapp._pojo.VarsTemplates;

public class CardSettingsAdapter extends ArrayAdapter<String> {
    Context context;
    String[] settings;

    public CardSettingsAdapter(@NonNull Context context, @NonNull String[] settings) {
        super(context, 0, settings);
        this.context = context;
        this.settings = settings;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("ViewHolder") View view = layoutInflater.inflate(R.layout.item_card_settings, parent, false);

        TextView name = view.findViewById(R.id.row_card_settings_setting);
        name.setText(settings[position]);



        switch (settings[position]) {
            case "История операций":
                break;
            case "Заблокировать":
                view.setOnClickListener(v -> {
                    ConstraintLayout cl = (ConstraintLayout) layoutInflater.inflate(R.layout.dialog_card_block, parent, false);
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);

                    builder.setPositiveButton("Отмена", (dialogInterface, i) -> {
                        dialogInterface.dismiss();
                    });

                    builder.setNegativeButton("Заблокировать", (dialogInterface, i) -> {
                        EditText password = cl.findViewById(R.id.dialog_card_block_password);

                        if (!password.getText().toString().equals("")) {
                            if (VarsAndConstants.userPassword.equals(password.getText().toString())) {
                                for (VarsTemplates.BankCard card : VarsAndConstants.cards) {
                                    if (card.getNumber().equals(VarsAndConstants.currentCard.getNumber())) {
                                        card.setBlocked(true);
                                        dialogInterface.dismiss();
                                        Toast.makeText(context, "Карта заблокирована", Toast.LENGTH_SHORT).show();
                                        Log.d("CardSettingsAdapter", "Карта заблокирована");
                                        break;
                                    }
                                }
                            } else {
                                Toast.makeText(context, "Неверный пароль", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(context, "Неверный формат", Toast.LENGTH_SHORT).show();
                        }
                    });

                    builder.setView(cl);
                    builder.show();
                });
                break;
            case "Переименовать":
                break;
        }

        return view;
    }
}
