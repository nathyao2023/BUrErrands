package com.example.myapplication.util;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.util.ItemClickListener;
import com.example.myapplication.R;

public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView txtOrderID,txtItemname, txtDeliveryID, txtCustomerID, txtIdentity, txtOrderStatus;
    private ItemClickListener itemClickListener;


    public OrderViewHolder(@NonNull View itemView) {
        super(itemView);

        txtOrderID = (TextView) itemView.findViewById(R.id.order_id);
        txtItemname = (TextView) itemView.findViewById(R.id.item_name);
        txtDeliveryID = (TextView) itemView.findViewById(R.id.Delivery_ID);
        txtCustomerID = (TextView) itemView.findViewById(R.id.Customer_ID);
        txtIdentity = (TextView) itemView.findViewById(R.id.Identity);
        txtOrderStatus = (TextView) itemView.findViewById(R.id.order_status);

        itemView.setOnClickListener(this);

    }

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);

    }
}
