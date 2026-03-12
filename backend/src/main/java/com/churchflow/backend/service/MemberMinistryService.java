package com.churchflow.backend.service;

import com.churchflow.backend.dto.MemberMinistryRequestDTO;
import com.churchflow.backend.dto.MemberMinistryResponseDTO;
import com.churchflow.backend.entity.Member;
import com.churchflow.backend.entity.MemberMinistry;
import com.churchflow.backend.entity.Ministry;
import com.churchflow.backend.repository.MemberMinistryRepository;
import com.churchflow.backend.repository.MemberRepository;
import com.churchflow.backend.repository.MinistryRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberMinistryService {

    private final MemberMinistryRepository memberMinistryRepository;
    private final MemberRepository memberRepository;
    private final MinistryRepository ministryRepository;

    public MemberMinistryService(MemberMinistryRepository memberMinistryRepository,
                                 MemberRepository memberRepository,
                                 MinistryRepository ministryRepository) {
        this.memberMinistryRepository = memberMinistryRepository;
        this.memberRepository = memberRepository;
        this.ministryRepository = ministryRepository;
    }

    public MemberMinistryResponseDTO createLink(MemberMinistryRequestDTO dto) {
        Member member = memberRepository.findById(dto.getMemberId())
                .orElseThrow(() -> new RuntimeException("Membro não encontrado."));

        Ministry ministry = ministryRepository.findById(dto.getMinistryId())
                .orElseThrow(() -> new RuntimeException("Ministério não encontrado."));

        MemberMinistry memberMinistry = new MemberMinistry();
        memberMinistry.setMember(member);
        memberMinistry.setMinistry(ministry);
        memberMinistry.setRole(dto.getRole());
        memberMinistry.setActive(dto.getActive() != null ? dto.getActive() : true);
        memberMinistry.setJoinedAt(dto.getJoinedAt());

        MemberMinistry saved = memberMinistryRepository.save(memberMinistry);

        return new MemberMinistryResponseDTO(
                saved.getId(),
                saved.getMember().getId(),
                saved.getMember().getName(),
                saved.getMinistry().getId(),
                saved.getMinistry().getName(),
                saved.getRole(),
                saved.getActive(),
                saved.getJoinedAt()
        );
    }
}