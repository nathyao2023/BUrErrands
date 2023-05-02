package com.example.myapplication.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryAdapter.OrderHistoryViewHolder> {
    private ArrayList<String> orderHistory;
    private LayoutInflater inflater;

    public OrderHistoryAdapter(Context context, ArrayList<String> orderHistory) {
        this.orderHistory = orderHistory;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public OrderHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        return new OrderHistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHistoryViewHolder holder, int position) {
        String order = orderHistory.get(position);
        holder.orderTextView.setText(order);
    }

    @Override
    public int getItemCount() {
        return orderHistory.size();
    }

    class OrderHistoryViewHolder extends RecyclerView.ViewHolder {
        TextView orderTextView;

        public OrderHistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            orderTextView = itemView.findViewById(android.R.id.text1);
        }
    }
}

