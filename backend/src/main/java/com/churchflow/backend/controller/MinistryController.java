package com.churchflow.backend.controller;

import com.churchflow.backend.dto.MinistryRequestDTO;
import com.churchflow.backend.dto.MinistryResponseDTO;
import com.churchflow.backend.service.MinistryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ministries")
@CrossOrigin("*")
public class MinistryController {

    private final MinistryService ministryService;

    public MinistryController(MinistryService ministryService) {
        this.ministryService = ministryService;
    }

    @PostMapping
    public ResponseEntity<MinistryResponseDTO> createMinistry(@Valid @RequestBody MinistryRequestDTO ministryRequestDTO) {
        MinistryResponseDTO createdMinistry = ministryService.createMinistry(ministryRequestDTO);
        return ResponseEntity.ok(createdMinistry);
    }

    @GetMapping
    public ResponseEntity<List<MinistryResponseDTO>> getAllMinistries() {
        return ResponseEntity.ok(ministryService.getAllMinistries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MinistryResponseDTO> getMinistryById(@PathVariable Long id) {
        return ministryService.getMinistryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MinistryResponseDTO> updateMinistry(@PathVariable Long id,
                                                              @Valid @RequestBody MinistryRequestDTO ministryRequestDTO) {
        MinistryResponseDTO updatedMinistry = ministryService.updateMinistry(id, ministryRequestDTO);
        return ResponseEntity.ok(updatedMinistry);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMinistry(@PathVariable Long id) {
        ministryService.deleteMinistry(id);
        return ResponseEntity.noContent().build();
    }
}