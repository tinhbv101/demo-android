package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<SanPham> {

    Context context;
    List<SanPham> arrayList;
    int layoutResource;
    public CustomAdapter(Context context, int resource, List<SanPham> objects)
    {
        super(context, resource, objects);
        this.context = context;
        this.arrayList = objects;
        this.layoutResource = resource;
    }


    @NonNull
    @Override
    //Hàm khởi tạo cho các dòng để hiển thị trên ListView
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(layoutResource,null);

        TextView txt1 = (TextView)convertView.findViewById(R.id.mainText);
        txt1.setText(arrayList.get(position).getTen());
        TextView txt2 = (TextView)convertView.findViewById(R.id.subText);
        txt2.setText(arrayList.get(position).getGia().toString());
        ImageView img = (ImageView)convertView.findViewById(R.id.img);
        img.setImageResource(arrayList.get(position).getImg());
        return convertView;
    }
}
