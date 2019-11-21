package com.example.retretku;

import android.os.Parcel;
import android.os.Parcelable;

public class Rating implements Parcelable {
    User rater;
    float rating;

    public Rating(User rater, float rating) {
        this.rater = rater;
        this.rating = rating;
    }

    protected Rating(Parcel in) {
        rating = in.readFloat();
    }

    public static final Creator<Rating> CREATOR = new Creator<Rating>() {
        @Override
        public Rating createFromParcel(Parcel in) {
            return new Rating(in);
        }

        @Override
        public Rating[] newArray(int size) {
            return new Rating[size];
        }
    };

    public User getRater() {
        return rater;
    }

    public void setRater(User rater) {
        this.rater = rater;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(rating);
    }
}
