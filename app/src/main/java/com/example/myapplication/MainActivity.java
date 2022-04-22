package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<SanPham> sanPhamList = new ArrayList<SanPham>();
        sanPhamList.add(new SanPham("Coca", 10000, R.drawable.coca));
        sanPhamList.add(new SanPham("Pepsi", 9000, R.drawable.coca));
        sanPhamList.add(new SanPham("Number One", 12000,R.drawable.coca));

        listView = (ListView)findViewById(R.id.listView);

         customAdapter = new CustomAdapter(this, R.layout.custom_list_items, sanPhamList);

        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, sanPhamList.get(i).getTen().toString() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}