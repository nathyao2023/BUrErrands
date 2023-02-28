package com.example.myapplication.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myapplication.R;
import com.example.myapplication.ShoppingCartResponse;

import java.util.List;

public class GoodsAdapter extends BaseQuickAdapter<ShoppingCartResponse.OrderDataBean.CartlistBean, BaseViewHolder> {
    public GoodsAdapter(int layoutResId, @Nullable List<ShoppingCartResponse.OrderDataBean.CartlistBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShoppingCartResponse.OrderDataBean.CartlistBean item) {
        helper.setText(R.id.tv_good_name, item.getProductName())
                .setText(R.id.tv_good_color,item.getCondiment())
                .setText(R.id.tv_good_size,item.getSize())
                .setText(R.id.tv_goods_price,item.getPrice()+"")
                .setText(R.id.tv_goods_num,item.getCount()+"");
        ImageView goodImg = helper.getView(R.id.iv_goods);
        Glide.with(mContext).load(item.getDefaultPic()).into(goodImg);
    }
}
