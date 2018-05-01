package com.example.saiful.dailyexpense;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class FragmentShow extends Fragment {
    ListView listView;
    CustomizedList customizedList;

    Income income;
    Expense expense;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_show, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    public void showIncomeInformation(Income data) {
        this.income = data;
//        listView = (ListView) getActivity().findViewById(R.id.listView);
//        customizedList = new CustomizedList((View.OnClickListener) getActivity(), data);
//        listView.setAdapter(customizedList);
    }

    public void showExpenseInformation(Expense data) {
        this.expense = data;
    }
}
