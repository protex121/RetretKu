package com.example.retretku;

import java.util.ArrayList;

public class katering_class {
    private ArrayList<String> list_paket_makanan = new ArrayList<String>();
    private ArrayList<String> list_paket_snack = new ArrayList<String>();
    private ArrayList<String> list_menu = new ArrayList<String>();
    private String email;
    private String password;
    private String nama_katering;
    private int stat;
    private String desk;
    private String nomor_telpon;

    public katering_class(String email, String password, String nama_katering, String desk, String nomor_telpon) {
        this.email = email;
        this.password = password;
        this.nama_katering = nama_katering;
        this.desk = desk;
        this.nomor_telpon = nomor_telpon;
        this.stat = 0;
    }

    public ArrayList<String> getList_menu() {
        return list_menu;
    }

    public void add_menu(String a) {
        this.list_menu.add(a);
    }

    public ArrayList<String> getList_paket_snack() {
        return list_paket_snack;
    }

    public void add_paket_snack(String a) {
        this.list_paket_snack.add(a);
    }

    public ArrayList<String> getList_paket_makanan() {
        return list_paket_makanan;
    }

    public void add_paket_makanan(String a) {
        this.list_paket_makanan.add(a);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama_katering() {
        return nama_katering;
    }

    public void setNama_katering(String nama_katering) {
        this.nama_katering = nama_katering;
    }

    public int getStat() {
        return stat;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }

    public String getDesk() {
        return desk;
    }

    public void setDesk(String desk) {
        this.desk = desk;
    }

    public String getNomor_telpon() {
        return nomor_telpon;
    }

    public void setNomor_telpon(String nomor_telpon) {
        this.nomor_telpon = nomor_telpon;
    }
}