package com.example.retretku.Object;

public class Contact {
    private String nama, jenis, telepon;

    public Contact(String nama, String jenis, String telepon) {
        this.nama = nama;
        this.jenis = jenis;
        this.telepon = telepon;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    @Override
    public String toString() {
        return nama + " - " + jenis + " - " + telepon;
    }
}
