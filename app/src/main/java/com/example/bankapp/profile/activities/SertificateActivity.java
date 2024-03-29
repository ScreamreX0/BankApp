package com.example.bankapp.profile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.example.bankapp.R;
import com.example.bankapp._pojo.VarsAndConstants;

public class SertificateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sertificate);

        Init();
    }

    @SuppressLint("SetTextI18n")
    private void Init() {
        // Sertificate
        TextView sertificate = findViewById(R.id.activity_sertificate_link);
        sertificate.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.avangard.ru/rus/docs/rules_cart_use_in_system_mobile_pays.pdf");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
    }
}