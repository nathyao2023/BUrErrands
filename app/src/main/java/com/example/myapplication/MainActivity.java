package com.example.myapplication;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.myapplication.adapter.StoreAdapter;
import com.example.myapplication.util.Constant;
import com.example.myapplication.util.GoodsCallback;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements GoodsCallback {
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
        storeAdapter = new StoreAdapter(R.layout.item_store, mList,this);
        rvStore.setLayoutManager(new LinearLayoutManager(this));
        rvStore.setAdapter(storeAdapter);

        storeAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                ShoppingCartResponse.OrderDataBean storeBean = mList.get(position);
                if(view.getId() == R.id.iv_checked_store){
                    storeBean.setChecked(!storeBean.isChecked());
                    storeAdapter.notifyDataSetChanged();

                    if(storeBean.isChecked()){
                        storeAdapter.controlGoods(storeBean.getShopId(),true);
                    }else{
                        storeAdapter.controlGoods(storeBean.getShopId(),false);
                    }
                }
            }
        });
    }
    @Override
    public void checkedStore(int shopId,boolean state) {
        for (ShoppingCartResponse.OrderDataBean bean : mList) {

            if(shopId == bean.getShopId()){
                bean.setChecked(state);
                storeAdapter.notifyDataSetChanged();
            }
        }
    }

} 