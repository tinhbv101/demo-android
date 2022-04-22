package com.example.myapplication.BTSQLite.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.myapplication.BTSQLite.Model.Customer;
import com.example.myapplication.BTSQLite.Model.User;
import com.example.myapplication.BTSQLite.SQLiteHelper.SQLiteHelper;
import com.example.myapplication.R;

import java.util.ArrayList;

public class CustomerActivity extends AppCompatActivity {

    EditText txtIdCustomer;
    EditText txtNameCustomer;
    EditText txtAddressCustomer;
    EditText txtPhoneCustomer;
    EditText txtEmailCustomer;
    Button btnAddCustomer;
    Button btnUpdateCustomer;
    Button btnDeleteCustomer;
    Button btnAllCustomer;
    ListView listViewCustomer;
    SQLiteHelper sqLiteHelper = new SQLiteHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);


        txtIdCustomer = findViewById(R.id.txtIdCustomer);
        txtNameCustomer = findViewById(R.id.txtNameCustomer);
        txtAddressCustomer = findViewById(R.id.txtAddressCustomer);
        txtPhoneCustomer = findViewById(R.id.txtPhoneCustomer);
        txtEmailCustomer = findViewById(R.id.txtEmailCustomer);
        btnAddCustomer = findViewById(R.id.btnAddCustomer);
        btnUpdateCustomer = findViewById(R.id.btnUpdateCustomer);
        btnDeleteCustomer = findViewById(R.id.btnDeleteCustomer);
        btnAllCustomer = findViewById(R.id.btnAllCustomer);
        listViewCustomer = findViewById(R.id.listViewCustomer);

        btnAddCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Customer customer = new Customer();
                customer.setId(Integer.parseInt(txtIdCustomer.getText().toString()));
                customer.setAddress(txtAddressCustomer.getText().toString());
                customer.setName(txtNameCustomer.getText().toString());
                customer.setEmail(txtEmailCustomer.getText().toString());
                customer.setPhone(txtPhoneCustomer.getText().toString());
                sqLiteHelper.addCustomer(customer);
            }
        });

        btnAllCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Customer> listCustomer = new ArrayList<Customer>();
                listCustomer = sqLiteHelper.getAllCustomer();
                ArrayAdapter<Customer> arrayAdapter = new ArrayAdapter<Customer>(CustomerActivity.this, android.R.layout.simple_list_item_1, listCustomer);
                listViewCustomer.setAdapter(arrayAdapter);
            }
        });

    }
}