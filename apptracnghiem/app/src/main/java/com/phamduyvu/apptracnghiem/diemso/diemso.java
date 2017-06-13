package com.phamduyvu.apptracnghiem.diemso;

/**
 * Created by T-420 on 29/05/2017.
 */

public class diemso {
    private int id;
    private String ten;
    private int diem;
    private String ngay;

    public diemso(String ten, int diem) {
        this.ten = ten;
        this.diem = diem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }
}
