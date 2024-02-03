package com.example.on_thi_toi_uu;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class KhuyenMaiActivity extends AppCompatActivity {
    EditText edtNgayThang, edtMaKM, edtNoiDung;


    ListView lvKhuyenMai;
    int viTri = -1;

    //Dat SAn
    CustomAdapter_khuyenmai customAdapterKhuyenMai;
    ArrayList<KhuyenMai> dataKhuyenMai = new ArrayList<>();
    ArrayList<KhuyenMai> newDataKM = new ArrayList<>();
    //Db
    DBKhuyenMai dbKhuyenMai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khuyenmai);
        setControl();
        setEvent();

    }

    private void setEvent() {
        dbKhuyenMai = new DBKhuyenMai(this);
        customAdapterKhuyenMai = new CustomAdapter_khuyenmai(this, R.layout.layout_khuyenmai, dataKhuyenMai);
        lvKhuyenMai.setAdapter(customAdapterKhuyenMai);
        lvKhuyenMai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                viTri = position;
                KhuyenMai datSan = dataKhuyenMai.get(viTri);
                edtNgayThang.setText(datSan.getNgayThang());
                edtMaKM.setText(datSan.getMaKM());
                edtNoiDung.setText(datSan.getNoiDung());

            }
        });
    }

    public void ChucNangKM(View view) {
        switch (view.getId()) {
            case R.id.btnThemKM:
                AddKhuyenMai();
                break;
            case R.id.btnXoaKM:
                DeleteKKhuyenMai();
                break;
            case R.id.btnSuaKM:
                UpdateKhuyenMai();
                break;
            case R.id.btnClearKM:
                ClearAll();
                break;
        }
    }

    private void ClearAll() {
        SetTextRong();
        Toast.makeText(this, "Đã clear", Toast.LENGTH_SHORT).show();
    }

    private void UpdateKhuyenMai() {
        if (viTri != -1){
            KhuyenMai khuyenMai = dataKhuyenMai.get(viTri);
            khuyenMai.setNgayThang(edtNgayThang.getText().toString());
            khuyenMai.setNoiDung(edtNoiDung.getText().toString());
            khuyenMai.setMaKM(edtMaKM.getText().toString());
            khuyenMai.setImgKM(edtMaKM.getText().toString());
            customAdapterKhuyenMai.notifyDataSetChanged();
            viTri = -1;
            Toast.makeText(this, "Đã sửa", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Bạn chưa chọn Khuyen mãi để sửa", Toast.LENGTH_SHORT).show();
        }
        SetTextRong();
    }

    private void DeleteKKhuyenMai() {
        if (viTri != -1){
            KhuyenMai khuyenMai = dataKhuyenMai.get(viTri);
            dataKhuyenMai.remove(khuyenMai);
            customAdapterKhuyenMai.notifyDataSetChanged();
            viTri = -1;
            Toast.makeText(this, "Đã xóa", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Bạn chưa chọn KM để xóa", Toast.LENGTH_SHORT).show();
        }
        SetTextRong();
    }

    private void AddKhuyenMai() {
        KhuyenMai khuyenMai = new KhuyenMai();
        khuyenMai.setNgayThang(edtNgayThang.getText().toString());
        khuyenMai.setNoiDung(edtNoiDung.getText().toString());
        khuyenMai.setMaKM(edtMaKM.getText().toString());
        khuyenMai.setImgKM(edtMaKM.getText().toString());
        dataKhuyenMai.add(khuyenMai);
        newDataKM.add(khuyenMai);
        customAdapterKhuyenMai.notifyDataSetChanged();
        Toast.makeText(this, "Đã thêm" + khuyenMai, Toast.LENGTH_SHORT).show();
        SetTextRong();
    }
    private void SetTextRong() {
        edtNgayThang.setText("");
        edtMaKM.setText("");
        edtNoiDung.setText("");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);



        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
                case R.id.mnSave:
                    SaveKM();
                Toast.makeText(this, "Đã lưu", Toast.LENGTH_SHORT).show();
               return true;

            case R.id.mnRead:
                ReadKM();
                Toast.makeText(this, "Đã đọc", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mnExit:
                finish();
                return true;
            default:
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
        }

    }




    private void ReadKM() {
        dataKhuyenMai.clear();
        dataKhuyenMai.addAll(dbKhuyenMai.ReadDbKhuyenMai());
        customAdapterKhuyenMai.notifyDataSetChanged();
    }

    private void SaveKM() {
        for (KhuyenMai khuyenMai : newDataKM){
            dbKhuyenMai.AddKhuyenMaiDB(khuyenMai);
        }
    }


    private void setControl() {
        edtNgayThang = findViewById(R.id.edtNgayThang);
        edtMaKM = findViewById(R.id.edtMaKm);
        edtNoiDung = findViewById(R.id.edtNoiDungMain);

        lvKhuyenMai = findViewById(R.id.lvKhuyenMai);
    }
}