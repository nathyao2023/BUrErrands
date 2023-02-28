package com.example.myapplication;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.StoreAdapter;
import com.example.myapplication.util.Constant;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    private RecyclerView rvStore;
    private List<ShoppingCartResponse.OrderDataBean> mList = new ArrayList<>();
    private StoreAdapter storeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        rvStore = findViewById(R.id.rv_store);
        ShoppingCartResponse carResponse = new Gson().fromJson(Constant.CAR_JSON, ShoppingCartResponse.class);

        mList.addAll(carResponse.getOrderData());
        storeAdapter = new StoreAdapter(R.layout.item_store, mList);
        rvStore.setLayoutManager(new LinearLayoutManager(this));
        rvStore.setAdapter(storeAdapter);
    }

}