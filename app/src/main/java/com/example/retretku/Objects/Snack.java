package com.example.retretku.Objects;

class Snack {
    String id_snack, nama, deskripsi;

    public Snack(String id_snack, String nama, String deskripsi) {
        this.id_snack = id_snack;
        this.nama = nama;
        this.deskripsi = deskripsi;
    }

    public String getId_snack() {
        return id_snack;
    }

    public void setId_snack(String id_snack) {
        this.id_snack = id_snack;
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
}
