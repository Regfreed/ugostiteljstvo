package com.example.narudbe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String ORDERS_TABLE = "ORDERS_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_ORDER = "ORDERS";
    public static final String COLUMN_FOR_THE = "FOR_THE";
    public static final String COLUMN_IS_CHECKED = "IS_CHECKED";

    public DataBaseHelper(@Nullable Context context) {
        super(context,"orders.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableStatement = "CREATE TABLE " + ORDERS_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_ORDER + " TEXT, " + COLUMN_FOR_THE + " TEXT, " + COLUMN_IS_CHECKED + " BOOL)";

        db.execSQL(createTableStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    public boolean addOrder(OrdersModel ordersModel){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        //provjeriti dal se sve dobro uklapa u bazu

        cv.put(COLUMN_ORDER, ordersModel.getOrder());
        cv.put(COLUMN_FOR_THE, ordersModel.getFor_the());
        cv.put(COLUMN_IS_CHECKED, ordersModel.isChecked());

        long insert = db.insert(ORDERS_TABLE, null, cv);
        if(insert == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean deleteOrder(OrdersModel ordersModel){

        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + ORDERS_TABLE + " WHERE " + COLUMN_ID + " = " + ordersModel.getId();

        Cursor cursor = db.rawQuery(queryString, null);
        if(cursor.moveToFirst()){
            return true;
        }else{
            return false;
        }
    }

    public List<OrdersModel> getEverything(){
        List<OrdersModel> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + ORDERS_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()){
            do{
                int orderID = cursor.getInt(0);
                String order = cursor.getString(1);
                String forThe = cursor.getString(2);
                boolean isChecked = cursor.getInt(3) == 1 ? true: false;

                OrdersModel newOrder = new OrdersModel(orderID, order, forThe,isChecked);
                returnList.add(newOrder);

            }while(cursor.moveToNext());
        }else{

        }
        cursor.close();
        db.close();

        return returnList;
    }

}
