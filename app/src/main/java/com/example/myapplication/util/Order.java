package com.example.myapplication.util;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Order extends AppCompatActivity {

    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;

    DBcontact database;


    List<OrderInfo> order = new ArrayList<>();
    OrderViewHolder adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        database = database;
        recyclerView = (RecyclerView)findViewById(R.id.listOrders);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
       // loadOrders();
    }


    //private void loadOrders(String userID) {
        //adapter = new Request<Request,OderViewHolder>(
        //        Request.class,
        //        R.layout.order_layout,
        //        OderViewHolder.class,
        //        request.orderByChild("userID")
        //                .equalTo(userID)
        //) {
        //    @Override
        //    protected void populateViewHolder(OderViewHolder viewHolder, Request model, int position) {
         //       viewHolder.txtOrderID.setText(adapter.getRef(position).getKey());
          //      viewHolder.txtItemname.setItemname(adapter);
           //     viewHolder.
            //    viewHolder.txtOrderStatus.setText(Common.convertCodeToStatus(model.getStatus()));
             //   viewHolder.txtCustomerID.setText(Request.getCustomerID());
              //  viewHolder.txtOrderPhone.setText(model.getPhone());
           // }
       // };
        //recyclerView.setAdapter(adapter);

    }
