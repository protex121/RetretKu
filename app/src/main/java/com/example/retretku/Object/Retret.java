package com.example.retretku.Object;

public class Retret {
    //class untuk mengatur acara retret
    private String id_retret,deksripsi;

    public Retret(String id_retret, String deskripsi) {
        this.id_retret = id_retret;
        this.deksripsi = deskripsi;
    }

    public Retret(){}

    public String getId_retret() {
        return id_retret;
    }

    public void setId_retret(String id_retret) {
        this.id_retret = id_retret;
    }

    public String getDeksripsi() {
        return deksripsi;
    }

    public void setDeksripsi(String deksripsi) {
        this.deksripsi = deksripsi;
    }
}
