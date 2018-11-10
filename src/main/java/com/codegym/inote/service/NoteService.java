package com.codegym.inote.service;

import com.codegym.inote.model.Note;
import com.codegym.inote.model.Notetype;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoteService {
    Page<Note> findAll(Pageable pageable);

    Note findById(Integer id);

    void save(Note note);

    void remove(Integer id);

    Iterable<Note> findAllByNotetype(Notetype notetype);

}