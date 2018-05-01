package com.example.saiful.dailyexpense;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddExpense extends AppCompatActivity {
    EditText eteAmount, eteDescription, eteDate;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        eteAmount = (EditText) findViewById(R.id.eteAmount);
        eteDescription = (EditText) findViewById(R.id.eteDescription);
        eteDate = (EditText) findViewById(R.id.eteDate);
        databaseHelper = new DatabaseHelper(this);
    }

    public void btneSubmit(View view) {
        String e_amount = eteAmount.getText().toString();
        String e_description = eteDescription.getText().toString();
        String e_date = eteDate.getText().toString();
        Expense expense = new Expense(e_amount, e_description, e_date);
//        Toast.makeText(getApplicationContext(), expense.toString(), Toast.LENGTH_SHORT).show();
        long inserted = databaseHelper.insertExpense(expense);
        if (inserted >= 0) {
            Toast.makeText(getApplicationContext(), "data inserted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "data inserted failed...", Toast.LENGTH_SHORT).show();
        }

    }

}
