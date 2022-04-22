package com.example.myapplication.Book_Firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BookFirebaseActivity extends AppCompatActivity {
    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_firebase);

        database = FirebaseDatabase.getInstance("https://fir-c6367-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Books");
        Book book1 = new Book("How to developer Android apps", "Jane Developer");
        Book book2 = new Book("How to use Firebase", "Adam Writer");
        Book book3 = new Book("How to search Google", "Ava Searcher");
        database.child("Book one").setValue(book1);
        database.child("Book two").setValue(book2);
        database.child("Book three").setValue(book3);
    }
}