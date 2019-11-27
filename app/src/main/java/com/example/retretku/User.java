package com.example.retretku;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    int imgAddress;
    String nama, password;
    String notelp;

    public User(int imgAddress, String nama, String password, String notelp) {
        this.imgAddress = R.drawable.person;
        this.nama = nama;
        this.password = password;
        this.notelp = notelp;
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

    protected User(Parcel in) {
        imgAddress = in.readInt();
        nama = in.readString();
        password = in.readString();
        notelp = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imgAddress);
        parcel.writeString(nama);
        parcel.writeString(password);
        parcel.writeString(notelp);
    }
}
