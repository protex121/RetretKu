package com.example.retretku;

public class menu_class {
    private String nama;
    private String deskripsi;
    private int tipe;

    public menu_class(String nama, int tipe, String deskiripsi) {
        this.nama = nama;
        this.tipe = tipe;
        this.deskripsi = deskiripsi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getTipe() {
        return tipe;
    }

    public void setTipe(int tipe) {
        this.tipe = tipe;
    }

    @Override
    public String toString() {
        return this.nama + " - " + this.deskripsi;
    }
}
