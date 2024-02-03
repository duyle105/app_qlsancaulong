package com.example.on_thi_toi_uu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBBadmintonApp extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "badminton_app";
    private static final int DATABASE_VERSION = 1;

    //Tạo database đăng ký, đăng nhập
    private static final String TABLE_USERS = "users";
    private static final String COLUMN_USERS = "username";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_CONFIRMPASS = "confirmpass";


    public DBBadmintonApp(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_USERS =
                "CREATE TABLE " + TABLE_USERS + " ("
                        + COLUMN_USERS + " TEXT,"
                        + COLUMN_PHONE + " TEXT,"
                        + COLUMN_PASSWORD + " TEXT,"
                        + COLUMN_CONFIRMPASS + " TEXT"
                        + " )";
        db.execSQL(SQL_CREATE_USERS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);


    }

    //Thêm người dùng vào cơ sở dữ liệu đăng ký
    public void addUsers(TaiKhoan taiKhoan) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERS, taiKhoan.user);
        values.put(COLUMN_PHONE, taiKhoan.phone);
        values.put(COLUMN_PASSWORD, taiKhoan.pass);
        values.put(COLUMN_CONFIRMPASS, taiKhoan.confirmPass);
        db.insert(TABLE_USERS, null, values);
    }

    //Kiểm tra thông tin đăng nhập người dùng
    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + COLUMN_USERS + " FROM " + TABLE_USERS + " WHERE " + COLUMN_USERS + " = " + username + " AND " + COLUMN_PASSWORD + " = " + password, null);
        return cursor.moveToFirst();
    }
}
