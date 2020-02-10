package com.example.demo.api;

import com.example.demo.domain.dto.*;
import com.example.demo.domain.orm.Demo;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/demos")
public class DemoApi {

    private DemoService demoService;

    @Autowired
    public DemoApi(DemoService demoService) {
        this.demoService = demoService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public DemoResponse createDemo(DemoRequest demo) {
        return demoService.save(demo);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public DemoResponse updateDemo(@PathVariable("id") Long id, DemoRequest demo) {
        return demoService.update(id, demo);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void removeDemo(@PathVariable("id") Long id) {
        demoService.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public DemoResponse findOneDemo(Long id) {
        return demoService.findById(id);
    }

    @GetMapping("/")
    public Page<Demo> findAllByFilters(@RequestParam("page") Integer page,
                                       @RequestParam("pageSize") Integer pageSize) {
        return demoService.findAll(page, pageSize);
    }
}
