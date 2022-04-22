package com.example.myapplication.BTSQLite.SQLiteHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.BTSQLite.Model.Customer;
import com.example.myapplication.BTSQLite.Model.User;
import com.example.myapplication.SQLiteTest.ProductModel;

import java.util.ArrayList;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "User.db";
    private static final Integer DATABASE_VERSION = 1;




    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String script1 = "CREATE TABLE IF NOT EXISTS user(id INTEGER PRIMARY KEY, email TEXT, phone TEXT)" ;
        String script2 = " CREATE TABLE IF NOT EXISTS customer(id INTEGER PRIMARY KEY, name TEXT, address TEXT, phone TEXT, email TEXT)";
        sqLiteDatabase.execSQL(script1);
        sqLiteDatabase.execSQL(script2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String script1 = "DROP TABLE IF EXISTS user";
        String script2 = "DROP TABLE IF EXISTS customer";
        sqLiteDatabase.execSQL(script1);
        sqLiteDatabase.execSQL(script2);
        onCreate(sqLiteDatabase);
    }

    //=========== CRUD USER=====================
    public ArrayList<User> getAllUsers() {
        ArrayList<User> listUsers = new ArrayList<User>();
        String selectQuery = "SELECT  * FROM user";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                User user  = new User();
                user.setId(Integer.parseInt(cursor.getString(0)));
                user.setEmail(cursor.getString(1));
                user.setPhone(cursor.getString(2));
                listUsers.add(user);
            } while (cursor.moveToNext());
        }

        return listUsers;
    }

    public void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", user.getId());
        values.put("email", user.getEmail());
        values.put("phone", user.getPhone());
        db.insert("user", null, values);

        System.out.println("ADD USER SUCCESSFULLY");

    }


    public int updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("email", user.getEmail());
        values.put("phone", user.getPhone());

        return db.update("user", values, "id = ?",
                new String[]{String.valueOf(user.getId())});
    }

    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("user", "id = ?",
                new String[] { String.valueOf(user.getId()) });
        db.close();
    }

    // ===========CRUD - CUSTOMER -----------

    public ArrayList<Customer> getAllCustomer() {
        ArrayList<Customer> listCustomers = new ArrayList<Customer>();
        String selectQuery = "SELECT  * FROM customer";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Customer customer  = new Customer();
                customer.setId(Integer.parseInt(cursor.getString(0)));
                customer.setName(cursor.getString(1));
                customer.setAddress(cursor.getString(2));
                customer.setPhone(cursor.getString(3));
                customer.setEmail(cursor.getString(4));
                listCustomers.add(customer);
            } while (cursor.moveToNext());
        }

        return listCustomers;
    }

    public void addCustomer(Customer customer){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", customer.getId());
        values.put("name", customer.getName());
        values.put("address", customer.getAddress());
        values.put("phone", customer.getPhone());
        values.put("email", customer.getEmail());
        db.insert("customer", null, values);

        System.out.println("ADD CUSTOMER SUCCESSFULLY");

    }


    public int updateCustomer(Customer customer) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("name", customer.getName());
        values.put("address", customer.getAddress());
        values.put("phone", customer.getPhone());
        values.put("email", customer.getEmail());

        return db.update("customer", values, "id = ?",
                new String[]{String.valueOf(customer.getId())});
    }

    public void deleteCustomer(Customer customer) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("customer", "id = ?",
                new String[] { String.valueOf(customer.getId()) });
        db.close();
    }

}

