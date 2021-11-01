package com.example.bankapp.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
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
import com.example.bankapp.pojo.BankVarsAndConstants;
import com.example.bankapp.pojo.Cards;

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
        @SuppressLint("ViewHolder") View view = layoutInflater.inflate(R.layout.row_card_settings, parent, false);

        TextView name = view.findViewById(R.id.row_card_settings_setting);
        name.setText(settings[position]);

        switch (settings[position]) {
            case "История операций":
                break;
            case "Заблокировать":
                view.setOnClickListener(v -> {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    ConstraintLayout cl = (ConstraintLayout) layoutInflater.inflate(R.layout.dialog_card_block, parent, false);

                    builder.setPositiveButton("Заблокировать", (dialogInterface, i) -> {
                        EditText password = cl.findViewById(R.id.dialog_card_block_password);

                        if (!password.getText().toString().equals("")) {
                            Log.wtf("123", "Прошло");
                            if (String.valueOf(BankVarsAndConstants.userPassword).contentEquals(password.getText())) {
                                for (Cards.BankCard card : Cards.cards) {
                                    if (card.getNumber().equals(Cards.currentCard.getNumber())) {
                                        card.setBlocked(true);
                                        dialogInterface.dismiss();
                                        Toast.makeText(context, "Карта заблокирована", Toast.LENGTH_SHORT).show();
                                        break;
                                    }
                                }
                            } else {
                                dialogInterface.cancel();
                                Toast.makeText(context, "Неверный пароль", Toast.LENGTH_SHORT).show();
                            }
                        } else {

                            Toast.makeText(context, "Неверный формат", Toast.LENGTH_SHORT).show();
                        }
                    });

                    builder.setNegativeButton("Отмена", (dialogInterface, i) -> {
                        dialogInterface.dismiss();
                    });

                    builder.setView(R.layout.dialog_card_block);
                    builder.show();
                });
                break;
            case "Переименовать":
                break;
        }

        return view;
    }
}
