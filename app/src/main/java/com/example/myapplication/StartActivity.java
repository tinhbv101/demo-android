package com.example.myapplication;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

public class StartActivity extends Activity {
    private static final int REQUEST_CODE=1;
    private static final int MY_PERMISSIONS_REQUEST_CODE=1;
    EditText txtSend, txtReceive;
    Button btnCall, btnPer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        txtSend = findViewById(R.id.textSend);
        txtReceive = findViewById(R.id.textReceiveStart);
        btnCall = findViewById(R.id.btnCall);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCall_Activity(view);
            }
        });
        btnPer = findViewById(R.id.btnPer);
        btnPer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(StartActivity.this, new String[] {Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST_CODE);
            }
        });

    }

    public void onCall_Activity(View view){
        final Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("SEND", txtSend.getText().toString());
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if (resultCode == Activity.RESULT_OK) {
                String result = data.getStringExtra(MainActivity2.RESULT_DATA);
                txtReceive.setText(result);
            } else {

            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CODE:
                if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Intent call = new Intent(Intent.ACTION_CALL);
                    Uri number = Uri.parse("tel:0385859164");
                    call.setData(number);
                    startActivity(call);
                } else {
                    Toast.makeText(StartActivity.this, "Permissions denied", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}