package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TestListView extends Activity {
    private static final int REQUEST_CODE=0;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_list_view);

        String[] list = {"Coca", "Pepsi"};

        listView = findViewById(R.id.listView);

        ArrayAdapter arrayAdaper = new ArrayAdapter<String>(TestListView.this, R.layout.activity_test_list_view, list);

        listView.setAdapter(arrayAdaper);


    }
}