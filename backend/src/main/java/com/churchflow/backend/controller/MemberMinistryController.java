package com.churchflow.backend.controller;

import com.churchflow.backend.dto.MemberMinistryRequestDTO;
import com.churchflow.backend.dto.MemberMinistryResponseDTO;
import com.churchflow.backend.service.MemberMinistryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member-ministries")
@CrossOrigin("*")
public class MemberMinistryController {

    private final MemberMinistryService memberMinistryService;

    public MemberMinistryController(MemberMinistryService memberMinistryService) {
        this.memberMinistryService = memberMinistryService;
    }

    @PostMapping
    public ResponseEntity<MemberMinistryResponseDTO> createLink(@Valid @RequestBody MemberMinistryRequestDTO dto) {
        return ResponseEntity.ok(memberMinistryService.createLink(dto));
    }
}