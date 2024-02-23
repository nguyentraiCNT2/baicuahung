package com.example.le_dinh_hung_2110900025.Ledinhhung.beans;

public class Ledinhhung_2110900025_Product {
    private String masp;
    private String tensp;
    private int soluong;
    private float dongia;
    private String anh;

    public Ledinhhung_2110900025_Product() {
    }

    public Ledinhhung_2110900025_Product(String masp, String tensp, int soluong, float dongia, String anh) {
        this.masp = masp;
        this.tensp = tensp;
        this.soluong = soluong;
        this.dongia = dongia;
        this.anh = anh;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
}
