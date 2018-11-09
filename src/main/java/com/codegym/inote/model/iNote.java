package com.codegym.inote.model;

import javax.persistence.*;

@Entity
@Table(name = "note")
public class iNote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private TypeNote typeNote;

    public iNote() {
    }

    public iNote(String title) {
        this.title = title;
    }

    public iNote(String title, String content) {
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

    public TypeNote getTypeNote() {
        return typeNote;
    }

    @Override
    public String toString() {
        return "iNote{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", typeNote=" + typeNote +
                '}';
    }
}
