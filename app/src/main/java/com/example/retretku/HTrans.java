package com.example.retretku;

import java.util.Date;

public class HTrans {
    String id_trans;
    Date cin, cout;
    long total;
    int status;

    public HTrans(String id_trans, Date cin, Date cout, long total, int status) {
        this.id_trans = id_trans;
        this.cin = cin;
        this.cout = cout;
        this.total = total;
        this.status = status;
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
}
