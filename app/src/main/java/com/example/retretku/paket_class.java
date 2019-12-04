package com.example.retretku;

import java.util.ArrayList;

public class paket_class {
    private String id;
    private ArrayList<String> list_menu = new ArrayList<String>();
    private String nama;
    private int harga;
    private String deskripsi;
    private int jenis;

    public void add_menu(String a){
        list_menu.add(a);
    }

    public paket_class(String id,int harga, String nama,String deskripsi,int jenis) {
        this.id = id;
        this.harga = harga;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.jenis = jenis;
    }

    public int getJenis() {
        return jenis;
    }

    public void setJenis(int jenis) {
        this.jenis = jenis;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public ArrayList<String> getList_menu() {
        return list_menu;
    }

    @Override
    public String toString() {
        return this.nama + " - Rp." + this.harga + ",-";
    }
}
