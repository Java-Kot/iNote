package com.codegym.inote.service;

import com.codegym.inote.model.TypeNote;
import com.codegym.inote.model.iNote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface iNoteService {
    Page<iNote> findAll(Pageable pageable);

    iNote findById(Integer id);

    void save(iNote inote);

    void remove(Integer id);

    Iterable<iNote> findAllByCatergory(TypeNote typeNote);

//    Page<iNote> findAllByTitlePostContaining(String titlepost, Pageable pageable);
}
