package com.codegym.inote.service;

import com.codegym.inote.model.Type;
import com.codegym.inote.model.iNote;
import com.codegym.inote.repository.iNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class iNoteImpl implements iNoteService {

    @Autowired
    private iNoteRepository inoteRepository;

    @Override
    public Page<iNote> findAll(Pageable pageable) {
        return inoteRepository.findAll(pageable);
    }

    @Override
    public iNote findById(Integer id) {
        return null;
    }

    @Override
    public void save(iNote post) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Iterable<iNote> findAllByCatergory(Type type) {
        return null;
    }
}
