package com.codegym.inote.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "note_type")
public class TypeNote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;

    @OneToMany(targetEntity = iNote.class)
    private Set<iNote> iNotes;

    public TypeNote() {
    }

    public TypeNote(String name) {
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

    public Set<iNote> getiNotes() {
        return iNotes;
    }

    public void setiNotes(Set<iNote> iNotes) {
        this.iNotes = iNotes;
    }
}
