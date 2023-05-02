package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.util.OrderHistory;
import com.example.myapplication.util.OrderHistoryAdapter;

import java.util.ArrayList;

public class OrderHistoryActivity extends AppCompatActivity {

    private RecyclerView rvOrderHistory;
    private OrderHistoryAdapter orderHistoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);

        rvOrderHistory = findViewById(R.id.rv_order_history);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvOrderHistory.setLayoutManager(layoutManager);

        OrderHistory orderHistory = new OrderHistory(this);
        ArrayList<String> orderHistoryList = orderHistory.getOrderHistory();

        orderHistoryAdapter = new OrderHistoryAdapter(this, orderHistoryList);
        rvOrderHistory.setAdapter(orderHistoryAdapter);
    }
}

