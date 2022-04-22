package com.example.myapplication.SQLiteTest;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import com.example.myapplication.R;

import java.util.ArrayList;

public class Product extends AppCompatActivity {

    ProductSQLiteHelper productSQLiteHelper;

    EditText txtIdProduct;
    EditText txtNameProduct;
    EditText txtInStockProduct;
    Button btnAdd;
    Button btnUpdate;
    Button btnDelete;
    Button btnAll;
    ListView listView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        txtIdProduct = findViewById(R.id.txtIdProduct);
        txtNameProduct = findViewById(R.id.txtNameProduct);
        txtInStockProduct = findViewById(R.id.txtInStock);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnAll = findViewById(R.id.btnAll);
        listView = findViewById(R.id.listViewProduct);





        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductSQLiteHelper productSQLiteHelper = new ProductSQLiteHelper(Product.this);
                ProductModel productModel = new ProductModel();
                productModel.setId(Integer.parseInt(txtIdProduct.getText().toString()));
                productModel.setName(txtNameProduct.getText().toString());
                productModel.setInStock(Integer.parseInt(txtInStockProduct.getText().toString()));
                productSQLiteHelper.addProduct(productModel);
            }
        });


        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductSQLiteHelper productSQLiteHelper = new ProductSQLiteHelper(Product.this);

                ArrayList<ProductModel> listProduct = new ArrayList<ProductModel>();
                listProduct = productSQLiteHelper.getAllProducts();
                ArrayAdapter<ProductModel> arrayAdapter = new ArrayAdapter<ProductModel>(Product.this, android.R.layout.simple_list_item_1, listProduct);
                listView.setAdapter(arrayAdapter);
            }
        });



    }
}