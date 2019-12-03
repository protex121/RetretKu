package com.example.retretku.Objects;

import java.util.ArrayList;

class PacketMakanan {
    String id_packetMakanan;
    String nama, deskripsi;
    long harga;
    ArrayList<Makanan> menu;

    public PacketMakanan(String id_packetMakanan, String nama, String deskripsi, long harga) {
        this.id_packetMakanan = id_packetMakanan;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.menu = new ArrayList<>();
    }

    public String getId_packetMakanan() {
        return id_packetMakanan;
    }

    public void setId_packetMakanan(String id_packetMakanan) {
        this.id_packetMakanan = id_packetMakanan;
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

    public long getHarga() {
        return harga;
    }

    public void setHarga(long harga) {
        this.harga = harga;
    }

    public ArrayList<Makanan> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<Makanan> menu) {
        this.menu = menu;
    }
}
