package com.example.saiful.dailyexpense;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Vector;

public class InputAndShow extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    EditText inputDate;
    Button btnShow;
    ListView listView, listViewExpense;
    CustomizedList list;
    Vector dataVec;
    Vector expenseVec;
    DataTransfer dt;
    DataTransfer expenseDT;
    ArrayList<Income> incomes2 = new ArrayList<Income>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_and_show);
        listView = (ListView) findViewById(R.id.listView2);
        listViewExpense = (ListView) findViewById(R.id.listViewExpense);
        databaseHelper = new DatabaseHelper(this);
        inputDate = (EditText) findViewById(R.id.inputDate);
        btnShow = (Button) findViewById(R.id.btnShow);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keyword = inputDate.getText().toString();
                if (!keyword.isEmpty()){

                    ArrayList<Income> incomes = databaseHelper.searchIncome(keyword);
                    ArrayList<Expense> expenses = databaseHelper.searchExpense(keyword);

                    dataVec = new Vector();
                    expenseVec = new Vector();


                    if (incomes != null && incomes.size() > 0) {
                        for (Income value : incomes) {
                            DataTransfer dt = new DataTransfer();
                            dt.setDate(value.getDate());
                            dt.setAmount(value.getAmount());
                            dt.setDescription(value.getDescription());
                            dataVec.add(dt);

                            //Toast.makeText(this, "Date: "+value.getDate(), Toast.LENGTH_SHORT).show();
                        }

                        //list = new CustomizedList(InputAndShow.this, dataVec);
                        listView.setAdapter(new CustomizedList(InputAndShow.this,dataVec));
                    }



                    if (expenses != null && expenses.size() > 0) {
                        for (Expense expense : expenses) {

                            expenseDT = new DataTransfer();
                            expenseDT.setDate(expense.getDate());
                            expenseDT.setAmount(expense.getAmount());
                            expenseDT.setDescription(expense.getDescription());

                            expenseVec.add(expenseDT);

                        /*Toast.makeText(getApplicationContext(), expense.date, Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(), expense.amount, Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(), expense.description, Toast.LENGTH_SHORT).show();*/
                        }

                        listViewExpense.setAdapter(new CustomizedExpenseList(InputAndShow.this,expenseVec));

                    }

                }else {
                    Toast.makeText(InputAndShow.this, "Please enter Date.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
