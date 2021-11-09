package com.example.bankapp.auth.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bankapp.auth.api.MainActivityApi;
import com.example.bankapp.menu.activities.CardsActivity;
import com.example.bankapp.menu.activities.MenuActivity;
import com.example.bankapp.R;
import com.example.bankapp._pojo.VarsAndConstants;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    String currentDate;
    TextView currentDateText;
    ImageView firstWhiteRectIV;
    ImageView secondWhiteRectIV;
    Button enterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /*// TODO: УБРАТЬ
        Intent intent = new Intent(this, CardsActivity.class);
        startActivity(intent);*/

        // TODO: УБРАТЬ
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        // Получение данных о курсах валют с API
        new MainActivityApi().execute(
                findViewById(R.id.activity_main_tv_rub_usd),
                findViewById(R.id.activity_main_tv_rub_eu),
                "https://www.cbr.ru/scripts/XML_daily.asp?date_req=");
    }

    @SuppressLint("SimpleDateFormat")
    private void init() {
        // Отделения и банкоматы
        firstWhiteRectIV = findViewById(R.id.activity_main_iv_first_white_rect);
        firstWhiteRectIV.setOnClickListener(v -> {
            Intent branches_intent = new Intent(this, BranchesAtmActivity.class);
            startActivity(branches_intent);
        });

        // Курсы валют
        secondWhiteRectIV = findViewById(R.id.activity_main_iv_second_white_rect);
        secondWhiteRectIV.setOnClickListener(v -> {
            Intent exchanges_intent = new Intent(this, ExchangeRatesActivity.class);
            startActivity(exchanges_intent);
        });


        currentDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        currentDateText = findViewById(R.id.activity_main_tv_current_date);
        currentDateText.setText(currentDate);

        // Кнопка Войти
        enterButton = findViewById(R.id.activity_main_btn_enter);
        enterButton.setOnClickListener(v -> {
            ConstraintLayout cl = (ConstraintLayout) getLayoutInflater().inflate(R.layout.dialog_enter, null);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setPositiveButton("Войти", (dialogInterface, i) -> {
                EditText loginET = cl.findViewById(R.id.dialog_enter_et_login);
                EditText pass = cl.findViewById(R.id.dialog_enter_p_password);

                if (loginET != null && pass != null) {
                    if (VarsAndConstants.userLogin.contentEquals(loginET.getText()) &&
                            VarsAndConstants.userPassword.contentEquals(pass.getText())) {
                        Intent menu = new Intent(this, MenuActivity.class);
                        startActivity(menu);
                    } else {
                        Toast.makeText(this, "Неверный логин или пароль", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Неверный формат", Toast.LENGTH_SHORT).show();
                }
            });

            // Кнопка Отмена
            builder.setNegativeButton("Отмена", (dialogInterface, i) -> {
                dialogInterface.dismiss();
            });

            builder.setView(cl);
            builder.show();
        });
    }
}