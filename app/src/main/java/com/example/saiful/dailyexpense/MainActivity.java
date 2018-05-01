package com.example.saiful.dailyexpense;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private TextView txvMonth, tvIncome, tvExpense, tvBalance, tvRemaining;
    DatabaseHelper dbHelper;

    int allIncome = 0;
    int allExpense = 0;
    int balance = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txvMonth = (TextView) findViewById(R.id.txvMonth);
        tvIncome = (TextView) findViewById(R.id.tvIncome);
        tvRemaining = (TextView) findViewById(R.id.tvRemaining);
        tvExpense = (TextView) findViewById(R.id.tvExpense);
        tvBalance = (TextView) findViewById(R.id.tvBalance);
        dbHelper = new DatabaseHelper(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        String dt;
//        Date cal = (Date) Calendar.getInstance().getTime();
//        dt = cal.toLocaleString();
//        txvMonth.setText(dt.toString());

        DateFormat dateFormat = new SimpleDateFormat("MM");
        Date date = new Date();
        String d = dateFormat.format(date);
        String month;
        switch (d) {
            case "01":
                month = "January";
                txvMonth.setText(month);

                break;
            case "02":
                month = "February";
                txvMonth.setText(month);
//                tvIncome=null;
//                tvExpense=null;
//                tvRemaining.setText(Integer.toString(balance));
                break;
            case "03":
                month = "March";
                txvMonth.setText(month);
                break;
            case "04":
                month = "April";
                txvMonth.setText(month);
                break;
            case "05":
                month = "May";
                txvMonth.setText(month);
                break;
            case "06":
                month = "June";
                txvMonth.setText(month);
                break;
            case "07":
                month = "July";
                txvMonth.setText(month);
                break;
            case "08":
                month = "August";
                txvMonth.setText(month);
                break;
            case "09":
                month = "September";
                txvMonth.setText(month);
                break;
            case "10":
                month = "October";
                txvMonth.setText(month);
                break;
            case "11":
                month = "November";
                txvMonth.setText(month);
                break;
            case "12":
                month = "December";
                txvMonth.setText(month);
                break;

        }

        showIncome();
        //income show
//        int allIncome=0;
//        int balance=0;
        /*ArrayList<Income> incomes = dbHelper.getAllIncome();
        if (incomes != null && incomes.size() > 0) {
            for (Income inc : incomes) {
                allIncome += Integer.parseInt(inc.getAmount());
                tvIncome.setText(Integer.toString(allIncome));
                Toast.makeText(getApplicationContext(), inc.toString(), Toast.LENGTH_SHORT).show();
            }
        } else if (incomes.size() == 0) {
            Toast.makeText(getApplicationContext(), "No data found", Toast.LENGTH_SHORT).show();
        }

        //expense show
//        int allExpense=0;
        ArrayList<Expense> expenses = dbHelper.getAllExpense();
        if (expenses != null && expenses.size() > 0) {
            for (Expense exp : expenses) {
                allExpense += Integer.parseInt(exp.getAmount());
                tvExpense.setText(Integer.toString(allExpense));
                Toast.makeText(getApplicationContext(), exp.toString(), Toast.LENGTH_SHORT).show();
            }
        } else if (expenses.size() == 0) {
            Toast.makeText(getApplicationContext(), "No data found", Toast.LENGTH_SHORT).show();
        }*/
        /*balance = allIncome - allExpense;
        tvBalance.setText(Integer.toString(balance));*/

        return super.onCreateOptionsMenu(menu);


    }

    public void addIncome(View view) {
        Intent intent = new Intent(this, AddIncome.class);
        startActivity(intent);
    }

    public void addExpense(View view) {
        Intent intent = new Intent(this, AddExpense.class);
        startActivity(intent);
    }

    public void reportByDate(View view) {
//        Intent intent = new Intent(this, ReportByDate.class);
//        startActivity(intent);
        Intent intent = new Intent(this, InputAndShow.class);
        startActivity(intent);
    }

    public void update(View view) {
        Intent intent = new Intent(this, Update.class);
        startActivity(intent);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        showIncome();

//        Toast.makeText(this, "onPostResume", Toast.LENGTH_SHORT).show();
    }

    public void showIncome() {

        balance = 0;
        allIncome = 0;
        allExpense = 0;
        ArrayList<Income> incomes = dbHelper.getAllIncome();
        if (incomes != null && incomes.size() > 0) {
            for (Income inc : incomes) {
                allIncome += Integer.parseInt(inc.getAmount());
                tvIncome.setText(Integer.toString(allIncome));
                //Toast.makeText(getApplicationContext(), inc.toString(), Toast.LENGTH_SHORT).show();
            }
        } else if (incomes.size() == 0) {
            Toast.makeText(getApplicationContext(), "No data found", Toast.LENGTH_SHORT).show();
        }


        ArrayList<Expense> expenses = dbHelper.getAllExpense();
        if (expenses != null && expenses.size() > 0) {
            for (Expense exp : expenses) {
                allExpense += Integer.parseInt(exp.getAmount());
                tvExpense.setText(Integer.toString(allExpense));
                //Toast.makeText(getApplicationContext(), exp.toString(), Toast.LENGTH_SHORT).show();
            }
        } else if (expenses.size() == 0) {
            Toast.makeText(getApplicationContext(), "No data found", Toast.LENGTH_SHORT).show();
        }

        balance = allIncome - allExpense;
        tvBalance.setText(Integer.toString(balance));

    }

}
