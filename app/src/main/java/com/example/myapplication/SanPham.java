package com.example.myapplication;

public class SanPham {
    private String ten;
    private Integer gia;
    private Integer img;

    SanPham(String ten, Integer gia, Integer img) {
        this.ten = ten;
        this.gia = gia;
        this.img = img;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Integer getGia() {
        return gia;
    }

    public void setGia(Integer gia) {
        this.gia = gia;
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }
}
