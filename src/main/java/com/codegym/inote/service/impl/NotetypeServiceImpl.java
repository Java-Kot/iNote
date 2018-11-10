package com.codegym.inote.service.impl;

import com.codegym.inote.model.Notetype;
import com.codegym.inote.repository.NotetypeRepository;
import com.codegym.inote.service.NotetypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("NotetypeService")
public class NotetypeServiceImpl implements NotetypeService {

    @Autowired
    private NotetypeRepository notetypeRepository;

    @Override
    public Iterable<Notetype> findAll() {
        return notetypeRepository.findAll();
    }

    @Override
    public Notetype findById(Integer id) {
        return notetypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Notetype notetype) {
        notetypeRepository.save(notetype);
    }

    @Override
    public void remove(Integer id) {
        notetypeRepository.deleteById(id);
    }
}
