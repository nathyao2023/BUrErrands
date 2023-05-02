package com.example.myapplication;


import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myapplication.R;
import com.example.myapplication.Order;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class DeliveryAdapter extends BaseQuickAdapter<Order, BaseViewHolder> {

    public DeliveryAdapter() {
        super(R.layout.item_delivery);
    }


    public void setNewInstance(List<Order> orders) {
        setNewData(orders);
        // 更新适配器的数据源并刷新RecyclerView
    }


    @Override
    protected void convert(BaseViewHolder helper, Order item) {
        helper.setText(R.id.order_id, "Order ID: " + item.getOrderNumber())
                .setText(R.id.order_name, "Order Name: " + item.getOrderName())
                .setText(R.id.start_address, "Start Address: " + item.getStartAddress())
                .setText(R.id.end_address, "End Address: " + item.getEndAddress());

        Button acceptOrderButton = helper.getView(R.id.accept_order_button);
        acceptOrderButton.setOnClickListener(v -> {
            // Perform actions when the accept order button is clicked
            showOrderDetailsDialog(item);
        });
    }

    private void showOrderDetailsDialog(Order item) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        View view = LayoutInflater.from(mContext).inflate(R.layout.delivery_accept_layout, null);
        TextView orderDetailsText = view.findViewById(R.id.delivery_details_text);
        Button closeButton = view.findViewById(R.id.close_button);

        String orderDetails = "Order accepted:\n" +
                "Order ID: " + item.getOrderNumber() + "\n" +
                "Order Name: " + item.getOrderName() + "\n" +
                "Start Address: " + item.getStartAddress() + "\n" +
                "End Address: " + item.getEndAddress();

        orderDetailsText.setText(orderDetails);

        builder.setView(view);
        AlertDialog dialog = builder.create();

        closeButton.setOnClickListener(v -> {
            dialog.dismiss();
        });

        dialog.show();
    }
}




//
//    String toastMessage = "Order accepted:\n" +
//                    "Order ID: " + item.getOrderNumber() + "\n" +
//                    "Order Name: " + item.getOrderName() + "\n" +
//                    "Start Address: " + item.getStartAddress() + "\n" +
//                    "End Address: " + item.getEndAddress();
//            Toast.makeText(mContext, toastMessage, Toast.LENGTH_LONG).show();
//        });
//    }
//}
