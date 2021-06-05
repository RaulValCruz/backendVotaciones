package com.upgrade.erp.app.services.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CommonService<E> {

    Iterable<E> findAll();

    Page<E> findAll(Pageable pageable);

    Optional<E> findById(Long id);

    E save(E alumno);

    void deleteById(Long id);
}
