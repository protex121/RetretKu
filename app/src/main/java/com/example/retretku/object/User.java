package com.example.retretku.object;

public class User {
    private String id_user, password_user, nama_user, telp_user, email_user;
    private int status; //1.Admin 2.User

    public User(String id_user, String password_user, String nama_user, String telp_user, int status, String email_user) {
        this.id_user = id_user;
        this.password_user = password_user;
        this.nama_user = nama_user;
        this.telp_user = telp_user;
        this.status = status;
        this.email_user = email_user;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getPassword_user() {
        return password_user;
    }

    public void setPassword_user(String password_user) {
        this.password_user = password_user;
    }

    public String getNama_user() {
        return nama_user;
    }

    public void setNama_user(String nama_user) {
        this.nama_user = nama_user;
    }

    public String getTelp_user() {
        return telp_user;
    }

    public void setTelp_user(String telp_user) {
        this.telp_user = telp_user;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }
}
