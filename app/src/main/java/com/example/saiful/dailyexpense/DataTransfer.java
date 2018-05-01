package com.example.saiful.dailyexpense;

/**
 * Created by Malinda on 5/2/2016.
 */
public class DataTransfer {

    String amount, description, date;


    public void setAmount(String amount) {
        this.amount = amount;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getAmount() {
        return amount;
    }
    public String getDescription() {
        return description;
    }
    public String getDate() {
        return date;
    }


}
