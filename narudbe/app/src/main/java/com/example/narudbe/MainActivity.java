package com.example.narudbe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Button btn_add;
    Button btn_dallyMenu;
    ListView lv_ordersList;
    DataBaseHelper dataBaseHelper;
    ArrayAdapter ordersArrayAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_ordersList = findViewById(R.id.lv_ordersList);
        btn_add = findViewById(R.id.btn_add);
        btn_dallyMenu = findViewById(R.id.btn_dallyMenu);

        dataBaseHelper = new DataBaseHelper(MainActivity.this);

        showOrdersOnListView(dataBaseHelper);

        //dodati funkcionalnost gumba
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, CreateOrder.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        //dodati funkcionalnost gumba
        btn_dallyMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
    private void showOrdersOnListView(DataBaseHelper dataBaseHelper1){
        ordersArrayAdapter = new ArrayAdapter<OrdersModel>(MainActivity.this, android.R.layout.simple_list_item_1, dataBaseHelper1.getEverything());
        lv_ordersList.setAdapter(ordersArrayAdapter);
    }
}