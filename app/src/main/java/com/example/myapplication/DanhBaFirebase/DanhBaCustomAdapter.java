package com.example.myapplication.DanhBaFirebase;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;

import java.util.List;

public class DanhBaCustomAdapter extends ArrayAdapter<DanhBaEntity> {
    Context context;
    List<DanhBaEntity> arrayList;
    int layoutResource;

    public DanhBaCustomAdapter(@NonNull Context context, int resource, List<DanhBaEntity> object) {
        super(context, resource, object);
        this.context = context;
        this.arrayList = object;
        this.layoutResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(layoutResource, null);
        TextView txt = (TextView) convertView.findViewById(R.id.textDanhBa);
        txt.setText(arrayList.get(position).toString());
        Button btnCallDanhBa = (Button) convertView.findViewById(R.id.btnCallDanhBa);
        btnCallDanhBa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = arrayList.get(position).getSdt();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+number));
                context.startActivity(callIntent);
            }
        });
        return convertView;
    }
}
