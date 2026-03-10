package com.churchflow.backend.service;

import com.churchflow.backend.dto.MemberRequestDTO;
import com.churchflow.backend.dto.MemberResponseDTO;
import com.churchflow.backend.dto.MinistrySimpleDTO;
import com.churchflow.backend.entity.Member;
import com.churchflow.backend.entity.Ministry;
import com.churchflow.backend.repository.MemberRepository;
import com.churchflow.backend.repository.MinistryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final MinistryRepository ministryRepository;

    public MemberService(MemberRepository memberRepository, MinistryRepository ministryRepository) {
        this.memberRepository = memberRepository;
        this.ministryRepository = ministryRepository;
    }

    public MemberResponseDTO createMember(MemberRequestDTO dto) {
        if (memberRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Já existe um membro com este email.");
        }

        Member member = new Member();
        member.setName(dto.getName());
        member.setEmail(dto.getEmail());
        member.setPhone(dto.getPhone());
        member.setBirthDate(dto.getBirthDate());
        member.setBaptized(dto.getBaptized());
        member.setMemberSince(dto.getMemberSince());
        member.setStatus(dto.getStatus());

        Member savedMember = memberRepository.save(member);
        return convertToResponseDTO(savedMember);
    }

    public List<MemberResponseDTO> getAllMembers() {
        return memberRepository.findAll()
                .stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public Optional<MemberResponseDTO> getMemberById(Long id) {
        return memberRepository.findById(id)
                .map(this::convertToResponseDTO);
    }

    public MemberResponseDTO updateMember(Long id, MemberRequestDTO dto) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Membro não encontrado."));

        member.setName(dto.getName());
        member.setEmail(dto.getEmail());
        member.setPhone(dto.getPhone());
        member.setBirthDate(dto.getBirthDate());
        member.setBaptized(dto.getBaptized());
        member.setMemberSince(dto.getMemberSince());
        member.setStatus(dto.getStatus());

        Member updatedMember = memberRepository.save(member);
        return convertToResponseDTO(updatedMember);
    }

    public void deleteMember(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Membro não encontrado."));

        memberRepository.delete(member);
    }

    public void addMemberToMinistry(Long memberId, Long ministryId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Membro não encontrado."));

        Ministry ministry = ministryRepository.findById(ministryId)
                .orElseThrow(() -> new RuntimeException("Ministério não encontrado."));

        member.getMinistries().add(ministry);

        memberRepository.save(member);
    }

    private MemberResponseDTO convertToResponseDTO(Member member) {
        List<MinistrySimpleDTO> ministries = member.getMinistries()
                .stream()
                .map(ministry -> new MinistrySimpleDTO(
                        ministry.getId(),
                        ministry.getName()
                ))
                .collect(Collectors.toList());

        return new MemberResponseDTO(
                member.getId(),
                member.getName(),
                member.getEmail(),
                member.getPhone(),
                member.getBirthDate(),
                member.getBaptized(),
                member.getMemberSince(),
                member.getStatus(),
                ministries
        );
    }
}