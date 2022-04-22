package com.example.myapplication.DanhBaFirebase;

public class DanhBaEntity {
    private String ten;
    private String sdt;

    public DanhBaEntity() {
    }

    public DanhBaEntity(String ten, String sdt) {
        this.ten = ten;
        this.sdt = sdt;
    }

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

    @Override
    public String toString() {
        return ten + " " + sdt;
    }
}
