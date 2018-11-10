package com.codegym.inote.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "note_type")
public class Notetype {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;

    @OneToMany(targetEntity = Note.class)
    private Set<Note> Notes;

    public Notetype() {
    }

    public Notetype(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Note> getNotes() {
        return Notes;
    }

    public void setNotes(Set<Note> notes) {
        this.Notes = notes;
    }
}
