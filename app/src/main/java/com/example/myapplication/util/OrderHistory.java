package com.example.myapplication.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class OrderHistory {
    private static final String ORDER_HISTORY_PREF = "order_history_pref";
    private static final String ORDER_HISTORY_KEY = "order_history_key";
    private SharedPreferences sharedPreferences;

    public OrderHistory(Context context) {
        sharedPreferences = context.getSharedPreferences(ORDER_HISTORY_PREF, Context.MODE_PRIVATE);
    }

    public void addOrder(String orderDetails) {
        Set<String> orderSet = getOrderSet();
        orderSet.add(orderDetails);
        saveOrderSet(orderSet);
    }

    public ArrayList<String> getOrderHistory() {
        Set<String> orderSet = getOrderSet();
        return new ArrayList<>(orderSet);
    }

    private Set<String> getOrderSet() {
        return sharedPreferences.getStringSet(ORDER_HISTORY_KEY, new HashSet<>());
    }

    private void saveOrderSet(Set<String> orderSet) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putStringSet(ORDER_HISTORY_KEY, orderSet);
        editor.apply();
    }
}
