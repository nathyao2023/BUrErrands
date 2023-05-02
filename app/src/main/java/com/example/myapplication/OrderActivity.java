package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Helper.ManagementCart;
import com.example.myapplication.util.MainPageActivity;
import com.example.myapplication.util.OrderHistory;

public class OrderActivity extends AppCompatActivity {
    TextView itemTotal, tax, delivery, total;
    Button placeOrder;
//    private Double itemTotalValue,taxValue,deliveryValue,totalValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        itemTotal = findViewById(R.id.tv_item_total);
        tax = findViewById(R.id.tv_tax);
        delivery = findViewById(R.id.tv_delivery);
        total = findViewById(R.id.tv_total);
        placeOrder = findViewById(R.id.btn_place_order);

        // 获取购物车信息
        double itemTotalValue = getIntent().getDoubleExtra("itemTotal", 0);
        double taxValue = getIntent().getDoubleExtra("tax", 0);
        double deliveryValue = getIntent().getDoubleExtra("delivery", 0);
        double totalValue = getIntent().getDoubleExtra("total", 0);

        // 设置文本
        itemTotal.setText(String.format("$%.2f", itemTotalValue));
        tax.setText(String.format("$%.2f", taxValue));
        delivery.setText(String.format("$%.2f", deliveryValue));
        total.setText(String.format("$%.2f", totalValue));

        // 设置按钮事件
        placeOrder.setOnClickListener(view -> {
            placeOrder(itemTotalValue,taxValue,deliveryValue,totalValue);
        });
    }
    private void placeOrder(Double itemTotalValue,Double taxValue,Double deliveryValue,Double totalValue) {

        ManagementCart managementCart = new ManagementCart(this);
        managementCart.clear();


        Toast.makeText(this, "The order has been completed, thank you for your purchase!", Toast.LENGTH_SHORT).show();


         Intent intent = new Intent(this, MainPageActivity.class);
         startActivity(intent);
        String orderDetails = String.format("Item Total: $%.2f, Tax: $%.2f, Delivery: $%.2f, Total: $%.2f",
                itemTotalValue,taxValue,deliveryValue,totalValue);
        OrderHistory orderHistory = new OrderHistory(this);
        orderHistory.addOrder(orderDetails);
         finish();
    }
}

