package com.example.on_thi_toi_uu;

import java.io.Serializable;

public class TaiKhoan implements Serializable {
    String user, phone, pass, confirmPass;

    //constructor
    public TaiKhoan(){
    }
    public TaiKhoan(String user, String phone, String pass, String confirmPass) {
        this.user = user;
        this.phone = phone;
        this.pass = pass;
        this.confirmPass = confirmPass;
    }

    //get, set
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }

    //toString
    @Override
    public String toString() {
        return "TaiKhoan{" +
                "user='" + user + '\'' +
                ", phone='" + phone + '\'' +
                ", pass='" + pass + '\'' +
                ", confirmPass='" + confirmPass + '\'' +
                '}';
    }
}
