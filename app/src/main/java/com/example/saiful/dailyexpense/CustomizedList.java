package com.example.saiful.dailyexpense;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CustomizedList extends BaseAdapter {
    Context context;
    //ArrayList<Income> income;
    Vector vector;
    //    Income income;
//    Expense expense;
    LayoutInflater inflater = null;

    public CustomizedList(Context context, Vector vector) {
        this.context = context;
        this.vector = vector;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return vector.size();
    }

    @Override
    public Object getItem(int position) {
        return vector.elementAt(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        view = inflater.inflate(R.layout.single_row, null);

        ///customList is the inflated view
        /// components in inflated view

        TextView txt6 = (TextView) view.findViewById(R.id.txvDate);
        TextView txt8 = (TextView) view.findViewById(R.id.txvAmount);
        TextView txt10 = (TextView) view.findViewById(R.id.txvDescription);

        final DataTransfer dt = (DataTransfer) vector.elementAt(position);
        txt6.setText(dt.getDate());
        txt8.setText(dt.getAmount());
        txt10.setText(dt.getDescription());

        //Toast.makeText(context, "amount: "+dt.getAmount(), Toast.LENGTH_SHORT).show();

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Working", Toast.LENGTH_LONG).show();
                //updateAlbum();
            }
        });

        return view;


    }
}
