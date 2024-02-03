package com.example.on_thi_toi_uu;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Dang_Ky extends AppCompatActivity {
    EditText edtUser, edtPhone, edtPass, edtConfirmPass;
    Button btnDangKy, btnQuayLai;
    DBBadmintonApp dbBadmintonApp = new DBBadmintonApp(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaiKhoan taiKhoan = new TaiKhoan();
                taiKhoan.setUser(edtUser.getText().toString());
                taiKhoan.setPhone(edtPhone.getText().toString());
                taiKhoan.setPass(edtPass.getText().toString());
                taiKhoan.setConfirmPass(edtConfirmPass.getText().toString());
                dbBadmintonApp.addUsers(taiKhoan);
                Toast.makeText(Dang_Ky.this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Dang_Ky.this, LoginActivityy.class);
                startActivity(intent);
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
        edtUser = findViewById(R.id.edtUserDangKy);
        edtPhone = findViewById(R.id.edtPhone);
        edtPass = findViewById(R.id.edtPassDangKy);
        edtConfirmPass = findViewById(R.id.edtConfirmPass);
        btnDangKy = findViewById(R.id.btnDangKy);
        btnQuayLai = findViewById(R.id.btnQuayLai);
    }
}