package com.example.myapplication.util;

public class OrderInfo {
    private String OrderID;
    private String Itemname;
    private String DeliveryID;
    private String CustomerID;
    private String Identity;
    private String order_status;

    public OrderInfo(){
    }

    public OrderInfo(String OrderID, String Itemname, String DeliveryID, String CustomerID, String Identity, String order_status){
        OrderID = OrderID;
        Itemname = Itemname;
        DeliveryID = DeliveryID;
        CustomerID = CustomerID;
        Identity = Identity;
        order_status = order_status;
    }

    public String getOrderID(){
        return OrderID;
    }
    public void setOrderID(){
        OrderID = OrderID;
    }

    public String getitemname(){
        return Itemname;
    }
    public void setItemname(String itemname){
        itemname = itemname;
    }
    public String getDeliveryID(){

        return DeliveryID;
    }
    public void setDeliveryID(String DeliveryID){
        DeliveryID = DeliveryID;
    }
    public String getCustomerID(){
        return CustomerID;
    }
    public void setCustomerId(String CustomerID){

        CustomerID = CustomerID;
    }
    public String getIdentity(){

        return Identity;
    }
    public void setIdentity(String Identity){

        Identity = Identity;
    }
    public String getOrder_status(){

        return order_status;
    }
    public void setOrder_status(String order_status){
        order_status = order_status;
    }

}
