package com.example.on_thi_toi_uu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter_DatSan extends ArrayAdapter<DatSan> {
    Context context;
    int resource;
    ArrayList<DatSan> data;

    public CustomAdapter_DatSan(@NonNull Context context, int resource, ArrayList<DatSan> data) {
        super(context, resource, data);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resource, null);
        ImageView imageViewLoaiKhach = convertView.findViewById(R.id.imgLoaiKhach);
        TextView txtHoTenKH = convertView.findViewById(R.id.txtHoTenKH);
        TextView txtSoDienThoai = convertView.findViewById(R.id.txtSoDienThoai);

        DatSan datSan = data.get(position);
        txtHoTenKH.setText(datSan.getHoTenKH());

        if (datSan.getImgLoaiKhach().equals("HSSV")){
            imageViewLoaiKhach.setImageResource(R.drawable.hssv);
        }
        if (datSan.getImgLoaiKhach().equals("Hội Viên")){
            imageViewLoaiKhach.setImageResource(R.drawable.hoivien);
        }if (datSan.getImgLoaiKhach().equals("Khách")){
            imageViewLoaiKhach.setImageResource(R.drawable.khach);
        }

        txtSoDienThoai.setText(datSan.getSoDienThoai());

        return convertView;
    }
}
