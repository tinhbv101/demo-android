package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends Activity {
    public static final String RESULT_DATA = "RESULT_DATA";
    EditText txtReceive, txtResult;
    Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtReceive = findViewById(R.id.textReceive);
        txtResult = findViewById(R.id.textResult);
        btnOK = findViewById(R.id.btnOk);
        Intent intent = getIntent();
        String data = intent.getStringExtra("SEND");
        txtReceive.setText(data);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent data = new Intent();
                data.putExtra(RESULT_DATA,txtResult.getText().toString());
                setResult(Activity.RESULT_OK, data);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        setResult(Activity.RESULT_CANCELED);
        super.onBackPressed();
    }
}