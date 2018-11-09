package com.codegym.inote.service;

import com.codegym.inote.model.TypeNote;

public interface NotetypeService {
    Iterable<TypeNote> findAll();

    TypeNote findById(Integer id);

    void save(TypeNote typeNote);

    void remove(Integer id);
}
