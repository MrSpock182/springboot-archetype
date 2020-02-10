package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DatabaseExternal<T1, T2> {
    T1 save(T1 t);

    T1 findById(T2 id);

    List<T1> findAll();

    Page<T1> findAll(Pageable pageable);

    Boolean existsById(T2 id);

    Long count();

    void deleteById(T2 id);

}
