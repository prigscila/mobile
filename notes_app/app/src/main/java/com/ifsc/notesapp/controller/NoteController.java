package com.ifsc.notesapp.controller;

import android.content.Context;

import com.ifsc.notesapp.model.Note;
import com.ifsc.notesapp.model.NoteDao;

import java.util.ArrayList;

public class NoteController {
    Context context;
    static NoteDao notesDao;
    public ArrayList<Note> notes;

    public NoteController(Context context) {
        this.context =context;

        if (notesDao == null) {
            notesDao = new NoteDao(context);
        }
    }

    public Note createNote(Note note){
        return  notesDao.addNote(note);
    }

    public ArrayList<Note> listNotes() {
        return notesDao.getNotes();
    }

    public ArrayList<String> getNotesTitles() {
        ArrayList<String> titles = new ArrayList<>();

        for (Note nota: this.listNotes()) {
            titles.add(nota.getTitle());
        }

        return titles;
    }

    public Note getNote(Integer id){
        return notesDao.getNoteById(id);
    }

    public boolean updateNote(Note nota){
        return notesDao.updateNote(nota);
    }

    public boolean deleteNote(Note nota ) {
        return notesDao.removeNote(nota);
    }
}

