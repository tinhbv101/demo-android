package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TestFirebase extends AppCompatActivity {
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_firebase);
        databaseReference = FirebaseDatabase.getInstance("https://fir-c6367-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("book");

        databaseReference.child("node").setValue("Value node");
        databaseReference.child("node").child("node1").setValue("Value node1");
        databaseReference.child("node").child("node2").setValue("Value node2");
        System.out.println(databaseReference.child("node").child("node1"));





    }
}