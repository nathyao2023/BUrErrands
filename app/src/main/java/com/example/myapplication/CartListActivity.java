package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.CartListAdapter;
import com.example.myapplication.Helper.ManagementCart;
import com.example.myapplication.Interface.ChangeNumberItemsListener;
import com.example.myapplication.util.OrderHistory;
import com.example.myapplication.util.OrderInfo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CartListActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCart managementCart;
    TextView totalFeeTxt, taxTxt, deliveryTxt, totalTxt, emptyTxt, textViewCheckOutTxt;
    private double tax;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);

        managementCart = new ManagementCart(this);

        initView();
        initList();
        CalculateCart();
//        BottomNavigation();

    }

//    private void BottomNavigation() {
//        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
//        LinearLayout homeBtn = findViewById(R.id.home_Btn);
//
//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(CartListActivity.this, CartListActivity.class));
//            }
//        });
//        homeBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(CartListActivity.this, MainActivity.class));
//            }
//        });
//    }

    private void initView() {
        recyclerViewList = findViewById(R.id.recyclerView);
        totalFeeTxt = findViewById(R.id.totalFeeTxt);
        taxTxt = findViewById(R.id.taxTxt);
        deliveryTxt = findViewById(R.id.deliveryTxt);
        totalTxt = findViewById(R.id.totalTxt);
        emptyTxt = findViewById(R.id.emptyTxt);
        scrollView = findViewById(R.id.scrollView3);
        recyclerViewList = findViewById(R.id.cartView_s);
        textViewCheckOutTxt = findViewById(R.id.textView_check_out);

        textViewCheckOutTxt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 跳转到 OrderInfo Activity，并传递相关数据
                Intent intent = new Intent(CartListActivity.this, OrderActivity.class);
                intent.putExtra("itemTotal", managementCart.getTotalFee());
                intent.putExtra("tax", tax);
                intent.putExtra("delivery", 10.0);
                intent.putExtra("total", managementCart.getTotalFee() + tax + 10.0);
                startActivity(intent);
                // 清空购物车
                managementCart.clear();
                // 重新初始化购物车列表
                initList();
                // 重新计算购物车费用
                CalculateCart();
            }
        });




    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter = new CartListAdapter(managementCart.getListCart(),this,new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                CalculateCart();
            }
        });

        recyclerViewList.setAdapter(adapter);
        if (managementCart.getListCart().isEmpty()) {
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        } else {
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }


    }

    private void
    CalculateCart() {
        double percentTax = 0.02;
        double delivery = 10;

//        保留小数点后两位；keep it to two decimal places

        tax = managementCart.getTotalFee() * percentTax;
        double total = managementCart.getTotalFee() + tax + delivery;
        double itemTotal = managementCart.getTotalFee();
//        格式化结算 Formatted settlement
        totalFeeTxt.setText(String.format("$%.2f", itemTotal));
        taxTxt.setText(String.format("$%.2f", tax));
        deliveryTxt.setText(String.format("$%.2f", delivery));
        totalTxt.setText(String.format("$%.2f", total));

    }
}