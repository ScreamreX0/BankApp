package com.example.bankapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bankapp.apiReaders.MainActivityApi;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {
    String currentDate;
    TextView currentDateText;
    ImageView firstWhiteRectIV;
    ImageView secondWhiteRectIV;
    Button enterButton;

    String login;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        // TODO: DELETE
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);

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
                    if (BankVarsAndConstants.userLogin.contentEquals(loginET.getText()) &&
                            BankVarsAndConstants.userPassword.contentEquals(pass.getText())) {
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