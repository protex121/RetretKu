package com.example.retretku;

import java.util.ArrayList;

public class paket_class {
    private ArrayList<menu_class> list_menu = new ArrayList<menu_class>();
    private String nama;
    private int harga;
    private String deskripsi;

    public void add_menu(menu_class a){
        list_menu.add(a);
    }

    public paket_class(int harga, String nama,String deskripsi) {
        this.harga = harga;
        this.nama = nama;
        this.deskripsi = deskripsi;
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

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public ArrayList<menu_class> getList_menu() {
        return list_menu;
    }

    @Override
    public String toString() {
        return this.nama + " - Rp." + this.harga + ",-";
    }
}
