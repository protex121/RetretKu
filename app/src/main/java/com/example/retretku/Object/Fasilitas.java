package com.example.retretku.Object;

public class Fasilitas {
    private String id_fasilitas,nama_fasilitas, deskripsi_fasilitas;
    private long harga_fasilitas;
    private int jumlah_fasilitas;

    public Fasilitas(String nama_fasilitas, String deskripsi_fasilitas, long harga_fasilitas, int jumlah_fasilitas) {
//        this.id_fasilitas = id_fasilitas;
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

    public long getHarga_fasilitas() {
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
