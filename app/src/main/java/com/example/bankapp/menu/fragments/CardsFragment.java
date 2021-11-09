package com.example.bankapp.menu.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bankapp.R;
import com.example.bankapp._pojo.Items;
import com.example.bankapp._pojo.VarsAndConstants;
import com.example.bankapp.menu.adapters.MenuAdapter;

import kotlin.Suppress;

public class CardsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_cards, container, false);

        ListView listView = view.findViewById(R.id.fragment_menu_lv_main);
        listView.setAdapter(new MenuAdapter(getContext(), new Items.IMenuItem[]{
                new Items.HeaderItem("Мои карты"),
                VarsAndConstants.cards.get(0),
                VarsAndConstants.cards.get(1),
                VarsAndConstants.cards.get(2),

                new Items.HeaderItem("Мои счета"),
                VarsAndConstants.accounts.get(0),
                VarsAndConstants.accounts.get(1),
                VarsAndConstants.accounts.get(2),
                VarsAndConstants.accounts.get(3),

                new Items.HeaderItem("Мои кредиты"),
                VarsAndConstants.credits.get(0),
                VarsAndConstants.credits.get(1),
                VarsAndConstants.credits.get(2),
                VarsAndConstants.credits.get(3)
        }));

        return view;
    }
}
