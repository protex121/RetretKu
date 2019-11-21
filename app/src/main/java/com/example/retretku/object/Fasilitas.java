package com.example.retretku.object;

public class Fasilitas {
    private String id_fasilitas,nama_fasilitas, deskripsi_fasilitas;
    private int harga_fasilitas, jumlah_fasilitas;

    public Fasilitas(String id_fasilitas, String nama_fasilitas, String deskripsi_fasilitas, int harga_fasilitas, int jumlah_fasilitas) {
        this.id_fasilitas = id_fasilitas;
        this.nama_fasilitas = nama_fasilitas;
        this.deskripsi_fasilitas = deskripsi_fasilitas;
        this.harga_fasilitas = harga_fasilitas;
        this.jumlah_fasilitas = jumlah_fasilitas;
    }

    public Fasilitas(){}

    public String getId_fasilitas() {
        return id_fasilitas;
    }

    public void setId_fasilitas(String id_fasilitas) {
        this.id_fasilitas = id_fasilitas;
    }

    public String getNama_fasilitas() {
        return nama_fasilitas;
    }

    public void setNama_fasilitas(String nama_fasilitas) {
        this.nama_fasilitas = nama_fasilitas;
    }

    public String getDeskripsi_fasilitas() {
        return deskripsi_fasilitas;
    }

    public void setDeskripsi_fasilitas(String deskripsi_fasilitas) {
        this.deskripsi_fasilitas = deskripsi_fasilitas;
    }

    public int getHarga_fasilitas() {
        return harga_fasilitas;
    }

    public void setHarga_fasilitas(int harga_fasilitas) {
        this.harga_fasilitas = harga_fasilitas;
    }

    public int getJumlah_fasilitas() {
        return jumlah_fasilitas;
    }

    public void setJumlah_fasilitas(int jumlah_fasilitas) {
        this.jumlah_fasilitas = jumlah_fasilitas;
    }
}
