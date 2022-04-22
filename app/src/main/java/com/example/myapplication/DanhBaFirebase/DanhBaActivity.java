package com.example.myapplication.DanhBaFirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.Book_Firebase.Book;
import com.example.myapplication.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DanhBaActivity extends AppCompatActivity {

    private DatabaseReference database;
    ListView listViewDanhBa;
    DanhBaCustomAdapter danhBaCustomAdapter;
    EditText txtNameDanhBa;
    EditText txtPhoneDanhBa;
    Button btnAddDanhBa;
    Button btnDeleteDanhBa;
    List<DanhBaEntity> danhBaEntities = new ArrayList<DanhBaEntity>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_ba);

        listViewDanhBa = (ListView) findViewById(R.id.listViewDanhBa);
        txtNameDanhBa = findViewById(R.id.txtNameDanhBa);
        txtPhoneDanhBa = findViewById(R.id.txtPhoneDanhBa);
        btnAddDanhBa = findViewById(R.id.btnAddDanhBa);
        btnDeleteDanhBa = findViewById(R.id.btnDeleteDanhBa);
        database = FirebaseDatabase.getInstance("https://fir-c6367-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Phones");

        danhBaCustomAdapter = new DanhBaCustomAdapter(this, R.layout.danh_ba_resource, danhBaEntities);





        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                danhBaEntities.clear();
                for (DataSnapshot dsp : snapshot.getChildren()) {
                    danhBaEntities.add(dsp.getValue(DanhBaEntity.class));
                    Toast.makeText(DanhBaActivity.this,"s12323", Toast.LENGTH_SHORT).show();
                }
                listViewDanhBa.setAdapter(danhBaCustomAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        btnAddDanhBa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DanhBaEntity danhBaEntity = new DanhBaEntity(txtNameDanhBa.getText().toString(),
                        txtPhoneDanhBa.getText().toString());
                database.child(danhBaEntity.getSdt()).setValue(danhBaEntity);
                danhBaCustomAdapter = new DanhBaCustomAdapter(DanhBaActivity.this, R.layout.danh_ba_resource, danhBaEntities);
                listViewDanhBa.setAdapter(danhBaCustomAdapter);
                Toast.makeText(DanhBaActivity.this,"success", Toast.LENGTH_SHORT).show();
            }
        });


        btnDeleteDanhBa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (DanhBaEntity danhBaEntity : danhBaEntities) {
                    if (danhBaEntity.getSdt().equals(txtPhoneDanhBa.getText().toString().trim())){
                        database.child(danhBaEntity.getSdt()).removeValue();
                        Toast.makeText(DanhBaActivity.this,"delete sucess", Toast.LENGTH_SHORT).show();
                    }
                }
                Toast.makeText(DanhBaActivity.this,"phone number not exist", Toast.LENGTH_SHORT).show();
            }
        });
    }
}