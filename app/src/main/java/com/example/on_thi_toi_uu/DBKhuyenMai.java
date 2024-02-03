package com.example.on_thi_toi_uu;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBKhuyenMai extends SQLiteOpenHelper {
    public DBKhuyenMai(@Nullable Context context) {
        super(context, "tbKhuyenMai", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE tbKhuyenMai(NgayThang TEXT, NoiDung TEXT, MaKM TEXT, ImgKhuyenMai TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void AddKhuyenMaiDB(KhuyenMai khuyenMai) {
        String sql = "INSERT INTO tbKhuyenMai VALUES(?, ?, ?, ?)";
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql, new String[]{khuyenMai.getNgayThang(), khuyenMai.getNoiDung(), khuyenMai.getMaKM(), khuyenMai.getImgKM()});
    }

    public ArrayList<KhuyenMai> ReadDbKhuyenMai() {
        ArrayList<KhuyenMai> data = new ArrayList<>();
        String sql = "SELECT * FROM tbKhuyenMai";
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                KhuyenMai khuyenMai = new KhuyenMai();
                khuyenMai.setNgayThang(cursor.getString(0));
                khuyenMai.setNoiDung(cursor.getString(1));
                khuyenMai.setMaKM(cursor.getString(2));
                khuyenMai.setImgKM(cursor.getString(3));

                data.add(khuyenMai);
            } while (cursor.moveToNext());
        }
        return data;
    }
}
