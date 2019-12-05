package com.example.retretku.Objects;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.retretku.R;

import java.util.ArrayList;

public class RumahRetret implements Parcelable {
    int imgAddress;
    String rumah_id;
    String nama, password;
    String notelp;

    ArrayList<Integer> images;

    //Foreign Key
    ArrayList<Transaksi> transaksi;
    ArrayList<Rating> ratings;

    public RumahRetret(int imgAddress, String nama, String password, String notelp) {
        this.imgAddress = R.drawable.person;
        this.nama = nama;
        this.password = password;
        this.notelp = notelp;
        this.images = new ArrayList<>();
        this.transaksi = new ArrayList<>();
        this.ratings = new ArrayList<>();
    }

    public int getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(int imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    public String getRumah_id() {
        return rumah_id;
    }

    public void setRumah_id(String rumah_id) {
        this.rumah_id = rumah_id;
    }

    public ArrayList<Integer> getImages() {
        return images;
    }

    public void setImages(ArrayList<Integer> images) {
        this.images = images;
    }

    public ArrayList<Transaksi> getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(ArrayList<Transaksi> transaksi) {
        this.transaksi = transaksi;
    }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Rating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.imgAddress);
        dest.writeString(this.nama);
        dest.writeString(this.password);
        dest.writeString(this.notelp);
        dest.writeTypedList(this.ratings);
    }

    protected RumahRetret(Parcel in) {
        this.imgAddress = in.readInt();
        this.nama = in.readString();
        this.password = in.readString();
        this.notelp = in.readString();
        this.ratings = in.createTypedArrayList(Rating.CREATOR);
    }

    public static final Creator<RumahRetret> CREATOR = new Creator<RumahRetret>() {
        @Override
        public RumahRetret createFromParcel(Parcel source) {
            return new RumahRetret(source);
        }

        @Override
        public RumahRetret[] newArray(int size) {
            return new RumahRetret[size];
        }
    };
}
