package com.ifsc.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ifsc.notesapp.controller.NoteController;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
    }

    public void addNote(View v) {
        Intent intent = new Intent(this, NoteActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        NoteController noteController = new NoteController(this);
        ArrayList<String> notesTitles = noteController.getNotesTitles();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                notesTitles);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(
                    getApplicationContext(),
                    Long.toString(parent.getItemIdAtPosition(position)),
                    Toast.LENGTH_LONG
                ).show();

                Intent intent = new Intent(getApplicationContext(), NoteActivity.class);
                intent.putExtra("noteId", noteController.listNotes().get(position).getId());

                startActivity(intent);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                dialogBuilder.setTitle("Warning!");
                dialogBuilder.setMessage("Delete note?");
                dialogBuilder.setNegativeButton("No", null);
                dialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        noteController.deleteNote(noteController.listNotes().get(position));
                        onResume();
                    }
                });
                dialogBuilder.show();
                return true;
            }
        });
    }
}