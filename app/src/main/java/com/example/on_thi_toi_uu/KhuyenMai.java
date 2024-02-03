package com.example.on_thi_toi_uu;

import java.io.Serializable;

public class KhuyenMai implements Serializable {
    protected String maKM;
    protected String noiDung;
    protected String ngayThang;
    protected String imgKM;

    public KhuyenMai() {
    }

    public KhuyenMai(String maKM, String noiDung, String ngayThang, String imgKM) {
        this.maKM = maKM;
        this.noiDung = noiDung;
        this.ngayThang = ngayThang;
        this.imgKM = imgKM;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getImgKM() {
        return imgKM;
    }

    public void setImgKM(String imgKM) {
        this.imgKM = imgKM;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNgayThang() {
        return ngayThang;
    }

    public void setNgayThang(String ngayThang) {
        this.ngayThang = ngayThang;
    }

    @Override
    public String toString() {
        return "KhuyenMai{" +
                "maKM='" + maKM + '\'' +
                ", noiDung='" + noiDung + '\'' +
                ", ngayThang='" + ngayThang + '\'' + "imgKM='" +imgKM+
                '}';
    }
}
