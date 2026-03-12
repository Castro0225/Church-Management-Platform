package com.churchflow.backend.controller;

import com.churchflow.backend.dto.MemberRequestDTO;
import com.churchflow.backend.dto.MemberResponseDTO;
import com.churchflow.backend.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@CrossOrigin("*")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<MemberResponseDTO> createMember(@Valid @RequestBody MemberRequestDTO memberRequestDTO) {
        MemberResponseDTO createdMember = memberService.createMember(memberRequestDTO);
        return ResponseEntity.ok(createdMember);
    }

    @GetMapping
    public ResponseEntity<List<MemberResponseDTO>> getAllMembers() {
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDTO> getMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberResponseDTO> updateMember(@PathVariable Long id,
                                                          @Valid @RequestBody MemberRequestDTO memberRequestDTO) {
        MemberResponseDTO updatedMember = memberService.updateMember(id, memberRequestDTO);
        return ResponseEntity.ok(updatedMember);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }
}