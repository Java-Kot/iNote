package com.codegym.inote.repository;

import com.codegym.inote.model.TypeNote;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NotetypeRepository extends PagingAndSortingRepository<TypeNote, Integer> {
}
