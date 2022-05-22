package com.ifsc.notesapp.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NoteDao {
    Context context;
    SQLiteDatabase database;
    private String NOTES_TABLE = "notes";

    public NoteDao(Context context) {
        this.context = context;
        database = context.openOrCreateDatabase("notesdb", Context.MODE_PRIVATE, null);

        database.execSQL(
            "CREATE TABLE IF NOT EXISTS " + NOTES_TABLE + " (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "title varchar," +
            "text varchar)"
        );
    }

    public Note addNote(Note note) {
        if (note.getId() == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("title", note.getTitle());
            contentValues.put("text", note.getText());

            long id = database.insert(NOTES_TABLE, null, contentValues);
            note.setId((int) id);
        }

        return note;
    }

    public ArrayList<Note> getNotes() {
        Cursor cursor = database.rawQuery("SELECT * FROM " + NOTES_TABLE, null);
        cursor.moveToFirst();

        ArrayList<Note> notes = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            Note nota = new Note(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2)
            );
            notes.add(nota);
            cursor.moveToNext();
        }

        return notes;
    }

    public Note getNoteById(Integer id) {
        Cursor cursor = this.database.rawQuery(
            "SELECT * FROM " + NOTES_TABLE + " WHERE id=?",
            new String [] {Integer.toString(id)}
        );

        cursor.moveToFirst();
        return new Note(
            cursor.getInt(0),
            cursor.getString(1),
            cursor.getString(2)
        );
    }

    public boolean updateNote(Note note) {
        if (note.getId() != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("title", note.getTitle());
            contentValues.put("text", note.getText());

            database.update(NOTES_TABLE, contentValues, "id=?", new String[] { Integer.toString(note.getId()) });

            return  true;
        }

        return  false;
    }

    public boolean removeNote(Note nota) {
        boolean noteWasDeleted = database.delete(NOTES_TABLE, "id=?", new String[] { Integer.toString(nota.getId()) }) > 0;
        return noteWasDeleted;
    }
}
