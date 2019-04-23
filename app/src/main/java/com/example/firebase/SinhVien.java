package com.example.firebase;

import java.io.Serializable;

public class SinhVien implements Serializable {
    public String ten;
    public String sdt;
    public Integer tuoi;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(Integer tuoi) {
        this.tuoi = tuoi;
    }

    public SinhVien(String ten, String sdt, Integer tuoi) {
        this.ten = ten;
        this.sdt = sdt;
        this.tuoi = tuoi;
    }

    public SinhVien() {

    }
}
