package com.codegym.inote.repository;

import com.codegym.inote.model.Note;
import com.codegym.inote.model.Notetype;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NoteRepository extends PagingAndSortingRepository<Note, Integer> {
    Iterable<Note> findAllByNotetype(Notetype notetype);

    Page<Note> findAllByTitleContaining(String titlenote, Pageable pageable);

    Page<Note> findAllByTitleContainingOrContentContaining(String title, String content, Pageable pageable);

    Page<Note> findAllByContentContaining(String content, Pageable pageable);

}
