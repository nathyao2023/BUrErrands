package com.example.myapplication.adapter;


import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myapplication.R;
import com.example.myapplication.ShoppingCartResponse;
import com.example.myapplication.util.GoodsCallback;

import java.util.List;

public class StoreAdapter extends BaseQuickAdapter<ShoppingCartResponse.OrderDataBean, BaseViewHolder> {

    private RecyclerView rvGood;
    private GoodsCallback goodsCallback;

    private List<ShoppingCartResponse.OrderDataBean> storeBean;

    public StoreAdapter(int layoutResId, @Nullable List<ShoppingCartResponse.OrderDataBean> data, GoodsCallback goodsCallback) {
        super(layoutResId, data);
        this.goodsCallback = goodsCallback;
        storeBean = data;
    }
    private void controlStore(ShoppingCartResponse.OrderDataBean item) {
        int num = 0;
        for (ShoppingCartResponse.OrderDataBean.CartlistBean bean : item.getCartlist()) {
            if (bean.isChecked()) {
                ++num;
            }
        }
        if (num == item.getCartlist().size()) {
            goodsCallback.checkedStore(item.getShopId(),true);
        } else {
            goodsCallback.checkedStore(item.getShopId(),false);
        }
    }
    public void controlGoods(int shopId, boolean state) {
        for (ShoppingCartResponse.OrderDataBean orderDataBean : storeBean) {
            if (orderDataBean.getShopId() == shopId) {
                for (ShoppingCartResponse.OrderDataBean.CartlistBean cartlistBean : orderDataBean.getCartlist()) {
                    cartlistBean.setChecked(state);
                    notifyDataSetChanged();
                }
            }
        }
    }
    @Override
    protected void convert(BaseViewHolder helper, ShoppingCartResponse.OrderDataBean item) {
        rvGood = helper.getView(R.id.rv_goods);
        helper.setText(R.id.tv_store_name,item.getShopName());

        ImageView checkedStore = helper.getView(R.id.iv_checked_store);
        if (item.isChecked()) {
            checkedStore.setImageDrawable(mContext.getDrawable(R.drawable.ic_checked));
        } else {
            checkedStore.setImageDrawable(mContext.getDrawable(R.drawable.ic_check));
        }

        helper.addOnClickListener(R.id.iv_checked_store);
        final GoodsAdapter goodsAdapter = new GoodsAdapter(R.layout.item_good,item.getCartlist());
        rvGood.setLayoutManager(new LinearLayoutManager(mContext));
        rvGood.setAdapter(goodsAdapter);

        goodsAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                ShoppingCartResponse.OrderDataBean.CartlistBean goodsBean = item.getCartlist().get(position);

                switch (view.getId()) {
                    case R.id.iv_checked_goods:

                        goodsBean.setChecked(!goodsBean.isChecked());

                        goodsAdapter.notifyDataSetChanged();
                        controlStore(item);
                        break;
                    case R.id.tv_increase_goods_num:

                        break;
                    case R.id.tv_reduce_goods_num:

                        break;
                    default:
                        break;
                }
            }
        });
    }

}
