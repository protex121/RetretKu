package com.example.retretku.Objects;

import android.os.Parcel;
import android.os.Parcelable;

public class Rating implements Parcelable {
    RumahRetret rater;
    float rating;

    public Rating(RumahRetret rater, float rating) {
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

    public RumahRetret getRater() {
        return rater;
    }

    public void setRater(RumahRetret rater) {
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
