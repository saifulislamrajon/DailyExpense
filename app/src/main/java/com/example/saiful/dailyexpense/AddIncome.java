package com.example.saiful.dailyexpense;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddIncome extends AppCompatActivity {
    EditText etiAmount, etiDescription, etiDate;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income);

        etiAmount = (EditText) findViewById(R.id.etiAmount);
        etiDescription = (EditText) findViewById(R.id.etiDescription);
        etiDate = (EditText) findViewById(R.id.etiDate);
        dbHelper = new DatabaseHelper(this);
    }

    public void btniSubmit(View view) {
//        Toast.makeText(this, "saiful", Toast.LENGTH_SHORT).show();
        String i_amount = etiAmount.getText().toString();
        String i_description = etiDescription.getText().toString();
        String i_date = etiDate.getText().toString();
        Income income = new Income(i_amount, i_description, i_date);
//        Toast.makeText(getApplicationContext(), income.toString(), Toast.LENGTH_SHORT).show();
        long inserted = dbHelper.insertIncome(income);
        if (inserted >= 0) {
            Toast.makeText(getApplicationContext(), "data inserted", Toast.LENGTH_SHORT).show();
//            Intent intent=new Intent(this,MainActivity.class);
//            startActivity(intent);

        } else {
            Toast.makeText(getApplicationContext(), "data inserted failed...", Toast.LENGTH_SHORT).show();
        }
    }

}
