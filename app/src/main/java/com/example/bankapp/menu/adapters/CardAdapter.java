package com.example.bankapp.menu.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bankapp.R;
import com.example.bankapp._pojo.VarsTemplates;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    ArrayList<VarsTemplates.BankCard> cards;

    public CardAdapter(ArrayList<VarsTemplates.BankCard> bankCards) {
        this.cards = bankCards;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView card_number;
        TextView card_name;
        TextView card_money;
        ImageView card_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            card_number = itemView.findViewById(R.id.item_cards_tv_card_number);
            card_name = itemView.findViewById(R.id.item_cards_tv_name);
            card_money = itemView.findViewById(R.id.item_cards_iv_money);
            card_image = itemView.findViewById(R.id.item_cards_iv_card);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_cards_card, parent, false);

        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.card_name.setText(cards.get(position).getName());
        holder.card_number.setText(cards.get(position).getHideNumber());
        holder.card_money.setText(cards.get(position).getMoney() + " рублей");
        holder.card_image.setImageResource(cards.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }
}
