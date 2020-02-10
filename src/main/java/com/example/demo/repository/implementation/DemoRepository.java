package com.example.demo.repository.implementation;

import com.example.demo.domain.orm.Demo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends CrudRepository<Demo, Long> {
    Page<Demo> findAll(Pageable pageable);
}
