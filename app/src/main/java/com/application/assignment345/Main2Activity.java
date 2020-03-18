package com.application.assignment345;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    ArrayList<String> order=new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ListView listView = findViewById(R.id.listView);
        String orderName=getIntent().getStringExtra("order");
        String quantity = getIntent().getStringExtra("quant");
        String price = getIntent().getStringExtra("prices");
        List<Order> orderList = new ArrayList<>();

        Order orderDetail = new Order(orderName,quantity,price);
         orderList.add(orderDetail);

//        for (int i = 1; i <= 20 ; i++) {
//            Order orderDetail = new Order(orderName,quantity,price);
//            orderList.add(orderDetail);
//        }

        OrderAdapter orderAdapter = new OrderAdapter(this, R.layout.order_layout, orderList);
        listView.setAdapter(orderAdapter);


    }
}
