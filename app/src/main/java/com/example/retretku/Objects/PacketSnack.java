package com.example.retretku.Objects;

import java.util.ArrayList;

class PacketSnack {
    String id_packetSnack;
    String nama, deskripsi;
    long harga;
    ArrayList<Snack> snacks;

    public PacketSnack(String id_packetSnack, String nama, String deskripsi, long harga, ArrayList<Snack> snack) {
        this.id_packetSnack = id_packetSnack;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.snacks = new ArrayList<>();
    }

    public String getId_packetSnack() {
        return id_packetSnack;
    }

    public void setId_packetSnack(String id_packetSnack) {
        this.id_packetSnack = id_packetSnack;
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

    public ArrayList<Snack> getSnack() {
        return snacks;
    }

    public void setSnack(ArrayList<Snack> snack) {
        this.snacks = snack;
    }
}
