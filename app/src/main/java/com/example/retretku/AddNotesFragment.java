package com.example.retretku;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.retretku.AppDatabase.AppDatabaseNotes;
import com.example.retretku.object.Notes;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class AddNotesFragment extends Fragment {

    Button btnadd;
    EditText txtnotes;
    ListView lvnotes;

    AppDatabaseNotes db;
    ArrayAdapter adap;
    List<Notes> listnotes = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.addnotesfragment_layout, container,false);
        btnadd = v.findViewById(R.id.btnadd);
        txtnotes = v.findViewById(R.id.txtnotes);
        lvnotes = v.findViewById(R.id.lvnotes);

        db = Room.databaseBuilder(getContext(), AppDatabaseNotes.class,"notesDB").build();
        getAllNotes();
        adap=new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, listnotes);
        lvnotes.setAdapter(adap);


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String notes = txtnotes.getText().toString();
                Notes n = new Notes("1",notes); //nanti idnya harus ambil dari id retretnya(?)
                new insertNotes().execute(n);
                getAllNotes();
            }
        });


        return v;
    }

    public void getAllNotes(){
        new getAllnotes().execute();
    }

    private class getAllnotes extends AsyncTask<Void,Void,Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            listnotes.clear();
            listnotes.addAll(db.notesDao().getAllnotes());
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adap.notifyDataSetChanged();
        }
    }

    private class insertNotes extends AsyncTask<Notes,Void,Void>{

        @Override
        protected Void doInBackground(Notes... notes) {
            db.notesDao().insert(notes[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toasty.success(getContext(), "Sukses Menambah Notes", Toast.LENGTH_SHORT).show();
        }

    }




}
