package com.codegym.inote.service;

import com.codegym.inote.model.Notetype;

public interface NotetypeService {
    Iterable<Notetype> findAll();

    Notetype findById(Integer id);

    void save(Notetype notetype);

    void remove(Integer id);
}
