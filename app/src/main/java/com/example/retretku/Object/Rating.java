package com.example.retretku.Object;

public class Rating {
    private String id_rating, id_user;
    private float rating;

    public Rating(String id_rating, String id_user, float rating) {
        this.id_rating = id_rating;
        this.id_user = id_user;
        this.rating = rating;
    }

    public Rating() {}

    public String getId_rating() {
        return id_rating;
    }

    public void setId_rating(String id_rating) {
        this.id_rating = id_rating;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
