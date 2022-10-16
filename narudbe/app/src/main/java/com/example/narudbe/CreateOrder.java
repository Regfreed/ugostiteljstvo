package com.example.narudbe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

//klasa za stvaranje ordera, treba sada dodati funkcionalnosti za elemente na layoutu
//dodati dodavanje novih elemenata na izgled iz klase
public class CreateOrder extends AppCompatActivity {

    Button btn_addMore,btn_cancel, btn_ok;
    EditText et_food;
    TextView tv_times2;
    Button btn_less, btn_more;
    int j = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);

        btn_addMore = findViewById(R.id.btn_addMore);
        btn_cancel = findViewById(R.id.btn_cancel);
        btn_ok = findViewById(R.id.btn_ok);
        btn_less = findViewById(R.id.btn_less);
        btn_more = findViewById(R.id.btn_more);
        et_food = findViewById(R.id.et_food);
        tv_times2 = findViewById(R.id.tv_times2);


        //napraviti da se pomoću klika doda jos jedan upis za neko novo jelo
        btn_addMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearLayout);
                LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                ConstraintLayout constraintLayout = (ConstraintLayout)inflater.inflate(R.layout.adding_orders,null);
                Button btn_more_new = (Button)constraintLayout.getViewById(R.id.btn_more);
                Button btn_less_new = (Button)constraintLayout.getViewById(R.id.btn_less);
                btn_more_new.setTag(""+j);
                btn_less_new.setTag(""+j);
                EditText et_food_new = (EditText) constraintLayout.getViewById(R.id.et_food);
                TextView tv_times_new = (TextView) constraintLayout.getViewById(R.id.tv_times2);
                et_food_new.setTag(""+j);
                tv_times_new.setTag(""+j);

                linearLayout.addView(constraintLayout,1);
                j++;

            }
        });

        //napraviti da se poništi upis narudbe i vrati na prijašnji screen
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CreateOrder.this, MainActivity.class);
                CreateOrder.this.startActivity(myIntent);

            }
        });
        //napraviti da se narudba potvrdi i da se spremi u bazu podataka
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //napraviti da se poveća jelo za 1
        btn_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = Integer.parseInt(tv_times2.getText().toString())+1;

                tv_times2.setText(""+i);

            }
        });

        //napraviti da se jelo smanji za 1
        btn_less.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = Integer.parseInt(tv_times2.getText().toString())-1;
                tv_times2.setText(""+i);

            }
        });


    }
    public void more (View view){
        int i = Integer.parseInt(tv_times2.getText().toString())+1;
        tv_times2.setText(""+i);
    }

    public void less (View view){
        int i = Integer.parseInt(tv_times2.getText().toString())-1;
        tv_times2.setText(""+i);
    }
}