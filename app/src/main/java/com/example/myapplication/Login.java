package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    EditText textName;
    EditText textEmail;
    Button btnWrite;
    Button btnRead;
    Button btnRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //_______________________________
        textName = findViewById(R.id.textName);
        textEmail = findViewById(R.id.textEmail);
        btnWrite = findViewById(R.id.btnWrite);
        btnRead = findViewById(R.id.btnRead);
        btnRemove = findViewById(R.id.btnRemove1);


        //_______________________________
        sharedPreferences = getSharedPreferences("preferenceFile", Context.MODE_PRIVATE);

        if (sharedPreferences.contains("Name")){
            textName.setText(sharedPreferences.getString("Name",""));
        }
        if (sharedPreferences.contains("Email")){
            textEmail.setText(sharedPreferences.getString("Email",""));
        }

        //______________________________

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = textName.getText().toString();
                String email = textEmail.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Name", name);
                editor.putString("Email", email);
                editor.commit();
            }
        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sharedPreferences.contains("Name")){
                    textName.setText(sharedPreferences.getString("Name",""));
                }
                if (sharedPreferences.contains("Email")){
                    textEmail.setText(sharedPreferences.getString("Email",""));
                }
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("Name");
                editor.remove("Email");
                editor.commit();
                textName.setText("");
                textEmail.setText("");
            }
        });
    }

}