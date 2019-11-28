package com.example.retretku.AppDatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.retretku.Dao.NotesDao;
import com.example.retretku.object.Notes;

@Database(entities = {Notes.class},version=1,exportSchema = false)
public abstract class AppDatabaseNotes extends RoomDatabase {
    public abstract NotesDao notesDao();
}
