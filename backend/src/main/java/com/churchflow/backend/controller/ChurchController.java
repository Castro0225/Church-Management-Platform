package com.churchflow.backend.controller;

import com.churchflow.backend.entity.Church;
import com.churchflow.backend.service.ChurchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/churches")
public class ChurchController {

    private final ChurchService churchService;

    public ChurchController(ChurchService churchService) {
        this.churchService = churchService;
    }

    @PostMapping
    public ResponseEntity<Church> create(@RequestBody Church church) {
        Church created = churchService.create(church);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public List<Church> findAll() {
        return churchService.findAll();
    }

    @GetMapping("/{id}")
    public Church findById(@PathVariable Long id) {
        return churchService.findById(id);
    }
}