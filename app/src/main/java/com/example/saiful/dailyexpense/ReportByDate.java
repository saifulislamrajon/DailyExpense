package com.example.saiful.dailyexpense;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ReportByDate extends AppCompatActivity implements Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_by_date);
    }

    @Override
    public void dataIncome(Income data) {
        FragmentManager manager = getFragmentManager();
        FragmentShow fShow = (FragmentShow) manager.findFragmentById(R.id.fragment2);
        fShow.showIncomeInformation(data);
    }

    @Override
    public void dataExpense(Expense data) {
        FragmentManager manager = getFragmentManager();
        FragmentShow fShow = (FragmentShow) manager.findFragmentById(R.id.fragment2);
        fShow.showExpenseInformation(data);
    }
}
