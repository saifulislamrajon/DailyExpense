package com.example.saiful.dailyexpense;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class FragmentInput extends Fragment {
    EditText inputDate;
    Button btnShow;
    DatabaseHelper databaseHelper;
    Communicator communicator;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_input, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        databaseHelper = new DatabaseHelper(getActivity());
        communicator = (Communicator) getActivity();
        inputDate = (EditText) getActivity().findViewById(R.id.inputDate);
        btnShow = (Button) getActivity().findViewById(R.id.btnShow);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String keyword = inputDate.getText().toString();
//                Toast.makeText(getActivity(),keyword,Toast.LENGTH_SHORT).show();
                ArrayList<Income> incomes = databaseHelper.searchIncome(keyword);
                ArrayList<Expense> expenses = databaseHelper.searchExpense(keyword);
                if (incomes != null && incomes.size() > 0) {
                    for (Income income : incomes) {
                        communicator.dataIncome(income);
//                        Toast.makeText(getActivity(), income.toString(), Toast.LENGTH_LONG).show();
                    }
                }
                if (expenses != null && expenses.size() > 0) {
                    for (Expense expense : expenses) {
                        communicator.dataExpense(expense);
//                        Toast.makeText(getActivity(), expense.toString(), Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }

}
