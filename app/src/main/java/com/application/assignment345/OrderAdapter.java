package com.application.assignment345;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class OrderAdapter extends ArrayAdapter {

    private List<Order> order;
    private final LayoutInflater layoutInflater;
    private final int layoutResource;


    public OrderAdapter(@NonNull Context context, int resource, List<Order> orders) {
        super(context, resource);
        this.order = orders;
        this.layoutInflater = LayoutInflater.from(context);
        this.layoutResource = resource;
    }

    @Override
    public int getCount() {
        return order.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null)
            v = layoutInflater.inflate(layoutResource, parent, false);
        TextView ordertext = v.findViewById(R.id.orderName1);
        TextView quant = v.findViewById(R.id.quantity1);
        TextView tPrice = v.findViewById(R.id.totalPrice1);

        ordertext.setText(order.get(position).order2);
        quant.setText(String.valueOf(order.get(position).quantity2));
        tPrice.setText(String.valueOf(order.get(position).tPrice2));

        return v;
    }
}