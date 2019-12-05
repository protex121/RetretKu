package com.example.retretku.Object;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.retretku.Objects.Rating;
import com.example.retretku.Objects.Transaksi;

import java.util.ArrayList;

public class RumahRetret implements Parcelable {
    private Integer mainImage;
    private String rumah_id,rumah_nama,rumah_email,rumah_pass,rumah_alamat, rumah_notelp;
    private int rumah_status,rumah_kapasitas;
    private float rumah_rating;
    private String rumah_deskripsi;

    private double longitude,latitude;

    //Gallery
    ArrayList<Integer> images;

    //Foreign Key
    ArrayList<Fasilitas> fasilitas;
    ArrayList<Transaksi> transaksi;
    ArrayList<Rating> ratings;

    //nanti constructornya diganti
    public RumahRetret(String rumah_id, String rumah_nama, String rumah_email,String rumah_pass, String rumah_alamat, String rumah_notelp, double longitude,double latitude, int kapasitas) {
        this.rumah_id = rumah_id;
        this.rumah_nama = rumah_nama;
        this.rumah_email = rumah_email;
        this.rumah_pass = rumah_pass;
        this.rumah_alamat = rumah_alamat;
        this.rumah_notelp = rumah_notelp;
        this.rumah_rating = 0;
        this.rumah_status = 1;
        this.rumah_kapasitas = 0;
        this.rumah_deskripsi = "This user has not set their description yet!";
        this.latitude = latitude;
        this.longitude = longitude;
        this.images = new ArrayList<>();
        this.fasilitas = new ArrayList<>();
        this.transaksi = new ArrayList<>();
        this.ratings = new ArrayList<>();
        this.rumah_kapasitas = kapasitas;
    }
    public RumahRetret(String rumah_id, String rumah_nama, String rumah_email,String rumah_pass, String rumah_alamat, String rumah_notelp, double longitude,double latitude) {
        this.rumah_id = rumah_id;
        this.rumah_nama = rumah_nama;
        this.rumah_email = rumah_email;
        this.rumah_pass = rumah_pass;
        this.rumah_alamat = rumah_alamat;
        this.rumah_notelp = rumah_notelp;
        this.rumah_rating = 0;
        this.rumah_status = 1;
        this.rumah_kapasitas = 0;
        this.rumah_deskripsi = "This user has not set their description yet!";
        this.latitude = latitude;
        this.longitude = longitude;
        this.images = new ArrayList<>();
        this.fasilitas = new ArrayList<>();
        this.transaksi = new ArrayList<>();
        this.ratings = new ArrayList<>();
    }

    public RumahRetret(){}

    public Integer getMainImage() {
        return mainImage;
    }

    public void setMainImage(Integer mainImage) {
        this.mainImage = mainImage;
    }

    public String getRumah_notelp() {
        return rumah_notelp;
    }

    public void setRumah_notelp(String rumah_notelp) {
        this.rumah_notelp = rumah_notelp;
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

    public float getRumah_rating() {
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

    public ArrayList<Fasilitas> getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(ArrayList<Fasilitas> fasilitas) {
        this.fasilitas = fasilitas;
    }

    @Override
    public String toString() {
        return this.rumah_nama;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.mainImage);
        dest.writeString(this.rumah_id);
        dest.writeString(this.rumah_nama);
        dest.writeString(this.rumah_email);
        dest.writeString(this.rumah_pass);
        dest.writeString(this.rumah_alamat);
        dest.writeFloat(this.rumah_rating);
        dest.writeInt(this.rumah_status);
        dest.writeInt(this.rumah_kapasitas);
        dest.writeString(this.rumah_deskripsi);
        dest.writeDouble(this.longitude);
        dest.writeDouble(this.latitude);
        dest.writeList(this.images);
        dest.writeList(this.transaksi);
        dest.writeTypedList(this.ratings);
    }

    protected RumahRetret(Parcel in) {
        this.mainImage = (Integer) in.readValue(Integer.class.getClassLoader());
        this.rumah_id = in.readString();
        this.rumah_nama = in.readString();
        this.rumah_email = in.readString();
        this.rumah_pass = in.readString();
        this.rumah_alamat = in.readString();
        this.rumah_rating = in.readInt();
        this.rumah_status = in.readInt();
        this.rumah_kapasitas = in.readInt();
        this.rumah_deskripsi = in.readString();
        this.longitude = in.readDouble();
        this.latitude = in.readDouble();
        this.images = new ArrayList<Integer>();
        in.readList(this.images, Integer.class.getClassLoader());
        this.transaksi = new ArrayList<Transaksi>();
        in.readList(this.transaksi, Transaksi.class.getClassLoader());
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
