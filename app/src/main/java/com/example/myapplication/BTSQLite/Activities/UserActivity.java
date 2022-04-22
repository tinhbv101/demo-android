package com.example.myapplication.BTSQLite.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.myapplication.BTSQLite.Model.User;
import com.example.myapplication.BTSQLite.SQLiteHelper.SQLiteHelper;
import com.example.myapplication.R;
import com.example.myapplication.SQLiteTest.Product;
import com.example.myapplication.SQLiteTest.ProductModel;
import com.example.myapplication.SQLiteTest.ProductSQLiteHelper;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {

    EditText txtIdUser;
    EditText txtEmailUser;
    EditText txtPhoneUser;
    Button btnAddUser;
    Button btnUpdateUser;
    Button btnDeleteUser;
    Button btnAllUser;
    ListView listViewUser;
    SQLiteHelper sqLiteHelper = new SQLiteHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        txtIdUser = findViewById(R.id.txtIdUser);
        txtEmailUser = findViewById(R.id.txtEmailUser);
        txtPhoneUser = findViewById(R.id.txtPhoneUser);
        btnAddUser = findViewById(R.id.btnAddUser);
        btnUpdateUser = findViewById(R.id.btnUpdateUser);
        btnDeleteUser = findViewById(R.id.btnDeleteUser);
        btnAllUser = findViewById(R.id.btnAllUser);
        listViewUser = findViewById(R.id.listViewUser);

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User user = new User();
                user.setId(Integer.parseInt(txtIdUser.getText().toString()));
                user.setEmail(txtEmailUser.getText().toString());
                user.setPhone(txtPhoneUser.getText().toString());
                sqLiteHelper.addUser(user);
            }
        });

        btnAllUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<User> listUser = new ArrayList<User>();
                listUser = sqLiteHelper.getAllUsers();
                ArrayAdapter<User> arrayAdapter = new ArrayAdapter<User>(UserActivity.this, android.R.layout.simple_list_item_1, listUser);
                listViewUser.setAdapter(arrayAdapter);
            }
        });

    }
}