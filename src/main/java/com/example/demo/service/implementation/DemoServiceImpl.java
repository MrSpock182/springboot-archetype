package com.example.demo.service.implementation;

import com.example.demo.domain.orm.Demo;
import com.example.demo.domain.dto.DemoRequest;
import com.example.demo.domain.dto.DemoResponse;
import com.example.demo.repository.DatabaseExternal;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DatabaseExternal<Demo, Long> repository;

    @Override
    public DemoResponse save(DemoRequest demoRequest) {
        return DemoResponse.toDTO(
                repository.save(DemoRequest.fromDTO(demoRequest)));
    }

    @Override
    public DemoResponse update(Long id, DemoRequest demoRequestDTO) {
        Demo demo = repository.findById(id);
        demo.setDemo(demoRequestDTO.getDemo());
        return DemoResponse.toDTO(repository.save(demo));
    }

    @Override
    public DemoResponse findById(Long id) {
        return DemoResponse.toDTO(repository.findById(id));
    }

    @Override
    public Page<Demo> findAll(Integer page, Integer pageSize) {
        return repository.findAll(PageRequest.of(page, pageSize));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
