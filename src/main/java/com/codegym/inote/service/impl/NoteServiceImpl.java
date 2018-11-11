package com.codegym.inote.service.impl;

import com.codegym.inote.model.Notetype;
import com.codegym.inote.model.Note;
import com.codegym.inote.repository.NoteRepository;
import com.codegym.inote.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("NoteService")
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Page<Note> findAll(Pageable pageable) {
        return noteRepository.findAll(pageable);
    }

    @Override
    public Note findById(Integer id) {
        return noteRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void remove(Integer id) {
        noteRepository.deleteById(id);
    }

    @Override
    public Iterable<Note> findAllByNotetype(Notetype notetype) {
        return noteRepository.findAllByNotetype(notetype);
    }

    @Override
    public Page<Note> findAllByTitleContaining(String titlenote, Pageable pageable) {
        return noteRepository.findAllByTitleContaining(titlenote, pageable);
    }

    @Override
    public Page<Note> findAllByTitleContainingOrContentContaining(String titlenote, String content, Pageable pageable) {
        return noteRepository.findAllByTitleContainingOrContentContaining(titlenote, content, pageable);
    }

    @Override
    public Page<Note> findAllByContentContaining(String content, Pageable pageable) {
        return noteRepository.findAllByContentContaining(content, pageable);
    }
}
