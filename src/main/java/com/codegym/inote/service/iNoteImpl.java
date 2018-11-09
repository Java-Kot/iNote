package com.codegym.inote.service;

import com.codegym.inote.model.TypeNote;
import com.codegym.inote.model.iNote;
import com.codegym.inote.repository.iNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("iNoteService")
public class iNoteImpl implements iNoteService {

    @Autowired
    private iNoteRepository inoteRepository;

    @Override
    public Page<iNote> findAll(Pageable pageable) {
        return inoteRepository.findAll(pageable);
    }

    @Override
    public iNote findById(Integer id) {
        return inoteRepository.findById(id).orElse(null);
    }

    @Override
    public void save(iNote inote) {
        inoteRepository.save(inote);
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Iterable<iNote> findAllByCatergory(TypeNote typeNote) {
        return null;
    }
}
