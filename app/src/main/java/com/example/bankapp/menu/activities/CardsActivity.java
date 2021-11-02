package com.example.bankapp.menu.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.bankapp.R;
import com.example.bankapp._pojo.VarsAndConstants;
import com.example.bankapp.menu.adapters.CardAdapter;
import com.example.bankapp.menu.adapters.CardSettingsAdapter;

public class CardsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);


        Init();
    }

    private void Init() {
        // ViewPager2
        CardAdapter cardAdapter = new CardAdapter(VarsAndConstants.cards);
        ViewPager2 viewPager2 = findViewById(R.id.activity_cards_view_pager);

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);

        viewPager2.setAdapter(cardAdapter);


        // ListView settings
        CardSettingsAdapter cardSettingsAdapter = new CardSettingsAdapter(this, new String[]{
                "История операций",
                "Заблокировать",
                "Переименовать"
        });
        ListView listView = findViewById(R.id.activity_cards_list_view);
        listView.setAdapter(cardSettingsAdapter);
    }
}








