package com.example.saiful.dailyexpense;


public interface Communicator {
    public void dataIncome(Income data);

    public void dataExpense(Expense data);
}
