package com.ifsc.notesapp.model;

public class Note {
    private Integer id;
    private String title;
    private String text;

    public Note(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public Note(int id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public void setId(int id) {
        this.id = id;
    }
}
