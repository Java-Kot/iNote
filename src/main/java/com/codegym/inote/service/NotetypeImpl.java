package com.codegym.inote.service;

import com.codegym.inote.model.TypeNote;
import com.codegym.inote.repository.NotetypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("NotetypeService")
public class NotetypeImpl implements NotetypeService {

    @Autowired
    private NotetypeRepository notetypeRepository;

    @Override
    public Iterable<TypeNote> findAll() {
        return notetypeRepository.findAll();
    }

    @Override
    public TypeNote findById(Integer id) {
        return notetypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(TypeNote typeNote) {

    }

    @Override
    public void remove(Integer id) {

    }
}