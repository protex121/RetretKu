package com.example.retretku.object;

import android.os.Parcel;
import android.os.Parcelable;

public class RumahRetret implements Parcelable {
    private String rumah_id,rumah_nama,rumah_email,rumah_pass,rumah_alamat;
    private int rumah_rating,rumah_status,rumah_kapasitas;
    private String rumah_deskripsi;

    private double longitude,latitude;

    //nanti constructornya diganti
    public RumahRetret(String rumah_id, String rumah_nama, String rumah_email,String rumah_pass, String rumah_alamat, double longitude,double latitude) {
        this.rumah_id = rumah_id;
        this.rumah_nama = rumah_nama;
        this.rumah_pass = rumah_pass;
        this.rumah_alamat = rumah_alamat;
        this.latitude = latitude;
        this.longitude = longitude;
        this.rumah_email = rumah_email;
    }

    public RumahRetret(){}

    protected RumahRetret(Parcel in) {
        rumah_id = in.readString();
        rumah_nama = in.readString();
        rumah_email = in.readString();
        rumah_pass = in.readString();
        rumah_alamat = in.readString();
        rumah_rating = in.readInt();
        rumah_status = in.readInt();
        rumah_kapasitas = in.readInt();
        rumah_deskripsi = in.readString();
        longitude = in.readDouble();
        latitude = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(rumah_id);
        dest.writeString(rumah_nama);
        dest.writeString(rumah_email);
        dest.writeString(rumah_pass);
        dest.writeString(rumah_alamat);
        dest.writeInt(rumah_rating);
        dest.writeInt(rumah_status);
        dest.writeInt(rumah_kapasitas);
        dest.writeString(rumah_deskripsi);
        dest.writeDouble(longitude);
        dest.writeDouble(latitude);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<RumahRetret> CREATOR = new Creator<RumahRetret>() {
        @Override
        public RumahRetret createFromParcel(Parcel in) {
            return new RumahRetret(in);
        }

        @Override
        public RumahRetret[] newArray(int size) {
            return new RumahRetret[size];
        }
    };

    public String getRumah_id() {
        return rumah_id;
    }

    public void setRumah_id(String rumah_id) {
        this.rumah_id = rumah_id;
    }

    public String getRumah_nama() {
        return rumah_nama;
    }

    public void setRumah_nama(String rumah_nama) {
        this.rumah_nama = rumah_nama;
    }

    public String getRumah_pass() {
        return rumah_pass;
    }

    public void setRumah_pass(String rumah_pass) {
        this.rumah_pass = rumah_pass;
    }

    public String getRumah_alamat() {
        return rumah_alamat;
    }

    public void setRumah_alamat(String rumah_alamat) {
        this.rumah_alamat = rumah_alamat;
    }

    public int getRumah_rating() {
        return rumah_rating;
    }

    public void setRumah_rating(int rumah_rating) {
        this.rumah_rating = rumah_rating;
    }

    public int getRumah_status() {
        return rumah_status;
    }

    public void setRumah_status(int rumah_status) {
        this.rumah_status = rumah_status;
    }

    public int getRumah_kapasitas() {
        return rumah_kapasitas;
    }

    public void setRumah_kapasitas(int rumah_kapasitas) {
        this.rumah_kapasitas = rumah_kapasitas;
    }

    public String getRumah_deskripsi() {
        return rumah_deskripsi;
    }

    public void setRumah_deskripsi(String rumah_deskripsi) {
        this.rumah_deskripsi = rumah_deskripsi;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getRumah_email() {
        return rumah_email;
    }

    public void setRumah_email(String rumah_email) {
        this.rumah_email = rumah_email;
    }

    @Override
    public String toString() {
        return this.rumah_nama;
    }
}
