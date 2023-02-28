package com.example.myapplication.adapter;


import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myapplication.R;
import com.example.myapplication.ShoppingCartResponse;

import java.util.List;

public class StoreAdapter extends BaseQuickAdapter<ShoppingCartResponse.OrderDataBean, BaseViewHolder> {

    private RecyclerView rvGood;
    public StoreAdapter(int layoutResId, @Nullable List<ShoppingCartResponse.OrderDataBean> data) {
        super(layoutResId, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, ShoppingCartResponse.OrderDataBean item) {
        rvGood = helper.getView(R.id.rv_goods);
        helper.setText(R.id.tv_store_name,item.getShopName());

        final GoodsAdapter goodsAdapter = new GoodsAdapter(R.layout.item_good,item.getCartlist());
        rvGood.setLayoutManager(new LinearLayoutManager(mContext));
        rvGood.setAdapter(goodsAdapter);
    }


}
