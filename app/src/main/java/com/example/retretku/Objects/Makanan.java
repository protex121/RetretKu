package com.example.retretku.Objects;

class Makanan {
    String id_makanan, nama, deskripsi;

    public Makanan(String id_makanan, String nama, String deskripsi) {
        this.id_makanan = id_makanan;
        this.nama = nama;
        this.deskripsi = deskripsi;
    }

    public String getId_makanan() {
        return id_makanan;
    }

    public void setId_makanan(String id_makanan) {
        this.id_makanan = id_makanan;
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
