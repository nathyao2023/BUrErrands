package com.example.myapplication.util;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class OrderHistory extends AppCompatActivity {

    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;

    public OrderListAdapter adapter;
    //private Button BackButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        //BackButton = findViewById(R.id.back);
        //setClickListener();

        recyclerView = findViewById(R.id.listOrder);
        adapter = new OrderListAdapter();
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        List<OrderInfo> orderhistory = new ArrayList<>();
        orderhistory.add(new OrderInfo("#202301", "Fried Rice", "U12345678", "U87654321","UNCOMPLETED"));
        orderhistory.add(new OrderInfo("#202302", "Hot Brewed Coffee","U12345678", "U13456789", "COMPLETED"));
        orderhistory.add(new OrderInfo("#202303","Dragon Roll","U12345678","U87654321","COMPLETED"));
        orderhistory.add(new OrderInfo("#202303","The Poke, Dragon Roll","U12345678","U87654321","COMPLETED"));
        orderhistory.add(new OrderInfo("#202303","Napoleones","U12345678","U87654321","COMPLETED"));
        orderhistory.add(new OrderInfo("#202303","The Poke","U12345678","U87654321","COMPLETED"));
        orderhistory.add(new OrderInfo("#202303","Hot Brewed Coffee, Napoleones","U12345678","U87654321","COMPLETED"));


        adapter.setInstance(orderhistory);
        // loadOrders();

    }

    /*
    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()){
                case R.id.back:
                    intent = new Intent(OrderHistory.this, MainPageActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }

    private void setClickListener(){
        OnClick onClick = new OnClick();
        BackButton.setOnClickListener(onClick);
    }

     */


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