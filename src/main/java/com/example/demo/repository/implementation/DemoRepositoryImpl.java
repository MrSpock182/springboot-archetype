package com.example.demo.repository.implementation;

import com.example.demo.domain.orm.Demo;
import com.example.demo.exception.NotFoundException;
import com.example.demo.exception.InternalServerErrorException;
import com.example.demo.repository.DatabaseExternal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class DemoRepositoryImpl implements DatabaseExternal<Demo, Long> {

    @Autowired
    private DemoRepository repository;

    @Override
    public Demo save(Demo t) {
        try {
            return repository.save(t);
        } catch (Exception ex) {
            throw new InternalServerErrorException(ex);
        }
    }

    @Override
    public Demo findById(Long id) {
        try {
            Optional<Demo> demo = repository.findById(id);

            if(!demo.isPresent()) {
                throw new NotFoundException("Nenhum arquivo encontrado");
            }

            return demo.get();
        } catch (Exception ex) {
            throw new InternalServerErrorException(ex);
        }
    }

    @Override
    public List<Demo> findAll() {
        try {
            List<Demo> demos = StreamSupport.stream(repository.findAll().spliterator(), false)
                            .collect(Collectors.toList());

            if(demos.isEmpty()) {
                throw new NotFoundException("Nenhum arquivo encontrado");
            }

            return demos;
        } catch (Exception ex) {
            throw new InternalServerErrorException(ex);
        }
    }

    @Override
    public Page<Demo> findAll(Pageable pageable) {
        try {
            return repository.findAll(pageable);
        } catch (Exception ex) {
            throw new InternalServerErrorException(ex);
        }
    }

    @Override
    public Boolean existsById(Long id) {
        try {
            return repository.existsById(id);
        } catch (Exception ex) {
            throw new InternalServerErrorException(ex);
        }
    }

    @Override
    public Long count() {
        try {
            return repository.count();
        } catch (Exception ex) {
            throw new InternalServerErrorException(ex);
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception ex) {
            throw new InternalServerErrorException(ex);
        }
    }
}
