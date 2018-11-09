package com.codegym.inote.service;

import com.codegym.inote.model.Type;
import com.codegym.inote.model.iNote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface iNoteService {
    Page<iNote> findAll(Pageable pageable);

    iNote findById(Integer id);

    void save(iNote post);

    void remove(Integer id);

    Iterable<iNote> findAllByCatergory(Type type);

//    Page<iNote> findAllByTitlePostContaining(String titlepost, Pageable pageable);
}
