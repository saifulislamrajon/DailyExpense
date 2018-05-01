package com.example.saiful.dailyexpense;


public class Income {
    int id;
    String amount, description, date;

    public Income(int id, String amount, String description, String date) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public Income(String amount, String description, String date) {
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public Income(String amount) {
        this.amount = amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Income{" +
                "id=" + id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
