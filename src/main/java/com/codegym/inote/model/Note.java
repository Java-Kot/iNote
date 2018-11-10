package com.codegym.inote.model;

import javax.persistence.*;

@Entity
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "node_type_id")
    private Notetype notetype;

    public Note() {
    }

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Notetype getNotetype() {
        return notetype;
    }

    public void setNotetype(Notetype notetype) {
        this.notetype = notetype;
    }
}
