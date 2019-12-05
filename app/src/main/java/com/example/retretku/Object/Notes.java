package com.example.retretku.Object;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Notes {
    @NonNull
    @PrimaryKey(autoGenerate = false)
    private String id_notes;


    @ColumnInfo(name="keterangan")
    private String keterangan;

    public Notes(@NonNull String id_notes, String keterangan) {
        this.id_notes = id_notes;
        this.keterangan = keterangan;
    }

    @NonNull
    public String getId_notes() {
        return id_notes;
    }

    public void setId_notes(@NonNull String id_notes) {
        this.id_notes = id_notes;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @NonNull
    @Override
    public String toString() {
        return this.keterangan;
    }


}
