package com.example.myapplication;

//订单数据
public class Order {
    private int orderNumber;
    private String orderName;    //可以是餐厅的名称，或者描述
    private String startAddress;
    private String endAddress;

    // Generate constructor and getter/setter methods
    public Order(int orderNumber, String orderName, String startAddress, String endAddress) {
        this.orderNumber = orderNumber;
        this.orderName = orderName;
        this.startAddress = startAddress;
        this.endAddress = endAddress;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getOrderName() {
        return orderName;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public String getEndAddress() {
        return endAddress;
    }



}
