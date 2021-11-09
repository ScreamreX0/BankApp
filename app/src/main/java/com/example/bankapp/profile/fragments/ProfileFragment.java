package com.example.bankapp.profile.fragments;

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
import com.example.bankapp.profile.adapters.ProfileSettingsAdapter;

public class ProfileFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_settings, container, false);

        ListView listView = view.findViewById(R.id.fragment_profile_lv_main);
        listView.setAdapter(new ProfileSettingsAdapter(getContext(), new Items.SettingItem[] {
                new Items.SettingItem("Изменение пароля"),
                new Items.SettingItem("Изменение логина"),
                new Items.SettingItem("История посещений"),
                new Items.SettingItem("Информация о приложении"),
                new Items.SettingItem("Выход")
        }));

        return view;
    }
}
