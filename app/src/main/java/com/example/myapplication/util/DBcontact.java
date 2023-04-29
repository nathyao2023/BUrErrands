package com.example.myapplication.util;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBcontact extends SQLiteOpenHelper{
    private static final int VERSION = 1;
    private static final String DBNAME = "BUrErrands.db";
    private Context context;

    public DBcontact(Context context){
        super(context, DBNAME,null,VERSION);
        context = context;
    }


    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table order_tb (OrderID varchar(20) primary key autoincrement,ItemName varchar(30),DeliveryID varchar(20),CustomerID varchar(20),Identity char,OrderStatus char,UserID varchar(20))");

    }

    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion){
        db.execSQL("drop table if exists order_tb");
        onCreate(db);
    }

    public void insertOrder(String OrderID,String ItemNname, String DeliveryID, String CustomerID, String Identity,String OrderStatus, String UserID){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("OrderID",OrderID);
        values.put("ItemName",ItemNname);
        values.put("DeliveryID",DeliveryID);
        values.put("CustomerID",CustomerID);
        values.put("Identity",Identity);
        values.put("OrderStatus",OrderStatus);
        values.put("UserID",UserID);

        db.insert("order_tb",null,values);
        db.close();
    }
    public String getOrder(){
        String query = "SELECT * FROM order_tb";
        String result = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =db.rawQuery(query,null);

        cursor.moveToFirst();
        while(cursor.isAfterLast() == false){
            result += cursor.getString(0)+" "+cursor.getString(1)+"\n";
            cursor.moveToNext();
        }
        db.close();
        return result;
    }

}
