package com.example.retretku.Objects;

import java.util.ArrayList;
import java.util.Date;

public class Transaksi {
    //Bagian HTrans
    private String id_trans;
    private Date cin, cout;
    private long total;
    private int status;

    String rumah_id;
    private int jumlah_orang;

    //Bagian DTrans
    private String id_detail;

    //Foreign Key
    private ArrayList<FasilitasTransaksi> fasilitasTransaksi;
    private ArrayList<String> idPaketMakanan;
    private ArrayList<String> idPaketSnack;


    public Transaksi(String id_trans, Date cin, Date cout, long total, int status) {
        this.id_trans = id_trans;
        this.cin = cin;
        this.cout = cout;
        this.total = total;
        this.status = status;
//        this.id_detail = ;
    }

    public String getId_trans() {
        return id_trans;
    }

    public void setId_trans(String id_trans) {
        this.id_trans = id_trans;
    }

    public Date getCin() {
        return cin;
    }

    public void setCin(Date cin) {
        this.cin = cin;
    }

    public Date getCout() {
        return cout;
    }

    public void setCout(Date cout) {
        this.cout = cout;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getId_detail() {
        return id_detail;
    }

    public void setId_detail(String id_detail) {
        this.id_detail = id_detail;
    }

    public ArrayList<FasilitasTransaksi> getFasilitasTransaksi() {
        return fasilitasTransaksi;
    }

    public void setFasilitasTransaksi(ArrayList<FasilitasTransaksi> fasilitasTransaksi) {
        this.fasilitasTransaksi = fasilitasTransaksi;
    }

    public ArrayList<String> getIdPaketMakanan() {
        return idPaketMakanan;
    }

    public void setIdPaketMakanan(ArrayList<String> idPaketMakanan) {
        this.idPaketMakanan = idPaketMakanan;
    }

    public ArrayList<String> getIdPaketSnack() {
        return idPaketSnack;
    }

    public void setIdPaketSnack(ArrayList<String> idPaketSnack) {
        this.idPaketSnack = idPaketSnack;
    }
}
