package com.example.retretku.Object;

public class Menu {
    private String nama, deskripsi;
    private int tipe;

    public Menu(String nama, String deskripsi, int tipe) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.tipe = tipe;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getTipe() {
        return tipe;
    }

    public void setTipe(int tipe) {
        this.tipe = tipe;
    }

    @Override
    public String toString() {
        return nama + " - " + tipe;
    }
}
