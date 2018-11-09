package com.codegym.inote.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "note_type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;

//    @OneToMany(mappedBy = "note_type", fetch = FetchType.LAZY)
    @OneToMany(targetEntity = iNote.class)
    private Set<iNote> iNotes;

    public Type() {
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
