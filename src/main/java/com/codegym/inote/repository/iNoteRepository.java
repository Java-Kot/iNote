package com.codegym.inote.repository;

import com.codegym.inote.model.iNote;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface iNoteRepository extends PagingAndSortingRepository<iNote, Integer> {

}
