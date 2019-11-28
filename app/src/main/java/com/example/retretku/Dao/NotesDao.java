package com.example.retretku.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.retretku.object.Notes;

import java.util.List;

@Dao
public interface NotesDao {
    @Insert
    void insert(Notes n);

    @Delete
    void delete(Notes n);

    @Query("SELECT * FROM notes")
    List<Notes> getAllnotes();
}
