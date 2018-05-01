package com.example.saiful.dailyexpense;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {
    DatabaseHelper dbHelper;
    EditText etPAmount,etIorE,etDate,etAmount,etDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        dbHelper=new DatabaseHelper(this);
        etPAmount= (EditText) findViewById(R.id.etPAmount);
        etIorE= (EditText) findViewById(R.id.etIorE);
        etDate= (EditText) findViewById(R.id.etDate);
        etAmount= (EditText) findViewById(R.id.etAmount);
        etDescription= (EditText) findViewById(R.id.etDescription);
    }
    public void update(View view){
        String previous_amount=etPAmount.getText().toString();
        String IorE=etIorE.getText().toString();
        String date=etDate.getText().toString();
        String amount=etAmount.getText().toString();
        String description=etDescription.getText().toString();
        int chag=dbHelper.dataUpdate(previous_amount,IorE,date,amount,description);
        if(chag>0){
            Toast.makeText(getApplicationContext(),"data update",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),"data not update",Toast.LENGTH_SHORT).show();
        }
    }
}
