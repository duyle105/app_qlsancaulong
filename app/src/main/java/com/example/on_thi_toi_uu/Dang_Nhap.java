package com.example.on_thi_toi_uu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Dang_Nhap extends AppCompatActivity {
    EditText edtUser, edtPass;
    Button btnDangNhap, btnQuayLai;
    DBBadmintonApp dbBadmintonApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        setControl();
        setEvent();
    }

    private void setEvent() {
        dbBadmintonApp = new DBBadmintonApp(this);

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String user = edtUser.getText().toString();
                    String pass = edtPass.getText().toString();
                    if (dbBadmintonApp.checkUser(user, pass)) {
                        Toast.makeText(Dang_Nhap.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Dang_Nhap.this, Trang_Chu.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(Dang_Nhap.this, "Thông tin đăng nhập không đúng", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception ex) {
                    Log.w("Lỗi", ex.getMessage());
                }
            }
        });
        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void setControl() {
        edtUser = findViewById(R.id.edtUserDangNhap);
        edtPass = findViewById(R.id.edtPassDangNhap);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        btnQuayLai = findViewById(R.id.btnQuayLai);
    }
}