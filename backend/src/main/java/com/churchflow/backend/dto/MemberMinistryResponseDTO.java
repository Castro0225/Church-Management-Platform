package com.churchflow.backend.dto;

import com.churchflow.backend.entity.enums.MinistryRole;

import java.time.LocalDate;

public class MemberMinistryResponseDTO {

    private Long id;
    private Long memberId;
    private String memberName;
    private Long ministryId;
    private String ministryName;
    private MinistryRole role;
    private Boolean active;
    private LocalDate joinedAt;

    public MemberMinistryResponseDTO() {
    }

    public MemberMinistryResponseDTO(Long id, Long memberId, String memberName,
                                     Long ministryId, String ministryName,
                                     MinistryRole role, Boolean active, LocalDate joinedAt) {
        this.id = id;
        this.memberId = memberId;
        this.memberName = memberName;
        this.ministryId = ministryId;
        this.ministryName = ministryName;
        this.role = role;
        this.active = active;
        this.joinedAt = joinedAt;
    }

    public Long getId() {
        return id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public Long getMinistryId() {
        return ministryId;
    }

    public String getMinistryName() {
        return ministryName;
    }

    public MinistryRole getRole() {
        return role;
    }

    public Boolean getActive() {
        return active;
    }

    public LocalDate getJoinedAt() {
        return joinedAt;
    }
}