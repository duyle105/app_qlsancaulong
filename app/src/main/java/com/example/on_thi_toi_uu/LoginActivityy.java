package com.example.on_thi_toi_uu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


import androidx.appcompat.app.AppCompatActivity;

public class LoginActivityy extends AppCompatActivity {

    Button btnDangNhap, btnDangKy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badminton);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivityy.this, Dang_Nhap.class);
                startActivity(intent);
            }
        });

        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivityy.this, Dang_Ky.class);
                startActivity(intent);
            }
        });
    }

    private void setControl() {
        btnDangNhap = findViewById(R.id.btnLogin);
        btnDangKy = findViewById(R.id.btnCreate);
    }
}

