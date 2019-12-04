package com.example.retretku.Object;

import java.util.ArrayList;

public class Katering {
    private String nomor_telpon, alamat, desk, email, password, nama_katering;
    private int stat;
    private ArrayList<Paket> list_paket_makanan;
    private ArrayList<Paket> list_paket_snack;
    private ArrayList<Menu> list_menu;

    public Katering(String nomor_telpon, String desk, String email, String password, String nama_katering, int stat, String alamat) {
        this.nomor_telpon = nomor_telpon;
        this.alamat = alamat;
        this.desk = desk;
        this.email = email;
        this.password = password;
        this.nama_katering = nama_katering;
        this.stat = stat;
        this.list_menu = new ArrayList<>();
        this.list_paket_makanan = new ArrayList<>();
        this.list_paket_snack = new ArrayList<>();
    }

    public String getNomor_telpon() {
        return nomor_telpon;
    }

    public void setNomor_telpon(String nomor_telpon) {
        this.nomor_telpon = nomor_telpon;
    }

    public String getDesk() {
        return desk;
    }

    public void setDesk(String desk) {
        this.desk = desk;
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

    public ArrayList<Paket> getList_paket_makanan() {
        return list_paket_makanan;
    }

    public void setList_paket_makanan(ArrayList<Paket> list_paket_makanan) {
        this.list_paket_makanan = list_paket_makanan;
    }

    public ArrayList<Paket> getList_paket_snack() {
        return list_paket_snack;
    }

    public void setList_paket_snack(ArrayList<Paket> list_paket_snack) {
        this.list_paket_snack = list_paket_snack;
    }

    public ArrayList<Menu> getList_menu() {
        return list_menu;
    }

    public void setList_menu(ArrayList<Menu> list_menu) {
        this.list_menu = list_menu;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
