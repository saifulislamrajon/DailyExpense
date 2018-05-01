package com.example.saiful.dailyexpense;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "calculation_management";
    public static final int DB_VERSION = 1;

    public static final String INCOME_TABLE = "income_table";
    public static final String EXPENSE_TABLE = "expense_table";

    public static final String ID_FIELD = "_id";
    public static final String AMOUNT_FIELD = "_amount";
    public static final String DESCRIPTION_FIELD = "_description";
    public static final String DATE_FIELD = "_date";

    public static final String INCOME_TABLE_SQL = " CREATE TABLE " +
            INCOME_TABLE + " (" +
            ID_FIELD + " INTEGER PRIMARY KEY, " +
            AMOUNT_FIELD + " TEXT, " +
            DESCRIPTION_FIELD + " TEXT, " +
            DATE_FIELD + " TEXT)";
    public static final String EXPENSE_TABLE_SQL = " CREATE TABLE " +
            EXPENSE_TABLE + " ( " +
            ID_FIELD + " INTEGER PRIMARY KEY, " +
            AMOUNT_FIELD + " TEXT , " +
            DESCRIPTION_FIELD + " TEXT , " +
            DATE_FIELD + " TEXT ) ";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(INCOME_TABLE_SQL);
        db.execSQL(EXPENSE_TABLE_SQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertIncome(Income income) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AMOUNT_FIELD, income.getAmount());
        values.put(DESCRIPTION_FIELD, income.getDescription());
        values.put(DATE_FIELD, income.getDate());
        long inserted = db.insert(INCOME_TABLE, null, values);
        db.close();
        return inserted;
    }

    public long insertExpense(Expense expense) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AMOUNT_FIELD, expense.getAmount());
        values.put(DESCRIPTION_FIELD, expense.getDescription());
        values.put(DATE_FIELD, expense.getDate());
        long inserted = db.insert(EXPENSE_TABLE, null, values);
        db.close();
        return inserted;
    }

    public ArrayList<Income> getAllIncome() {
        ArrayList<Income> allIncome = new ArrayList<Income>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(INCOME_TABLE, null, null, null, null, null, null);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                String income = cursor.getString(cursor.getColumnIndex(AMOUNT_FIELD));
                Income income1 = new Income(income);
                allIncome.add(income1);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return allIncome;
    }

    public ArrayList<Expense> getAllExpense() {
        ArrayList<Expense> allExpense = new ArrayList<Expense>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(EXPENSE_TABLE, null, null, null, null, null, null);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                String expense = cursor.getString(cursor.getColumnIndex(AMOUNT_FIELD));
                Expense expense1 = new Expense(expense);
                allExpense.add(expense1);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return allExpense;
    }

    public ArrayList<Income> searchIncome(String keyword) {
        ArrayList<Income> incomes = new ArrayList<Income>();
        SQLiteDatabase db = this.getReadableDatabase();
        if (!keyword.isEmpty()){
            Cursor cursor = db.query(INCOME_TABLE, null, "_date LIKE '%" + keyword + "%'", null, null, null, null);

            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();
                for (int i = 0; i < cursor.getCount(); i++) {
                    int id = cursor.getInt(cursor.getColumnIndex(ID_FIELD));
                    String amount = cursor.getString(cursor.getColumnIndex(AMOUNT_FIELD));
                    String description = cursor.getString(cursor.getColumnIndex(DESCRIPTION_FIELD));
                    String date = cursor.getString(cursor.getColumnIndex(DATE_FIELD));
                    Income income = new Income(id, amount, description, date);
                    incomes.add(income);
                    cursor.moveToNext();
                }
            }
            cursor.close();
            db.close();
        }
        return incomes;

    }

    public ArrayList<Expense> searchExpense(String keyword) {
        ArrayList<Expense> expenses = new ArrayList<Expense>();
        SQLiteDatabase db = this.getReadableDatabase();

        if (!keyword.isEmpty()) {
            Cursor cursor = db.query(EXPENSE_TABLE, null, "_date LIKE '%" + keyword + "%'", null, null, null, null);
            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();
                for (int i = 0; i < cursor.getCount(); i++) {
                    int id = cursor.getInt(cursor.getColumnIndex(ID_FIELD));
                    String amount = cursor.getString(cursor.getColumnIndex(AMOUNT_FIELD));
                    String description = cursor.getString(cursor.getColumnIndex(DESCRIPTION_FIELD));
                    String date = cursor.getString(cursor.getColumnIndex(DATE_FIELD));
                    Expense expense = new Expense(id, amount, description, date);
                    expenses.add(expense);
                    cursor.moveToNext();
                }
            }
            cursor.close();
            ;
            db.close();
        }
        return expenses;

    }

    public int dataUpdate(String previous_amount, String IorE, String date, String amount, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        int update=0;
        if (IorE.equals("income")) {
            ContentValues values = new ContentValues();
            values.put(DATE_FIELD, date);
            values.put(AMOUNT_FIELD, amount);
            values.put(DESCRIPTION_FIELD, description);
            update = db.update(INCOME_TABLE, values, AMOUNT_FIELD + "=?", new String[]{previous_amount});
            db.close();
        }
        if (IorE.equals("expense")) {
            ContentValues values = new ContentValues();
            values.put(DATE_FIELD, date);
            values.put(AMOUNT_FIELD, amount);
            values.put(DESCRIPTION_FIELD, description);
            update = db.update(EXPENSE_TABLE, values, AMOUNT_FIELD + "=?", new String[]{previous_amount});
            db.close();
        }
        return update;


    }
}
