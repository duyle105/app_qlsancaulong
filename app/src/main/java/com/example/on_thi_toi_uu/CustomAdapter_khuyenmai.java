package com.example.on_thi_toi_uu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter_khuyenmai extends ArrayAdapter<KhuyenMai> {
    Context context;
    int resource;
    ArrayList<KhuyenMai> data;

    public CustomAdapter_khuyenmai(Context context, int resource, ArrayList<KhuyenMai> data) {
        super(context, resource, data);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(resource, null);
        ImageView imgKM = convertView.findViewById(R.id.imgKM);

        TextView tvNoiDung = convertView.findViewById(R.id.tvNoiDung);
        TextView tvMaKm = convertView.findViewById(R.id.tvMaKm);
        TextView tvNgay = convertView.findViewById(R.id.tvNgay);

        Button btnChiTiet = convertView.findViewById(R.id.btnChiTiet);

        KhuyenMai km = data.get(position);



        tvMaKm.setText(km.getMaKM());
        tvNoiDung.setText(km.getNoiDung());
        tvNgay.setText(km.getNgayThang());
//
//        edtMaKm.setText(km.getMaKM());
//        edtNgayThang.setText(km.getNgayThang());
//        edtNoiDungMain.setText(km.getNoiDung());


        //lay hinh anh cua tung doi tuong khuyen mai
        if(km.getMaKM().toString().toLowerCase().equals("1")) {
            imgKM.setImageResource(R.drawable.bigsale);
        }
        else if(km.getMaKM().toString().toLowerCase().equals("2")) {
            imgKM.setImageResource(R.drawable.bigsalered);
        }
        else if(km.getMaKM().toString().toLowerCase().equals("3")) {
            imgKM.setImageResource(R.drawable.hotsummer);
        }
        else if(km.getMaKM().toString().toLowerCase().equals("4")) {
            imgKM.setImageResource(R.drawable.sale);
        }
        else {
            imgKM.setImageResource(R.drawable.ic_launcher_background);
        }

        btnChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DatSanActivity.class);
                intent.putExtra("km", km);
                context.startActivities(new Intent[]{intent});
            }
        });
        return convertView;

    }
}
