package com.example.retretku.Object;

import java.util.ArrayList;

public class Paket {
    private String nama, deskripsi;
    private int harga;
    private ArrayList<Menu> list_menu;

    public Paket(String nama, String deskripsi, int harga) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.list_menu = new ArrayList<>();
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

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public ArrayList<Menu> getList_menu() {
        return list_menu;
    }

    public void setList_menu(ArrayList<Menu> list_menu) {
        this.list_menu = list_menu;
    }

    @Override
    public String toString() {
        return nama + " - " + harga;
    }
}
