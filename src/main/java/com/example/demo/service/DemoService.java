package com.example.demo.service;

import com.example.demo.domain.dto.*;
import com.example.demo.domain.orm.Demo;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

public interface DemoService {
    DemoResponse save(DemoRequest demoRequestDTO);
    DemoResponse update(Long id, DemoRequest demoRequestDTO);
    DemoResponse findById(Long id);
    Page<Demo> findAll(Integer page, Integer pageSize);
    void delete(Long id);
}
