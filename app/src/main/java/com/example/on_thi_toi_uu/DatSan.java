package com.example.on_thi_toi_uu;

public class DatSan {
    private String ngayDanKy, hoTenKH, soDienThoai, imgLoaiKhach, maSan;

    public DatSan() {
    }

    public DatSan(String ngayDanKy, String hoTenKH, String soDienThoai, String imgLoaiKhach, String maSan) {
        this.ngayDanKy = ngayDanKy;
        this.hoTenKH = hoTenKH;
        this.soDienThoai = soDienThoai;
        this.imgLoaiKhach = imgLoaiKhach;
        this.maSan = maSan;
    }

    public String getNgayDanKy() {
        return ngayDanKy;
    }

    public void setNgayDanKy(String ngayDanKy) {
        this.ngayDanKy = ngayDanKy;
    }

    public String getHoTenKH() {
        return hoTenKH;
    }

    public void setHoTenKH(String hoTenKH) {
        this.hoTenKH = hoTenKH;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getImgLoaiKhach() {
        return imgLoaiKhach;
    }

    public void setImgLoaiKhach(String imgLoaiKhach) {
        this.imgLoaiKhach = imgLoaiKhach;
    }

    public String getMaSan() {
        return maSan;
    }

    public void setMaSan(String phuongTien) {
        this.maSan = maSan;
    }

    @Override
    public String toString() {
        return "DangKyTour{" +
                "ngayDanKy='" + ngayDanKy + '\'' +
                ", hoTenKH='" + hoTenKH + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", imgLoaiKhach='" + imgLoaiKhach + '\'' +
                ", phuongTien='" + maSan + '\'' +
                '}';
    }
}
