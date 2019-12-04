package com.example.retretku.Objects;

import com.example.retretku.Objects.Fasilitas;

public class FasilitasTransaksi {
    private Fasilitas fasilitas;
    private int jml;
    private long subtotal;

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

    public long getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(long subtotal) {
        this.subtotal = subtotal;
    }
}
