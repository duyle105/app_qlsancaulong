package com.example.on_thi_toi_uu;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBDatSan extends SQLiteOpenHelper {
    public DBDatSan(@Nullable Context context) {
        super(context, "dbDatSan", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE tbDatSan(NgayDangKy TEXT, HoTen TEXT, SoDienThoai TEXT PRIMARY KEY, ImgLoaiKhach TEXT, MaSan TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void AddDatSanDB(DatSan datSan) {
        String sql = "INSERT INTO tbDatSan VALUES(?, ?, ?, ?, ?)";
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql, new String[]{datSan.getNgayDanKy(), datSan.getHoTenKH(), datSan.getSoDienThoai(), datSan.getImgLoaiKhach(), datSan.getMaSan()});
    }

    public void deleteDatSan(DatSan datSan) {
        SQLiteDatabase db = this.getWritableDatabase();
        String whereClause = "SoDienThoai"; // Thay "id" bằng tên cột khóa chính
        String[] whereArgs = {String.valueOf(datSan.getSoDienThoai())}; // Thay "id" bằng tên cột khóa chính

        // Thực hiện câu lệnh DELETE
        int rowsAffected = db.delete("tbDatSan", whereClause, whereArgs); // Thay "TenBang" bằng tên bảng

        // Xử lý kết quả nếu cần
        if (rowsAffected > 0) {
            Log.d("DatabaseHelper", "Dữ liệu đã được xóa thành công.");
        } else {
            Log.d("DatabaseHelper", "Không có dữ liệu nào được xóa.");
        }

        // Đóng kết nối đến cơ sở dữ liệu
        db.close();
    }

    public ArrayList<DatSan> ReadDB(){
        ArrayList<DatSan> data = new ArrayList<>();
        String sql = "SELECT * FROM tbDatSan";
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery(sql, null);
        if (cursor.moveToFirst()){
            do {
                DatSan datSan = new DatSan();
                datSan.setNgayDanKy(cursor.getString(0));
                datSan.setHoTenKH(cursor.getString(1));
                datSan.setSoDienThoai(cursor.getString(2));
                datSan.setImgLoaiKhach(cursor.getString(3));
                datSan.setMaSan(cursor.getString(4));
                data.add(datSan);
            }while (cursor.moveToNext());
        }
        return  data;
    }
}
