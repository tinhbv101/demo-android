package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class Assets_Example extends AppCompatActivity {
    private ImageView imageView;
    private AssetManager assetManager;
    private Button btnNext;
    private Button btnPre;
    private int flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assets_example);
        imageView = findViewById(R.id.imageView);
        assetManager = getAssets();

        imageView.setVisibility(View.VISIBLE);

        btnNext = findViewById(R.id.btnNext);

        String[] listImages = new String[0];
        try {
            listImages = assetManager.list("imgs");
        } catch (IOException e) {
            Log.e("Assets_Example", e.getMessage());
        }
        String[] finalListImages = listImages;

        try {
            InputStream is = assetManager.open("imgs/" + finalListImages[0]);
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            imageView.setImageBitmap(bitmap);

        } catch (IOException e) {
            Log.e("Assets_Example", e.getMessage());
        }

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag += 1;
                if (flag >= finalListImages.length){
                    flag = 0;
                }
                try {
                    InputStream is = assetManager.open("imgs/" + finalListImages[flag]);
                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                    imageView.setImageBitmap(bitmap);
                } catch (IOException e) {
                    Log.e("Assets_Example", e.getMessage());
                }
            }
        });

        btnPre = findViewById(R.id.btnPre);
        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag -= 1;
                if (flag == -1){
                    flag = finalListImages.length - 1;

                }
                try {
                    InputStream is = assetManager.open("imgs/" + finalListImages[flag]);
                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                    imageView.setImageBitmap(bitmap);
                } catch (IOException e) {
                    Log.e("Assets_Example", e.getMessage());
                }
            }
        });

    }
}