package com.example.myapplication.SQLiteTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ProductSQLiteHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "product";
    private static final Integer DATABASE_VERSION = 1;

    public ProductSQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String script = "CREATE TABLE IF NOT EXISTS product(id INTEGER PRIMARY KEY, name TEXT, inStock Integer)";
        sqLiteDatabase.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String script = "DROP TABLE IF EXISTS product";
        sqLiteDatabase.execSQL(script);
        onCreate(sqLiteDatabase);
    }

    public ArrayList<ProductModel> getAllProducts() {
        ArrayList<ProductModel> listProducts = new ArrayList<ProductModel>();
        // Select All Query
        String selectQuery = "SELECT  * FROM product";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ProductModel productModel = new ProductModel();
                productModel.setId(Integer.parseInt(cursor.getString(0)));
                productModel.setName(cursor.getString(1));
                productModel.setInStock(Integer.parseInt(cursor.getString(2)));
                // Adding note to list
                listProducts.add(productModel);
            } while (cursor.moveToNext());
        }

        // return note list
        return listProducts;
    }

    public void addProduct(ProductModel productModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", productModel.getId());
        values.put("name", productModel.getName());
        values.put("inStock", productModel.getInStock());
        db.insert("product", null, values);

        System.out.println("ADD PRODUCT SUCCESSFULLY");

    }


    public int updateProduct(ProductModel productModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", productModel.getName());
        values.put("inStock", productModel.getInStock());

        // updating row
        return db.update("product", values, "id = ?",
                new String[]{String.valueOf(productModel.getId())});
    }

    public void deleteProduct(ProductModel productModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("product", "id = ?",
                new String[] { String.valueOf(productModel.getId()) });
        db.close();
    }

}
