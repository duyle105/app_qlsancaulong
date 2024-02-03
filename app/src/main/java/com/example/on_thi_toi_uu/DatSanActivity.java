package com.example.on_thi_toi_uu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class DatSanActivity extends AppCompatActivity {
    EditText edtNgayDangKy, edtHoTenKH, edtSoDienThoai;
    Spinner spnLoaiKhach, spnMaSan;
    ListView lvDanhSach;
    int viTri = -1;
    //Use Spinner
    ArrayAdapter arrayAdapterLoaiKhach, arrayAdapterMaSan;
    ArrayList<String> arrayListStringLoaiKhach = new ArrayList<>();
    ArrayList<String> arrayListStringMaSan = new ArrayList<>();
    //Dat SAn
    CustomAdapter_DatSan customAdapterDatSan;
    ArrayList<DatSan> dataDS = new ArrayList<>();
    ArrayList<DatSan> newData = new ArrayList<>();
    //Db
    DBDatSan dbDatSan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_san);
        setControl();
        setEvent();

    }

    private void setEvent() {
        dbDatSan = new DBDatSan(this);
        KhoiTao();
        arrayAdapterLoaiKhach = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayListStringLoaiKhach);
        spnLoaiKhach.setAdapter(arrayAdapterLoaiKhach);
        arrayAdapterMaSan = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayListStringMaSan);
        spnMaSan.setAdapter(arrayAdapterMaSan);

        customAdapterDatSan = new CustomAdapter_DatSan(this, R.layout.layout_item_dat_san, dataDS);
        lvDanhSach.setAdapter(customAdapterDatSan);
        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                viTri = position;
                DatSan datSan = dataDS.get(viTri);
                edtNgayDangKy.setText(datSan.getNgayDanKy());
                edtHoTenKH.setText(datSan.getHoTenKH());
                edtSoDienThoai.setText(datSan.getSoDienThoai());
                spnLoaiKhach.setSelection(arrayListStringLoaiKhach.indexOf(datSan.getImgLoaiKhach()));
                spnMaSan.setSelection(arrayListStringMaSan.indexOf(datSan.getMaSan()));
            }
        });
    }

    public void ChucNang(View view) {
        switch (view.getId()) {
            case R.id.btnThem:
                AddSan();
                break;
            case R.id.btnXoa:
                DeleteSan();
                break;
            case R.id.btnSua:
                UpdateDatSan();
                break;
            case R.id.btnClearAll:
                ClearAll();
                break;
        }
    }

    private void ClearAll() {
        SetTextRong();
        Toast.makeText(this, "Đã clear", Toast.LENGTH_SHORT).show();
    }

    private void UpdateDatSan() {
        if (viTri != -1){
            DatSan datSan = dataDS.get(viTri);
            datSan.setNgayDanKy(edtNgayDangKy.getText().toString());
            datSan.setHoTenKH(edtHoTenKH.getText().toString());
            datSan.setSoDienThoai(edtSoDienThoai.getText().toString());
            datSan.setImgLoaiKhach(spnLoaiKhach.getSelectedItem().toString());
            datSan.setMaSan(spnMaSan.getSelectedItem().toString());
            customAdapterDatSan.notifyDataSetChanged();
            viTri = -1;
            Toast.makeText(this, "Đã sửa", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Bạn chưa chọn Sân để sửa", Toast.LENGTH_SHORT).show();
        }
        SetTextRong();
    }

    private void DeleteSan() {
        if (viTri != -1){
            DatSan datSan = dataDS.get(viTri);
            dataDS.remove(datSan);
            customAdapterDatSan.notifyDataSetChanged();
            viTri = -1;
            Toast.makeText(this, "Đã xóa", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Bạn chưa chọn SÂN để xóa", Toast.LENGTH_SHORT).show();
        }
        SetTextRong();
    }

    private void AddSan() {
        DatSan datSan = new DatSan();
        datSan.setNgayDanKy(edtNgayDangKy.getText().toString());
        datSan.setHoTenKH(edtHoTenKH.getText().toString());
        datSan.setSoDienThoai(edtSoDienThoai.getText().toString());
        datSan.setImgLoaiKhach(spnLoaiKhach.getSelectedItem().toString());
        datSan.setMaSan(spnMaSan.getSelectedItem().toString());
        dataDS.add(datSan);
        newData.add(datSan);
        customAdapterDatSan.notifyDataSetChanged();
        Toast.makeText(this, "Đã thêm" + datSan, Toast.LENGTH_SHORT).show();
        SetTextRong();
    }
    private void SetTextRong() {
        edtNgayDangKy.setText("");
        edtHoTenKH.setText("");
        edtSoDienThoai.setText("");
        spnLoaiKhach.setSelection(0);
        spnMaSan.setSelection(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        // Xử lý sự kiện khi người dùng nhấn vào icon menu
        MenuItem menuItem = menu.findItem(R.id.mnPromotion);
        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                handleMenuItemClick();
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
                case R.id.mnSave:
                Save();
                Toast.makeText(this, "Đã lưu", Toast.LENGTH_SHORT).show();
                break;

            case R.id.mnRead:
                Read();
                Toast.makeText(this, "Đã đọc", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnExit:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void handleMenuItemClick() {
        Intent intent = new Intent(this, KhuyenMaiActivity.class);
        startActivity(intent);
    }


    private void Read() {
        dataDS.clear();
        dataDS.addAll(dbDatSan.ReadDB());
        customAdapterDatSan.notifyDataSetChanged();
    }

    private void Save() {
        for (DatSan datSan : newData){
            dbDatSan.AddDatSanDB(datSan);
        }
    }

    private void KhoiTao() {
        arrayListStringLoaiKhach.add("HSSV");
        arrayListStringLoaiKhach.add("Hội Viên");
        arrayListStringLoaiKhach.add("Khách");
        arrayListStringMaSan.add("a1");
        arrayListStringMaSan.add("b1");
        arrayListStringMaSan.add("c1");
        arrayListStringMaSan.add("a2");
        arrayListStringMaSan.add("b2");
        arrayListStringMaSan.add("c2");
    }

    private void setControl() {
        edtNgayDangKy = findViewById(R.id.edtNgayDangKy);
        edtHoTenKH = findViewById(R.id.edtHoTenKH);
        edtSoDienThoai = findViewById(R.id.edtSoDienThoai);
        spnLoaiKhach = findViewById(R.id.spnLoaiKhach);
        spnMaSan = findViewById(R.id.spnMaSan);
        lvDanhSach = findViewById(R.id.lvDanhSach);
    }
}