package com.example.on_thi_toi_uu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class Trang_Chu extends AppCompatActivity {
    Button btnThemSan;
    ListView lvDanhSach;
    DBBadmintonApp dbBadmintonApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);

        setControl();
        setEvent();
    }

    private void setEvent() {
        btnThemSan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Trang_Chu.this, DatSanActivity.class);
                startActivity(intent);
            }
        });

    }

    private void setControl() {
        btnThemSan = findViewById(R.id.btnDatSanTrangChu);
        lvDanhSach = findViewById(R.id.lvDanhSach);
    }
}