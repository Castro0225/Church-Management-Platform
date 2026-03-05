package com.churchflow.backend.service;

import com.churchflow.backend.entity.Church;
import com.churchflow.backend.repository.ChurchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChurchService {

    private final ChurchRepository churchRepository;

    public ChurchService(ChurchRepository churchRepository) {
        this.churchRepository = churchRepository;
    }

    public Church create(Church church) {
        return churchRepository.save(church);
    }

    public List<Church> findAll() {
        return churchRepository.findAll();
    }

    public Church findById(Long id) {
        return churchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Church not found with id: " + id));
    }
}