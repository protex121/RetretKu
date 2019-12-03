package com.example.retretku;

import com.example.retretku.Objects.Fasilitas;

public class FasilitasTransaksi {
    Fasilitas fasilitas;
    int jml;
    long subtotal;

    public FasilitasTransaksi(Fasilitas fasilitas, int jml) {
        this.fasilitas = fasilitas;
        this.jml = jml;
        this.subtotal = fasilitas.getHarga() * jml;
    }

    public Fasilitas getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(Fasilitas fasilitas) {
        this.fasilitas = fasilitas;
    }

    public int getJml() {
        return jml;
    }

    public void setJml(int jml) {
        this.jml = jml;
    }
}
