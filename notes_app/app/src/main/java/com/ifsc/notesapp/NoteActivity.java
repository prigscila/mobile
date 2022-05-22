package com.ifsc.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ifsc.notesapp.controller.NoteController;
import com.ifsc.notesapp.model.Note;

public class NoteActivity extends AppCompatActivity {
    NoteController noteController;
    EditText titleField, textField;
    Note note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        noteController = new NoteController(getApplicationContext());

        titleField = findViewById(R.id.titleEdit);
        textField = findViewById(R.id.textEdit);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            Integer noteId = bundle.getInt("noteId");
            note = noteController.getNote(noteId);
        } else {
            note = new Note(titleField.getText().toString(), textField.getText().toString());
        }
    }

    public void saveNote(View v) {
        Note noteToSave = new Note(titleField.getText().toString(), textField.getText().toString());
        if (note.getId()!=null) {
            noteController.updateNote(noteToSave);
            Toast.makeText(this, "Note was updated successfully!", Toast.LENGTH_SHORT).show();
        } else {
            noteController.createNote(noteToSave);
            Toast.makeText(this, "Created a new note!", Toast.LENGTH_SHORT).show();
        }
    }

    protected void onResume() {
        super.onResume();
        titleField.setText(note.getTitle());
        textField.setText(note.getText());
    }
}